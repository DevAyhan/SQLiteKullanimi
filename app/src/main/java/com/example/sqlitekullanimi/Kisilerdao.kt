package com.example.sqlitekullanimi

import android.content.ContentValues

class Kisilerdao {

    fun kisiEkle(vt:VeriTabaniYardimcisi,kisi_ad:String,kisi_tel:String,kisi_yas:Int,kisi_boy:Double){

        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("kisi_ad",kisi_ad)
        values.put("kisi_tel",kisi_tel)
        values.put("kisi_yas",kisi_yas)
        values.put("kisi_boy",kisi_boy)

        db.insertOrThrow("kisiler",null,values)
        db.close()

    }

    fun tumKisiler(vt: VeriTabaniYardimcisi) : ArrayList<Kisiler>{

        val kisilerArrayList = ArrayList<Kisiler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM kisiler",null)

        while (cursor.moveToNext()){

            val kisi = Kisiler(cursor.getInt(cursor.getColumnIndex("kisi_no"))
                ,cursor.getString(cursor.getColumnIndex("kisi_ad"))
                ,cursor.getString(cursor.getColumnIndex("kisi_tel"))
                ,cursor.getInt(cursor.getColumnIndex("kisi_yas"))
                ,cursor.getDouble(cursor.getColumnIndex("kisi_boy")))

            kisilerArrayList.add(kisi)

        }

        return kisilerArrayList

    }

}