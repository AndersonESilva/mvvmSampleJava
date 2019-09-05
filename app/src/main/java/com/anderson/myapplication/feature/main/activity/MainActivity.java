package com.anderson.myapplication.feature.main.activity;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.anderson.myapplication.R;
import com.anderson.myapplication.feature.main.viewmodel.presentation.MainPresentation;
import com.anderson.myapplication.ui.generic.BaseActivity;
import com.anderson.myapplication.feature.main.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();

    @Inject
    MainViewModel mainViewModel;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initialize() {

        getActivityComponent().inject(this);

        mainViewModel.getMainObservable().observe(this, new Observer<MainPresentation>() {
            @Override
            public void onChanged(MainPresentation mainPresentation) {
                Log.i(TAG, mainPresentation.name);
                Log.i(TAG, mainPresentation.company);
            }
        });
    }

}
