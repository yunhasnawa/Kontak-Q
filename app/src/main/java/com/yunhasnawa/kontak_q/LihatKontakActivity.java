package com.yunhasnawa.kontak_q;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.yunhasnawa.kontak_q.entities.Kontak;
import com.yunhasnawa.kontak_q.models.KontakModel;

import java.util.ArrayList;

public class LihatKontakActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // Data
    private KontakModel mKontak;
    private ArrayList<Kontak> allKontak;
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
        this.mKontak = new KontakModel(this);

        this.allKontak = this.mKontak.selectAll();

        this.daftarNama = new ArrayList<>();

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

        this.lstDaftarKontak.setOnItemClickListener(this);
    }

    public void button_onClick(View view)
    {
        Button b = (Button) view;

        if(b == this.btnOk)
        {
            this.finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        int id = this.allKontak.get(i).getId();

        Intent intent = new Intent(this, DetailKontakActivity.class);

        intent.putExtra("selectedContactId", id);

        this.startActivity(intent);
    }
}
