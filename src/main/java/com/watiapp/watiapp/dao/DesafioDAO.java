package com.watiapp.watiapp.dao;

import android.util.Log;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.watiapp.watiapp.model.Desafio;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class DesafioDAO extends BaseDaoImpl<Desafio, Integer> {

    private static final int COLUNA_DESC = 2;

    public DesafioDAO(ConnectionSource cs) throws SQLException {
        super(Desafio.class);
        setConnectionSource(cs);
        initialize();
    }

    public List<String> buscaDesafiosString(){
        List<String> desafios = new ArrayList<>();

        try {

            desafios = this.queryRaw("SELECT descricao FROM desafio", new RawRowMapper<String>() {
                @Override
                public String mapRow(String[] columnNames, String[] resultColumns) throws SQLException {
                    return resultColumns[COLUNA_DESC];
                }
            }).getResults();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return desafios;
    }

    public List<Desafio> buscaDesafios(){
        List<Desafio> desafios = new ArrayList<>();

        try {

            desafios = this.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return desafios;
    }


    public Desafio buscaDesafioTitulo(String titulo){
        Desafio desafio = new Desafio();

        try {
            desafio = (Desafio) queryBuilder().where().eq("titulo", titulo).query();
        }catch (SQLException ex){
            Log.e("DesafioDAO" , "Ocorreu um erro ao buscar desafio pelo titulo");
        }

        return desafio;
    }


}
