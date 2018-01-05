package com.watiapp.watiapp.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.watiapp.watiapp.model.Usuario;
import java.sql.SQLException;

public class UsuarioDAO extends BaseDaoImpl<Usuario, Integer> {

    public UsuarioDAO(ConnectionSource cs) throws SQLException {
        super(Usuario.class);
        setConnectionSource(cs);
        initialize();
    }

}