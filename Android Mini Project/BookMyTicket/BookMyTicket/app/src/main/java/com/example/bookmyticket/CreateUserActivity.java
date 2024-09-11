package com.example.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateUserActivity extends AppCompatActivity {

    Button insert;
    EditText un,pw,pwConf;
    DBHelper dbHelper;

    TextView login;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        insert=findViewById(R.id.insert);
        un=findViewById(R.id.unCreate);
        pw=findViewById(R.id.pw);
        pwConf=findViewById(R.id.pwConfirm);
        login=findViewById(R.id.login);

        dbHelper=new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=un.getText().toString();
                String pass=pw.getText().toString();
                String passConf=pwConf.getText().toString();

                if (pass.equals(passConf)){
                    Boolean checkinsertdata=dbHelper.insertLoginData(user,pass);
                    if (checkinsertdata==true){
                        Toast.makeText(getBaseContext(),"User Created",Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(getBaseContext(),"Error Occured",Toast.LENGTH_LONG).show();


                    }
                }else {
                    Toast.makeText(getBaseContext(),"Password Doesn't Match",Toast.LENGTH_LONG).show();

                }



            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(CreateUserActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
