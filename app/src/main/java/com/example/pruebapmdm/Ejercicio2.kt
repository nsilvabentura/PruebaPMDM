package com.example.pruebapmdm

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //carga la pantalla XML
        setContentView(R.layout.ejercicio2)

        //enlazamos el botón del XML
        val btnIrConRetraso = findViewById<Button>(R.id.btnIrConRetraso)

        //programamos la acción del clic
        btnIrConRetraso.setOnClickListener {
            //mostramos un aviso para que nosotros sepamos que tiene que esperar
            Toast.makeText(this, "Navegando en 10 segundos...", Toast.LENGTH_SHORT).show()

            //INTENT EXPLÍCITO hacia la pantalla de destino
            val intentDestino = Intent(this, Ejercicio2Destino::class.java)

            //PENDING INTENT:guardamos el intent para ejecutarlo más tarde
            //FLAG_IMMUTABLE: es obligatorio en versiones modernas de Android por seguridad
            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intentDestino,
                PendingIntent.FLAG_IMMUTABLE
            )

            //pausa el código durante 10 segundos y luego ejecuta el send()
            Handler(Looper.getMainLooper()).postDelayed({
                pendingIntent.send()
            }, 10000) //10 segundos
        }
    }
}