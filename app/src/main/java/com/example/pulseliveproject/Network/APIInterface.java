package com.example.pulseliveproject.Network;

import com.example.pulseliveproject.pojo.ItemDetail;
import com.example.pulseliveproject.pojo.ItemList;
import com.example.pulseliveproject.pojo.Item_detail;
import com.example.pulseliveproject.pojo.Items;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface APIInterface {

    @GET("/test/native/contentList.json")
    Single<ItemList> getItems();
    @GET("/test/native/content/{id}.json")
    Single<ItemDetail> getItemDetail(@Path("id") int item_id);
}
