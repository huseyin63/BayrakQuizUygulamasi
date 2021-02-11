package com.example.bayrakquizuygulamasi

class bayraklardao {

    fun rastgele5bayrakgetir(vt:VeritabaniYardimcisi) : ArrayList<Bayraklar>{

        val bayraklarListe = ArrayList<Bayraklar>()
        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null)


        while (cursor.moveToNext()){
            val bayrak = Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrak_id")),
                                   cursor.getString(cursor.getColumnIndex("bayrak_ad")),
                                   cursor.getString(cursor.getColumnIndex("bayrak_resim")))

            bayraklarListe.add(bayrak)
        }
        return bayraklarListe
    }


    fun rastgele3yanlissecenekgetir(vt:VeritabaniYardimcisi,bayrak_id:Int) : ArrayList<Bayraklar>{

        val bayraklarListe = ArrayList<Bayraklar>()
        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3",null)


        while (cursor.moveToNext()){
            val bayrak = Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrak_id")),
                cursor.getString(cursor.getColumnIndex("bayrak_ad")),
                cursor.getString(cursor.getColumnIndex("bayrak_resim")))

            bayraklarListe.add(bayrak)
        }
        return bayraklarListe
    }


}