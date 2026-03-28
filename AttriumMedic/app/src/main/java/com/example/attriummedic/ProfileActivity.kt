package com.example.attriummedic

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Configuração dos itens de informação (Email, Telefone, etc)
        setupItem(R.id.itemEmail, android.R.drawable.ic_dialog_email, "Email", "maria.silva@email.com")
        setupItem(R.id.itemTelefone, android.R.drawable.ic_menu_call, "Telefone", "(11) 98765-4321")
        setupItem(R.id.itemCpf, android.R.drawable.ic_menu_info_details, "CPF", "***.***.***-90")
        setupItem(R.id.itemNascimento, android.R.drawable.ic_menu_my_calendar, "Nascimento", "15/04/1988")
        setupItem(R.id.itemSangue, android.R.drawable.ic_menu_compass, "Tipo Sanguíneo", "O+")

        setupNavigation()
    }

    private fun setupNavigation() {

        val btnInicio = findViewById<View>(R.id.btnNavInicio)
        val btnConsultas = findViewById<View>(R.id.btnNavConsultas)
        val btnNavMedicos = findViewById<View>(R.id.btnNavMedicos)

        btnInicio.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnConsultas.setOnClickListener {
            val intent = Intent(this, ConsultasActivity::class.java)
            startActivity(intent)
        }

        btnNavMedicos.setOnClickListener {
            startActivity(Intent(this, MedicosActivity::class.java))
        }
    }

    private fun setupItem(viewId: Int, iconRes: Int, title: String, value: String) {
        val item = findViewById<View>(viewId)
        val iconView = item.findViewById<ImageView>(R.id.icon)
        val titleView = item.findViewById<TextView>(R.id.title)
        val valueView = item.findViewById<TextView>(R.id.value)

        iconView.setImageResource(iconRes)
        titleView.text = title
        valueView.text = value
    }
}