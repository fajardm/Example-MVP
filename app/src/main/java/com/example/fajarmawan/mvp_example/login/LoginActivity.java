package com.example.fajarmawan.mvp_example.login;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fajarmawan.mvp_example.R;
import com.example.fajarmawan.mvp_example.login.presenter.LoginPresenter;
import com.example.fajarmawan.mvp_example.login.presenter.LoginPresenterImpl;
import com.example.fajarmawan.mvp_example.login.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ProgressDialog progress;
    private EditText username;
    private EditText password;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
    }

    private void initComponents() {
        username = (EditText) findViewById(R.id.username_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);
        loginPresenter = new LoginPresenterImpl(this);

        progress = new ProgressDialog(this);
        progress.setMessage("Please Wait...");
        progress.setIndeterminate(true);
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progress.show();
    }

    @Override
    public void hideProgress() {
        progress.hide();
    }

    @Override
    public void showUsernameError() {
        username.setError(getString(R.string.error_null_username));
    }

    @Override
    public void showPasswordError() {
        password.setError(getString(R.string.error_null_password));
    }

    @Override
    public void showValidateError() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showValidateSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void login(View v) {
        loginPresenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
