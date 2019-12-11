package com.example.juegoconintent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_juego_cronometro.*
import android.os.SystemClock
import android.widget.Toast
import org.jetbrains.anko.toast


class JuegoCronometro : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_cronometro)

        btnIniciar.setOnClickListener {
            val tiempoIni= (((System.currentTimeMillis())/1000).toInt()+5) //Hay que dividirlos entre mil para que funcione ya que aunque se pase a int estaba cogiendo un numero muy justo
            btnIniciar.setEnabled(false) //Una vez que inicias no puedes volver a hacerlo
            intent.putExtra("tiempoIni",tiempoIni)
            toast("Empieza!")


        }

        btnParar.setOnClickListener {
            val tiempoFinal= ((System.currentTimeMillis())/1000).toInt()
            intent.putExtra("tiempoFinal",tiempoFinal)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


    }

}