package br.com.adley.wtest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cv")
public class PostalCode {


    private int cod_concelho;
    private int cod_distrito;
    private int cod_localidade;
    private int nome_localidade;
    private int cod_arteria;
    private int tipo_arteria;
    private int prep1;
    private int titulo_arteria;
    private int prep2;
    private int nome_arteria;
    private int local_arteria;
    private int troco;
    private int porta;
    private int cliente;
    private int num_cod_postal;
    private int ext_cod_postal;
    private int desig_postal;

    @PrimaryKey
    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
