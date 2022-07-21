insert into disciplina(id, nombre, codigo, descripcion) values
    (1,'Futbol','fut','Deporte:Futbol'),
    (2,'Voley','vol','Deporte:Voley'),
    (3,'Basket','bas','Deporte:Basket'),
    (4,'Rugby','rug','Deporte:Rugby'),
    (5,'Tenis','ten','Deporte:Tenis'),
    (6,'Handball','han','Deporte:Handball');

insert into facultad(id, nombre, codigo, codigo_numerico) values
    (1,'UTN Villa Maria','UTNFRVM','45'),
    (2,'UTN Cordoba','UTNFRC','20'),
    (3,'UTN Rosario','UTNFRRO','31'),
    (4,'UTN San Francisco','UTNFRSF','8'),
    (5,'UTN Chubut','UTNFRCH','26'),
    (6,'UTN Santa Fe','UTNFRSF','12');

insert into jugador(id,apellido,dni,email,fecha_nacimiento,legajo,nombre,telefono,disciplina_id,facultad_id,nacionalidad) values
    (1,'González','38094008','GonFel@gmail.com','1970-10-05','36302','Felipe','15217972',1,3,'Argentina'),
    (2,'Rodríguez','31450955','RodMat@live.com','1964-01-12','45563','Mateo','15315362',6,5,'Belize'),
    (3,'López','26611674','LopBau@hotmail.com','1984-07-28','70644','Bautista','15605204',4,3,'Chile'),
    (4,'Fernández','24311903','FerBen@gmail.com','1979-04-20','46602','Benjamín','15145014',2,2,'Argentina'),
    (5,'García','33933092','GarThi@gmail.com','1968-02-14','48301','Thiago','15581435',2,1,'Uruguay'),
    (6,'Fernández',43611344,'FerLau@live.com','2001-06-24','63410','Lautaro','15998431',3,1,'Chile');