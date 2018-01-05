package com.watiapp.watiapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by fernanda on 11/12/17.
 */
@DatabaseTable(tableName = "usuario")
public class Usuario implements Serializable {

    @DatabaseField(columnName = "id", generatedId=true)
    private int id;
    @DatabaseField(columnName = "nome")
    private String nome;
    @DatabaseField(columnName = "email")
    private String email;
    @DatabaseField(columnName = "genero")
    private String genero;
    @DatabaseField(columnName = "num_cigarros_diario")
    private int numCigarrosDiarios;
    @DatabaseField(columnName = "valor_maco")
    private int valorMaco;
    @DatabaseField(columnName = "data")
    private Date data;
    @DatabaseField(foreign = true)
    private List<TarefaDesafio> desafiosRealizados;
    @DatabaseField(foreign = true)
    private List<TarefaDica> dicasLidas;

    public Usuario() {}

    public int getId() {
        return id;
    }

    public Usuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public Usuario setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public List<TarefaDesafio> getDesafiosRealizados() {
        return desafiosRealizados;
    }

    public void setDesafiosRealizados(List<TarefaDesafio> desafiosRealizados) {
        this.desafiosRealizados = desafiosRealizados;
    }

    public int getNumCigarrosDiarios() {
        return numCigarrosDiarios;
    }

    public Usuario setNumCigarrosDiarios(int numCigarrosDiarios) {
        this.numCigarrosDiarios = numCigarrosDiarios;
        return this;
    }

    public int getValorMaco() {
        return valorMaco;
    }

    public Usuario setValorMaco(int valorMaco) {
        this.valorMaco = valorMaco;
        return this;
    }

    public Date getData() {
        return data;
    }

    public Usuario setData(Date data) {
        this.data = data;
        return this;
    }
}
