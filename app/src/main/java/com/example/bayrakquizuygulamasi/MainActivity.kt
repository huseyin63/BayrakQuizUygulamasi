package com.example.bayrakquizuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()

        buttonbasla.setOnClickListener{
            startActivity(Intent(this@MainActivity,QuizActivity :: class.java))
        }
    }


    // Uygulama açıldığında veritabanını uygulamaya aktarır kopyalar
    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch(e:Exception){
            e.printStackTrace()
        }
    }



}