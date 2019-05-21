package com.gminney.jennsanderson_jacobdaltongavin2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class StartupMainActivity extends AppCompatActivity {

    private Switch switch1;
    private Button button1;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        switch1 = findViewById(R.id.switch1);
        button1 = findViewById(R.id.button1);



    }



}
