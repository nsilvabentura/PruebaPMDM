package com.example.pruebapmdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//esta es la pantalla de destino a la que se navega tras esperar los 10 segundos
class Ejercicio2Destino : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //carga el diseño XML
        setContentView(R.layout.ejercicio2_destino)
    }
}