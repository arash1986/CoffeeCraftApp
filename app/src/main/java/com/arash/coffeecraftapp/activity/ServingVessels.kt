package com.arash.coffeecraftapp.activity

import android.os.Bundle
import android.util.Log
import com.arash.coffeecraftapp.adapter.ViewPagerDotViewAdapter
import com.arash.coffeecraftapp.databinding.ActivityServingVesselsBinding
import com.arash.coffeecraftapp.models.Data
import com.arash.coffeecraftapp.utils.SetHeaderAttributes
import com.google.gson.Gson

class ServingVessels: BaseActivity() {
    lateinit var binding: ActivityServingVesselsBinding
    lateinit var adapter: ViewPagerDotViewAdapter
    var data =  Data()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServingVesselsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent != null && !intent.extras!!.getString("json").isNullOrEmpty()) {
            Log.d("asdadads",intent.extras!!.getString("json")?.length.toString() )
            val gson = Gson()
            data = gson.fromJson(intent!!.extras!!.getString("json"), Data::class.java)
        }

        (if(intent != null && intent.hasExtra("itemName")) intent.getStringExtra("itemName") else "Title")?.let {
            SetHeaderAttributes(binding.header,
                it, null)
        }

        binding.header.back.setOnClickListener { finish() }

        adapter = ViewPagerDotViewAdapter(this, data.Serving)
        binding.viewPager.adapter = adapter
        binding.springDotsIndicator.attachTo(binding.viewPager)
    }
}