package com.example.spusapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar bottomBar;
    public boolean doubleTapParam = false;
//    Button rutin, sekali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
//        mengganti judul pada action bar
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Main Menu");
        }

        //memunculkan fragment diawal
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container,new HomeFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.home_menu:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.payment_menu:
                            selectedFragment = new PaymentFragment();
                            break;
                        case R.id.history_menu:
                            selectedFragment = new HistoryFragment();
                            break;
                        case R.id.account_menu:
                            selectedFragment = new AccountFragment();
                            break;
                    }

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_container, selectedFragment)
                            .commit();

                    return true;
                }
            };
    public void onBackPressed() {
        if (doubleTapParam) {
            super.onBackPressed();
            return;
        }

        this.doubleTapParam = true;
        Toast.makeText(this, "Tap sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleTapParam = false;
            }
        }, 2000);
    }

}

