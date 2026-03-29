package com.example.attriummedic.mock

import com.example.attriummedic.model.Medico

object MedicoMock {

    fun getMedicos(): List<Medico> {
        return listOf(
            Medico("Dr. João Silva", "Cardiologia", "Especialista em coração", ""),
            Medico("Dra. Ana Souza", "Pediatria", "Atendimento infantil", ""),
            Medico("Dr. Carlos Lima", "Ortopedia", "Especialista em joelho", ""),
            Medico("Dra. Juliana Rocha", "Dermatologia", "Cuidados com a pele", "")
        )
    }
}