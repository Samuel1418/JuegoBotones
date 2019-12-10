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
            val tiempoIni= (System.currentTimeMillis()+5).toInt() //pasado a int para que no se comparen los long
            btnIniciar.setEnabled(false)  //Que se desactive al usarse
            intent.putExtra("tiempoIni",tiempoIni)
            toast("Empieza!")


        }

        btnParar.setOnClickListener {
            val tiempoFinal= (System.currentTimeMillis()).toInt()
            intent.putExtra("tiempoFinal",tiempoFinal)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


    }

}