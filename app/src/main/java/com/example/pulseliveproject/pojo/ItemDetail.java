package com.example.pulseliveproject.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDetail {
    @SerializedName("item")
    @Expose
    private Item_detail itemDetail = null;

    public ItemDetail(Item_detail item_details) {
        super();
        this.itemDetail = item_details;
    }

    public Item_detail getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(Item_detail itemDetail) {
        this.itemDetail = itemDetail;
    }
}
