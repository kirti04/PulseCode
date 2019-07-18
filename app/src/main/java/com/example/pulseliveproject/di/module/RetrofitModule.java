package com.example.pulseliveproject.di.module;


import com.example.pulseliveproject.Network.APIInterface;
import com.example.pulseliveproject.di.scopes.ApplicationScope;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    public static final String ITEMS_URL = "http://dynamic.pulselive.com";

    @Provides
    @ApplicationScope
    APIInterface getApiInterface(Retrofit retroFit) {
        return retroFit.create(APIInterface.class);
    }

    @Provides
    @ApplicationScope
    Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ITEMS_URL)
                .build();
    }


}
