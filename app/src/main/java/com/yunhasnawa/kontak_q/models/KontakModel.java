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

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();

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

    public void insert(Kontak k)
    {
        String nama = k.getNama();
        String nomor = k.getNomor();

        String sql = "INSERT INTO kontak(nama, nomor) VALUES('" + nama + "', '" + nomor + "')";

        this.db.executeWrite(sql);
    }

    public Kontak selectOne(int id)
    {
        String sql = "SELECT * FROM kontak WHERE id = '" + id + "'";

        Cursor cursor = this.db.executeRead(sql);

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();

            Kontak k = new Kontak();

            k.setId(cursor.getInt(0));
            k.setNama(cursor.getString(1));
            k.setNomor(cursor.getString(2));

            return k;
        }

        return null;
    }

    public void delete(Kontak k)
    {
        if(k.getId() < 0) // ID negatif -> Bukan dari tabel
            return;

        String sql = "DELETE FROM kontak WHERE id = '" + k.getId() + "'";

        this.db.executeWrite(sql);
    }

    public void update(Kontak k)
    {
        if(k.getId() < 0)
            return;

        int id = k.getId();
        String nama = k.getNama();
        String nomor = k.getNomor();

        String sql = "UPDATE kontak SET nama = '" + nama + "', nomor = '" + nomor + "' WHERE id = '" + id + "'";

        this.db.executeWrite(sql);
    }
}
