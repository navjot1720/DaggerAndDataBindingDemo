package com.daggeranddatabindingdemo.di.component;

import android.app.Application;

import com.daggeranddatabindingdemo.DemoApplication;
import com.daggeranddatabindingdemo.di.builder.ActivityBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Rupinder Kaur on 13/8/18.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,  ActivityBuilder.class})
public interface AppComponent {

    void inject(DemoApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
