CREATE DATABASE mago_jogo;
USE mago_jogo;

CREATE TABLE Mago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    vidas INT NOT NULL DEFAULT 3
);

CREATE TABLE Inimigo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    vidas INT NOT NULL
);

CREATE TABLE Sala (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL
);

CREATE TABLE MagoSala (
    mago_id INT,
    sala_id INT,
    PRIMARY KEY (mago_id, sala_id),
    FOREIGN KEY (mago_id) REFERENCES Mago(id),
    FOREIGN KEY (sala_id) REFERENCES Sala(id)
);

CREATE TABLE SalaInimigo (
    sala_id INT,
    inimigo_id INT,
    PRIMARY KEY (sala_id, inimigo_id),
    FOREIGN KEY (sala_id) REFERENCES Sala(id),
    FOREIGN KEY (inimigo_id) REFERENCES Inimigo(id)
);
