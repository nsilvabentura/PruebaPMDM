package com.example.pruebapmdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// APUNTES: Pantalla del Ejercicio 4 (Matriz 3x3 formada por 9 FrameLayouts de colores)
class Ejercicio4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Carga el diseño XML (comprueba si en tu proyecto se llama activity_ejercicio4 o ejercicio4)
        setContentView(R.layout.ejercicio4)
    }
}