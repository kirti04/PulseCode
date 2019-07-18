package com.example.pulseliveproject.pojo;

import com.google.gson.annotations.SerializedName;

public class Item_detail {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("body")
    private String body;
    @SerializedName("date")
    private String date;


    public Item_detail(int id, String title, String subtitle, String date,String body){
        this.body = body;
        this.id =  id;
        this.date = date;
        this.title = title;
        this.subtitle =subtitle;

    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
