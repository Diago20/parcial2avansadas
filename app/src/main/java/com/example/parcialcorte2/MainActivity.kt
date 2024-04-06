package com.example.parcialcorte2

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvNombre: TextView
    lateinit var btEnviar: Button
    var name: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btEnviar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (TextUtils.isEmpty(tvNombre.text.toString())) {
            tvNombre.error = "Ingrese su nombre"
            tvNombre.requestFocus()
            return
        } else {
            name = tvNombre.text.toString()
        }when (v?.id) {
            R.id.btEnviar -> {
                val intet = intet (this,Enviar::class.java)
                intent.extras("texto Enviado", name)
            }
        }
    }
}


