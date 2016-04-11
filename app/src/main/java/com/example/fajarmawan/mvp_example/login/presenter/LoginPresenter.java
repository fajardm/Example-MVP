package com.example.fajarmawan.mvp_example.login.presenter;

/**
 * Created by fajarmawan on 4/11/16.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();

    void onPasswordError();

    void onUsernameError();

    void onValiateError();

    void onValidateSuccess();
}
