package com.example.pulseliveproject.pojo;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemList {
    @SerializedName("items")
    @Expose
    private List<Items> items = null;

    public ItemList(List<Items> items) {
        this.items = items;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
