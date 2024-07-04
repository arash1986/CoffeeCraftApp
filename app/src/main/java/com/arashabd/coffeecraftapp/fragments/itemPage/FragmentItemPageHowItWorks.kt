package com.arashabd.coffeecraftapp.fragments.itemPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arashabd.coffeecraftapp.activity.ActivityItemPage
import com.arashabd.coffeecraftapp.adapter.HowItWorksAdapter
import com.arashabd.coffeecraftapp.databinding.FragmentItemPagePreparationBinding
import com.arashabd.coffeecraftapp.models.ModelHowItWorks

class FragmentItemPageHowItWorks : Fragment(){

    lateinit var binding: FragmentItemPagePreparationBinding
    lateinit var adapter: HowItWorksAdapter
    var items = ArrayList<ModelHowItWorks>()
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
            items = ArrayList()
            items = (requireActivity() as ActivityItemPage).data.HowItWork
            adapter = HowItWorksAdapter(items)
            binding.recyclerPreparation.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerPreparation.adapter = adapter
        }

}