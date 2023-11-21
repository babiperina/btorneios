CREATE TABLE Genero (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL
);

CREATE TABLE Nivel (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL
);

CREATE TABLE Categoria (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL,
    genero_id INT REFERENCES Genero(id) NOT NULL,
    genero_name VARCHAR(255),
    nivel_id INT REFERENCES Nivel(id) NOT NULL,
    nivel_name VARCHAR(255)
);

CREATE TABLE Status (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE Torneio (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    quantidade_min_duplas INT,
    configuracao_game_set VARCHAR(255),
    status_id INT REFERENCES Status(id)
);



CREATE TABLE Categoria_Torneio (
    id SERIAL PRIMARY KEY,
    categoria_id INT REFERENCES Categoria(id) NOT NULL,
    torneio_id INT REFERENCES Torneio(id) NOT NULL
);


CREATE TABLE Jogador (
    id SERIAL PRIMARY KEY,
    name VARCHAR (255),
    genero_id INT REFERENCES Genero(id),
    nivel_id INT REFERENCES Nivel(id)
);

CREATE TABLE Dupla (
    id SERIAL PRIMARY KEY,
    jogadorA INT REFERENCES Jogador(id),
    jogadorB INT REFERENCES Jogador(id)
);

CREATE TABLE Dupla_Torneio (
    id SERIAL PRIMARY KEY,
    dupla_id INT REFERENCES Dupla(id),
    torneio_id INT REFERENCES Torneio(id)
);

