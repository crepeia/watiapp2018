package com.watiapp.watiapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by fernanda on 16/12/17.
 */

@DatabaseTable(tableName = "tipo")
public class Tipo {

    @DatabaseField(columnName = "id" , generatedId=true)
    private int id;
    @DatabaseField(columnName = "tipo")
    private String tipo;

    public Tipo() {}

    public int getId() {
        return id;
    }

    public Tipo setId(int id) {
        this.id = id;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Tipo setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
}
