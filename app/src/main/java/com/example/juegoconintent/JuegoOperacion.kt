package com.example.juegoconintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_juego_operacion.*

class JuegoOperacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_operacion)

    val ope = txtOperacion.text
        btnSalir.setOnClickListener{
        val intent = Intent()
        intent.putExtra("comprobarOperacion",ope.toString())
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

}
}
