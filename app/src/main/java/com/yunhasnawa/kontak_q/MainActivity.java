package com.yunhasnawa.kontak_q;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLihatKontak;
    private Button btnTambahKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initComponents();
    }

    private void initComponents()
    {
        this.btnLihatKontak = (Button) this.findViewById(R.id.btnLihatKontak);
        this.btnTambahKontak = (Button) this.findViewById(R.id.btnTambahKontak);
    }

    public void button_onClick(View view)
    {
        Button b = (Button) view;

        if(b == this.btnLihatKontak)
        {
            this.openLihatKontakActivity();
        }
        else if(b == this.btnTambahKontak)
        {
            this.openTambahKontakActivity();
        }
    }

    private void openLihatKontakActivity()
    {
        Intent i = new Intent(this, LihatKontakActivity.class);

        this.startActivity(i);
    }

    private void openTambahKontakActivity()
    {
        Intent i = new Intent(this, TambahKontakActivity.class);

        this.startActivity(i);
    }
}
