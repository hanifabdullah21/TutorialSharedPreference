package com.singpaulee.tutorialsharedpreference;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Locale;

public class ProfilActivity extends AppCompatActivity {
    //TODO 22 Buat Variabel Baru sesuai dengan view yang kita buat pada layout
    MaterialEditText medtUsername;
    MaterialEditText medtTelp;
    MaterialEditText medtAlamat;
    MaterialEditText medtTanggalLahir;
    MaterialEditText medtBahasa;
    Button mbtnSimpan;

    //Buat Objek Kelas SharedPrefManager
    SharedPrefManager prefManager;

    Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        initview();

        //Deklarasikan objek kelas SharedPrefManager
        prefManager = new SharedPrefManager(this);

        //Cek Bahasa
        cekBahasa();

        //Set Text Edittext dari data di SharedPreference
        medtUsername.setText(""+prefManager.getUsername());
        medtTelp.setText(""+prefManager.getTelp());
        medtAlamat.setText(""+prefManager.getAlamat());
        medtTanggalLahir.setText(""+prefManager.getTanggalLahir());
        medtBahasa.setText(""+prefManager.getBAHASA());

        //TODO 24 Handler tombol SImpan
        mbtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ambil dari Edittext
                String username = medtUsername.getText().toString().trim();
                String telp = medtTelp.getText().toString().trim();
                String alamat = medtAlamat.getText().toString().trim();
                String tglLahir = medtTanggalLahir.getText().toString().trim();

                //Simpan ke dalam SharedPreference
                prefManager.savePrefString(SharedPrefManager.USERNAME,username);
                prefManager.savePrefString(SharedPrefManager.TELP,telp);
                prefManager.savePrefString(SharedPrefManager.ALAMAT,alamat);
                prefManager.savePrefString(SharedPrefManager.TANGGAL_LAHIR,tglLahir);

                prefManager.savePrefString(SharedPrefManager.BAHASA, medtBahasa.getText().toString());
                changeLanguage(prefManager.getBAHASA());

                finish();
            }
        });
    }

    private void initview() {
        //TODO 23 Sambungkan antara Variabel (Java) dengan id (xml)
        medtUsername = findViewById(R.id.medt_username);
        medtTelp = findViewById(R.id.medt_telp);
        medtAlamat = findViewById(R.id.medt_alamat);
        medtTanggalLahir = findViewById(R.id.medt_tanggal_lahir);
        medtBahasa = findViewById(R.id.medt_bahasa);
        mbtnSimpan = findViewById(R.id.btn_simpan);
    }

    /*TODO 26 Tambahkan Method untuk mengecek bahasa*/
    private void cekBahasa() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        Configuration config = getBaseContext().getResources().getConfiguration();
        String lang = settings.getString("LANG", "");
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }
    private void changeLanguage(String bahasa) {
        switch (bahasa) {
            case "jv":
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "jv").commit();
                setLangRecreate("jv");
                return;
            default:
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "in").commit();
                setLangRecreate("in");
                return;
        }
    }
    public void setLangRecreate(String langval) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        locale = new Locale(langval);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

}
