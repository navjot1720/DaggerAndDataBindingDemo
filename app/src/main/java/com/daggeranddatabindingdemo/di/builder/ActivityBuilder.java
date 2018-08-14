package com.daggeranddatabindingdemo.di.builder;


import com.daggeranddatabindingdemo.modules.MainActivity;
import com.daggeranddatabindingdemo.di.module.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Rupinder Kaur on 13/8/18.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
