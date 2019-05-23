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


public class StartupMainActivity extends AppCompatActivity {

    private Switch switch1;
    private Button button1;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.startup_activity_main);
        switch1 = findViewById(R.id.switch1);
        button1 = findViewById(R.id.button1);
        mEditText = findViewById(R.id.editText2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().trim().equals(getString(R.string.password))){
                    Intent intent = new Intent(getApplicationContext(), BotStatusActivity.class);
                    startActivity(intent);
                    System.out.println("Correct Password");
                }
            }
        });



    }

}
