package com.example.fajarmawan.mvp_example.login.presenter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.fajarmawan.mvp_example.login.model.UserInteractor;
import com.example.fajarmawan.mvp_example.login.model.UserInteractorImpl;
import com.example.fajarmawan.mvp_example.login.view.LoginView;

/**
 * Created by fajarmawan on 4/11/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private UserInteractor userInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.userInteractor = new UserInteractorImpl("fajar", "12345");
    }

    @Override
    public void validateCredentials(final String username, final String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        boolean cancel = false;

        if (TextUtils.isEmpty(username)) {
            onUsernameError();
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            onPasswordError();
            cancel = true;
        }

        if (!cancel) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    boolean result = userInteractor.login(username, password);

                    if (result) {
                        onValidateSuccess();
                    } else {
                        onValiateError();
                    }
                }
            }, 2000);
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.showPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.showUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onValiateError() {
        if (loginView != null) {
            loginView.showValidateError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onValidateSuccess() {
        if (loginView != null) {
            loginView.showValidateSuccess();
            loginView.hideProgress();
        }
    }
}
