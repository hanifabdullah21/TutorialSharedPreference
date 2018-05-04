package com.singpaulee.tutorialsharedpreference;

import java.util.ArrayList;

/**
 * Created by ASUS on 04/05/2018.
 */

public class Dummy {

    //TODO 10 Buat sebuah fungsi untuk membuat daftar profil beberapa orang(statik)
    public ArrayList<Dummy.DummyModel> setListOfProfil(){
        ArrayList<Dummy.DummyModel> list = new ArrayList<>();

        //TODO 11 Buat data statik dan masukkan dalam list
        DummyModel model = new DummyModel("hanifabdullah21","123456","089987654123","Jl. Lemah","21-06-1997");
        list.add(model);
        DummyModel model1 = new DummyModel("hanifabdullah97","654321","08978675645","Jl. Indraprasta","21-09-1997");
        list.add(model1);


        return list;
    }


    //TODO 6 Buat sebuah inner class sebagai model
    public class DummyModel {
        //TODO 7 Buat daftar apa saja yang ada di dalam profil
        String username;
        String password;
        String telp;
        String alamat;
        String tanggalLahir;

        //TODO 8 Buat Konstruktor
        public DummyModel(String username, String password, String telp, String alamat, String tanggalLahir) {
            this.username = username;
            this.password = password;
            this.telp = telp;
            this.alamat = alamat;
            this.tanggalLahir = tanggalLahir;
        }

        //TODO 9 Buat Getter dan Setter untuk data tsb.
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTelp() {
            return telp;
        }

        public void setTelp(String telp) {
            this.telp = telp;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getTanggalLahir() {
            return tanggalLahir;
        }

        public void setTanggalLahir(String tanggalLahir) {
            this.tanggalLahir = tanggalLahir;
        }
    }
}
