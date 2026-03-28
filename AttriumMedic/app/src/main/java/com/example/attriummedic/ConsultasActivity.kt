package com.example.attriummedic

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ConsultasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)

        setupNavigation()
    }

    private fun setupNavigation() {

        val btnInicio = findViewById<View>(R.id.btnNavInicio)
        btnInicio.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        val btnMedicos = findViewById<View>(R.id.btnNavMedicos)
        btnMedicos.setOnClickListener {
            startActivity(Intent(this, MedicosActivity::class.java))
        }

        val btnPerfil = findViewById<View>(R.id.btnNavPerfil)
        btnPerfil.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}