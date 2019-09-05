package com.anderson.myapplication.service;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anderson.myapplication.service.model.User;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private GitHubService gitHubService;

    @Inject
    public UserRepository(GitHubService gitHubService){
        this.gitHubService = gitHubService;
    }

    public LiveData<User> getUser(String userName){
        final MutableLiveData<User> data = new MutableLiveData<>();

        gitHubService.getUser(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                simulateDelay();
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    private void simulateDelay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
