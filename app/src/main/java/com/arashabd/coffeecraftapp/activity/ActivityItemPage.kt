package com.arashabd.coffeecraftapp.activity

import android.os.Bundle
import android.util.Log
import com.arashabd.coffeecraftapp.adapter.AdapterTabPager
import com.arashabd.coffeecraftapp.databinding.ActivityItemPageBinding
import com.arashabd.coffeecraftapp.fragments.itemPage.FragmentItemPageGeneral
import com.arashabd.coffeecraftapp.fragments.itemPage.FragmentItemPageHowItWorks
import com.arashabd.coffeecraftapp.fragments.itemPage.FragmentItemPagePreparation
import com.arashabd.coffeecraftapp.models.Data
import com.arashabd.coffeecraftapp.utils.SetHeaderAttributes
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class ActivityItemPage: BaseActivity() {
    lateinit var binding: ActivityItemPageBinding
    private var generalFragment = FragmentItemPageGeneral()
    private var preparationFragment = FragmentItemPagePreparation()
    private var howItWorksFragment = FragmentItemPageHowItWorks()
    var data =  Data()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent != null && !intent.extras!!.getString("json").isNullOrEmpty()) {
            Log.d("asdadads",intent.extras!!.getString("json")?.length.toString() )
            val gson = Gson()
            data = gson.fromJson(intent!!.extras!!.getString("json"), Data::class.java)
        }

        binding.header.back.setOnClickListener { finish() }
        (if(intent != null && intent.hasExtra("itemName")) intent.getStringExtra("itemName") else "Title")?.let {
            SetHeaderAttributes(binding.header,
                it, null)
        }

        val adapter = AdapterTabPager(this)
        adapter.addFragment(generalFragment, "General")
        adapter.addFragment(preparationFragment, "Preparation")
        adapter.addFragment(howItWorksFragment, "How It Works")

        binding.pager.adapter = adapter
        binding.pager.currentItem = 0
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = adapter.getTabTitle(position)
        }.attach()
    }
}