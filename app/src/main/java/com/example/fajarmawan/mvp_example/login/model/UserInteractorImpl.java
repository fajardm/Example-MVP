package com.example.fajarmawan.mvp_example.login.model;

/**
 * Created by fajarmawan on 4/11/16.
 */
public class UserInteractorImpl implements UserInteractor {

    enum ERROR_CODE {
        PASSWORD_ERROR,
        USERNAME_ERROR,
        VALIDATE_ERROR
    }

    private String username;
    private String password;

    public UserInteractorImpl(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
}
