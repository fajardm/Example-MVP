package com.example.fajarmawan.mvp_example.login.view;

import android.view.View;

/**
 * Created by fajarmawan on 4/11/16.
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void showUsernameError();

    void showPasswordError();

    void showValidateError();

    void showValidateSuccess();

    void login(View v);
}
