package com.watiapp.watiapp.webService;

import android.os.AsyncTask;

import com.watiapp.watiapp.model.Usuario;

import java.util.HashMap;

/**
 * Created by fernanda on 11/12/17.
 */

public class LoginFacebookWebService extends AsyncTask<String, Void, Boolean> {

    private Usuario usuario = new Usuario();

    public LoginFacebookWebService(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        Boolean sucesso = true;

        String method = "usuariosFacebook";

        HashMap<String , Object> dados = new HashMap<>();

        dados.put("name" , usuario.getNome());
        dados.put("email" , usuario.getEmail());
        dados.put("gender" , usuario.getGenero());

        Object msg = WebService.enviarDadosWS(method, dados);

        if(msg.equals(null)) sucesso = false;

        return sucesso;
    }
}
