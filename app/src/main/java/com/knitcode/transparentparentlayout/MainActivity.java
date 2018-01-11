package com.knitcode.transparentparentlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_with_xml:
                setContentView(R.layout.first_example);
                return true;
            case R.id.action_without_xml:
                setContentView(R.layout.second_example);
                return true;
            case R.id.action_reset:
                setContentView(R.layout.activity_main);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
