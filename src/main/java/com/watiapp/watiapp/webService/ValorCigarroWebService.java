package com.watiapp.watiapp.webService;

import android.os.AsyncTask;

import com.watiapp.watiapp.model.Usuario;

import java.util.HashMap;

/**
 * Created by fernanda on 12/12/17.
 */

public class ValorCigarroWebService extends AsyncTask<String, Void, Boolean> {

    private Usuario usuario;
    private UsuarioCigarro usuarioCigarro;

    public ValorCigarroWebService(Usuario usuario, UsuarioCigarro usuarioCigarro) {
        this.usuario = usuario;
        this.usuarioCigarro = usuarioCigarro;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        Boolean sucesso = true;
        String method = "enviaValorCigarro";

        HashMap<String , Object> dados = new HashMap<>();

        dados.put("cigarros", usuarioCigarro.getNumCigarrosDiarios());
        dados.put("valorMaco", usuarioCigarro.getValorMaco());
        dados.put("email", usuario.getEmail());

        Object msg = WebService.enviarDadosWS(method , dados);

        if(msg.equals(null)) sucesso = false;

        return sucesso;
    }
}
