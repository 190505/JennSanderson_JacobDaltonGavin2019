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

/////////// BotStatusActivity is the main screen that reveals bot information as well as a music queue and chat  ////////////////////////////////////////////////////////
public class BotStatusActivity extends AppCompatActivity {
    /////////// Variable instantiation for server communications, strings, and elements /////////////////////////////////////////////////////////////////////////////////
    private static Socket socket;
    private static PrintWriter printWriter;
    private String message;
    private String serverMessage;
    private static String ip = "73.130.144.51";
    private EditText urlTextField1;
    private EditText urlTextField2;
    private EditText urlTextField3;
    private EditText urlTextField4;
    private EditText urlTextField5;
    private EditText editText;
    private Button button;
    private Button button2;

/////////// onCreate method sets activity to NO TITLE and layout to bot_status_activity xml ////////////////////////////////////////////////////////////////////////////
/////////// Assigns editText and buttons to code ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bot_status_activity);

        urlTextField1 = findViewById(R.id.urlText1);
        urlTextField2 = findViewById(R.id.urlText2);
        urlTextField3 = findViewById(R.id.urlText3);
        urlTextField4 = findViewById(R.id.urlText4);
        urlTextField5 = findViewById(R.id.urlText5);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

/////////// Unused code for backendless and firebase ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        Backendless.initApp(getApplicationContext(), APP_ID, API_KEY);
        FirebaseApp.initializeApp(this);

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
        */

/////////// onClickListener for button to queue music through editText to server/////////////////////////////////////////////////////////////////////////////////////////
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Send button -  link sent");
                serverMessage = urlTextField1.getText().toString().trim();
                message = "+++" + serverMessage;
                SendMessage sendMessage = new SendMessage();
                sendMessage.execute();
            }
        });
/////////// onClickListenter for button to send chat messages to server /////////////////////////////////////////////////////////////////////////////////////////////////
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Send button -  chat sent");
                serverMessage = editText.getText().toString().trim();
                message = "---" + serverMessage;
                SendMessage sendMessage = new SendMessage();
                sendMessage.execute();
            }
        });
    }

/////////// Anonymous inner class off of the main thread that sends messages to a server using a socket /////////////////////////////////////////////////////////////////
    class SendMessage extends AsyncTask{
/////////// Creates a socket with an ip address and port number, writes information, sends, and closes the socket ////////////////////////////////////////////////////////
        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                socket = new Socket(ip, 5000);
                printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.write(message);
                printWriter.flush();
                printWriter.close();
                socket.close();
            }
/////////// Error handling for bad/no connection //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            catch (IOException exception){
                exception.printStackTrace();
                Toast.makeText(getApplicationContext(), R.string.badconnection, Toast.LENGTH_LONG);
            }
            return null;
        }
    }

}
