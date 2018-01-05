package com.watiapp.watiapp.webService;

import android.os.AsyncTask;
import android.util.Log;

import com.watiapp.watiapp.model.Usuario;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by fernanda on 11/12/17.
 */

public class LoginSiteWebService extends AsyncTask<String, Void, Usuario> {

    private String email;

    public LoginSiteWebService(String email){
        this.email = email;
    }

    @Override
    protected Usuario doInBackground(String... params) {
        Usuario usuarioLogado = null;
        String method = "validate";

        HashMap<String , Object> dados = new HashMap<>();

        dados.put("email", email);

        Object msg = WebService.enviarDadosWS(method, dados);

        if(!msg.equals(null)){
           usuarioLogado = retornaUsuarioLogado(msg);
        }

        return usuarioLogado;
    }

    private Usuario retornaUsuarioLogado(Object msg){
        Usuario usuario = new Usuario();
        SoapObject soapObject = (SoapObject) msg;

        usuario.setEmail(String.valueOf(soapObject.getProperty("email")));
        usuario.setNome(String.valueOf(soapObject.getProperty("name")));
        usuario.setGenero(String.valueOf(soapObject.getProperty("gender")));

        return usuario;
    }
}
