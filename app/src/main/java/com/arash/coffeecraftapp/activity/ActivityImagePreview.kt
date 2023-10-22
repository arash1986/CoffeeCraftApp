package com.arash.coffeecraftapp.activity

import android.os.Bundle
import com.arash.coffeecraftapp.R
import com.arash.coffeecraftapp.databinding.ActivityImagePreviewBinding
import com.arash.coffeecraftapp.utils.SetHeaderAttributes
import com.arash.coffeecraftapp.utils.glideHelper

class ActivityImagePreview: BaseActivity() {
    lateinit var binding: ActivityImagePreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetHeaderAttributes(binding.header, getString(R.string.view_image), null)
        binding.header.back.setOnClickListener { finish() }

        glideHelper(
            binding.image,
            intent.getStringExtra("imageLink").toString(),
            binding.progress.progressBar
        )
    }
}