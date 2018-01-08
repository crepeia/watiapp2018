package com.watiapp.watiapp.webService;

import android.os.AsyncTask;

import com.watiapp.watiapp.model.Desafio;
import com.watiapp.watiapp.model.Usuario;

import java.util.HashMap;

/**
 * Created by fernanda on 12/12/17.
 */

public class PontoWebService extends AsyncTask<String, Void, Boolean> {

    private Desafio desafio;
    private Usuario usuario;

    public PontoWebService(Desafio desafio, Usuario usuario) {
        this.desafio = desafio;
        this.usuario = usuario;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        Boolean sucesso = true;
        String method = "enviaPontos";

        HashMap<String , Object> dados = new HashMap<>();

        dados.put("desafio" , desafio.getId());
        dados.put("email", usuario.getEmail());

        Object msg = WebService.enviarDadosWS(method , dados);

        if(msg.equals(null)) sucesso = false;

        return sucesso;
    }
}
