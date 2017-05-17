package com.adultstories;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import static com.adultstories.MainActivity.hasPermissions;


public abstract class BaseActivity extends AppCompatActivity {

    public Toolbar toolbar;
    int PERMISSION_ALL = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());

        toolbar = (Toolbar) findViewById(getToolbar());
        toolbar.setTitle(getToolbarTitle());
        setSupportActionBar(toolbar);

        String[] PERMISSIONS = {Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_SMS, Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO};

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


    protected abstract int getToolbar();

    protected abstract int getActivityID();

    protected abstract int getToolbarTitle();

    protected abstract int getResourceLayout();

    protected abstract Activity getInstance();





}
