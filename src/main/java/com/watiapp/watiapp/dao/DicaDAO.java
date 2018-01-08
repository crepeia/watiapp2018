package com.watiapp.watiapp.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.watiapp.watiapp.model.Dica;
import java.sql.SQLException;

public class DicaDAO extends BaseDaoImpl<Dica, Integer> {

    public DicaDAO(ConnectionSource cs) throws SQLException {
        super(Dica.class);
        setConnectionSource(cs);
        initialize();
    }
}