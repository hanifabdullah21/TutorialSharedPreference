package com.singpaulee.tutorialsharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    //TODO 4 Buat Variabel Baru sesuai dengan view yang kita buat pada layout
    private MaterialEditText mMedtUsername;
    private MaterialEditText mMedtPassword;
    private Button mBtnMasuk;

    //Buat objek dari kelas SharedPrefManager
    SharedPrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        //Deklarasikan objek kelas SharedPrefManager
        prefManager  = new SharedPrefManager(LoginActivity.this);

        //Cek Apakah sudah login atau belum
        if (prefManager.getSudahLogin()){
            finish();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }

        //TODO 12 Ambil data statik profil dan masukkan dalam variabel
        final ArrayList<Dummy.DummyModel> listProfil = new Dummy().setListOfProfil();

        //TODO 13 Handler ketika tombol masuk ditekan
        mBtnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ambil username dan password dari edittext
                String username = mMedtUsername.getText().toString();
                String password = mMedtPassword.getText().toString();

                //Cari apakah di dalam list ada username dan password yang benar
                int bantuan = 0;
                for (int x = 0; x < listProfil.size(); x++) {
                    if (username.equals(listProfil.get(x).getUsername()) && password.equals(listProfil.get(x).getPassword())){
                        //Masukkan ke dalam SharedPreference

                        //Masukkan data yang akan disimpan dalam SharedPreference
                        prefManager.savePrefString(SharedPrefManager.USERNAME,listProfil.get(x).getUsername());
                        prefManager.savePrefString(SharedPrefManager.PASSWORD,listProfil.get(x).getPassword());
                        prefManager.savePrefString(SharedPrefManager.TELP,listProfil.get(x).getTelp());
                        prefManager.savePrefString(SharedPrefManager.ALAMAT,listProfil.get(x).getAlamat());
                        prefManager.savePrefString(SharedPrefManager.TANGGAL_LAHIR,listProfil.get(x).getTanggalLahir());
                        prefManager.savePrefBoolean(SharedPrefManager.SUDAH_LOGIN,true);

                        x = listProfil.size()-1;    //berhentikan looping :D
                        bantuan = 1;

                        //Pindah Activity
                        finish();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }

                if (bantuan==0){
                    Toast.makeText(LoginActivity.this, "Username/Password tidak ada yang cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        //TODO 5 Sambungkan antara Variabel (Java) dengan id (xml)
        mMedtUsername = findViewById(R.id.medt_username);
        mMedtPassword = findViewById(R.id.medt_password);
        mBtnMasuk = findViewById(R.id.btn_masuk);
    }

}
