package com.yunhasnawa.kontak_q.entities;

/**
 * Created by yunhasnawa on 08/11/17.
 */

public class Kontak
{
    private int id;
    private String nama;
    private String nomor;

    public Kontak()
    {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}
