package com.yunhasnawa.kontak_q;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.yunhasnawa.kontak_q.entities.Kontak;
import com.yunhasnawa.kontak_q.models.KontakModel;

import java.util.ArrayList;
import java.util.List;

public class LihatKontakActivity extends AppCompatActivity
{
    // Data
    private ArrayList<String> daftarNama;

    // Komponen
    private ListView lstDaftarKontak;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_kontak);

        this.initData();
        this.initComponents();
    }

    private void initData()
    {
        this.daftarNama = new ArrayList<>();

        KontakModel mKontak = new KontakModel(this);

        ArrayList<Kontak> allKontak = mKontak.selectAll();

        for(Kontak k : allKontak)
        {
            this.daftarNama.add(k.getNama());
        }
    }

    private void initComponents()
    {
        this.lstDaftarKontak = (ListView) this.findViewById(R.id.lstDaftarKontak);
        this.btnOk = (Button) this.findViewById(R.id.btnOk);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.daftarNama);

        this.lstDaftarKontak.setAdapter(adapter);
    }

    public void button_onClick(View view)
    {
        Button b = (Button) view;

        if(b == this.btnOk)
        {
            this.finish();
        }
    }
}
