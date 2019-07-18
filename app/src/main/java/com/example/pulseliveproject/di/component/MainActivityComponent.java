package com.example.pulseliveproject.di.component;

import android.content.Context;
import com.example.pulseliveproject.di.module.AdapterModule;
import com.example.pulseliveproject.di.qualifier.ActivityContext;
import com.example.pulseliveproject.di.scopes.ActivityScope;
import com.example.pulseliveproject.ui.MainActivity;
import dagger.Component;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();


    void injectMainActivity(MainActivity mainActivity);
}
