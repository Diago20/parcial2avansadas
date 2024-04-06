package com.example.parcialcorte2

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvNombre: EditText
    lateinit var btEnviar: Button
    var nombre: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvNombre = findViewById(R.id.tvNombre)
        btEnviar = findViewById(R.id.btEnviar)

        btEnviar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (TextUtils.isEmpty(tvNombre.text.toString())) {
            tvNombre.error = "Ingrese su nombre"
            tvNombre.requestFocus()
            return
        } else {
            nombre = tvNombre.text.toString()
        }

        when (v?.id) {
            R.id.btEnviar -> {
                val intent = Intent(this, Recibe::class.java)
                intent.putExtra("textoEnviado", nombre)
                startActivity(intent)
            }
        }
    }
}
