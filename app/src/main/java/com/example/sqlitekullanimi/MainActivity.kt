package com.example.sqlitekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vt = VeriTabaniYardimcisi(this)

        Kisilerdao().kisiEkle(vt,"Mehmet","888888",22,1.99)
        Kisilerdao().kisiEkle(vt,"Zeynep","3333",13,1.52)
        Kisilerdao().kisiEkle(vt,"Ali","11111",55,1.75)

        val kisiListe = Kisilerdao().tumKisiler(vt)

        for (k in kisiListe){

            Log.e("Kişi no",(k.kisi_no).toString())
            Log.e("Kişi ad",k.kisi_ad)
            Log.e("Kişi tel",k.kisi_tel)
            Log.e("Kişi yaş",(k.kisi_yas).toString())
            Log.e("Kişi boy",(k.kisi_boy).toString())

        }

    }
}