package com.anderson.myapplication.service;


import com.anderson.myapplication.service.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    String HTTPS_API_GITHUB_URL = "https://api.github.com/";

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);
}
