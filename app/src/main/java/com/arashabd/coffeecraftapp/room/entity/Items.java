package com.arashabd.coffeecraftapp.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Items {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /// private List<ServingModel> serving;
  //  private List<ModelGeneralInfo> generlaInfo;
   // private List<HowItWorks> howItWorks;

//    public List<ServingModel> getServing() {
//        return serving;
//    }
//
//    public void setServing(List<ServingModel> serving) {
//        this.serving = serving;
//    }
//
//    public List<ModelGeneralInfo> getGenerlaInfo() {
//        return generlaInfo;
//    }
//
//    public void setGenerlaInfo(List<ModelGeneralInfo> generlaInfo) {
//        this.generlaInfo = generlaInfo;
//    }
//
//    public List<HowItWorks> getHowItWorks() {
//        return howItWorks;
//    }
//
//    public void setHowItWorks(List<HowItWorks> howItWorks) {
//        this.howItWorks = howItWorks;
//    }
}
