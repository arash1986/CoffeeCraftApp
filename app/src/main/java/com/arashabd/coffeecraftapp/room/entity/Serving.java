package com.arashabd.coffeecraftapp.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class Serving {

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo (name = "Description")
    private String Description;

    @ColumnInfo (name = "imageURL")
    private String imageURL;
}
