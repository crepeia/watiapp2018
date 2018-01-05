package com.watiapp.watiapp.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.watiapp.watiapp.model.Cigarro;
import java.sql.SQLException;

public class CigarroDAO extends BaseDaoImpl<Cigarro, Integer> {

    public CigarroDAO(ConnectionSource cs) throws SQLException {
        super(Cigarro.class);
        setConnectionSource(cs);
        initialize();
    }
}
