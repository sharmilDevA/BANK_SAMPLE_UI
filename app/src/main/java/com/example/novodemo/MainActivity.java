package com.example.novodemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

/**
 * Used Card view for design
 * used vector images for all images and icon used
 * used horizontal recycler view
 * completed only the design part
 */
public class MainActivity extends AppCompatActivity {
BottomNavigationView navigationView;
private Fragment current_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            int pos= R.id.homeFragment;
            selfrag(pos);
            navigationView= findViewById(R.id.bottomNavigationView);
            navigationView.setOnNavigationItemSelectedListener(item -> {
                selfrag( item.getItemId());
                return true;
            });

        }catch(Exception ignored){}
    }
    public void selfrag(int item){
        try {
            Fragment selectedFragment = null;
            switch (item) {
                case R.id.homeFragment:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.bankFragment:
                    selectedFragment = new BankFragment();
                    break;
                case R.id.historyFragment:
                    selectedFragment = new HistoryFragment();
                    break;
                case R.id.profileFragment:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            current_fragment=selectedFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.Fragment,selectedFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }catch(Exception ignored){

        }
    }
}