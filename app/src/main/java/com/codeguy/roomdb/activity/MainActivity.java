package com.codeguy.roomdb.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codeguy.roomdb.R;
import com.codeguy.roomdb.db.AppDatabase;
import com.codeguy.roomdb.utils.DatabaseInit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseInit.populateAsync(AppDatabase.getAppDatabase(this));
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
