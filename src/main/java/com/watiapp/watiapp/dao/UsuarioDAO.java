package com.watiapp.watiapp.dao;

import android.util.Log;

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

    public Usuario buscaUsuarioPorEmail(String email) {

        Usuario usuario = new Usuario();

        try {
            usuario = (Usuario)this.queryForEq("email" , email);

        }catch(SQLException ex){
            Log.e("UsuarioDAO" , "Erro ao tentar buscar usuario pelo email");
        }

        return usuario;
    }

    public void criar(Usuario usuario) {
        try {
            this.create(usuario);
        }catch(SQLException ex) {
            Log.e("UsuarioDAO", "Erro ao tentar criar usuario");
        }
    }

    public void alterar(Usuario usuario) {
        try {
            this.update(usuario);
        }catch(SQLException ex) {
            Log.e("UsuarioDAO", "Erro ao tentar alterar usuario");
        }
    }
}