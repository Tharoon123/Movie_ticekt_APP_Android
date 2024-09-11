package com.example.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiptActivity extends AppCompatActivity {
    TextView fee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        fee=findViewById(R.id.fee);

        Intent i=getIntent();
        int seats=i.getIntExtra("KEYSEATS",0);

        int total=seats*450;

        fee.setText("Rs : "+ String.valueOf(total) + "/=");




    }
}
