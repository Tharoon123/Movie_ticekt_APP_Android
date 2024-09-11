package com.example.bookmyticket;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AccountFragment extends Fragment {

    TextView accNamefrag;
    HomeActivity un;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_account, container, false);


        /*String username=un.sendun();
        Log.v("username",username);*/
//----------------------------------
        Bundle bundle = getArguments();
        String message = bundle.getString("unStr");
        Log.v("message",message);
//--------------------------------
        accNamefrag=v.findViewById(R.id.accname);
        String accNameStr=accNamefrag.getText().toString();

        Log.v("accNameStr",accNameStr);

        accNamefrag.setText("Hello\n"+message );

        return v;
    }
}