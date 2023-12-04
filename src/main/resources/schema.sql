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