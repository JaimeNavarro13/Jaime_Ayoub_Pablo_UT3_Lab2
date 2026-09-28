package com.example.navarrojaime_atidiayoub_jimenezpablo_ut2_lab

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "VIAJE_ANILLO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: El viaje comienza en Rivendell")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saludo = findViewById<TextView>(R.id.textViewSaludo)
        val boton = findViewById<Button>(R.id.button)
        val contador = findViewById<TextView>(R.id.textViewContador)
        val botonCreador = findViewById<Button>(R.id.botonCreadorPersonajes)

        botonCreador.setOnClickListener {
            val intent = Intent(this, CreadorPersonajeActivity::class.java)
            startActivity(intent)
        }

        var miembros = 0

        boton.setOnClickListener {
            saludo.text = "La Comunidad ha partido hacia Mordor"
            miembros++
            contador.text = "Miembros reunidos: $miembros"
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: La Comunidad se prepara para partir")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: La Comunidad continúa hacia Mordor")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: La Comunidad se detiene a descansar")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: La Comunidad se oculta del enemigo")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: El viaje ha terminado")
    }
}