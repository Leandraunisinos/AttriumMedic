/* Criação do Banco de Dados: Attrium_Medic */


/* -- 1. Tabela: Paciente*/
CREATE TABLE IF NOT EXISTS Paciente (
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(100) NOT NULL, 
    email VARCHAR(100) UNIQUE, 
    telefone VARCHAR(15), 
    data_nascimento DATE, 
    tipo_sanguineo VARCHAR(3), 
    PRIMARY KEY (cpf) 
);

/* -- 2. Tabela: Medico*/
CREATE TABLE IF NOT EXISTS Medico (
    id_medico INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(100) NOT NULL, 
    especialidade VARCHAR(50) NOT NULL, 
    bio TEXT, 
    foto_url VARCHAR(255) 
);

/* -- 3. Tabela: Consulta*/
CREATE TABLE IF NOT EXISTS Consulta (
    id_consulta INTEGER PRIMARY KEY AUTOINCREMENT, 
    cpf_paciente VARCHAR(14),
    id_medico INT, 
    data_evento DATE NOT NULL, 
    status_consulta VARCHAR(25) NOT NULL, 
    /* -- Estado atual: Aguardando, Realizada ou Expirado */
    tipo_servico VARCHAR(100), 
    observacao TEXT, 
    
   /* -- Definição das Chaves Estrangeiras (Relacionamentos)*/
    FOREIGN KEY (cpf_paciente) REFERENCES Paciente(cpf), 
    FOREIGN KEY (id_medico) REFERENCES Medico(id_medico) 
);