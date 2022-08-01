USE srp;

DROP TRIGGER IF EXISTS tres_uniques;
DELIMITER %
CREATE TRIGGER tres_uniques
BEFORE INSERT ON tres_unicos
FOR EACH ROW
BEGIN
	-- Declare the program variables where we'll hold the values we're sending into the procedure;
	DECLARE val1 INT DEFAULT NULL;
	DECLARE val2 INT DEFAULT NULL;
	DECLARE val3 INT DEFAULT NULL;
    DECLARE errorMsg VARCHAR(55) DEFAULT '';
	-- We need a boolean variable to tell us when the cursor is out of data
	DECLARE done BOOL DEFAULT FALSE;
	-- declare a cursor to select the desired columns from the desired source
	-- the input argument (which you might or might not need) is used in this example for row selection
	DECLARE cursor1 -- cursor1 is an arbitrary label, an identifier for the cursor
		CURSOR FOR
		SELECT uno, dos, tres, CONCAT('NO SE PUEDEN REPETIR LOS 3: ',uno,',',dos,',',tres) AS msg
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
	FETCH NEXT FROM cursor1 INTO val1, val2, val3, errorMsg;
		IF done THEN -- this will be true when we are out of rows to read, so we go to the statement after END LOOP.
			LEAVE my_loop; 
		ELSE
		   -- Hacemos esto por cada fila
			IF (NEW.uno = val1 AND NEW.dos = val2 AND NEW.tres = val3)
			THEN
				SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = errorMsg;
			END IF;
		END IF;
	END LOOP;
	-- execution continues here when LEAVE my_loop is encountered;
	-- you might have more things you want to do here

	-- the cursor is implicitly closed when it goes out of scope, or can be explicitly closed if desired
	CLOSE cursor1;
END
% DELIMITER ;