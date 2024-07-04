package com.arashabd.coffeecraftapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import com.arashabd.coffeecraftapp.R
import com.arashabd.coffeecraftapp.adapter.GridViewAdapter
import com.arashabd.coffeecraftapp.databinding.ActivityMainBinding
import com.arashabd.coffeecraftapp.utils.DialogBuilder
import com.arashabd.coffeecraftapp.viewModel.ViewModelMainActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: BaseActivity() {

    private var gridViewImages = ArrayList<String>()
    private var gridViewTitles = ArrayList<String>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var gridViewAdapter: GridViewAdapter
//    @Inject
//    lateinit var loadingDialog: Dialog
 //   private lateinit var viewModelMainActivity: ViewModelMainActivity
    private val viewModelMainActivity: ViewModelMainActivity by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.header.txtTitle.text = getString(R.string.equipment)
        setHeaderIcon()
     //   initViewModel()
        gridViewAdapter = GridViewAdapter(this, gridViewImages, gridViewTitles)
        binding.gridView.adapter = gridViewAdapter
        if(viewModelMainActivity.jsonArray.value == null) {
            CoroutineScope(Dispatchers.IO).launch {
                runOnUiThread {
                    DialogBuilder.initProgressDialog(this@MainActivity, "Please Wait...")
                }

                viewModelMainActivity.getItemsData()
            }
        } else setGridView()
        viewModelMainActivity.jsonArray.observe(this) {
            setGridView()
        }
    }

    private fun setGridView() {
        gridViewImages.clear()
        gridViewTitles.clear()
        lifecycleScope.launch {
            for (items in viewModelMainActivity.jsonArray.value!!) {
                items!!.thumbImage?.let { gridViewImages.add(it) }
                items.title?.let { gridViewTitles.add(it) }
            }
            withContext(Dispatchers.Main) {

                gridViewAdapter.notifyDataSetChanged()
            }
        }


        binding.header.imageAction.setOnClickListener {
            if(sessionManager.lightMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this,
                    R.drawable.ic_light_view
                ))
                sessionManager.lightMode = false
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this,
                    R.drawable.ic_night_view
                ))

                sessionManager.lightMode = true
            }
        }
        binding.gridView.setOnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
            setAnalytics(gridViewTitles[position])
            val gson = Gson()
            val intent: Intent
            if(gridViewTitles[position] == "Serving Vessels")
            {
                intent = Intent(this, ServingVessels::class.java)
                intent.putExtra("itemName", gridViewTitles[position])
                intent.putExtras(
                    bundleOf(
                        "json" to gson.toJson(viewModelMainActivity.jsonArray.value?.get(position))
                    )
                )
                startActivity(intent)
            }
            else {
                intent = Intent(this, ActivityItemPage::class.java)
                intent.putExtra("itemName", gridViewTitles[position])
                intent.putExtras(
                    bundleOf(
                        "json" to gson.toJson(viewModelMainActivity.jsonArray.value?.get(position))
                    )
                )
                startActivity(intent)
            }
        }
    }

    private fun setHeaderIcon()
    {
        if(!sessionManager.lightMode)
            binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this,
                R.drawable.ic_light_view
            ))
        else
            binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this,
                R.drawable.ic_night_view
            ))

    }

//    private fun initViewModel() {
//        viewModelMainActivity = ViewModelProvider(this,ViewModelFactory(this))[ViewModelMainActivity::class.java]
//    }

    private fun setAnalytics(str: String) {
        val firebaseAnalytics = Firebase.analytics
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_BRAND   , str)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
    }

}