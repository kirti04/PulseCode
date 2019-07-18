package com.example.pulseliveproject.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pulseliveproject.MyApplication;
import com.example.pulseliveproject.Network.APIInterface;
import com.example.pulseliveproject.R;
import com.example.pulseliveproject.di.component.ApplicationComponent;
import com.example.pulseliveproject.di.component.DaggerDetailActivityComponent;
import com.example.pulseliveproject.di.component.DetailActivityComponent;
import com.example.pulseliveproject.di.qualifier.ApplicationContext;
import com.example.pulseliveproject.pojo.ItemDetail;
import com.example.pulseliveproject.pojo.Item_detail;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {
    DetailActivityComponent detailActivityComponent;
    Disposable disposable;
    TextView text_title;
    TextView text_subTitle;
    TextView text_body;
    Item_detail contentDetail;


    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        text_body = (TextView)findViewById(R.id.text_body);
        text_title = (TextView)findViewById(R.id.text_title_detail);
        text_subTitle = (TextView)findViewById(R.id.text_sub_detail);
        int id = getIntent().getIntExtra("item_id",0);
        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                                    .applicationComponent(applicationComponent)
                                    .build();
        detailActivityComponent.inject(this);
        apiInterface.getItemDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<ItemDetail>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable =  d;
                    }

                    @Override
                    public void onSuccess(ItemDetail itemDetail) {
                        contentDetail = itemDetail.getItemDetail();
                        populateView(contentDetail);
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.d("error", e.toString());
                    }
                });


    }

    private void populateView(Item_detail contentDetail) {
        text_title.setText(contentDetail.getTitle());
        text_subTitle.setText(contentDetail.getSubtitle());
        text_body.setText(contentDetail.getBody());


    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
