package com.example.pulseliveproject.di.module;

import android.content.Context;

import com.example.pulseliveproject.di.qualifier.ApplicationContext;
import com.example.pulseliveproject.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
