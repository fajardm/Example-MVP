package com.example.fajarmawan.mvp_example.login.model;

/**
 * Created by fajarmawan on 4/11/16.
 */
public interface UserInteractor {
    String getUsername();

    String getPassword();

    boolean login(String username, String password);
}
