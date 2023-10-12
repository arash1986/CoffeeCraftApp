package com.arash.coffeecraftapp.models

import com.google.gson.annotations.SerializedName


data class GeneralInfo (

    @SerializedName("imageURL"        ) var imageURL        : String? = null,
    @SerializedName("detailsImageURL" ) var detailsImageURL : String? = null,
    @SerializedName("EQDescription"   ) var EQDescription   : String? = null

)
