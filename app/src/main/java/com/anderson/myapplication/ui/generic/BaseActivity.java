package com.anderson.myapplication.ui.generic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anderson.myapplication.di.ActivityComponent;
import com.anderson.myapplication.di.ActivityModule;
import com.anderson.myapplication.di.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity implements GenericLayouter {

    protected void initialize(Bundle savedInstanceState) {}
    private  ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .build();

        if (getLayout() != -1 && getLayout() != 0) {
            setContentView(getLayout());
        }

        initialize(savedInstanceState);
        initialize();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

}
