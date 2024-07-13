package com.arashabd.coffeecraftapp.activity

import android.os.Bundle
import android.view.View
import coil.load
import com.arashabd.coffeecraftapp.R
import com.arashabd.coffeecraftapp.databinding.ActivityImagePreviewBinding
import com.arashabd.coffeecraftapp.utils.SetHeaderAttributes

class ActivityImagePreview: BaseActivity() {
    private lateinit var binding: ActivityImagePreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetHeaderAttributes(binding.header, getString(R.string.view_image), null)
        binding.header.back.setOnClickListener { finish() }
        binding.image.load(intent.getStringExtra("imageLink").toString()) {

         target (
             onStart = { placeholder ->
                 // Handle the placeholder drawable.
             },
             onSuccess = { result ->
                 binding.progress.progressBar.visibility = View.GONE
             },
             onError = { error ->
                 // Handle the error drawable.
             }
         )
        }



//        glideHelper(
//            applicationContext,
//            binding.image,
//            intent.getStringExtra("imageLink").toString(),
//            binding.progress.progressBar
//        )
    }
}