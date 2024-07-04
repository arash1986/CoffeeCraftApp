package com.arashabd.coffeecraftapp.models

import com.google.gson.annotations.SerializedName


data class ModelGeneralInfo (

    @SerializedName("imageURL"        ) var imageURL        : String? = null,
    @SerializedName("detailsImageURL" ) var detailsImageURL : String? = null,
    @SerializedName("EQDescription"   ) var EQDescription   : String? = null

)
