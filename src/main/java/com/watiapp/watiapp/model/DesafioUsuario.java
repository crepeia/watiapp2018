package com.watiapp.watiapp.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by fernanda on 05/01/18.
 */

@DatabaseTable(tableName = "desafio_usuario")
public class DesafioUsuario {

    @DatabaseField(columnName ="id", generatedId = true)
    private int id;
    @DatabaseField(columnName ="data_realizacao")
    private Date dataRealizacaoTarefa;
    @DatabaseField(foreign = true)
    private Desafio desafio;

    public DesafioUsuario() {}

    public int getId() {
        return id;
    }

    public DesafioUsuario setId(int id) {
        this.id = id;
        return this;
    }

    public Desafio getDesafio() {
        return desafio;
    }

    public DesafioUsuario setDesafio(Desafio desafio) {
        this.desafio = desafio;
        return this;
    }

    public Date getDataRealizacaoTarefa() {
        return dataRealizacaoTarefa;
    }

    public DesafioUsuario setDataRealizacaoTarefa(Date dataRealizacaoTarefa) {
        this.dataRealizacaoTarefa = dataRealizacaoTarefa;
        return this;
    }
}
