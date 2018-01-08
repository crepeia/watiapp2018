package com.watiapp.watiapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.watiapp.watiapp.R;
import com.watiapp.watiapp.controller.DesafioController;
import com.watiapp.watiapp.dao.DBSQLite;

import java.util.List;

/**
 * Created by fernanda on 16/12/17.
 */

public class DesafioActivity extends AppCompatActivity {

    private String DB_NAME = String.valueOf(R.string.dbName);
    private int DB_VERSION = Integer.getInteger(String.valueOf(R.string.dbVersion));
    private DesafioController desafioController;
    private DBSQLite dbsqLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio);

        dbsqLite = new DBSQLite(DesafioActivity.this, DB_NAME , DB_VERSION);
        desafioController = new DesafioController(dbsqLite);

        preencheListaDesafios();
    }

    private void preencheListaDesafios(){
        ListView listaDesafios = (ListView) findViewById(R.id.listDesafios);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, desafioController.buscaDesafiosString());
        listaDesafios.setAdapter(adapter);
    }

}
