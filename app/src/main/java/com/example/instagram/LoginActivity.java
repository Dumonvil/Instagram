package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin =findViewById(R.id.btnLogin);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username,password);
            }
        });
    }
    private void login(String username,String password){
        // TODO navigate to new aactivity if the user has signed properly
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e !=null){
                    Log.e(TAG, "Issue With login");
                    e.printStackTrace();
                    return;
                }
                goMain2Activity();
            }

            private void goMain2Activity() {
                Log.d(TAG, "NAVIGAtion to Main2Activity");
                Intent intent = new Intent(LoginActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
