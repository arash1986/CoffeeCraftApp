package com.arashabd.coffeecraftapp.room.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class GeneralInfo {

    @ColumnInfo(name = "imageURL")
    private String imageUrl;

    @ColumnInfo(name = "detailsImageURL")
    private String detailsImageURL;

    @ColumnInfo(name = "EQDescription")
    private String EQDescription;


}
