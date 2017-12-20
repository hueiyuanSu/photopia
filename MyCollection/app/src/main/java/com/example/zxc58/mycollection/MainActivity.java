package com.example.zxc58.mycollection;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
    }
    public void onClick(View view) {
        transaction = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.Button1:
                BlankFragment blank = new BlankFragment();
                transaction.replace(R.id.fragment, blank, "blank");

                break;
            case R.id.Button2:
                BlankFragment2 blank_fragment2 = new BlankFragment2();
                transaction.replace(R.id.fragment, blank_fragment2, "blank_fragment2");
                break;

        }
        transaction.commit();
    }
}
