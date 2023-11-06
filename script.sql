CREATE TABLE Sport (
    id SERIAL PRIMARY KEY,
	sport_name VARCHAR (50)
);

CREATE TABLE Match (
    id SERIAL PRIMARY KEY,
    match_name VARCHAR(50),
    team_a INT REFERENCES Team(id),
    team_b INT REFERENCES Team(id),
    winner VARCHAR(50),
	sport_id INT REFERENCES Sport(id)
);

CREATE TABLE Team (
    id SERIAL PRIMARY KEY,
	team_name VARCHAR (50)
);

CREATE TABLE Player (
    id SERIAL PRIMARY KEY,
	player_name VARCHAR (50),
	team_id INT REFERENCES Team(id)
);

CREATE TABLE Set (
    id SERIAL PRIMARY KEY,
    match_id INT REFERENCES Match(id),
    team_a_score INT,
	team_b_score INT,
	set_order INT,
	winner INT REFERENCES Player(id)
);

CREATE TABLE Game (
    id SERIAL PRIMARY KEY,
    set_id INT REFERENCES Set(id),
    team_a_score INT,
	team_b_score INT,
	winner INT REFERENCES Player(id)
);

------ CRIAÇÃO DE MASSA

-- Dependencia para adicionar um match
INSERT INTO Sport (sport_name)
VALUES ('Beach Tennis');
-- Criar o Match
INSERT INTO Match (match_name, sport_id)
VALUES ('PUTA TÊNIS Vila verde', 1);
-- Criar 2 times
INSERT INTO Team (team_name)
VALUES ('BOCOS');
-- Add jogador aos times
INSERT INTO Player (player_name, team_id)
VALUES('Rafael',2);
-- Adicionar time a Match
UPDATE public.match
SET team_b = 2
WHERE id = 1;
-- -- Criar as regras do Match
-- -- Configurar Set - Informar a qtde de Set (Id(PK), Match_Id(FK), Time1_Score, Time2_Score, Set_Number, Vencedor)
INSERT INTO public.set(
	match_id, team_a_score, team_b_score, set_order)
	VALUES (1, 0, 0, 1);
-- -- Configurar Game por Set - Informar a quantidade de Game por Set (Id, Set_Id, Time1_Score, Time2_Score, Vencedor)
INSERT INTO public.game(
	set_id, team_a_score, team_b_score)
	VALUES (1, 0, 0);
-- -- Após criar o Match, inicia-se com a contagem inicial. Não tem vencedor, o Set é 1 e o Game é 1.


------ CONSULTAS ÚTEIS
