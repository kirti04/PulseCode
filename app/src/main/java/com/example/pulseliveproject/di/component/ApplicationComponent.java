package com.example.pulseliveproject.di.component;

import android.content.Context;

import com.example.pulseliveproject.MyApplication;
import com.example.pulseliveproject.Network.APIInterface;
import com.example.pulseliveproject.di.module.ContextModule;
import com.example.pulseliveproject.di.module.RetrofitModule;
import com.example.pulseliveproject.di.qualifier.ApplicationContext;
import com.example.pulseliveproject.di.scopes.ApplicationScope;
import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);
}
