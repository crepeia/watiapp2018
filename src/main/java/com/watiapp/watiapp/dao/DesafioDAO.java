package com.watiapp.watiapp.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.support.ConnectionSource;
import com.watiapp.watiapp.model.TarefaDesafio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DesafioDAO extends BaseDaoImpl<TarefaDesafio, Integer> {

    private static final int COLUNA_DESC = 2;


    public DesafioDAO(ConnectionSource cs) throws SQLException {
        super(TarefaDesafio.class);
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
}
