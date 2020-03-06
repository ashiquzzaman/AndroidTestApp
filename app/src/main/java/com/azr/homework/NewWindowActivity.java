package com.azr.homework;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewWindowActivity extends AppCompatActivity {
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_window);
        txtView=(TextView)findViewById(R.id.textViewMain);

        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("txtValue");

        txtView.setText(result);
    }
}

