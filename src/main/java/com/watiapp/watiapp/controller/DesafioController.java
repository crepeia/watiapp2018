package com.watiapp.watiapp.controller;

import com.watiapp.watiapp.dao.DBSQLite;
import com.watiapp.watiapp.dao.DesafioDAO;
import com.watiapp.watiapp.model.TarefaDesafio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernanda on 19/12/17.
 */

public class DesafioController {

    private DesafioDAO desafioDAO;
    private DBSQLite dbsqLite;

    public DesafioController(DBSQLite dbsqLite) throws SQLException {
        this.desafioDAO = new DesafioDAO(dbsqLite.getConnectionSource());
        this.dbsqLite = dbsqLite;
    }

    public List<String> buscaDesafiosString(){

        return desafioDAO.buscaDesafiosString();
    }

    public List<TarefaDesafio> buscaDesafios(){
        List<TarefaDesafio> desafios = new ArrayList<>();

        try {

            desafios = desafioDAO.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return desafios;
    }

}
