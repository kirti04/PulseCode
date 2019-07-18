package com.example.pulseliveproject.di.component;

import com.example.pulseliveproject.di.scopes.ActivityScope;
import com.example.pulseliveproject.ui.DetailActivity;
import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailActivityComponent {

    void inject(DetailActivity detailActivity);
}
