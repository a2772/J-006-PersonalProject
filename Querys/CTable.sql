DROP DATABASE srp;
CREATE DATABASE srp;
USE srp;

DROP TABLE IF EXISTS tipo_cuenta;
CREATE TABLE tipo_cuenta(
	id int AUTO_INCREMENT PRIMARY KEY,
    cuenta VARCHAR(20) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS cat_entidad_federativa;
CREATE TABLE cat_entidad_federativa(
	id int AUTO_INCREMENT PRIMARY KEY,
	entidad VARCHAR(24) UNIQUE NOT NULL,
	clave VARCHAR(2) UNIQUE
);

DROP TABLE IF EXISTS direccion;
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

DROP TABLE IF EXISTS datos_personales;
CREATE TABLE datos_personales(
	id int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    primer_apellido VARCHAR(20) NOT NULL,
    segundo_apellido VARCHAR(20) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    sexo VARCHAR (6) NOT NULL,
    direccion int,
    tipo_cuenta int,
    curp VARCHAR(18),
    FOREIGN KEY (direccion) REFERENCES direccion(id),
    FOREIGN KEY (tipo_cuenta) REFERENCES tipo_cuenta(id)
);

DROP TABLE IF EXISTS cuenta;
CREATE TABLE cuenta(
    email VARCHAR(35) PRIMARY KEY,
    passwd VARCHAR(20) NOT NULL,
    datos_personales int,
    FOREIGN KEY (datos_personales) REFERENCES datos_personales(id)
);

DROP TABLE IF EXISTS tres_unicos;
CREATE TABLE tres_unicos(
	uno int,
    dos int,
    tres int
);

INSERT INTO tres_unicos(uno,dos,tres) VALUES (1,2,3);

DELIMITER %
CREATE TRIGGER tres_uniques
BEFORE INSERT ON tres_unicos
FOR EACH ROW
BEGIN
	-- Declare the program variables where we'll hold the values we're sending into the procedure;
	DECLARE val1 INT DEFAULT NULL;
	DECLARE val2 INT DEFAULT NULL;
	DECLARE val3 INT DEFAULT NULL;
	-- We need a boolean variable to tell us when the cursor is out of data
	DECLARE done BOOL DEFAULT FALSE;
	-- declare a cursor to select the desired columns from the desired source
	-- the input argument (which you might or might not need) is used in this example for row selection
	DECLARE cursor1 -- cursor1 is an arbitrary label, an identifier for the cursor
		CURSOR FOR
		SELECT uno, dos, tres
		FROM tres_unicos;
	-- a cursor that runs out of data throws an exception; we need to catch this.
	-- when the NOT FOUND condition fires, "done" -- which defaults to FALSE -- will be set to true,
	-- and since this is a CONTINUE handler, execution continues with the next statement.   
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	-- open the cursor
	OPEN cursor1;

	my_loop: -- loops have to have an arbitrary label; it's used to leave the loop
	LOOP
	-- read the values from the next row that is available in the cursor
	FETCH NEXT FROM cursor1 INTO val1, val2, val3;
		IF done THEN -- this will be true when we are out of rows to read, so we go to the statement after END LOOP.
			LEAVE my_loop; 
		ELSE
		   -- Hacemos esto por cada fila
			IF (NEW.uno = val1 AND NEW.dos = val2 AND NEW.tres = val3)
			THEN
				SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "NO SE PUEDEN REPETIR LOS 3";
			END IF;
		END IF;
	END LOOP;
	-- execution continues here when LEAVE my_loop is encountered;
	-- you might have more things you want to do here

	-- the cursor is implicitly closed when it goes out of scope, or can be explicitly closed if desired
	CLOSE cursor1;
END
% DELIMITER ;

