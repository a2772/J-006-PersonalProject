USE srp;

INSERT INTO tipo_cuenta(cuenta) VALUES ('Administrador');
INSERT INTO cat_entidad_federativa(entidad,clave) values ('AGUASCALIENTES','AS'),('BAJA CALIFORNIA','BC'),('BAJA CALIFORNIA SUR','BS'),('CAMPECHE','CC'),('COAHUILA','CL'),('COLIMA','CM'),('CHIAPAS','CS'),('CHIHUAHUA','CH'),('DISTRITO FEDERAL / CDMX','DF'),('DURANGO','DG'),('GUANAJUATO','GT'),('GUERRERO','GR'),('HIDALGO','HG'),('JALISCO','JC'),('ESTADO DE MEXICO','MC'),('MICHOACAN','MN'),('MORELOS','MS'),('NAYARIT','NT'),('NUEVO LEON','NL'),('OAXACA','OC'),('PUEBLA','PL'),('QUERETARO','QT'),('QUINTANA ROO','QR'),('SAN LUIS POTOSI','SP'),('SINALOA','SL'),('SONORA','SR'),('TABASCO','TC'),('TAMAULIPAS','TS'),('TLAXCALA','TL'),('VERACRUZ','VZ'),('YUCATAN','YN'),('ZACATECAS','ZS'),('NACIDO EN EL EXTRANJERO','NE');
INSERT INTO direccion (entidad,alcaldia,colonia,calle,num_ext,cp) VALUES 
	(9, 'Alcaldia A', 'Colonia A', 'Calle A', 2, '97666');
INSERT INTO datos_personales(nombre, primer_apellido, segundo_apellido, fecha_nacimiento, sexo, direccion, curp, tipo_cuenta) VALUES
	('Paris', 'Ramírez', 'Saldaña', '2001-05-27', 'Hombre', 1, null,1);


