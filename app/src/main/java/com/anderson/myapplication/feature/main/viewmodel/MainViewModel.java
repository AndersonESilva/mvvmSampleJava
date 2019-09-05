package com.anderson.myapplication.feature.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.anderson.myapplication.feature.main.viewmodel.presentation.MainPresentation;
import com.anderson.myapplication.feature.main.viewmodel.converter.MainPresentationConverter;
import com.anderson.myapplication.service.UserRepository;

import javax.inject.Inject;

public class MainViewModel{

    private final LiveData<MainPresentation> mainObservable;

    @Inject
    public MainViewModel(MainPresentationConverter mainPresentationConverter,
                         UserRepository repository){

        String nome = "LombiqBot";

        mainObservable = Transformations.switchMap(repository.getUser(nome), input ->{

            return mainPresentationConverter.convert(input);
        });

    }

    public LiveData<MainPresentation> getMainObservable() {
        return mainObservable;
    }
}
