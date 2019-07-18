package com.example.pulseliveproject.pojo;

import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("date")
    private String date;

public Items(int id, String title, String subtitle, String date){
    this.id = id;
    this.date = date;
    this.subtitle = subtitle;
    this.title = title;

}

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
