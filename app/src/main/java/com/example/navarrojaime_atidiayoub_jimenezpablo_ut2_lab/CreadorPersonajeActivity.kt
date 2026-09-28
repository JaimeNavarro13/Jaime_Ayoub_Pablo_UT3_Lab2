package com.example.navarrojaime_atidiayoub_jimenezpablo_ut2_lab

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreadorPersonajeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_creador_personaje)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Buscamos los campos de la pantalla
        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val raza = findViewById<Spinner>(R.id.spinnerRaza)
        val faccion = findViewById<RadioGroup>(R.id.radioGroup3)
        val sigilo = findViewById<CheckBox>(R.id.checkBoxSigilo)
        val espada = findViewById<CheckBox>(R.id.checkBoxCombateEspada)
        val registrar = findViewById<ImageButton>(R.id.imageButton)

        //Hacemos que gane el focus el valor nombre
        nombre.requestFocus()

        registrar.setOnClickListener {
            //Cogemos el nombre y la raza
            val nombreElegido = nombre.text.toString()
            val razaElegida = raza.selectedItem.toString()

            //Averiguamos que facción está marcada
            val faccionElegida = when (faccion.checkedRadioButtonId) {
                R.id.radioComunidad -> "Comunidad del Anillo"
                R.id.radioMordor -> "Huestes de Mordor"
                else -> "Sin facción"
            }

            //Averiguamos que habilidades especiales están marcadas
            var habilidades = ""
            if (sigilo.isChecked) habilidades = "Sigilo"
            if (espada.isChecked) habilidades += " Combate con Espada"
            if (habilidades.isEmpty()) habilidades = "Ninguna"

            // Mostramos el resumen y lo escribimos en Logcat.
            val resumen = "$nombreElegido | $razaElegida | $faccionElegida | $habilidades"
            Toast.makeText(this, resumen, Toast.LENGTH_LONG).show()
            Log.d("PERSONAJE", resumen)

        }
    }
}