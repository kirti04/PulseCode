package com.example.pulseliveproject.di.module;


import com.example.pulseliveproject.adapter.RecyclerViewAdapter;
import com.example.pulseliveproject.di.scopes.ActivityScope;
import com.example.pulseliveproject.ui.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getContentList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
