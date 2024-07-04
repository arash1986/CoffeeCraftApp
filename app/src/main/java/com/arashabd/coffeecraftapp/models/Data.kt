package com.arashabd.coffeecraftapp.models

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("title"          ) var title          : String?                =  "",
    @SerializedName("thumbImage"     ) var thumbImage     : String?                =  "",
    @SerializedName("GeneralInfo"    ) var GeneralInfo    : List<ModelGeneralInfo> = arrayListOf(),
    @SerializedName("PreprationInfo" ) var PreparationInfo : ArrayList<ModelPreparation>      = arrayListOf(),
    @SerializedName("HowItWork"      ) var HowItWork      : ArrayList<ModelHowItWorks>      = arrayListOf(),
    @SerializedName("Serving"        ) var Serving        : List<ServingModel>     = arrayListOf()
)