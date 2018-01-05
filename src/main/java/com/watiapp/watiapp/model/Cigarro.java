package com.watiapp.watiapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fernanda on 11/12/17.
 */

public class Cigarro implements Serializable {

    @DatabaseField(columnName = "id", generatedId=true)
    private long id;
    @DatabaseField(columnName = "data")
    private Date data;
    @DatabaseField(columnName = "num_cigarros")
    private int numCigarros;

    public Cigarro(){}

    public long getId() {
        return id;
    }

    public Cigarro setId(long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return data;
    }

    public Cigarro setDate(Date data) {
        this.data = data;
        return this;
    }

    public int getNumCigarros() {

        return numCigarros;
    }

    public void setNumCigarros(int numCigarros) {
        this.numCigarros = numCigarros;
    }

}
