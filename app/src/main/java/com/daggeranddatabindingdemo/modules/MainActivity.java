package com.daggeranddatabindingdemo.modules;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daggeranddatabindingdemo.R;
import com.daggeranddatabindingdemo.TestClass;
import com.daggeranddatabindingdemo.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    TestClass testClass;
    @Inject
    MainActivityViewModel mainActivityViewModel;
    @Inject
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for dagger dependency injection
        AndroidInjection.inject(this);

        //data binding
        activityMainBinding.btnUpdateTextview.setOnClickListener(this);
        mainActivityViewModel.getText().observe(this, new Observer<String> () {

            @Override
            public void onChanged(@Nullable String s) {
                activityMainBinding.textView.setText(s);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_update_textview:
                mainActivityViewModel.setText(activityMainBinding.etText.getText().toString());
                break;
        }
    }
}
