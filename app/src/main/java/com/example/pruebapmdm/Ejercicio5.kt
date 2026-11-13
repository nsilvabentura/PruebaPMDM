package com.example.pruebapmdm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//calculadora organizada con un TableLayout
class Ejercicio5 : AppCompatActivity() {

    //variables para controlar el estado de las operaciones
    private lateinit var tvPantalla: TextView
    private var primerNumero = 0.0
    private var operacionActual = ""
    private var esNuevoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Carga la pantalla XML de la calculadora
        setContentView(R.layout.ejercicio5)

        tvPantalla = findViewById(R.id.tvPantalla)

        /*usamos un array con los id de los botones numéricos
        esto evita escribir findViewById diez veces separadas*/
        val botonesNumeros = arrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )


        for (id in botonesNumeros) {
            findViewById<Button>(id).setOnClickListener { view ->
                val boton = view as Button
                presionarNumero(boton.text.toString())
            }
        }

        //botones de función y operaciones
        findViewById<Button>(R.id.btnPunto).setOnClickListener { presionarPunto() }
        findViewById<Button>(R.id.btnC).setOnClickListener { limpiarCalculadora() }

        findViewById<Button>(R.id.btnSuma).setOnClickListener { seleccionarOperacion("+") }
        findViewById<Button>(R.id.btnResta).setOnClickListener { seleccionarOperacion("-") }
        findViewById<Button>(R.id.btnMult).setOnClickListener { seleccionarOperacion("*") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { seleccionarOperacion("/") }

        findViewById<Button>(R.id.btnIgual).setOnClickListener { calcularResultado() }
    }

    //escribir un nuevo número en la pantalla
    private fun presionarNumero(numero: String) {
        if (esNuevoNumero || tvPantalla.text.toString() == "0") {
            tvPantalla.text = numero
            esNuevoNumero = false
        } else {
            tvPantalla.text = "${tvPantalla.text}$numero"
        }
    }

    //punto decimal
    private fun presionarPunto() {
        if (esNuevoNumero) {
            tvPantalla.text = "0."
            esNuevoNumero = false
        } else if (!tvPantalla.text.contains(".")) {
            tvPantalla.text = "${tvPantalla.text}."
        }
    }

    //guarda la operación deseada
    private fun seleccionarOperacion(op: String) {
        primerNumero = tvPantalla.text.toString().toDoubleOrNull() ?: 0.0
        operacionActual = op
        esNuevoNumero = true // El siguiente dígito reemplazará la pantalla
    }

    //ejecuta el cálculo según la operación seleccionada
    private fun calcularResultado() {
        if (operacionActual.isEmpty()) return

        val segundoNumero = tvPantalla.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = 0.0

        when (operacionActual) {
            "+" -> resultado = primerNumero + segundoNumero
            "-" -> resultado = primerNumero - segundoNumero
            "*" -> resultado = primerNumero * segundoNumero
            "/" -> {
                // Controlamos la división entre 0 para evitar fallos en la app
                if (segundoNumero != 0.0) {
                    resultado = primerNumero / segundoNumero
                } else {
                    tvPantalla.text = "Error"
                    operacionActual = ""
                    esNuevoNumero = true
                    return
                }
            }
        }

        //si el resultado es entero mostramos sin decimales sobrantes
        val textoResultado = if (resultado % 1 == 0.0) {
            resultado.toLong().toString()
        } else {
            resultado.toString()
        }

        tvPantalla.text = textoResultado
        operacionActual = ""
        esNuevoNumero = true
    }

    //resetea la calculadora
    private fun limpiarCalculadora() {
        tvPantalla.text = "0"
        primerNumero = 0.0
        operacionActual = ""
        esNuevoNumero = true
    }
}