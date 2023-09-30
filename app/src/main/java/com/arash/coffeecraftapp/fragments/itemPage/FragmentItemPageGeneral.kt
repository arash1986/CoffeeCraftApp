package com.arash.coffeecraftapp.fragments.itemPage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arash.coffeecraftapp.activity.ActivityImagePreview
import com.arash.coffeecraftapp.databinding.FragmentItemPageGeneralBinding

class FragmentItemPageGeneral : Fragment(){

    lateinit var binding: FragmentItemPageGeneralBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentItemPageGeneralBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feed

        binding.image.setOnClickListener {
            val intent = Intent(requireActivity(), ActivityImagePreview::class.java)
            intent.putExtra("imageLink", "")
            startActivity(intent)
        }
    }

    private val feed: Unit
        get() {

        }

}