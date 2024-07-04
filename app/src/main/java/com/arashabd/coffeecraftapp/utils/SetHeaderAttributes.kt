package com.arashabd.coffeecraftapp.utils

import android.view.View
import com.arashabd.coffeecraftapp.databinding.HeaderBinding

class SetHeaderAttributes(binding: HeaderBinding, title: String, textAction: String?) {
    init {
        binding.txtTitle.text = title
        if(textAction != null)
            binding.txtAction.text = textAction
        else
            binding.txtAction.visibility = View.GONE
    }
}