package com.example.pulseliveproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.idling.CountingIdlingResource;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pulseliveproject.MyApplication;
import com.example.pulseliveproject.Network.APIInterface;
import com.example.pulseliveproject.R;
import com.example.pulseliveproject.adapter.RecyclerViewAdapter;
import com.example.pulseliveproject.di.component.ApplicationComponent;
import com.example.pulseliveproject.di.component.DaggerMainActivityComponent;
import com.example.pulseliveproject.di.component.MainActivityComponent;
import com.example.pulseliveproject.di.module.MainActivityContextModule;
import com.example.pulseliveproject.di.qualifier.ActivityContext;
import com.example.pulseliveproject.di.qualifier.ApplicationContext;
import com.example.pulseliveproject.pojo.ItemList;
import com.example.pulseliveproject.pojo.Items;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    MainActivityComponent mainActivityComponent;
    Disposable disposable;
    public CountingIdlingResource countingIdlingResource =  new CountingIdlingResource("DATA_LOADER");

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countingIdlingResource.increment();
        recyclerView = findViewById(R.id.items_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent= DaggerMainActivityComponent.builder()
                                .mainActivityContextModule(new MainActivityContextModule(this))
                                .applicationComponent(applicationComponent)
                                .build();
        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        apiInterface.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<ItemList>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable =  d;
                    }

                    @Override
                    public void onSuccess(ItemList item_list) {
                        populateRecyclerView(item_list.getItems());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("error", e.toString());
                    }
                });

    }
    private void populateRecyclerView(List<Items> response) {
        recyclerViewAdapter.setData(response);
        countingIdlingResource.decrement();
    }

    @Override
    public void launchIntent(int id) {
        Toast.makeText(mContext, "Content selected", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(activityContext, DetailActivity.class).putExtra("item_id", id));

    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
