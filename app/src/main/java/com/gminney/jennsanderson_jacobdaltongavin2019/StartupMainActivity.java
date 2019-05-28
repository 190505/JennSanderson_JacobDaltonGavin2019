package com.gminney.jennsanderson_jacobdaltongavin2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

/////////// StartupMainActivity is the startup activity for the entire application /////////////////////////////////////////////////////////
public class StartupMainActivity extends AppCompatActivity {
    /////////// Variable instantiation for login button and and password text field ////////////////////////////////////////////////////////
    private Button button1;
    private EditText mEditText;

/////////// onCreate method sets the application to be NO TITLE, assigns startup_activity_main as the xml, ////////////////////////////////
/////////// and links up the button and editText to code //////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.startup_activity_main);
        button1 = findViewById(R.id.button1);
        mEditText = findViewById(R.id.editText2);

/////////// onClickListenter for login button to match password to editText field then starts a new intent ////////////////////////////////
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().trim().equals(getString(R.string.password))){
                    Intent intent = new Intent(getApplicationContext(), BotStatusActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
