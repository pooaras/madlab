package com.example.experiment2;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button bt;

    //Data for populating in Spinner
    String [] dept_array={"O","A+","A","B","B+","B","RW"};
    String kg,reg,dept; int name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referring the Views
        e1= (EditText) findViewById(R.id.editText);

        bt= (Button) findViewById(R.id.button);

        //Creating Listener for Button
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting the Values from Views(Edittext & Spinner)
                name=Integer.parseInt(e1.getText().toString());
                kg=String. valueOf( name*1000);


                //Intent For Navigating to Second Activity
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                //For Passing the Values to Second Activity
                i.putExtra("name_key",kg );


                startActivity(i);
            }
        });
    }
}

