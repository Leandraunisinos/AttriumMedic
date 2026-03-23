package com.example.attriummedic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Abre a tela de perfil diretamente
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)

        finish()
    }
}