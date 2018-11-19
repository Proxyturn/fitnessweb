CREATE TABLE usuarios (
id          		BIGINT (20) NOT NULL AUTO_INCREMENT,
dataHora   			TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
nome        		TEXT NOT NULL,
login       		VARCHAR (50) NOT NULL,
senha      			VARCHAR (50) NOT NULL,
dataNascimento		DATE NOT NULL,
altura				FLOAT(10,2) NOT NULL,
CONSTRAINT pkUsuarios PRIMARY KEY(id)) ENGINE = InnoDB COLLATE = latin1_general_ci;


CREATE TABLE treinos (
id                  BIGINT (20) NOT NULL AUTO_INCREMENT,
dataHora            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
identificacao       VARCHAR (100) NOT NULL,
dataInicio		    DATE NOT NULL,
dataFim		        DATE NOT NULL,
status              BIGINT (10) NOT NULL,
idTreinoUsuario     BIGINT (20) NOT NULL,
CONSTRAINT pkTreinos PRIMARY KEY(id),
CONSTRAINT fkTreinosUsuarios FOREIGN KEY(idTreinoUsuario) REFERENCES usuarios(id)) ENGINE = InnoDB COLLATE = latin1_general_ci;


Create TABLE dias(
id                  BIGINT (20) NOT NULL AUTO_INCREMENT,
dataHora            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
identificacao       VARCHAR (100) NOT NULL,
idDiasTreino        BIGINT (20) NOT NULL,
CONSTRAINT pkDias PRIMARY KEY(id),
CONSTRAINT fkDiasTreino FOREIGN KEY(idDiasTreino) REFERENCES treinos(id)) ENGINE = InnoDB COLLATE = latin1_general_ci;



Create TABLE catalogos(
id                  BIGINT (20) NOT NULL AUTO_INCREMENT,
dataHora            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
identificacao       VARCHAR (30) NOT NULL,
descricao           VARCHAR (100) NOT NULL,
CONSTRAINT pkCatalogos PRIMARY KEY(id)) ENGINE = InnoDB COLLATE = latin1_general_ci;


Create TABLE exercicios(
id                  BIGINT (20) NOT NULL AUTO_INCREMENT,
dataHora            TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
repeticoes       VARCHAR (100) NOT NULL,
idExerciciosDias        BIGINT (20) NOT NULL,
idExerciciosCatalogos       BIGINT (20) NOT NULL,
CONSTRAINT pkExercicios PRIMARY KEY(id),
CONSTRAINT fkExerciciosDias FOREIGN KEY(idExerciciosDias) REFERENCES dias(id),
CONSTRAINT fkExerciciosCatalogos FOREIGN KEY(idExerciciosCatalogos) REFERENCES catalogos(id)) ENGINE = InnoDB COLLATE = latin1_general_ci;



INSERT INTO usuarios (nome ,login, senha, dataNascimento, altura) VALUES ( 'Ussuario Aluno Teste','aluno', MD5('123456'),'1982-10-06',1.7);