package com.watiapp.watiapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.watiapp.watiapp.R;
import com.watiapp.watiapp.dao.DBSQLite;

public class MainActivity extends AppCompatActivity {

    private DBSQLite dbsqLite;
    private String DB_NAME;
    private int DB_VERSION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB_NAME = String.valueOf(R.string.dbName);
        DB_VERSION = Integer.getInteger(String.valueOf(R.string.dbVersion));

        dbsqLite = new DBSQLite(MainActivity.this, DB_NAME , DB_VERSION);
    }
}
