package com.example.pruebapmdm

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//pantalla del ejercicio6
class Ejercicio6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //carga el diseño XML de la pantalla de perfil
        setContentView(R.layout.ejercicio6)

        //enlazamos el botón de edición de perfil definido en el XML
        val btnEditar = findViewById<Button>(R.id.btnEditarPerfil)

        //programamos el evento de clic del botón
        btnEditar.setOnClickListener {
            //mostramos un mensaje emergente  como respuesta visual a la interacción
            Toast.makeText(this, "Opción de editar perfil pulsada", Toast.LENGTH_SHORT).show()
        }
    }
}