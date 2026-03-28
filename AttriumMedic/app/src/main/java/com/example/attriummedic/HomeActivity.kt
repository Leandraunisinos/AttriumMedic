package com.example.attriummedic

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupMenu()
        setupQuickAccess()
    }

    private fun setupMenu() {
        val btnNavMedicos = findViewById<View>(R.id.btnNavMedicos)
        val btnNavConsultas = findViewById<View>(R.id.btnNavConsultas)
        val btnNavPerfil = findViewById<View>(R.id.btnNavPerfil)

        btnNavMedicos.setOnClickListener {
            startActivity(Intent(this, MedicosActivity::class.java))
        }

        btnNavConsultas.setOnClickListener {
            startActivity(Intent(this, ConsultasActivity::class.java))
        }

        btnNavPerfil.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun setupQuickAccess() {
        val cardMedicos = findViewById<View>(R.id.cardAcessoMedicos)
        val cardConsultas = findViewById<View>(R.id.cardAcessoConsultas)

        cardMedicos.setOnClickListener {
            startActivity(Intent(this, MedicosActivity::class.java))
        }

        cardConsultas.setOnClickListener {
            val intent = Intent(this, ConsultasActivity::class.java)
            startActivity(intent)
        }
    }
}