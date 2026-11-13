package com.example.pruebapmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

//menú principal de la aplicación.
//acceder a cada uno de los ejercicios.
class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        //ejercicio 1
        findViewById<Button>(R.id.btnEjer1).setOnClickListener {
            startActivity(Intent(this, Ejercicio1::class.java))
        }

        //ejercicio2
        findViewById<Button>(R.id.btnEjer2).setOnClickListener {
            startActivity(Intent(this, Ejercicio2::class.java))
        }

        //ejercicio3
        findViewById<Button>(R.id.btnEjer3).setOnClickListener {
            startActivity(Intent(this, Ejercicio3::class.java))
        }

        //ejercicio4
        findViewById<Button>(R.id.btnEjer4).setOnClickListener {
            startActivity(Intent(this, Ejercicio4::class.java))
        }

        //ejercicio5
        findViewById<Button>(R.id.btnEjer5).setOnClickListener {
            startActivity(Intent(this, Ejercicio5::class.java))
        }

        //ejercicio6
        findViewById<Button>(R.id.btnEjer6).setOnClickListener {
            startActivity(Intent(this, Ejercicio6::class.java))
        }
    }
}