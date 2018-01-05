package com.watiapp.watiapp.controller;

import android.util.Log;

import com.watiapp.watiapp.model.Usuario;
import com.facebook.AccessToken;

/**
 * Created by fernanda on 16/12/17.
 */

public class UsuarioController {

    private Usuario loginUsuario(Usuario usuario){

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
}
