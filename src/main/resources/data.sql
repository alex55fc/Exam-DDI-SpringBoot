INSERT INTO REGION (nombre) VALUES ('Kanto');
INSERT INTO REGION (nombre) VALUES ('Johto');

INSERT INTO ENTRENADOR (nombre, active) VALUES ('Ash Ketchum', true);
INSERT INTO ENTRENADOR (nombre, active) VALUES ('Brock', true);

INSERT INTO POKEMON (nombre, region, entrenador_id) VALUES ('Pikachu', 1, 1);
INSERT INTO POKEMON (nombre, region, entrenador_id) VALUES ('Onix', 2, 2);
