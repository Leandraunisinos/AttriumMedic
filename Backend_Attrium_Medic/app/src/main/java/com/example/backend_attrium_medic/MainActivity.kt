package com.example.backend_attrium_medic

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajuste de Padding para Edge-to-Edge
        val mainView = findViewById<android.view.View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Execução do Banco de Dados
        executarOperacoesBanco()
    }

    private fun executarOperacoesBanco() {
        val db = AppDatabase.getDatabase(this)
        val dao = db.clinicaDao()

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                // 1. Inserindo Paciente
                val novoPaciente = Paciente(
                    cpf = "123.456.789-90",
                    nome = "Maria Silva",
                    email = "maria.silva@email.com",
                    telefone = "(11) 98765-4321",
                    dataNascimento = "1988-04-15",
                    tipoSanguineo = "O+"
                )
                dao.inserirPaciente(novoPaciente)

                // 2. Inserindo Médico
                val novoMedico = Medico(
                    nome = "Dr. Ricardo Almeida",
                    especialidade = "Cardiologia",
                    bio = "Especialista em cardiologia clínica...",
                    fotoUrl = "path/to/foto.jpg"
                )
                dao.inserirMedico(novoMedico)

                Log.d("DB_INFO", "Dados inseridos com sucesso!")
            } catch (e: Exception) {
                Log.e("DB_ERROR", "Erro ao acessar banco: ${e.message}")
            }
        }
    }
}

