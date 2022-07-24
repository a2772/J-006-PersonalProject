DROP DATABASE srp;
CREATE DATABASE srp;
USE srp;

CREATE TABLE tipo_cuenta(
	id int AUTO_INCREMENT PRIMARY KEY,
    cuenta VARCHAR(20) NOT NULL
);

CREATE TABLE cat_entidad_federativa(
	id int AUTO_INCREMENT PRIMARY KEY,
	entidad VARCHAR(24) UNIQUE NOT NULL,
	clave VARCHAR(2) UNIQUE
);

CREATE TABLE direccion(
	id int AUTO_INCREMENT PRIMARY KEY,
    entidad int NOT NULL,
    alcaldia VARCHAR(35) NOT NULL,
    colonia VARCHAR(35) NOT NULL,
    calle VARCHAR(60) NOT NULL,
    num_ext VARCHAR(10) NOT NULL,
    num_int VARCHAR(5),
    cp VARCHAR(5) NOT NULL,
    FOREIGN KEY(entidad) REFERENCES cat_entidad_federativa(id)
);

CREATE TABLE datos_personales(
	id int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    primer_apellido VARCHAR(20) NOT NULL,
    segundo_apellido VARCHAR(20) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    sexo VARCHAR (6) NOT NULL,
    direccion int,
    curp VARCHAR(18),
    FOREIGN KEY (direccion) REFERENCES direccion(id)
);