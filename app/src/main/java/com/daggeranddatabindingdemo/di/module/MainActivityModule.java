package com.daggeranddatabindingdemo.di.module;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;

import com.daggeranddatabindingdemo.BR;
import com.daggeranddatabindingdemo.R;
import com.daggeranddatabindingdemo.TestClass;
import com.daggeranddatabindingdemo.databinding.ActivityMainBinding;
import com.daggeranddatabindingdemo.di.MainActivityBindingVariableInfo;
import com.daggeranddatabindingdemo.di.MainActivityLayoutInfo;
import com.daggeranddatabindingdemo.modules.MainActivity;
import com.daggeranddatabindingdemo.modules.MainActivityViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rupinder Kaur on 13/8/18.
 */

@Module
public class MainActivityModule {

    @Provides
    AppCompatActivity provideContext(Application application) {
        return (AppCompatActivity) application.getApplicationContext();
    }

    @MainActivityBindingVariableInfo
    @Provides
    int getMainActivityBindingVariable() {
        return BR.mainActivityViewModel;
    }

    @MainActivityLayoutInfo
    @Provides
    int getMainActivityLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Provides
    TestClass provideTestClassInstance() {
        return new TestClass();
    }

    @Provides
    MainActivityViewModel provideMainActivityViewModelInstance() {
        return new MainActivityViewModel();
    }


    @Provides
    ActivityMainBinding provideMainActivityBindingInstance(@MainActivityLayoutInfo int mainActivitylayoutResourceId,@MainActivityBindingVariableInfo int mainActivityBindingVariable,MainActivity mainActivity,MainActivityViewModel mainActivityViewModel) {
       ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(mainActivity,mainActivitylayoutResourceId);
        activityMainBinding.setVariable(mainActivityBindingVariable, mainActivityViewModel);
        activityMainBinding.executePendingBindings();
        return activityMainBinding;
    }

}
