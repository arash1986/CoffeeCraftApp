package com.arash.coffeecraftapp.fragments.itemPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arash.coffeecraftapp.databinding.FragmentItemPagePreparationBinding

class FragmentItemPagePreparation : Fragment(){

    lateinit var binding: FragmentItemPagePreparationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentItemPagePreparationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feed
    }

    private val feed: Unit
        get() {
        }

}