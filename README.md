# Gestión de Pokémon, Regiones y Entrenadores

Este proyecto aborda la creación de una aplicación para gestionar Pokémon, regiones y entrenadores. A continuación, se detallan las funcionalidades principales junto con la puntuación asignada y los errores identificados:

## Funcionalidades

### Formulario para Capturar Pokémon (1 punto)

- El formulario debe incluir campos para el nombre del Pokémon y la región asociada.

### Formulario para Registrar Regiones (1 punto)

- Permite ingresar el nombre de la región.

### Borrar Región o Pokémon (2 puntos)

- Permite la eliminación de una región entera o de un Pokémon individual.
- Al borrar una región, también se eliminan los datos de los Pokémon capturados en esa región.

### Registro de Entrenadores (3 puntos)

- Extiende el modelo de datos para incluir una tabla de entrenadores (id, nombre, active).
- Crea un formulario para la creación de un nuevo entrenador.
- Modifica las tablas existentes para asociar cada registro de Pokémon con la clave externa del entrenador específico que lo capturó.

### Control de Acceso (3 puntos)

- Implementa un sistema de control para garantizar que el entrenador activo solo pueda eliminar sus propios registros de Pokémon y no los de otros entrenadores, permitiendo la visualización en un listado de los Pokémon de ese entrenador activo.
- Si al borrar la región hay Pokémon de otro entrenador en la misma región a eliminar, se deniega la operación e informa al entrenador.
- Se permite la opción de cambiar de un entrenador activo a otro.

## Puntuación y Errores

- Puntuación: 7/10.
- Únicos errores: Implementación del sistema de control (-3 puntos).

### Schema.sql
CREATE TABLE IF NOT EXISTS REGION(
   id INT primary key auto_increment,
   nombre varchar(25)
);


CREATE TABLE IF NOT EXISTS ENTRENADOR(
   id INT primary key auto_increment,
   nombre varchar(50),
   active boolean
);

CREATE TABLE IF NOT EXISTS POKEMON(
   id INT primary key auto_increment,
   nombre varchar(50),
   region INT,
   entrenador_id INT,
   FOREIGN KEY (region) REFERENCES REGION(id),
   FOREIGN KEY (entrenador_id) REFERENCES ENTRENADOR(id)
);

### Data.sql
INSERT INTO REGION (nombre) VALUES ('Kanto');
INSERT INTO REGION (nombre) VALUES ('Johto');

INSERT INTO ENTRENADOR (nombre, active) VALUES ('Ash Ketchum', false);
INSERT INTO ENTRENADOR (nombre, active) VALUES ('Brock', false);

INSERT INTO POKEMON (nombre, region, entrenador_id) VALUES ('Pikachu', 1, 1);
INSERT INTO POKEMON (nombre, region, entrenador_id) VALUES ('Onix', 2, 2);
