package com.example.buffalosfighters

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val txtNombre = findViewById<TextView>(R.id.nombreConfirmacion)
        val txtCorreo = findViewById<TextView>(R.id.correoConfirmacion)
        val txtModalidad = findViewById<TextView>(R.id.modalidadConfirmacion)
        val btnFinalizar = findViewById<Button>(R.id.btnFinalizar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val nombre = intent.getStringExtra("nombre") ?: ""
        val correo = intent.getStringExtra("correo") ?: ""
        val modalidad = intent.getStringExtra("modalidad") ?: ""

        txtNombre.text = "Nombre: $nombre"
        txtCorreo.text = "Correo: $correo"
        txtModalidad.text = "Modalidad: $modalidad"

        btnFinalizar.setOnClickListener {
            finishAffinity()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}