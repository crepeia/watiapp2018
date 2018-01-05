package com.watiapp.watiapp.webService;

import android.content.res.Resources;
import android.util.Log;

import com.watiapp.watiapp.R;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fernanda on 11/12/17.
 */

public class WebService {

    public static Object enviarDadosWS(String method , HashMap<String , Object> dados){

        Resources res = Resources.getSystem();
        String namespace = res.getString(R.string.namespaceWebService);
        String url = res.getString(R.string.urlWebService);
        String actionURL = "";
        Object msg = null;

        //Criando o objeto SOAP
        SoapObject soap = new SoapObject(namespace, method);

        for(Map.Entry<String, Object> entry : dados.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            soap.addProperty(key, value);
        }

        //Criando o envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);

        Log.i("WS", "Enviando dados para WebService");

        //Criando um transporte via HTTP
        HttpTransportSE httpTransportSE = new HttpTransportSE(url);
        try{
            httpTransportSE.debug = true;
            httpTransportSE.call(actionURL, envelope);
            msg = envelope.getResponse();

            Log.i("WS",  "Response: " + msg);

        } catch (HttpResponseException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return msg;
    }
}
