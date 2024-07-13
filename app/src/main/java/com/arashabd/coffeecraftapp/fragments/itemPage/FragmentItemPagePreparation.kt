package com.arashabd.coffeecraftapp.fragments.itemPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arashabd.coffeecraftapp.activity.ActivityItemPage
import com.arashabd.coffeecraftapp.adapter.PreparationAdapter
import com.arashabd.coffeecraftapp.databinding.FragmentItemPagePreparationBinding
import com.arashabd.coffeecraftapp.models.ModelPreparation
import com.arashabd.coffeecraftapp.ui.theme.White
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest

class FragmentItemPagePreparation: Fragment() {

//    lateinit var binding: FragmentItemPagePreparationBinding
    lateinit var adapter: PreparationAdapter
    var items = ArrayList<ModelPreparation>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
//        binding = FragmentItemPagePreparationBinding.inflate(inflater, container, false)
//        return binding.root
        return ComposeView(requireContext()).apply {
            setContent {

                CompositionLocalProvider(
                    LocalItems provides (requireActivity() as ActivityItemPage).data.PreparationInfo
                ) {
                    Greeting()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  feed
    }

//    private val feed: Unit
//        get() {
//            items = ArrayList()
//            items = (requireActivity() as ActivityItemPage).data.PreparationInfo
//
//            adapter = PreparationAdapter(items)
//            binding.recyclerPreparation.layoutManager = LinearLayoutManager(requireContext())
//            binding.recyclerPreparation.adapter = adapter
//        }

    @Composable
    @Preview
    fun Greeting() {
        val items = LocalItems.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)

        ) {
         //   Header(title = LocalHeaderTitle.current)
            LazyColumn() {
                items(items.size) {
                    Column {
                        Row {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(items[it].icon)
                                    .build(),
                                contentDescription = "icon",
                            )
                            Text(
                                text = items[it].title,
                            )
                        }
                            Text(
                                text = items[it].description,
                            )
                    }

                }
            }
        }

    }

}

val LocalItems = compositionLocalOf {
    ArrayList<ModelPreparation>()
}



