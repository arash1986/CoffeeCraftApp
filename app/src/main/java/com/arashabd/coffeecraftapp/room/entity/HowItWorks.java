package com.arashabd.coffeecraftapp.room.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class HowItWorks {

    @ColumnInfo(name = "SFSName")
    private String SFSName;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "Description")
    private String Description;


}
