package com.watiapp.watiapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by fernanda on 05/01/18.
 */

@DatabaseTable(tableName = "dica_usuario")
public class DicaUsuario {

    @DatabaseField(columnName ="id", generatedId = true)
    private int id;
    @DatabaseField(columnName ="data_realizacao")
    private Date dataRealizacaoTarefa;
    @DatabaseField(foreign = true)
    private Dica dica;

    public DicaUsuario() {}

    public int getId() {
        return id;
    }

    public DicaUsuario setId(int id) {
        this.id = id;
        return this;
    }

    public Dica getDica() {
        return dica;
    }

    public DicaUsuario setDesafio(Dica dica) {
        this.dica = dica;
        return this;
    }

    public Date getDataRealizacaoTarefa() {
        return dataRealizacaoTarefa;
    }

    public DicaUsuario setDataRealizacaoTarefa(Date dataRealizacaoTarefa) {
        this.dataRealizacaoTarefa = dataRealizacaoTarefa;
        return this;
    }
}
