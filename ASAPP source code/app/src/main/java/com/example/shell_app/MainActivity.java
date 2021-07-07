package com.example.shell_app;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Method;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.*;


public class MainActivity extends AppCompatActivity {
    Button commandButton;
    TextView commandText;
    TextView outputCommand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commandButton = (Button) findViewById(R.id.CommandButton);
        outputCommand = (TextView) findViewById(R.id.outputCommand);
        commandText = (TextView) findViewById(R.id.commandText);
        outputCommand.setMovementMethod(new ScrollingMovementMethod());
        commandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = exec(commandText.getText().toString());
                outputCommand.setText("$ " + commandText.getText().toString() + "\n" + output);
                System.out.println("Output: " + output);
            }
        });
    }

    public String exec (String command){
        StringBuffer output = new StringBuffer();
        StringBuffer error = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            if (p.exitValue() != 0){
                InputStream errorStream = p.getErrorStream();
                int c= 0;
                while ((c = errorStream.read()) != -1) {
                    System.out.print((char)c);
                    error.append((char)c);
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, error.toString(),duration);
                toast.show();
            }
            else {
                while ((line = reader.readLine())!= null) {
                    output.append(line + "\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, e.toString(),duration);
            toast.show();
        }
        String response = output.toString();
        return response;

    }




}