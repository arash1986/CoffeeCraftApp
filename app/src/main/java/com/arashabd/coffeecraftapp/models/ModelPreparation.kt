package com.arashabd.coffeecraftapp.models

import com.google.gson.annotations.SerializedName


data class ModelPreparation (

    @SerializedName("SFSName"        ) var sFSName        : String? = null,
    @SerializedName("title" ) var title : String = "",
    @SerializedName("android_icon" ) var icon  : String = "",
    @SerializedName("Description"   ) var description   : String = ""

)
