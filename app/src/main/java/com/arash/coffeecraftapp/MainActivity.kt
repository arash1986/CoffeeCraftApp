package com.arash.coffeecraftapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModelProvider
import com.arash.coffeecraftapp.activity.ActivityItemPage
import com.arash.coffeecraftapp.adapter.GridViewAdapter
import com.arash.coffeecraftapp.databinding.ActivityMainBinding
import com.arash.coffeecraftapp.models.Data
import com.arash.coffeecraftapp.viewModel.ViewModelFactory
import com.arash.coffeecraftapp.viewModel.ViewModelMainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.GenericSignatureFormatError
import java.lang.reflect.Type

class MainActivity: BaseActivity() {

    private val gridViewImages = ArrayList<String>()
    private val gridViewTitles = ArrayList<String>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var gridViewAdapter: GridViewAdapter
    private lateinit var viewModelMainActivity: ViewModelMainActivity
    private lateinit var itemModel : List<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        binding.header.txtTitle.text = getString(R.string.equipment)
     //   setGridView()
        setHeaderIcon()
        initViewModel()

        if(viewModelMainActivity.jsonArray.value == null)
            viewModelMainActivity.getItemsData()
        viewModelMainActivity.jsonArray.observe(this) {
//            Log.d("responseItems", viewModelMainActivity.jsonArray.value.toString())
//            val gson = Gson()
//            Log.d("responseItems", "sdfsfsfsfdsf")
//
//            val listType: Type = object : TypeToken<List<Data?>?>() {}.type
//            Log.d("responseItems", "sdfsfsfsfdsf")
//
//            itemModel = gson.fromJson(viewModelMainActivity.jsonArray.value.toString(), listType)
//            Log.d("responseItems", "sdfsfsfsfdsf")
//
//            Log.d("responseItems", itemModel.size.toString() + ",  ")
//            Log.d("responseItems", "sdfsfsfsfdsf")

            setGridView()
        }
    }

    private fun setGridView() {
        for(items in viewModelMainActivity.jsonArray.value!!) {
            Log.d("responseItems", items.thumbImage.toString())
            Log.d("responseItems", items.title.toString())
            items.thumbImage?.let { gridViewImages.add(it) }
            items.title?.let { gridViewTitles.add(it) }
        }
//        gridViewImages.add(R.drawable.ic_grid_image_2)
//        gridViewImages.add(R.drawable.ic_grid_image_3)
//        gridViewImages.add(R.drawable.ic_grid_image_4)
//        gridViewImages.add(R.drawable.ic_grid_image_5)
//        gridViewImages.add(R.drawable.ic_grid_image_6)
//        gridViewImages.add(R.drawable.ic_grid_image_7)
//        gridViewImages.add(R.drawable.ic_grid_image_8)
//        gridViewImages.add(R.drawable.ic_grid_image_9)
//        gridViewImages.add(R.drawable.ic_grid_image_10)
//        gridViewImages.add(R.drawable.ic_grid_image_11)
//        gridViewImages.add(R.drawable.ic_grid_image_12)

//        gridViewTitles.add(getString(R.string.Espresso_Machine))
//        gridViewTitles.add(getString(R.string.French_Press))
//        gridViewTitles.add(getString(R.string.Filter_Pour_over))
//        gridViewTitles.add(getString(R.string.Cloth_brewer))
//        gridViewTitles.add(getString(R.string.Aeropress))
//        gridViewTitles.add(getString(R.string.Syphon))
//        gridViewTitles.add(getString(R.string.Stove_top_Pot))
//        gridViewTitles.add(getString(R.string.Cold_Dripper))
//        gridViewTitles.add(getString(R.string.Electric_Filter_brew))
//        gridViewTitles.add(getString(R.string.Phin))
//        gridViewTitles.add(getString(R.string.Ibrik))
//        gridViewTitles.add(getString(R.string.Serving_Vessels))

        gridViewAdapter = GridViewAdapter(this, gridViewImages, gridViewTitles)
        binding.gridView.adapter = gridViewAdapter

        binding.header.imageAction.setOnClickListener {
            if(sessionManager.lightMode) {
                Log.d("asdadadad", "here1")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_light_view))
                sessionManager.lightMode = false
            }
            else {
                Log.d("asdadadad", "here2")

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_night_view))

                sessionManager.lightMode = true
            }
        }
        binding.gridView.setOnItemClickListener { _: AdapterView<*>?, view1: View?, position: Int, id: Long ->
            val intent = Intent(this, ActivityItemPage::class.java)
            intent.putExtra("itemName", gridViewTitles[position])
            startActivity(intent)
        }
    }

    private fun setHeaderIcon()
    {
        if(!sessionManager.lightMode)
            binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_light_view))
        else
            binding.header.imageAction.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_night_view))

    }

    private fun initViewModel() {
        viewModelMainActivity = ViewModelProvider(this,ViewModelFactory(sessionManager))[ViewModelMainActivity::class.java]
    }
}