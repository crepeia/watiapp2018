package com.watiapp.watiapp.webService;

import android.os.AsyncTask;

import com.watiapp.watiapp.model.Usuario;

import org.ksoap2.serialization.SoapObject;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by fernanda on 11/12/17.
 */

public class MediaCigarrosWebService extends AsyncTask<String, Void, Double> {

    private Date data;

    public MediaCigarrosWebService(Date data) {
        this.data = data;
    }

    @Override
    protected Double doInBackground(String... strings) {
        String method = "mediaGrafico";

        HashMap<String , Object> dados = new HashMap<>();

        dados.put("data", data.getTime());

        Object msg = WebService.enviarDadosWS(method , dados);

        return retornaMediaCigarro(msg);
    }

    private Double retornaMediaCigarro(Object msg){

        SoapObject soapObject = (SoapObject) msg;

        Double media = Double.parseDouble(String.valueOf(soapObject.getProperty("media")));

        return media;
    }
}
