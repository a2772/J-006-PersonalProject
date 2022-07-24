DROP PROCEDURE IF EXISTS obten_persona;
DELIMITER %
-- LAST UPDATED ON 2022/07/22 BY Paris Ramírez Saldaña
CREATE PROCEDURE obten_persona(IN id_inin int, IN email_invc VARCHAR(35))
BEGIN
	SELECT 
		dp.id, dp.nombre, dp.primer_apellido, dp.segundo_apellido, dp.fecha_nacimiento, dp.sexo, dp.curp,
		tc.id, tc.cuenta,
		d.id, d.alcaldia, d.colonia, d.calle,d.num_ext, d.num_int, d.cp,
		cef.id, cef.entidad, cef.clave,
		c.email
	FROM 
		datos_personales dp INNER JOIN tipo_cuenta tc ON dp.tipo_cuenta = tc.id
		INNER JOIN direccion d ON dp.direccion = d.id
		INNER JOIN cat_entidad_federativa cef ON d.entidad = cef.id
		LEFT JOIN cuenta c ON c.datos_personales = dp.id
	WHERE
		(email_invc IS NOT NULL OR id_inin) AND
		IF(id_inin IS NOT NULL, id_inin = dp.id, TRUE) AND
        IF(email_invc IS NOT NULL, c.email = email_invc, TRUE)
    ;
END
% DELIMITER ;