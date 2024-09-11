package com.example.bookmyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button loginBtn;
    EditText un,pw;

    TextView create,accName;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn=findViewById(R.id.login_btn);

        un=findViewById(R.id.un_input_login);
        pw=findViewById(R.id.pw_input_login);
        create=findViewById(R.id.create);


        dbHelper=new DBHelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String unStr=un.getText().toString();
                String pwStr=pw.getText().toString();

                Log.v("show",unStr   +   pwStr);


                Boolean checkuserpass=dbHelper.checkUnPw(unStr,pwStr);

                if (checkuserpass==true){

                    Toast.makeText(getBaseContext(), "Login SuccessFull",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent("android.intent.action.HomeActivity");
                    i.putExtra("KEYNAME",unStr);
                    startActivity(i);
                }else {

                    Toast.makeText(getBaseContext(), "Fail, Try Again",  Toast.LENGTH_SHORT).show();
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("android.intent.action.CreateUserActivity");
                startActivity(i);

            }
        });

    }
}