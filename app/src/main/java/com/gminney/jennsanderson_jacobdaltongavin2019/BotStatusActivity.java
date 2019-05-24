package com.gminney.jennsanderson_jacobdaltongavin2019;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.Messaging;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.messaging.MessageStatus;
import com.backendless.messaging.PublishOptions;
import com.backendless.push.DeviceRegistrationResult;
import com.google.firebase.FirebaseApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BotStatusActivity extends AppCompatActivity {

    private static Socket socket;
    private static ServerSocket serverSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static PrintWriter printWriter;
    private String message;
    private static String ip = "172.20.10.147";

    private EditText urlTextField1;
    private EditText urlTextField2;
    private EditText urlTextField3;
    private EditText urlTextField4;
    private EditText urlTextField5;
    private Button button;
    private String API_KEY;
    private String APP_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bot_status_activity);

        API_KEY = getString(R.string.API_KEY);
        APP_ID = getString(R.string.APP_ID);

        urlTextField1 = findViewById(R.id.urlText1);
        urlTextField2 = findViewById(R.id.urlText2);
        urlTextField3 = findViewById(R.id.urlText3);
        urlTextField4 = findViewById(R.id.urlText4);
        urlTextField5 = findViewById(R.id.urlText5);
        button = findViewById(R.id.button);

        Backendless.initApp(getApplicationContext(), APP_ID, API_KEY);
        //FirebaseApp.initializeApp
        final PublishOptions publishOptions = new PublishOptions();
        List<String> channels = new ArrayList<String>();
        channels.add( "androidMessage" );
        Backendless.Messaging.registerDevice(channels, new AsyncCallback<DeviceRegistrationResult>() {
            @Override
            public void handleResponse(DeviceRegistrationResult response) {
                System.out.println("Backendless registered to messaging channel androidMessage");

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                System.out.println("Backendless fault : " + fault);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Send button -  data sent");
                message = urlTextField1.getText().toString().trim();
                Backendless.Messaging.publish("androidMessage", message, publishOptions);

                //SendMessage sendMessage = new SendMessage();
            }
        });




    }


}
    /*class SendMessage extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            message = urlTextField1.getText().toString().trim();
            try {
                socket = new Socket(ip, 5000);
                printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.write(message);
                printWriter.flush();
                printWriter.close();
                socket.close();
            }
            catch (IOException exception){
                exception.printStackTrace();
            }
            return null;
        }
    }

}
*/