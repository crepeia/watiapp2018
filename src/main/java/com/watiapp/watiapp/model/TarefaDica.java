package com.watiapp.watiapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by fernanda on 11/12/17.
 */

@DatabaseTable(tableName = "dica")
public class TarefaDica {

    @DatabaseField(columnName = "id", generatedId=true)
    private long id;
    @DatabaseField(columnName = "titulo")
    private String titulo;
    @DatabaseField(columnName = "descricao")
    private String descricao;
    @DatabaseField(columnName = "ponto")
    private int ponto;
    @DatabaseField(columnName = "gostou")
    private boolean gostou;

    public TarefaDica() {}

    public boolean isGostou() {
        return gostou;
    }

    public TarefaDica setGostou(boolean gostou) {
        this.gostou = gostou;
        return this;
    }

    public long getId() {
        return id;
    }

    public TarefaDica setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public TarefaDica setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public TarefaDica setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public int getPonto() {
        return ponto;
    }

    public TarefaDica setPonto(int ponto) {
        this.ponto = ponto;
        return this;
    }
}
