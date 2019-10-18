package com.example.uts_d1041161024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.accounts.Account;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Home HomeFragment;
    private Kelas KelasFragment;
    private Method MethodFragment;
    private Operator OperatorFragment;
    private Relation RelationFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        HomeFragment = new Home();
        KelasFragment = new Kelas();
        MethodFragment = new Method();
        OperatorFragment = new Operator();
        RelationFragment = new Relation();
        setFragment(HomeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case  R.id.nav_home :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(HomeFragment);
                        return true;

                    case R.id.nav_kelas:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(KelasFragment);
                        return true;

                    case R.id.nav_method:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(MethodFragment);
                        return true;

                    case R.id.nav_operator:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(OperatorFragment);
                        return true;

                    case R.id.nav_relation:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(RelationFragment);
                        return true;

                    default :
                        return false;
                }
            }
        });


    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager() .beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
