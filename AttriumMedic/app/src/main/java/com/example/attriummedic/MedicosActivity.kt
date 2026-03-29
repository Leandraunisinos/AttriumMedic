package com.example.attriummedic

import androidx.cardview.widget.CardView
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.attriummedic.mock.MedicoMock

class MedicosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicos)

        setupMenu()
        setupListaMedicos()
    }

    private fun setupMenu() {
        findViewById<FrameLayout>(R.id.btnNavInicio).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        findViewById<FrameLayout>(R.id.btnNavConsultas).setOnClickListener {
            startActivity(Intent(this, ConsultasActivity::class.java))
            finish()
        }

        findViewById<FrameLayout>(R.id.btnNavPerfil).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }

    private fun setupListaMedicos() {
        val container = findViewById<LinearLayout>(R.id.containerDoctors)

        val medicos = MedicoMock.getMedicos()

        medicos.forEach { medico ->

            val card = CardView(this).apply {
                radius = 16f
                cardElevation = 4f
                setCardBackgroundColor(0xFFFFFFFF.toInt())
                useCompatPadding = true
            }

            val conteudo = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(32, 32, 32, 32)
            }

            val containerTopo = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
            }

            val imagem = ImageView(this).apply {
                setImageResource(R.drawable.ic_launcher_foreground)
                layoutParams = LinearLayout.LayoutParams(150, 150)
            }

            val info = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(24, 0, 0, 0)
            }

            val nome = TextView(this).apply {
                text = medico.nome
                textSize = 18f
                setTextColor(0xFF1A2B22.toInt())
            }

            val especialidade = TextView(this).apply {
                text = medico.especialidade
                setTextColor(0xFF2E7D32.toInt())
                setPadding(20, 8, 20, 8)
                setBackgroundColor(0xFFE8F5E9.toInt())
            }

            val descricao = TextView(this).apply {
                text = medico.descricao
                setTextColor(0xFF6B7280.toInt())
            }

            val botao = Button(this).apply {
                text = "Agendar via WhatsApp"
                setBackgroundColor(0xFF4CAF50.toInt())
                setTextColor(0xFFFFFFFF.toInt())
            }

            info.addView(nome)
            info.addView(especialidade)
            info.addView(descricao)

            containerTopo.addView(imagem)
            containerTopo.addView(info)

            conteudo.addView(containerTopo)
            conteudo.addView(botao)

            card.addView(conteudo)

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            val margin = (16 * resources.displayMetrics.density).toInt()
            params.setMargins(0, 0, 0, margin)

            card.layoutParams = params

            container.addView(card)
        }
    }
}