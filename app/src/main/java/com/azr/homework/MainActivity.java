package com.azr.homework;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    Spinner s1,s2;
    TextView txtView;
    Button newActivityBtn;
    Button newAppBtn;
    Button stopWatchBtn;
    EditText txtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        s1.setOnItemSelectedListener(this);

        txtView=(TextView)findViewById(R.id.textViewMain);
        // txtView.setText(result);


        newActivityBtn = (Button)findViewById(R.id.newActivityBtn);
        newActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show result in a new activity => Implicit
                Intent newIntent = new Intent(MainActivity.this, NewWindowActivity.class);
                newIntent.putExtra("txtValue", getResult());
                MainActivity.this.startActivity(newIntent);
            }
        });


        newAppBtn = (Button)findViewById(R.id.newAppBtn);
        newAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show result in a new application => Explicit
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                myIntent.putExtra(Intent.EXTRA_TEXT, getResult());
                MainActivity.this.startActivity(myIntent);
            }
        });


        stopWatchBtn = (Button)findViewById(R.id.stopWatchBtn);
        stopWatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stIntent = new Intent(MainActivity.this, StopWatchActivity.class);
                stIntent.putExtra("txtValue", getResult());
                MainActivity.this.startActivity(stIntent);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

        String sp1= String.valueOf(s1.getSelectedItem());
        Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Income")) {
            List<String> list = new ArrayList<String>();
            list.add("Salary");
            list.add("Sales");
            list.add("Others");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("Expense")) {
            List<String> list = new ArrayList<String>();
            list.add("Conveyance");
            list.add("Breakfast");
            list.add("Purchase");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {


    }


    public String getResult(){
        String acc = getResources().getString(R.string.suAcc);
        String sacc = getResources().getString(R.string.suSubAcc);
        String sp2= String.valueOf(s2.getSelectedItem());
        String sp1= String.valueOf(s1.getSelectedItem());

        txtAmount   = (EditText)findViewById(R.id.txtAmount);
        String result= "You are selected \n\n"+acc +": "+sp1 +"\n"+sacc+": "+sp2
                +"\n"+"Amount"+": "+txtAmount.getText().toString();
        return result;
    }


}