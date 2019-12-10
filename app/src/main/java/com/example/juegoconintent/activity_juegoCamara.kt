package com.example.juegoconintent

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_juego_camara.*
import org.jetbrains.anko.toast

class activity_juegoCamara : AppCompatActivity() {

    var condicion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_camara)
        btnFoto.setOnClickListener { camera(it) }
        btnConfirmar.setOnClickListener {
            val data = Intent()
            data.putExtra("resp", condicion) //Se devuelve el true o false
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun camera(it: View?) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) { //Si no hay permisos entra en el if
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                toast("TRUE?")
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
            } else {
                toast("No se ha accedido a la camara")
            }
        } else {
            toast("Se ha accedido a la camara")
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }

    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            cargarImagen.setImageBitmap(imageBitmap)
            val colorCentro = imageBitmap.getPixel(imageBitmap.width / 2, imageBitmap.height / 2)
            val red = colorCentro shr 16 and 0xff
            val green = colorCentro shr 8 and 0xff
            val blue = colorCentro and 0xff
            if (red > 100 && green < 60 && blue < 60) {  //Tiene mas componente roja que verde y azul
                condicion = true
            }
        }
    }
}
