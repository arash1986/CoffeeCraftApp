package com.arash.coffeecraftapp.models

import com.google.gson.annotations.SerializedName


data class Serving(

    @SerializedName("title") var title: String? = null,
    @SerializedName("Description") var Description: String? = null,
    @SerializedName("imageURL") var imageURL: String? = null

)
