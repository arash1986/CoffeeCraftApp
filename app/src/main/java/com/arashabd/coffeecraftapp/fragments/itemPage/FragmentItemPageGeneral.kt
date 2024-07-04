package com.arashabd.coffeecraftapp.fragments.itemPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arashabd.coffeecraftapp.activity.ActivityImagePreview
import com.arashabd.coffeecraftapp.activity.ActivityItemPage
import com.arashabd.coffeecraftapp.databinding.FragmentItemPageGeneralBinding
import com.arashabd.coffeecraftapp.utils.glideHelper

class FragmentItemPageGeneral : Fragment(){

    lateinit var binding: FragmentItemPageGeneralBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentItemPageGeneralBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if((requireActivity() as ActivityItemPage).data.GeneralInfo.isNotEmpty())
            feed
        binding.image.setOnClickListener {
            val intent = Intent(requireActivity(), ActivityImagePreview::class.java)
            intent.putExtra("imageLink", (requireActivity() as ActivityItemPage).data.GeneralInfo[0].detailsImageURL)
            startActivity(intent)
        }
    }

    private val feed: Unit
        get() {
            Log.d("asdadadas", (requireActivity() as ActivityItemPage).data.GeneralInfo[0].imageURL.toString())
            binding.description.text = (requireActivity() as ActivityItemPage).data.GeneralInfo[0].EQDescription
            (requireActivity() as ActivityItemPage).data.GeneralInfo[0].imageURL?.let {
                glideHelper(requireContext(),
                    binding.image,
                    it,
                    binding.progress.progressBar
                )
            }
        }

}