package com.arash.coffeecraftapp.models

import com.google.gson.annotations.SerializedName


data class Data (

    @SerializedName("title"          ) var title          : String?                = null,
    @SerializedName("thumbImage"     ) var thumbImage     : String?                = null,
    @SerializedName("GeneralInfo"    ) var GeneralInfo    : ArrayList<GeneralInfo> = arrayListOf(),
    @SerializedName("PreprationInfo" ) var PreprationInfo : ArrayList<Any>      = arrayListOf(),
    @SerializedName("HowItWork"      ) var HowItWork      : ArrayList<Any>      = arrayListOf(),
    @SerializedName("Serving"        ) var Serving        : ArrayList<Serving>     = arrayListOf()

)