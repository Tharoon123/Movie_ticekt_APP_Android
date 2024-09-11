package com.example.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_Book_Ticket extends AppCompatActivity {

    Button btnAdd;
    EditText seats;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_book_activity);

        btnAdd=findViewById(R.id.addRes);
        seats=findViewById(R.id.noSeats);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no_Seats= Integer.parseInt(seats.getText().toString());

                Intent i=new Intent("android.intent.action.ReceiptActivity");

                i.putExtra("KEYSEATS", no_Seats);

                startActivity(i);
                Toast.makeText(getBaseContext(), "Seats Selected" + no_Seats,Toast.LENGTH_LONG).show();

            }
        });

    }
}
