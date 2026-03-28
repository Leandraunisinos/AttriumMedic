package com.example.attriummedic

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MedicosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicos)

        setupNavigation()
    }

    private fun setupNavigation() {
        val btnInicio = findViewById<View>(R.id.btnNavInicio)
        val btnConsultas = findViewById<View>(R.id.btnNavConsultas)
        val btnPerfil = findViewById<View>(R.id.btnNavPerfil)

        btnInicio.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        btnConsultas.setOnClickListener {
            startActivity(Intent(this, ConsultasActivity::class.java))
            finish()
        }

        btnPerfil.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}