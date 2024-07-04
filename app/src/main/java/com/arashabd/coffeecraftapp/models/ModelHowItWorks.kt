package com.arashabd.coffeecraftapp.models

import com.google.gson.annotations.SerializedName


data class ModelHowItWorks (

    @SerializedName("SFSName"        ) var SFSName        : String = "",
    @SerializedName("title" ) var title  : String = "",
    @SerializedName("android_icon" ) var icon  : String = "",
    @SerializedName("Description"   ) var Description   : String = ""

)
