INSERT INTO Ciclo VALUES(01,'CICLO I',TO_DATE('2019/02/08','YYYY-MM-DD'),TO_DATE('2019/06/28','YYYY-MM-DD'));
INSERT INTO Ciclo VALUES(02,'CICLO II',TO_DATE('2019/07/12','YYYY-MM-DD'),TO_DATE('2019/11/26','YYYY-MM-DD'));
-- --------------------------------VETERIARIA----------------------------------
INSERT INTO Carrera VALUES(1,'Medicina Veterinaria','Licenciatura');

--PRIMER AÑO
INSERT INTO Curso VALUES(1,'Estudios Generales 1',3,3);
INSERT INTO Curso VALUES(2,'Estudios Generales 2',3,3);
INSERT INTO Curso VALUES(3,'Introducción a la Química General',4,4);
INSERT INTO Curso VALUES(4,'Zoología',3,3);
INSERT INTO Curso VALUES(5,'Ingles Tecnico',3,3);
INSERT INTO Curso VALUES(6,'Optativo',2,2);
INSERT INTO PlanEstudio VALUES(1,1,1,1);
INSERT INTO PlanEstudio VALUES(2,1,1,1);
INSERT INTO PlanEstudio VALUES(3,1,1,1);
INSERT INTO PlanEstudio VALUES(4,1,1,1);
INSERT INTO PlanEstudio VALUES(5,1,1,1);
INSERT INTO PlanEstudio VALUES(6,1,1,1);

INSERT INTO Curso VALUES(7,'Estudios Generales 3',3,3);
INSERT INTO Curso VALUES(8,'Estudios Generales 4',3,3);
INSERT INTO Curso VALUES(9,'Fundamentos de química orgánica',3,3);
INSERT INTO Curso VALUES(10,'Anatomía de los animales domésticos I',4,4);
INSERT INTO Curso VALUES(11,'Citología e histología general',3,3);
INSERT INTO Curso VALUES(12,'Optativo',2,2);
INSERT INTO PlanEstudio VALUES(7,1,1,2);
INSERT INTO PlanEstudio VALUES(8,1,1,2);
INSERT INTO PlanEstudio VALUES(9,1,1,2);
INSERT INTO PlanEstudio VALUES(10,1,1,2);
INSERT INTO PlanEstudio VALUES(11,1,1,2);
INSERT INTO PlanEstudio VALUES(12,1,1,2);

--SEGUNDO AÑO
INSERT INTO Curso VALUES(13,'Histología especial y Embriología',4,4);
INSERT INTO Curso VALUES(14,'Bioquímica general',5,5);
INSERT INTO Curso VALUES(15,'Estadística médica',3,3);
INSERT INTO Curso VALUES(16,'Bioética',2,2);
INSERT INTO Curso VALUES(17,'Anatomía de los animales domésticos II',4,4);
INSERT INTO PlanEstudio VALUES(13,1,2,1);
INSERT INTO PlanEstudio VALUES(14,1,2,1);
INSERT INTO PlanEstudio VALUES(15,1,2,1);
INSERT INTO PlanEstudio VALUES(16,1,2,1);
INSERT INTO PlanEstudio VALUES(17,1,2,1);

INSERT INTO Curso VALUES(18,'Biología Celular',3,3);
INSERT INTO Curso VALUES(19,'Fisiología animal I',5,5);
INSERT INTO Curso VALUES(20,'Genética',3,3);
INSERT INTO Curso VALUES(21,'Producción  animal sostenible I',3,3);
INSERT INTO Curso VALUES(22,'Nutrición animal I',3,3);
INSERT INTO PlanEstudio VALUES(18,1,2,2);
INSERT INTO PlanEstudio VALUES(19,1,2,2);
INSERT INTO PlanEstudio VALUES(20,1,2,2);
INSERT INTO PlanEstudio VALUES(21,1,2,2);
INSERT INTO PlanEstudio VALUES(22,1,2,2);

--TERCER AÑO 
INSERT INTO Curso VALUES(23,'Fisiología animal II',5,5);
INSERT INTO Curso VALUES(24,'Producción animal sostenible II',3,3);
INSERT INTO Curso VALUES(25,'Nutrición  animal II',3,3);
INSERT INTO Curso VALUES(26,'Inmunología y Microbiología',4,4);
INSERT INTO Curso VALUES(27,'Optativo',2,2);
INSERT INTO PlanEstudio VALUES(23,1,3,1);
INSERT INTO PlanEstudio VALUES(24,1,3,1);
INSERT INTO PlanEstudio VALUES(25,1,3,1);
INSERT INTO PlanEstudio VALUES(26,1,3,1);
INSERT INTO PlanEstudio VALUES(27,1,3,1);

INSERT INTO Curso VALUES(28,'Patología General',4,4);
INSERT INTO Curso VALUES(29,'Microbiología e Infectología',5,5);
INSERT INTO Curso VALUES(30,'Parasitología y Enfermedades Parasitarias I',3,3);
INSERT INTO Curso VALUES(31,'Farmacología y terapéutica I',3,3);
INSERT INTO Curso VALUES(32,'Análisis Clínicos',3,3);
INSERT INTO PlanEstudio VALUES(28,1,3,2);
INSERT INTO PlanEstudio VALUES(29,1,3,2);
INSERT INTO PlanEstudio VALUES(30,1,3,2);
INSERT INTO PlanEstudio VALUES(31,1,3,2);
INSERT INTO PlanEstudio VALUES(32,1,3,2);

--CUARTO AÑO 
INSERT INTO Curso VALUES(33,'Patología Especial',5,5);
INSERT INTO Curso VALUES(34,'Parasitología y Enfermedades Parasitarias II',3,3);
INSERT INTO Curso VALUES(35,'Farmacología y terapéutica II',4,4);
INSERT INTO Curso VALUES(36,'Clínica  propedéutica de especies mayores',3,3);
INSERT INTO Curso VALUES(37,'Clínica  propedéutica de especies menores',3,3);
INSERT INTO PlanEstudio VALUES(33,1,4,1);
INSERT INTO PlanEstudio VALUES(34,1,4,1);
INSERT INTO PlanEstudio VALUES(35,1,4,1);
INSERT INTO PlanEstudio VALUES(36,1,4,1);
INSERT INTO PlanEstudio VALUES(37,1,4,1);

INSERT INTO Curso VALUES(38,'Toxicología',3,3);
INSERT INTO Curso VALUES(39,'Medicina interna de especies mayores I',3,3);
INSERT INTO Curso VALUES(40,'Obstetricia',3,3);
INSERT INTO Curso VALUES(41,'Andrología',3,3);
INSERT INTO Curso VALUES(42,'Inspección e higiene de los alimentos I',3,3);
INSERT INTO Curso VALUES(43,'Enfermedades de las aves de producción',3,3);
INSERT INTO PlanEstudio VALUES(38,1,4,2);
INSERT INTO PlanEstudio VALUES(39,1,4,2);
INSERT INTO PlanEstudio VALUES(40,1,4,2);
INSERT INTO PlanEstudio VALUES(41,1,4,2);
INSERT INTO PlanEstudio VALUES(42,1,4,2);
INSERT INTO PlanEstudio VALUES(43,1,4,2);

--QUINTO AÑO 
INSERT INTO Curso VALUES(44,'Ginecología',3,3);
INSERT INTO Curso VALUES(45,'Medicina interna de especies mayores II',3,3);
INSERT INTO Curso VALUES(46,'Inspección e higiene de los alimentos II',3,3);
INSERT INTO Curso VALUES(47,'Propedéutica quirúrgica y diagnóstico',3,3);
INSERT INTO Curso VALUES(48,'Medicina interna de especies menores',3,3);
INSERT INTO Curso VALUES(49,'Optativo',3,3);
INSERT INTO PlanEstudio VALUES(44,1,5,1);
INSERT INTO PlanEstudio VALUES(45,1,5,1);
INSERT INTO PlanEstudio VALUES(46,1,5,1);
INSERT INTO PlanEstudio VALUES(47,1,5,1);
INSERT INTO PlanEstudio VALUES(48,1,5,1);
INSERT INTO PlanEstudio VALUES(49,1,5,1);

INSERT INTO Curso VALUES(50,'Cirugía de especies mayores',3,3);
INSERT INTO Curso VALUES(51,'Cirugía de especies menores',3,3);
INSERT INTO Curso VALUES(52,'Salud de hato',3,3);
INSERT INTO Curso VALUES(53,'Epidemiología y salud pública veterinaria',3,3);
INSERT INTO Curso VALUES(54,'Manejo y medicina de animales silvestres',3,3);
INSERT INTO Curso VALUES(55,'Optativo',3,3);
INSERT INTO PlanEstudio VALUES(50,1,5,2);
INSERT INTO PlanEstudio VALUES(51,1,5,2);
INSERT INTO PlanEstudio VALUES(52,1,5,2);
INSERT INTO PlanEstudio VALUES(53,1,5,2);
INSERT INTO PlanEstudio VALUES(54,1,5,2);
INSERT INTO PlanEstudio VALUES(55,1,5,2);

--SEXTO AÑO
INSERT INTO Curso VALUES(56,'Internado Rotatorio I*',15,15);
INSERT INTO Curso VALUES(57,'Internado Rotatorio II*',15,15);
INSERT INTO Curso VALUES(58,'Trabajo Final de Graduación',0,0);
INSERT INTO PlanEstudio VALUES(56,1,6,1);
INSERT INTO PlanEstudio VALUES(57,1,6,2);
INSERT INTO PlanEstudio VALUES(58,1,6,2);

-- --------------------Ingeniería em Sistemas----------------------
INSERT INTO Carrera VALUES(2,'Ingenieria en Sistemas','Bachillerato');
-- ----PRIMER AÑO
INSERT INTO Curso VALUES(59,'Fundamentos de Informática',3,3);
INSERT INTO Curso VALUES(60,'Matemática para Informática I',4,4);
INSERT INTO Curso VALUES(61,'Arte',3,3);
INSERT INTO Curso VALUES(62,'Cambio Climatico',3,3);
INSERT INTO Curso VALUES(63,'Inglés Integrado I',4,4);
INSERT INTO PlanEstudio VALUES(59,2,1,1);
INSERT INTO PlanEstudio VALUES(60,2,1,1);
INSERT INTO PlanEstudio VALUES(61,2,1,1);
INSERT INTO PlanEstudio VALUES(62,2,1,1);
INSERT INTO PlanEstudio VALUES(63,2,1,1);

INSERT INTO Curso VALUES(64,'Programación I',4,4);
INSERT INTO Curso VALUES(65,'Calculo I',4,4);
INSERT INTO Curso VALUES(66,'Globalizacion ',3,3);
INSERT INTO Curso VALUES(67,'Apreciacion del arte',3,3);
INSERT INTO Curso VALUES(68,'Inglés Integrado II',4,4);
INSERT INTO PlanEstudio VALUES(64,2,1,2);
INSERT INTO PlanEstudio VALUES(65,2,1,2);
INSERT INTO PlanEstudio VALUES(66,2,1,2);
INSERT INTO PlanEstudio VALUES(67,2,1,2);
INSERT INTO PlanEstudio VALUES(68,2,1,2);

-- -------------SEGUNDO AÑO------------------------------
INSERT INTO Curso VALUES(69,'Programación II',4,4);
INSERT INTO Curso VALUES(70,'Algebra',4,4);
INSERT INTO Curso VALUES(71,'Soporte Técnico',3,3);
INSERT INTO Curso VALUES(72,'Estructuras Discretas para Informática',3,3);
INSERT INTO Curso VALUES(73,'Inglés Integrado III',4,4);
INSERT INTO PlanEstudio VALUES(69,2,2,1);
INSERT INTO PlanEstudio VALUES(70,2,2,1);
INSERT INTO PlanEstudio VALUES(71,2,2,1);
INSERT INTO PlanEstudio VALUES(72,2,2,1);
INSERT INTO PlanEstudio VALUES(73,2,2,1);

INSERT INTO Curso VALUES(74,'Programación III',4,4);
INSERT INTO Curso VALUES(75,'Estructuras de Datos',4,4);
INSERT INTO Curso VALUES(76,'Arquitectura de Computadoras',3,3);
INSERT INTO Curso VALUES(77,'La Organización y su Entorno',3,3);
INSERT INTO Curso VALUES(78,'Probabilidad y Estadística',3,3);
INSERT INTO PlanEstudio VALUES(74,2,2,2);
INSERT INTO PlanEstudio VALUES(75,2,2,2);
INSERT INTO PlanEstudio VALUES(76,2,2,2);
INSERT INTO PlanEstudio VALUES(77,2,2,2);
INSERT INTO PlanEstudio VALUES(78,2,2,2);

-- -------------TERCER AÑO------------------------------
INSERT INTO Curso VALUES(79,'Programación IV',4,4);
INSERT INTO Curso VALUES(80,'Ingenieria de Sistemas  I',4,4);
INSERT INTO Curso VALUES(81,'Diseño e Implementación de Bases de Dato',4,4);
INSERT INTO Curso VALUES(82,'Sistemas Operativos',3,3);
INSERT INTO Curso VALUES(83,'Comunicaciones y Redes de Computadores',3,3);
INSERT INTO PlanEstudio VALUES(79,2,3,1);
INSERT INTO PlanEstudio VALUES(80,2,3,1);
INSERT INTO PlanEstudio VALUES(81,2,3,1);
INSERT INTO PlanEstudio VALUES(82,2,3,1);
INSERT INTO PlanEstudio VALUES(83,2,3,1);

INSERT INTO Curso VALUES(84,'Paradigmas de Programacion',4,4);
INSERT INTO Curso VALUES(85,'Ingenieria en Sistemas II',4,4);
INSERT INTO Curso VALUES(86,'Administracion de Bases de Datos',4,4);
INSERT INTO Curso VALUES(87,'Investigacion de Operaciones y sus Aplicaciones',3,3);
INSERT INTO Curso VALUES(88,'Liderazgo y Organizacion',3,3);
INSERT INTO PlanEstudio VALUES(84,2,5,2);
INSERT INTO PlanEstudio VALUES(85,2,5,2);
INSERT INTO PlanEstudio VALUES(86,2,5,2);
INSERT INTO PlanEstudio VALUES(87,2,5,2);
INSERT INTO PlanEstudio VALUES(88,2,5,2);

-- -------------CUARTO AÑO------------------------------
INSERT INTO Curso VALUES(89,'Diseño y programación de plataformas Móviles',4,4);
INSERT INTO Curso VALUES(90,'Ingenieria de Sistemas  III',4,4);
INSERT INTO Curso VALUES(91,'Optativo 1 ',3,3);
INSERT INTO Curso VALUES(92,'Optativo 2 ',3,3);
INSERT INTO Curso VALUES(93,'Met Inv Científica en Informática',3,3);
INSERT INTO PlanEstudio VALUES(89,2,4,1);
INSERT INTO PlanEstudio VALUES(90,2,4,1);
INSERT INTO PlanEstudio VALUES(91,2,4,1);
INSERT INTO PlanEstudio VALUES(92,2,4,1);
INSERT INTO PlanEstudio VALUES(93,2,4,1);

INSERT INTO Curso VALUES(94,'Proyectos y su Aplicacion en la Organizacion(PPS)',5,5);
INSERT INTO Curso VALUES(95,'Aplicaciones Informaticas Globales',4,4);
INSERT INTO Curso VALUES(96,'Optativo 3',3,3);
INSERT INTO Curso VALUES(97,'Optativo 4',3,3);
INSERT INTO Curso VALUES(98,'Informatica y Sociedad',2,2);
INSERT INTO PlanEstudio VALUES(94,2,4,2);
INSERT INTO PlanEstudio VALUES(95,2,4,2);
INSERT INTO PlanEstudio VALUES(96,2,4,2);
INSERT INTO PlanEstudio VALUES(97,2,4,2);
INSERT INTO PlanEstudio VALUES(98,2,4,2);

INSERT INTO Carrera VALUES(3,'Administración','Bachillerato');
INSERT INTO Curso VALUES(99,'Finanza Empresariales',2,2);
INSERT INTO Curso VALUES(100,'Desarrollo Socioeconómico de Costa Rica',2,2);
INSERT INTO Curso VALUES(101,'Paradigmas Administrativos',4,4);
INSERT INTO Curso VALUES(102,'Derecho Administrativo',2,2);
INSERT INTO Curso VALUES(103,'Administración de Recursos Humanos I',4,4);
INSERT INTO Curso VALUES(104,'Derecho Laboral',2,2);
INSERT INTO Curso VALUES(105,'Contabilidad Avanzada',4,4);
INSERT INTO Curso VALUES(106,'Microeconomía',2,2);
INSERT INTO Curso VALUES(107,'Análisis de Procesos Administrativos',4,4);
INSERT INTO Curso VALUES(108,'Derecho Empresarial',2,2);
INSERT INTO Curso VALUES(109,'Administración Bursátil',2,2);
INSERT INTO Curso VALUES(110,'Elaboración y Evaluación de Proyectos',4,4);
INSERT INTO Curso VALUES(111,'Investigación de Mercados',2,2);

-- Admin
INSERT INTO Administrador Values(12345,'DBA');

-- PROFESORES
INSERT INTO Profesor VALUES (1763589,'Juan Perez',35,87656789,'juanp@gmail.com');
INSERT INTO Profesor VALUES (6543789,'Margarita Gomez',31,76427896,'margaritag@gmail.com');
INSERT INTO Profesor VALUES (7648903,'Lucresia Ramirez',52,86345678,'lucresiar@gmail.com');
INSERT INTO Profesor VALUES (2789456,'Pablo Lopez',57,89345678,'pablol@gmail.com');

INSERT INTO Usuario VALUES(1763589,'1234','Profesor');
INSERT INTO Usuario VALUES(6543789,'1234','Profesor');
INSERT INTO Usuario VALUES(7648903,'1234','Profesor');
INSERT INTO Usuario VALUES(2789456,'1234','Profesor');

-- ALUMNOS
INSERT INTO Alumno VALUES(4678936,'Edgar Trigeros Arias','08/07/1997',22,'edgarta@gmail.com');
INSERT INTO Alumno VALUES(8362398,'Mirella Martinez','15/04/1995',24,'mirellam@gmail.com');
INSERT INTO Alumno VALUES(9859859,'Lourdes Ramirez','04/04/1997',22,'lourdes@gmail.com');
INSERT INTO Alumno VALUES(4564665,'María Jose Soto',22,'04/04/1997','mariasoto@gmail.com');
INSERT INTO Alumno VALUES(4465656,'Kimberly Hernandez Arce','04/04/1997',22,'kimher@gmail.com');
INSERT INTO Alumno VALUES(5675656,'Jennifer Hernandez Arce','04/04/1997',22,'jenniher@gmail.com');
INSERT INTO Alumno VALUES(9879586,'Karol Hernandez Arce','04/04/1997',22,'karolher@gmail.com');
INSERT INTO Alumno VALUES(4546956,'Estefany Hernandez Arce','04/04/1997',22,'estefanyher@gmail.com');
INSERT INTO Alumno VALUES(4666666,'Walter Ramirez Suniga','04/04/1997',22,'walR@gmail.com');
INSERT INTO Alumno VALUES(8096809,'Lukas Mora','04/04/1997',22,'lukasM@gmail.com');
INSERT INTO Alumno VALUES(8459867,'Marco Perez','04/04/1997',22,'marcoP@gmail.com');
INSERT INTO Alumno VALUES(4564645,'Jorge Alvarado','04/04/1997',22,'jorgeA@gmail.com');
INSERT INTO Alumno VALUES(6456456,'Geisel Alvarado','04/04/1997',22,'geiselAlv@gmail.com');
INSERT INTO Alumno VALUES(3534535,'Maria Jesus Lopez Martinez','04/04/1997',22,'mariajesusm@gmail.com');
INSERT INTO Alumno VALUES(6757576,'Mirella Gomez Lopez','04/04/1997',22,'mirellagomez@gmail.com');
INSERT INTO Alumno VALUES(4343453,'Zoe Montero Hernandez','04/04/1997',22,'zoemontero@gmail.com');

INSERT INTO Usuario VALUES(4678936,'1234','Alumno');
INSERT INTO Usuario VALUES(8362398,'1234','Alumno');
INSERT INTO Usuario VALUES(9859859,'1234','Alumno');
INSERT INTO Usuario VALUES(4564665,'1234','Alumno');
INSERT INTO Usuario VALUES(4465656,'1234','Alumno');
INSERT INTO Usuario VALUES(5675656,'1234','Alumno');
INSERT INTO Usuario VALUES(9879586,'1234','Alumno');
INSERT INTO Usuario VALUES(4546956,'1234','Alumno');
INSERT INTO Usuario VALUES(4666666,'1234','Alumno');
INSERT INTO Usuario VALUES(8096809,'1234','Alumno');
INSERT INTO Usuario VALUES(8459867,'1234','Alumno');
INSERT INTO Usuario VALUES(4564645,'1234','Alumno');
INSERT INTO Usuario VALUES(6456456,'1234','Alumno');
INSERT INTO Usuario VALUES(3534535,'1234','Alumno');
INSERT INTO Usuario VALUES(6757576,'1234','Alumno');
INSERT INTO Usuario VALUES(4343453,'1234','Alumno');




INSERT INTO Grupo VALUES(100,1,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(101,2,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(102,3,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(103,4,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(104,5,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(105,6,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(106,7,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(107,8,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(108,9,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(109,10,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(200,20,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(201,21,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(202,22,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(203,23,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(204,24,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(205,25,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(206,30,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(207,31,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(208,32,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(209,33,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(300,34,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(301,35,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(302,40,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(303,41,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(304,42,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(305,43,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(306,44,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(307,45,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(308,50,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(309,51,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(309,51,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(400,52,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(401,53,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(402,54,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(403,55,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(404,60,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(405,61,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(406,62,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(407,64,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(408,65,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(409,70,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(500,71,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(501,73,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(502,74,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(503,75,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(504,76,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(505,77,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(506,78,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(506,78,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(507,79,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(508,80,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(509,81,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(510,82,25,'L-V 8:00AM-10:40AM',7648903);
INSERT INTO Grupo VALUES(511,83,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(512,84,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(513,85,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(514,86,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(515,87,25,'L-V 8:00AM-10:40AM',2789456);
INSERT INTO Grupo VALUES(516,88,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(517,89,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(518,90,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(519,91,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(520,92,25,'L-V 8:00AM-10:40AM',1763589);
INSERT INTO Grupo VALUES(521,93,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(522,94,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(523,95,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(524,96,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(525,97,25,'L-V 8:00AM-10:40AM',6543789);
INSERT INTO Grupo VALUES(526,98,25,'L-V 8:00AM-10:40AM',6543789);






INSERT INTO Inscripcion VALUES(4678936,2);
INSERT INTO Inscripcion VALUES(8362398,2);
INSERT INTO Inscripcion VALUES(9859859,2);
INSERT INTO Inscripcion VALUES(4564665,2);
INSERT INTO Inscripcion VALUES(4465656,2);
INSERT INTO Inscripcion VALUES(5675656,2);
INSERT INTO Inscripcion VALUES(9879586,2);
INSERT INTO Inscripcion VALUES(4546956,2);
INSERT INTO Inscripcion VALUES(4666666,1);
INSERT INTO Inscripcion VALUES(8096809,3);
INSERT INTO Inscripcion VALUES(8459867,3);
INSERT INTO Inscripcion VALUES(4564645,3);
INSERT INTO Inscripcion VALUES(6456456,3);
INSERT INTO Inscripcion VALUES(3534535,3);
INSERT INTO Inscripcion VALUES(6757576,1);
INSERT INTO Inscripcion VALUES(4343453,2);


INSERT INTO Matricula VALUES(4678936,2,59,100,01);
INSERT INTO Matricula VALUES(4678936,2,60,101,01);
INSERT INTO Matricula VALUES(4678936,2,61,102,01);
INSERT INTO Matricula VALUES(4678936,2,62,103,01);
INSERT INTO Matricula VALUES(4678936,2,63,104,01);
INSERT INTO Matricula VALUES(4678936,2,64,105,02);
INSERT INTO Matricula VALUES(4678936,2,65,106,02);
INSERT INTO Matricula VALUES(4678936,2,66,107,02);
INSERT INTO Matricula VALUES(4678936,2,67,108,02);
INSERT INTO Matricula VALUES(4678936,2,68,109,02);

INSERT INTO Matricula VALUES(8362398,2,61,200,01);
INSERT INTO Matricula VALUES(8362398,2,62,201,01);
INSERT INTO Matricula VALUES(8362398,2,63,202,01);
INSERT INTO Matricula VALUES(8362398,2,64,203,01);
INSERT INTO Matricula VALUES(8362398,2,65,204,01);
INSERT INTO Matricula VALUES(8362398,2,66,205,02);
INSERT INTO Matricula VALUES(8362398,2,67,206,02);
INSERT INTO Matricula VALUES(8362398,2,68,207,02);
INSERT INTO Matricula VALUES(8362398,2,69,208,02);
INSERT INTO Matricula VALUES(8362398,2,70,209,02);

INSERT INTO Matricula VALUES(9859859,2,71,300,01);
INSERT INTO Matricula VALUES(9859859,2,72,302,01);
INSERT INTO Matricula VALUES(9859859,2,73,303,01);
INSERT INTO Matricula VALUES(9859859,2,74,304,01);
INSERT INTO Matricula VALUES(9859859,2,75,305,01);
INSERT INTO Matricula VALUES(9859859,2,76,306,02);
INSERT INTO Matricula VALUES(9859859,2,77,307,02);
INSERT INTO Matricula VALUES(9859859,2,78,308,02);
INSERT INTO Matricula VALUES(9859859,2,79,309,02);


INSERT INTO Matricula VALUES(4564665,2,80,401,01);
INSERT INTO Matricula VALUES(4564665,2,81,402,01);
INSERT INTO Matricula VALUES(4564665,2,82,403,01);
INSERT INTO Matricula VALUES(4564665,2,83,404,01);
INSERT INTO Matricula VALUES(4564665,2,84,405,02);
INSERT INTO Matricula VALUES(4564665,2,85,406,02);
INSERT INTO Matricula VALUES(4564665,2,86,407,02);
INSERT INTO Matricula VALUES(4564665,2,87,408,02);
INSERT INTO Matricula VALUES(4564665,2,88,409,02);


INSERT INTO Matricula VALUES(4465656,2,89,100,01);
INSERT INTO Matricula VALUES(4465656,2,90,101,01);
INSERT INTO Matricula VALUES(4465656,2,91,102,01);
INSERT INTO Matricula VALUES(4465656,2,92,103,01);
INSERT INTO Matricula VALUES(4465656,2,93,104,01);
INSERT INTO Matricula VALUES(4465656,2,94,105,02);
INSERT INTO Matricula VALUES(4465656,2,95,106,02);
INSERT INTO Matricula VALUES(4465656,2,96,107,02);
INSERT INTO Matricula VALUES(4465656,2,97,108,02);
INSERT INTO Matricula VALUES(4465656,2,98,109,02);

INSERT INTO Matricula VALUES(5675656,1,1,200,01);
INSERT INTO Matricula VALUES(5675656,1,2,201,01);
INSERT INTO Matricula VALUES(5675656,1,3,202,01);
INSERT INTO Matricula VALUES(5675656,1,4,203,01);
INSERT INTO Matricula VALUES(5675656,1,5,204,01);
INSERT INTO Matricula VALUES(5675656,1,6,205,02);
INSERT INTO Matricula VALUES(5675656,1,7,206,02);
INSERT INTO Matricula VALUES(5675656,1,8,207,02);
INSERT INTO Matricula VALUES(5675656,1,9,208,02);
INSERT INTO Matricula VALUES(5675656,1,10,209,02);

INSERT INTO Matricula VALUES(9879586,1,11,500,01);
INSERT INTO Matricula VALUES(9879586,1,12,501,01);
INSERT INTO Matricula VALUES(9879586,1,13,502,01);
INSERT INTO Matricula VALUES(9879586,1,14,503,01);
INSERT INTO Matricula VALUES(9879586,1,15,504,01);
INSERT INTO Matricula VALUES(9879586,1,16,505,02);
INSERT INTO Matricula VALUES(9879586,1,17,506,02);
INSERT INTO Matricula VALUES(9879586,1,18,403,02);
INSERT INTO Matricula VALUES(9879586,1,19,404,02);
INSERT INTO Matricula VALUES(9879586,1,20,406,02);

INSERT INTO Matricula VALUES(4546956,1,21,300,01);
INSERT INTO Matricula VALUES(4546956,1,22,301,01);
INSERT INTO Matricula VALUES(4546956,1,23,302,01);
INSERT INTO Matricula VALUES(4546956,1,24,303,01);
INSERT INTO Matricula VALUES(4546956,1,25,304,01);
INSERT INTO Matricula VALUES(4546956,1,26,305,02);
INSERT INTO Matricula VALUES(4546956,1,27,305,02);
INSERT INTO Matricula VALUES(4546956,1,28,306,02);
INSERT INTO Matricula VALUES(4546956,1,29,307,02);
INSERT INTO Matricula VALUES(4546956,1,30,209,02);

INSERT INTO Matricula VALUES(4666666,1,31,400,01);
INSERT INTO Matricula VALUES(4666666,1,32,401,01);
INSERT INTO Matricula VALUES(4666666,1,33,402,01);
INSERT INTO Matricula VALUES(4666666,1,34,409,01);
INSERT INTO Matricula VALUES(4666666,1,35,403,01);
INSERT INTO Matricula VALUES(4666666,1,36,404,02);
INSERT INTO Matricula VALUES(4666666,1,37,405,02);
INSERT INTO Matricula VALUES(4666666,1,38,406,02);
INSERT INTO Matricula VALUES(4666666,1,39,407,02);
INSERT INTO Matricula VALUES(4666666,1,40,408,02);

INSERT INTO Matricula VALUES(8096809,1,41,100,01);
INSERT INTO Matricula VALUES(8096809,1,42,101,01);
INSERT INTO Matricula VALUES(8096809,1,43,102,01);
INSERT INTO Matricula VALUES(8096809,1,44,103,01);
INSERT INTO Matricula VALUES(8096809,1,45,104,01);
INSERT INTO Matricula VALUES(8096809,1,46,105,02);
INSERT INTO Matricula VALUES(8096809,1,47,106,02);
INSERT INTO Matricula VALUES(8096809,1,48,107,02);
INSERT INTO Matricula VALUES(8096809,1,49,108,02);
INSERT INTO Matricula VALUES(8096809,1,50,109,02);

INSERT INTO Matricula VALUES(8459867,3,99,300,01);
INSERT INTO Matricula VALUES(8459867,3,100,301,01);
INSERT INTO Matricula VALUES(8459867,3,101,302,01);
INSERT INTO Matricula VALUES(8459867,3,102,303,01);
INSERT INTO Matricula VALUES(8459867,3,103,304,01);
INSERT INTO Matricula VALUES(8459867,3,104,400,02);
INSERT INTO Matricula VALUES(8459867,3,105,401,02);
INSERT INTO Matricula VALUES(8459867,3,106,406,02);
INSERT INTO Matricula VALUES(8459867,3,107,407,02);
INSERT INTO Matricula VALUES(8459867,3,108,408,02);

INSERT INTO Matricula VALUES(4564645,3,109,202,01);
INSERT INTO Matricula VALUES(4564645,3,110,203,01);
INSERT INTO Matricula VALUES(4564645,3,111,301,01);
INSERT INTO Matricula VALUES(4564645,3,100,105,01);
INSERT INTO Matricula VALUES(4564645,3,101,503,01);
INSERT INTO Matricula VALUES(4564645,3,102,205,02);
INSERT INTO Matricula VALUES(4564645,3,103,103,02);
INSERT INTO Matricula VALUES(4564645,3,104,108,02);
INSERT INTO Matricula VALUES(4564645,3,105,500,02);
INSERT INTO Matricula VALUES(4564645,3,106,306,02);

INSERT INTO Matricula VALUES(6456456,3,100,200,01);
INSERT INTO Matricula VALUES(6456456,3,101,202,01);
INSERT INTO Matricula VALUES(6456456,3,102,203,01);
INSERT INTO Matricula VALUES(6456456,3,103,206,01);
INSERT INTO Matricula VALUES(6456456,3,104,208,01);
INSERT INTO Matricula VALUES(6456456,3,105,106,02);
INSERT INTO Matricula VALUES(6456456,3,106,103,02);
INSERT INTO Matricula VALUES(6456456,3,107,100,02);
INSERT INTO Matricula VALUES(6456456,3,108,300,02);
INSERT INTO Matricula VALUES(6456456,3,109,104,02);

INSERT INTO Matricula VALUES(3534535,3,110,300,01);
INSERT INTO Matricula VALUES(3534535,3,111,301,01);
INSERT INTO Matricula VALUES(3534535,3,99,302,01);
INSERT INTO Matricula VALUES(3534535,3,100,303,01);
INSERT INTO Matricula VALUES(3534535,3,101,304,02);
INSERT INTO Matricula VALUES(3534535,3,102,305,02);
INSERT INTO Matricula VALUES(3534535,3,103,306,02);
INSERT INTO Matricula VALUES(3534535,3,104,307,02);
INSERT INTO Matricula VALUES(3534535,3,105,308,02);
INSERT INTO Matricula VALUES(3534535,3,106,309,02);

INSERT INTO Matricula VALUES(6757576,3,100,400,01);
INSERT INTO Matricula VALUES(6757576,3,107,401,01);
INSERT INTO Matricula VALUES(6757576,3,108,402,01);
INSERT INTO Matricula VALUES(6757576,3,109,403,01);
INSERT INTO Matricula VALUES(6757576,3,110,404,01);
INSERT INTO Matricula VALUES(6757576,3,111,405,02);
INSERT INTO Matricula VALUES(6757576,3,103,406,02);
INSERT INTO Matricula VALUES(6757576,3,104,407,02);
INSERT INTO Matricula VALUES(6757576,3,105,408,02);
INSERT INTO Matricula VALUES(6757576,3,106,409,02);

INSERT INTO Matricula VALUES(4343453,2,51,500,02);
INSERT INTO Matricula VALUES(4343453,2,52,501,02);
INSERT INTO Matricula VALUES(4343453,2,53,502,02);
INSERT INTO Matricula VALUES(4343453,2,54,503,02);
INSERT INTO Matricula VALUES(4343453,2,55,504,02);
INSERT INTO Matricula VALUES(4343453,2,56,505,02);
INSERT INTO Matricula VALUES(4343453,2,57,506,01);
INSERT INTO Matricula VALUES(4343453,2,58,404,01);
INSERT INTO Matricula VALUES(4343453,2,40,405,01);
INSERT INTO Matricula VALUES(4343453,2,42,406,01);



