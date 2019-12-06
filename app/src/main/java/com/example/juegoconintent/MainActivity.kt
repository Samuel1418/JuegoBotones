package com.example.juegoconintent

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

const val REQUEST_NAVEGADOR = 1
const val REQUEST_OPERACION = 2  //No se puede dejar en 1 ya que si hacemos asi al ejecutar un juego se desactiva el resto


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNavegador.setOnClickListener {
            val intent = Intent(
                this,
                JuegoNav::class.java
            )//Inicializamos el intent con la clase que le corresponde
            startActivityForResult(intent, REQUEST_NAVEGADOR)//Confirmacion y entrada en Intent
        }

        btnMates.setOnClickListener {
            val intent2 = Intent(this, JuegoOperacion::class.java)
            startActivityForResult(intent2, REQUEST_OPERACION)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        if (requestCode == REQUEST_NAVEGADOR) {  //Reto de buscar con el navegador
            if (resultCode == Activity.RESULT_OK) {
                if ((intent?.getStringExtra("comprobar").toString()).equals("1936")) {  //Si lo que obtenemos del intent es 1936 es correcto
                    btnNavegador.setBackgroundColor(Color.GREEN) //Se pone el boton en verde para indicar correcto
                    toast("Buen trabajo!")
                } else {
                    btnNavegador.setBackgroundColor(Color.RED)  //Se pone el boton en rojo para indicar fallado
                    toast("Has fallado...")
                }
                btnNavegador.setEnabled(false)
            }
        }

        if (requestCode == REQUEST_OPERACION) {  //Reto de realizar una operacion matematica
            if (resultCode == Activity.RESULT_OK) {
                if ((intent?.getStringExtra("comprobarOperacion").toString()).equals("23")) {
                    btnMates.setBackgroundColor(Color.GREEN)
                    toast("Buen trabajo!")
                } else {
                    btnMates.setBackgroundColor(Color.RED)
                    toast("Has fallado...")
                }
                btnMates.setEnabled(false)
            }
        }







        }
    }