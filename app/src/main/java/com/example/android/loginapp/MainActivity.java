package com.example.android.loginapp;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view) {


        EditText et_user = (EditText) findViewById(R.id.et_phone);
        EditText et_password = (EditText) findViewById(R.id.et_password);

        String userName = et_user.getText().toString().trim();
        String password = et_password.getText().toString().trim();


        if (isValidUser(userName) ) {
            if (isValidPasword(password)) {
                //call the login API
                Toast.makeText(this, "You have successfully logged in.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Invalid password/MPIN",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Invalid phone/email.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isValidPasword(String password) {

        String phonePattern = "(?=^\\d{4}$)(\\d)+(?!\\1)\\d\\d*";

        if (password.length() == 8) {
            return true;
        }
        if(password.matches(phonePattern) && password.length()== 4) {
            return true;
        }
        return false;
    }

    private boolean isValidUser(String phone) {
        String phonePattern = "(0/91)?[7-9][0-9]{9}";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (phone.matches(phonePattern) && phone.length() > 2)
        {
            return true;
        }
        if (phone.matches(emailPattern) && phone.length() > 0)
        {
            return true;
        }
        return  false;
    }
}
