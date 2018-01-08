package com.watiapp.watiapp.controller;

import android.util.Log;

import com.watiapp.watiapp.dao.DBSQLite;
import com.watiapp.watiapp.dao.DesafioDAO;
import com.watiapp.watiapp.dao.UsuarioDAO;
import com.watiapp.watiapp.model.Usuario;
import com.facebook.AccessToken;

import java.sql.SQLException;

/**
 * Created by fernanda on 16/12/17.
 */

public class UsuarioController {

    private UsuarioDAO usuarioDAO;
    private DBSQLite dbsqLite;

    public UsuarioController(DBSQLite dbsqLite) {
        try {
            this.usuarioDAO = new UsuarioDAO(dbsqLite.getConnectionSource());
            this.dbsqLite = dbsqLite;
        }catch (Exception ex){
            Log.e("UsuarioController" , "Ocorreu um erro ao tentar construir um novo objeto");
        }

    }

    public void criar (Usuario usuario){
        usuarioDAO.criar(usuario);
    }

    public void alterar(Usuario usuario){
        usuarioDAO.alterar(usuario);
    }

    public void criaOuAlteraUsuario(Usuario usuarioNovo){

        if(buscaUsuarioPorEmail(usuarioNovo.getEmail()) != null)
            alterar(usuarioNovo);
        else
            criar(usuarioNovo);
    }

    public Usuario loginUsuario(Usuario usuario){

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        Usuario usuarioLogado = null;


        if(accessToken != null){
            Log.i("UsuarioController", "Usuário logado no sistema: " + usuario.getNome());
            usuarioLogado = usuario;
        }
        else{
            Log.i("UsuarioController", "Usuário deslogado do sistema: " + usuario.getNome());
        }

        return usuarioLogado;
    }

    public Usuario buscaUsuarioPorEmail(String email){
       return  usuarioDAO.buscaUsuarioPorEmail(email);
    }

}
