package com.daggeranddatabindingdemo.modules;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


/**
 * Created by Rupinder Kaur on 13/8/18.
 */
public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> text=new MutableLiveData<>();

    public MutableLiveData<String> getText() {
        return text;
    }

    public void setText(String text) {
        this.text.setValue(text);
    }
}
