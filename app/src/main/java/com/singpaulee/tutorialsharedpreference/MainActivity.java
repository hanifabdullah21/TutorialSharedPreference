package com.singpaulee.tutorialsharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //TODO 16 Buat Variabel Baru sesuai dengan view yang kita buat pada layout
    private TextView mTvUsername;
    private TextView mTvTelp;
    private TextView mTvAlamat;
    private TextView mTvTanggalLahir;
    private Button mBtnProfil;
    private Button mBtnKeluar;

    SharedPrefManager prefManager;
    Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //Deklarasikan objek kelas prefManager
        prefManager = new SharedPrefManager(this);
        setTextView();

        //TODO 19 Handler tombol Profil
        mBtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProfilActivity.class);
                startActivity(intent);
            }
        });

        //TODO 20 Handler tombol Keluar
        mBtnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                prefManager.delAllPref();
            }
        });
    }

    //TODO 18 Set TextView dari data yang disimpan pada SharedPreference
    private void setTextView() {
        mTvUsername.setText(""+prefManager.getUsername());
        mTvTelp.setText(""+prefManager.getTelp());
        mTvAlamat.setText(""+prefManager.getAlamat());
        mTvTanggalLahir.setText(""+prefManager.getTanggalLahir());
    }

    private void initView() {
        //TODO 17 Sambungkan antara Variabel (Java) dengan id (xml)
        mTvUsername = findViewById(R.id.tv_username);
        mTvTelp = findViewById(R.id.tv_telp);
        mTvAlamat = findViewById(R.id.tv_alamat);
        mTvTanggalLahir = findViewById(R.id.tv_tanggal_lahir);
        mBtnProfil = findViewById(R.id.btn_profil);
        mBtnKeluar = findViewById(R.id.btn_keluar);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setTextView();
    }
}
