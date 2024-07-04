package com.arashabd.coffeecraftapp.activity

import android.os.Bundle
import com.arashabd.coffeecraftapp.R
import com.arashabd.coffeecraftapp.databinding.ActivityImagePreviewBinding
import com.arashabd.coffeecraftapp.utils.SetHeaderAttributes
import com.arashabd.coffeecraftapp.utils.glideHelper

class ActivityImagePreview: BaseActivity() {
    private lateinit var binding: ActivityImagePreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetHeaderAttributes(binding.header, getString(R.string.view_image), null)
        binding.header.back.setOnClickListener { finish() }

        glideHelper(
            applicationContext,
            binding.image,
            intent.getStringExtra("imageLink").toString(),
            binding.progress.progressBar
        )
    }
}