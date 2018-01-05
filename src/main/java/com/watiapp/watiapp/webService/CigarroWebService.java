package com.watiapp.watiapp.webService;

import android.os.AsyncTask;

import com.watiapp.watiapp.model.Cigarro;
import com.watiapp.watiapp.model.Usuario;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by fernanda on 11/12/17.
 */

public class CigarroWebService extends AsyncTask<String, Void, Boolean> {

    private Cigarro cigarro = new Cigarro();
    private Usuario usuario = new Usuario();

    public CigarroWebService(Cigarro cigarro, Usuario usuario){
        this.cigarro = cigarro;
        this.usuario = usuario;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        Boolean sucesso = true;
        String method = "enviaCigarros";

        HashMap<String , Object> dados = new HashMap<>();
        dados.put("data" , cigarro.getDate().getTime());
        dados.put("cigarros" , cigarro.getNumCigarros());
        dados.put("email", usuario.getEmail());

        Object msg = WebService.enviarDadosWS(method, dados);

        if(msg.equals(null)) sucesso = false;

        return sucesso;
    }
}
