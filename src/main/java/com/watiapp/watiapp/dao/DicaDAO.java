package com.watiapp.watiapp.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.watiapp.watiapp.model.TarefaDica;
import java.sql.SQLException;

public class DicaDAO extends BaseDaoImpl<TarefaDica, Integer> {

    public DicaDAO(ConnectionSource cs) throws SQLException {
        super(TarefaDica.class);
        setConnectionSource(cs);
        initialize();
    }
}