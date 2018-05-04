package com.singpaulee.tutorialsharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

import java.util.Locale;

/**
 * Created by ASUS on 04/05/2018.
 */

//TODO 0 Buat kelas SharedPrefManager
public class SharedPrefManager {
    /*Nama File SharedPreference*/
    public static final String SHARED_FILE = "WEEKLY51";

    /*Key-key yang akan dimasukkan dalam SharedPreference*/
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String TELP = "telp";
    public static final String ALAMAT = "alamat";
    public static final String TANGGAL_LAHIR = "tanggal_lahir";
    public static final String SUDAH_LOGIN = "sudah_login";
    public static final String BAHASA = "bahasa";

    //Buat objek kelas SharedPreference dan SharedPreference.Editor
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    //Buat Konstruktor
    public SharedPrefManager(Context context) {
        this.sp = context.getSharedPreferences(SHARED_FILE,Context.MODE_PRIVATE);
        this.editor = sp.edit();
    }

    /*Method untuk menyimpan key bernilai String*/
    public void savePrefString(String key, String value){
        editor.putString(key,value);
        editor.commit();
    }

    public void savePrefInt(String key, int value){
        editor.putInt(key,value);
        editor.commit();
    }

    public void savePrefBoolean(String key, Boolean value){
        editor.putBoolean(key,value);
        editor.commit();
    }

    /*Method untuk menghapus key (per key)*/
    public void delPref(String key){
        editor.remove(key);
        editor.commit();
    }

    /*Method untuk mengpaus key (semua)*/
    public void delAllPref(){
        editor.clear();
        editor.commit();
    }

    /*Buat Getter untuk mendapatkan nilai yang udah disimpan dalam SharedPreference*/
    public String getUsername(){return sp.getString(USERNAME,"");}
    public String getPassword(){return sp.getString(PASSWORD,"");}
    public String getTelp(){return sp.getString(TELP,"");}
    public String getAlamat(){return sp.getString(ALAMAT,"");}
    public String getTanggalLahir(){return sp.getString(TANGGAL_LAHIR,"");}
    public Boolean getSudahLogin(){return sp.getBoolean(SUDAH_LOGIN,false);}
    public String getBAHASA() {
        return sp.getString(BAHASA,"in");
    }


}
