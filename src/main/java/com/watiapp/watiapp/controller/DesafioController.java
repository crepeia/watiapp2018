package com.watiapp.watiapp.controller;

import android.util.Log;

import com.watiapp.watiapp.dao.DBSQLite;
import com.watiapp.watiapp.dao.DesafioDAO;
import com.watiapp.watiapp.model.Desafio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fernanda on 19/12/17.
 */

public class DesafioController {

    private DesafioDAO desafioDAO;
    private DBSQLite dbsqLite;

    public DesafioController(DBSQLite dbsqLite) {
        try{
            this.desafioDAO = new DesafioDAO(dbsqLite.getConnectionSource());
            this.dbsqLite = dbsqLite;

        }catch (Exception ex){
            Log.e("DesafioController" , "Ocorreu um erro ao tentar construir um novo objeto");
        }
    }

    public List<String> buscaDesafiosString(){

        return desafioDAO.buscaDesafiosString();
    }

    public List<Desafio> buscaDesafios(){

        return desafioDAO.buscaDesafios();
    }

    public Desafio buscaDesafioTitulo(String titulo){
        return desafioDAO.buscaDesafioTitulo(titulo);
    }

}
