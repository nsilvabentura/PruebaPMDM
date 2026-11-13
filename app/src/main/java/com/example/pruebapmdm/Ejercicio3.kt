package com.example.pruebapmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

//esta actúa como menú secundario para el Ejercicio 3
class Ejercicio3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //carga la pantalla XML principal del ejerci3
        setContentView(R.layout.ejercicio3)

        //buscamos los 3 botones del XML por su ID
        val btn1 = findViewById<Button>(R.id.btnPantalla1)
        val btn2 = findViewById<Button>(R.id.btnPantalla2)
        val btn3 = findViewById<Button>(R.id.btnPantalla3)

        //asignamos la navegación a cada uno usando intents
        btn1.setOnClickListener {
            // Abre la vista con la bandera Azul/Blanco/Azul
            startActivity(Intent(this, Ejercicio3Pantalla1::class.java))
        }

        btn2.setOnClickListener {
            //abre la vista con la bandera Verde/Blanco/Verde
            startActivity(Intent(this, Ejercicio3Pantalla2::class.java))
        }

        btn3.setOnClickListener {
            //abre la vista estructurada en cuadrantes Rojo/Blanco
            startActivity(Intent(this, Ejercicio3Pantalla3::class.java))
        }
    }
}