package com.anderson.myapplication.di;

import com.anderson.myapplication.feature.main.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
