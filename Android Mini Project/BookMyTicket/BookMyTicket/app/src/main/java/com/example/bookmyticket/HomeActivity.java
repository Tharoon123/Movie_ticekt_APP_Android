package com.example.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    TextView accName;

    BottomNavigationView nav;

    HomeFragment home=new HomeFragment();
    FindFragment fin=new FindFragment();
    BookFragment book=new BookFragment();
    AccountFragment acc=new AccountFragment();
    //----------------------------
    final androidx.fragment.app.FragmentManager mFragmentManager = getSupportFragmentManager();
    final androidx.fragment.app.FragmentTransaction mFragmentTransaction=mFragmentManager.beginTransaction();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        nav=findViewById(R.id.bottom_navi);
        Intent i=getIntent();
        String unStr=i.getStringExtra("KEYNAME");
        Log.v("unStr",unStr);
//-----------------------------------------------

        Bundle mBundle = new Bundle();
        mBundle.putString("unStr",unStr);
        acc.setArguments(mBundle);
        mFragmentTransaction.commit();



        getSupportFragmentManager().beginTransaction().replace(R.id.container,home).commit();

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.getItemId()==R.id.nav_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,home).commit();
                    return true;
                } else if (item.getItemId()==R.id.nav_book) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,book).commit();
                    return true;
                } else if (item.getItemId()==R.id.nav_find) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fin).commit();

                    return true;
                } else if (item.getItemId()==R.id.nav_account) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,acc).commit();
                    return true;
                }


                return false;
            }
        });





    }



}
