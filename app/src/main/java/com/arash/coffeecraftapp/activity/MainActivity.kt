package com.arash.coffeecraftapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.arash.coffeecraftapp.R
import com.arash.coffeecraftapp.adapter.GridViewAdapter
import com.arash.coffeecraftapp.databinding.ActivityMainBinding
import com.arash.coffeecraftapp.viewModel.ViewModelFactory
import com.arash.coffeecraftapp.viewModel.ViewModelMainActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity: BaseActivity() {

    private var gridViewImages = ArrayList<String>()
    private var gridViewTitles = ArrayList<String>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var gridViewAdapter: GridViewAdapter
    private lateinit var viewModelMainActivity: ViewModelMainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.header.txtTitle.text = getString(R.string.equipment)
     //   setGridView()
        setHeaderIcon()
        initViewModel()
      //  initDataBase()
     //   GlobalScope.launch(Dispatchers.IO) {
          //  if(coffeeRepository.getAllCoffeeItems().isEmpty())
      //  setGridView()
            // Now you can use the coffeeItems on the main thread if needed
            // (e.g., update UI elements)
//            runOnUiThread {
//                // Update UI here with coffeeItems
//            }
       // }
        gridViewAdapter = GridViewAdapter(this, gridViewImages, gridViewTitles)
        binding.gridView.adapter = gridViewAdapter
        if(viewModelMainActivity.jsonArray.value == null) {
            Log.d("asdasdadas", "here2")

            CoroutineScope(Dispatchers.IO).launch {
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
//                val coffeeItems = Items()
//                coffeeItems.serving = items.Serving
//                coffeeItems.generalInfo = items.GeneralInfo
//                coffeeRepository.insertCoffeeItem(coffeeItems)
                items!!.thumbImage?.let { gridViewImages.add(it) }
                items.title?.let { gridViewTitles.add(it) }
            }
            withContext(Dispatchers.Main) {

                gridViewAdapter.notifyDataSetChanged()
            }
        }
//            runOnUiThread {
//                // Update UI here with coffeeItems
//            }
      //  }




        binding.header.imageAction.setOnClickListener {
            if(sessionManager.lightMode) {
                Log.d("asdadadad", "here1")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this,
                    R.drawable.ic_light_view
                ))
                sessionManager.lightMode = false
            }
            else {
                Log.d("asdadadad", "here2")

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this,
                    R.drawable.ic_night_view
                ))

                sessionManager.lightMode = true
            }
        }
        binding.gridView.setOnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
            setAnalytics(gridViewTitles[position])
            val intent = Intent(this, ActivityItemPage::class.java)
            intent.putExtra("itemName", gridViewTitles[position])
            val gson = Gson()
            intent.putExtras(
                bundleOf(
                "json" to gson.toJson(viewModelMainActivity.jsonArray.value?.get(position))))
            startActivity(intent)
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

    private fun initViewModel() {
        viewModelMainActivity = ViewModelProvider(this,ViewModelFactory(this))[ViewModelMainActivity::class.java]
    }

//    private fun initDataBase()
//    {
//        coffeeRepository = CoffeeRepository(this)
//    }

    private fun setAnalytics(str: String) {
        val firebaseAnalytics = Firebase.analytics
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_BRAND   , str)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
    }

}