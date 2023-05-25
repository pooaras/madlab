package com.example.exp9;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button BTN;
    private EditText email;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTN = (Button) findViewById(R.id.btn);
        email = (EditText) findViewById(R.id.emailInput);
        BTN.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String val = email.getText().toString();
                if (val == null || val.length() <= 0) {
                    Toast.makeText(getApplicationContext(),
                            "Please Enter the GPA", Toast.LENGTH_LONG).show();
                } else if (val.equals("enpboss@gmail.com")) {
                    Intent intent = new Intent(getApplicationContext(),
                            Second_Activity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),
                            "convert gram to kilogram.....", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                                    "Please Enter valid gpa", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
