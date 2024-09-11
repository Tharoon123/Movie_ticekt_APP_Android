package com.example.bookmyticket;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BookFragment extends Fragment {

    Button btn1,btn2,btn3,btn4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_book, container, false);

        btn1=(Button) v.findViewById(R.id.book1);
        btn2=(Button) v.findViewById(R.id.book2);
        btn3=(Button) v.findViewById(R.id.book3);
        btn4=(Button) v.findViewById(R.id.book4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("android.intent.action.Activity_Book_Ticket");
                startActivity(i);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("android.intent.action.Activity_Book_Ticket");
                startActivity(i);


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("android.intent.action.Activity_Book_Ticket");
                startActivity(i);


            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("android.intent.action.Activity_Book_Ticket");
                startActivity(i);


            }
        });

        return v;

    }


}