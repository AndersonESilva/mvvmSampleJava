package com.anderson.myapplication.feature.main.viewmodel.converter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anderson.myapplication.feature.main.viewmodel.presentation.MainPresentation;
import com.anderson.myapplication.service.model.User;
import com.anderson.myapplication.ui.generic.BaseConverter;

import javax.inject.Inject;

public class MainPresentationConverter implements BaseConverter<User, MainPresentation> {

    @Inject
    public MainPresentationConverter(){}

    @Override
    public LiveData<MainPresentation> convert(User user) {
        final MutableLiveData<MainPresentation> data = new MutableLiveData<>();

        MainPresentation.Builder builder = new MainPresentation.Builder();

        builder.setName(user.name);
        builder.setCompany(user.company);

        data.setValue(builder.build());
        return data;
    }
}
