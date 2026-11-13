package com.example.pruebapmdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//pantalla 2 del ejercicio3
class Ejercicio3Pantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //carga el diseño XML (comprueba si en tu proyecto se llama activity_ejercicio3_pantalla2 o ejercicio3_pantalla2)
        setContentView(R.layout.ejercicio3_pantalla2)
    }
}