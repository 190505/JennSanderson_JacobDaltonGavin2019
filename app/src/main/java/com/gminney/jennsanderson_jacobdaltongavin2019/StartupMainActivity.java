package com.gminney.jennsanderson_jacobdaltongavin2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        switch1 = findViewById(R.id.switch1);
        button1 = findViewById(R.id.button1);
        mEditText = findViewById(R.id.editText2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString() == getString(R.string.password)){
                    Intent intent = new Intent(StartupMainActivity.this, BotStatusActivity.this);
                    startActivity(intent);
                }
            }
        });



    }

}
