package com.example.pruebapmdm

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //comprueba que el nombre coincide con el XML
        setContentView(R.layout.ejercicio1)

        //enlazamos las vistas del XML con variables Kotlin usando su ID
        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnAbrir = findViewById<Button>(R.id.btnAbrir)

        //Evento al pulsar el botón
        btnAbrir.setOnClickListener {
            //.trim() quita los espacios en blanco sobrantes
            var texto = etUrl.text.toString().trim()

            //comprobar que el hemos escrito algo
            if (texto.isEmpty()) {
                Toast.makeText(this, "Introduce una URL", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Detiene la función aquí para no seguir ejecutando
            }

            //si no pusimos http:// se lo autocompletamos
            if (!texto.startsWith("http://") && !texto.startsWith("https://")) {
                texto = "https://$texto"
            }

            //valida el formato web
            if (URLUtil.isValidUrl(texto)) {
                /* INTENT IMPLÍCITO: Le decimos la acción y el dato,
                pero no la clase. Android buscará la app del sistema que sepa abrir webs (Chrome, etc.)*/
                val intentNavegador = Intent(Intent.ACTION_VIEW, Uri.parse(texto))
                startActivity(intentNavegador)
            } else {
                Toast.makeText(this, "La URL no tiene un formato válido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}