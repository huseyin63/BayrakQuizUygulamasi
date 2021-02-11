package com.example.bayrakquizuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc.*

class SonucActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)


        val dogruSayac = intent.getIntExtra("dogruSayac",0)


        textViewsonuc.text = "$dogruSayac DOĞRU ${5 - dogruSayac} YANLIŞ"
        textViewbasariorani.text = "% ${dogruSayac*100/5} BAŞARI"


        buttontekrardene.setOnClickListener {

            startActivity(Intent(this,QuizActivity :: class.java))
            finish()
        }


    }
}