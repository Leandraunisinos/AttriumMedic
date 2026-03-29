object MedicosMock {

    fun getDoctors(): List<MedicosMock> {
        return listOf(
            MedicosMock("Dr. João Silva", "Cardiologia", "Especialista em coração", ""),
            MedicosMock("Dra. Ana Souza", "Pediatria", "Atendimento infantil", ""),
            MedicosMock("Dr. Carlos Lima", "Ortopedia", "Especialista em joelho", "")
        )
    }
}