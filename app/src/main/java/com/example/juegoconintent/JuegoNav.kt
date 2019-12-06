package com.example.juegoconintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_juego_nav.*
import org.jetbrains.anko.browse

class JuegoNav : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_nav)
        btnInfo.setOnClickListener{
            browse("https://es.wikipedia.org/wiki/Guerra_civil_espa%C3%B1ola")
        }
        //Recigemos el texto introducido para luego comprobar en el main si es correcto
        val res = txtValor.text
        btnComp.setOnClickListener{
            val intent = Intent()
            intent.putExtra("comprobar",res.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()

        }

    }

}
