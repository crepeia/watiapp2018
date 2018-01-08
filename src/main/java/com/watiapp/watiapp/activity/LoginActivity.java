package com.watiapp.watiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.watiapp.watiapp.R;
import com.watiapp.watiapp.controller.DesafioController;
import com.watiapp.watiapp.controller.UsuarioController;
import com.watiapp.watiapp.dao.DBSQLite;
import com.watiapp.watiapp.model.Desafio;
import com.watiapp.watiapp.model.DesafioUsuario;
import com.watiapp.watiapp.model.Usuario;
import com.watiapp.watiapp.webService.LoginFacebookWebService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by fernanda on 16/12/17.
 */

public class LoginActivity extends AppCompatActivity {

    private DBSQLite dbsqLite;
    private String DB_NAME = String.valueOf(R.string.dbName);
    private int DB_VERSION = Integer.getInteger(String.valueOf(R.string.dbVersion));

    private UsuarioController usuarioController;
    private DesafioController desafioController;

    private LoginButton loginButton;
    private EditText textEmail;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbsqLite = new DBSQLite(LoginActivity.this, DB_NAME , DB_VERSION);
        usuarioController = new UsuarioController(dbsqLite);
        desafioController = new DesafioController(dbsqLite);

        VerificaLoginFacebook();
    }


    private void VerificaLoginFacebook(){

        String applicationId = String.valueOf(String.valueOf(R.string.applicationIdFacebook));
        FacebookSdk.setApplicationId(applicationId);
        FacebookSdk.sdkInitialize(getApplicationContext());
        FacebookSdk.getApplicationSignature(getApplicationContext());

        //loginButton = (LoginButton) findViewById(R.id.button_login);
        //loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                setFacebookData(loginResult);
            }

            @Override
            public void onCancel() {}

            @Override
            public void onError(FacebookException error) {}
        });
    }

    private void setFacebookData(final LoginResult loginResult) {

        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
            Log.i("Login", "Verificando se o usuário já está cadastrado");

            Usuario usuario = getUsuarioObjectJson(object, response);

            usuarioController.criaOuAlteraUsuario(usuario);

            executarWebService(usuario);

            adicionaPontoCadastroApp(usuario);

            redirecionarUsuario(usuario);
        }
    });

    }

    private void executarWebService(Usuario usuario){
        LoginFacebookWebService loginFacebookWebService = new LoginFacebookWebService(usuario);
        loginFacebookWebService.execute();
    }

    private Usuario getUsuarioObjectJson(JSONObject object, GraphResponse response) {

        Usuario usuario = new Usuario();

        try {

            usuario = usuario.setId(object.getInt("id"))
                             .setEmail(response.getJSONObject().getString("email"))
                             .setGenero(response.getJSONObject().getString("gender"))
                             .setNome(response.getJSONObject().getString("first_name"));

        } catch (JSONException ex){
            Log.e("Login" , "Erro ao tentar ler json");
        }

        return usuario;

    }

    private void adicionaPontoCadastroApp(Usuario usuario){
        String titulo =  String.valueOf(R.string.tituloDesafioCadastro);

        Desafio desafioCadastro = desafioController.buscaDesafioTitulo(titulo);
        DesafioUsuario desafioCadastroUsuario = new DesafioUsuario();
        desafioCadastroUsuario = desafioCadastroUsuario.setDesafio(desafioCadastro)
                                                       .setDataRealizacaoTarefa(new Date());


        usuario.getDesafiosRealizados().add(desafioCadastroUsuario);

        usuarioController.alterar(usuario);

    }

    public void redirecionarUsuario(Usuario usuario){
        Intent i;

       // if(usuario.getNumCigarrosDiarios() > 0 && usuario.getValorMaco() > 0){
            i = new Intent(getApplicationContext(), MainActivity.class);
        //}
        //else{
        //    i = new Intent(getApplicationContext(), telaUnica.class);
        //}

        startActivity(i);
    }
}
