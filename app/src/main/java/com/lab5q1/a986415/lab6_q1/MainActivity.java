package com.lab5q1.a986415.lab6_q1;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar =findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        manager =getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragments, new HomeFragment());
        transaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                replacefragments(new HomeFragment());
                return true;
            case R.id.menu_about:
                replacefragments(new AboutFragment());
                return true;
            case R.id.menu_work:
                replacefragments(new WorkFragment());
                return true;
            case R.id.menu_contact:
                replacefragments(new ContactFragment());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void replacefragments(Fragment fr){
// replace
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragments, fr);
        ft.commit();
//// remove
//        Fragment fragment = fm.findFragmentById(R.id.your_placehodler);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.remove(fragment);
//        ft.commit();
    }
}
