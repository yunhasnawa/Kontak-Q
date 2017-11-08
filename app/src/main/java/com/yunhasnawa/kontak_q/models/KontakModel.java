package com.yunhasnawa.kontak_q.models;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import com.yunhasnawa.kontak_q.entities.Kontak;
import com.yunhasnawa.kontak_q.libraries.DbHelper;

/**
 * Created by yunhasnawa on 08/11/17.
 */

public class KontakModel
{
    private Context context;
    private DbHelper db;

    public KontakModel(Context context)
    {
        this.context = context;

        this.db = new DbHelper(this.context);
    }

    public ArrayList<Kontak> selectAll()
    {
        String sql = "SELECT * FROM kontak";

        ArrayList<Kontak> semuaKontak = new ArrayList<>();

        Cursor cursor = this.db.executeRead(sql);

        cursor.moveToFirst();

        if(cursor.getCount() > 0)
        {
            do
            {
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String nomor = cursor.getString(2);

                Kontak k = new Kontak();

                k.setId(id);
                k.setNama(nama);
                k.setNomor(nomor);

                semuaKontak.add(k);
            }
            while (cursor.moveToNext());
        }

        return semuaKontak;
    }

    public void insertOne(Kontak k)
    {
        String nama = k.getNama();
        String nomor = k.getNomor();

        String sql = "INSERT INTO kontak(nama, nomor) VALUES('" + nama + "', '" + nomor + "')";

        this.db.executeWrite(sql);
    }
}
