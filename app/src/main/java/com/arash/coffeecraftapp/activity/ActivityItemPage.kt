package com.arash.coffeecraftapp.activity

import android.os.Bundle
import com.arash.coffeecraftapp.BaseActivity
import com.arash.coffeecraftapp.adapter.AdapterTabPager
import com.arash.coffeecraftapp.databinding.ActivityItemPageBinding
import com.arash.coffeecraftapp.fragments.itemPage.FragmentItemPageGeneral
import com.arash.coffeecraftapp.fragments.itemPage.FragmentItemPageHowItWorks
import com.arash.coffeecraftapp.fragments.itemPage.FragmentItemPagePreparation
import com.arash.coffeecraftapp.utils.SetHeaderAttributes
import com.google.android.material.tabs.TabLayoutMediator

class ActivityItemPage: BaseActivity() {
    lateinit var binding: ActivityItemPageBinding
    private var generalFragment = FragmentItemPageGeneral()
    private var preparationFragment = FragmentItemPagePreparation()
    private var howItWorksFragment = FragmentItemPageHowItWorks()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

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