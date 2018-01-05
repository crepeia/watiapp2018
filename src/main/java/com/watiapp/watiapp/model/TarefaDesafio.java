package com.watiapp.watiapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by fernanda on 11/12/17.
 */
@DatabaseTable(tableName = "desafio")
public class TarefaDesafio  implements Serializable{

    @DatabaseField(columnName ="id", generatedId = true)
    private long id;
    @DatabaseField(columnName = "titulo")
    private String titulo;
    @DatabaseField(columnName = "descricao")
    private String descricao;
    @DatabaseField(columnName = "ponto")
    private int ponto;
    @DatabaseField(columnName = "tipo")
    private Tipo tipo;

    public TarefaDesafio(){}

    public Tipo getTipo() {
        return tipo;
    }

    public TarefaDesafio setTipo(Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public long getId() {
        return id;
    }

    public TarefaDesafio setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public TarefaDesafio setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public TarefaDesafio setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public int getPonto() {
        return ponto;
    }

    public TarefaDesafio setPonto(int ponto) {
        this.ponto = ponto;
        return this;
    }

}
