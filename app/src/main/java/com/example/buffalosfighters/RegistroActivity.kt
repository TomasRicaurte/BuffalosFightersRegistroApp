package com.example.buffalosfighters

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val campoNombre = findViewById<EditText>(R.id.campoNombre)
        val campoCorreo = findViewById<EditText>(R.id.campoCorreo)
        val rdGrupo = findViewById<RadioGroup>(R.id.rdGrupo)
        val cbTerminos = findViewById<CheckBox>(R.id.cbTermminos)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnEnviar.setOnClickListener {
            val nombre = campoNombre.text.toString().trim()
            val correo = campoCorreo.text.toString().trim()
            val modalidadId = rdGrupo.checkedRadioButtonId

            if (nombre.isEmpty()) {
                campoNombre.error = "Escriba su nombre"
                campoNombre.requestFocus()
                return@setOnClickListener
            }

            if (correo.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(correo)
                    .matches()
            ) {
                campoCorreo.error = "Ingrese un correo electronico válido."
                campoCorreo.requestFocus()
                return@setOnClickListener
            }

            if (modalidadId == -1) {
                Toast.makeText(this, "Seleccione una modalidad", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!cbTerminos.isChecked) {
                Toast.makeText(this, "Debe aceptar los términos y condiciones.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val modalidadSeleccionada = findViewById<RadioButton>(modalidadId).text.toString()

            val intent = Intent(this, ConfirmacionActivity::class.java)
            intent.putExtra("nombre", nombre)
            intent.putExtra("correo", correo)
            intent.putExtra("modalidad", modalidadSeleccionada)

            startActivity(intent)
        }

        btnVolver.setOnClickListener {
            finish()
        }

    }
}