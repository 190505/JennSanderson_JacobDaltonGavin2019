package com.gminney.jennsanderson_jacobdaltongavin2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class StartupMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) throws LoginException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_activity_main);

        JDABuilder bot = new JDABuilder(AccountType.BOT);
        bot.setToken(getString(R.string.TOKEN_STRING));
        bot.build();




    }
}
