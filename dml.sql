
----------------------------------VETERIARIA----------------------------------
INSERT into Carrera VALUES(1,'Medicina Veterinaria','Licenciatura');

--PRIMER AÑO
INSERT into Curso VALUES(1,'Estudios Generales',3,3);
INSERT into Curso VALUES(2,'Estudios Generales',3,3);
INSERT into Curso VALUES(3,'Introducción a la Química General',4,4);
INSERT into Curso VALUES(4,'Zoología',3,3);
INSERT into Curso VALUES(5,'Ingles Tecnico',3,3);
INSERT into Curso VALUES(6,'Optativo',2,2);
INSERT into PlanEstudio VALUES(1,1,1,1);
INSERT into PlanEstudio VALUES(2,1,1,1);
INSERT into PlanEstudio VALUES(3,1,1,1);
INSERT into PlanEstudio VALUES(4,1,1,1);
INSERT into PlanEstudio VALUES(5,1,1,1);
INSERT into PlanEstudio VALUES(6,1,1,1);

INSERT into Curso VALUES(7,'Estudios Generales',3,3);
INSERT into Curso VALUES(8,'Estudios Generales',3,3);
INSERT into Curso VALUES(9,'Fundamentos de química orgánica',3,3);
INSERT into Curso VALUES(10,'Anatomía de los animales domésticos I',4,4);
INSERT into Curso VALUES(11,'Citología e histología general',3,3);
INSERT into Curso VALUES(12,'Optativo',2,2);
INSERT into PlanEstudio VALUES(7,1,1,2);
INSERT into PlanEstudio VALUES(8,1,1,2);
INSERT into PlanEstudio VALUES(9,1,1,2);
INSERT into PlanEstudio VALUES(10,1,1,2);
INSERT into PlanEstudio VALUES(11,1,1,2);
INSERT into PlanEstudio VALUES(12,1,1,2);

--SEGUNDO AÑO
INSERT into Curso VALUES(13,'Histología especial y Embriología',4,4);
INSERT into Curso VALUES(14,'Bioquímica general',5,5);
INSERT into Curso VALUES(15,'Estadística médica',3,3);
INSERT into Curso VALUES(16,'Bioética',2,2);
INSERT into Curso VALUES(17,'Anatomía de los animales domésticos II',4,4);
INSERT into PlanEstudio VALUES(13,1,2,1);
INSERT into PlanEstudio VALUES(14,1,2,1);
INSERT into PlanEstudio VALUES(15,1,2,1);
INSERT into PlanEstudio VALUES(16,1,2,1);
INSERT into PlanEstudio VALUES(17,1,2,1);

INSERT into Curso VALUES(18,'Biología Celular',3,3);
INSERT into Curso VALUES(19,'Fisiología animal I',5,5);
INSERT into Curso VALUES(20,'Genética',3,3);
INSERT into Curso VALUES(21,'Producción  animal sostenible I',3,3);
INSERT into Curso VALUES(22,'Nutrición animal I',3,3);
INSERT into PlanEstudio VALUES(18,1,2,2);
INSERT into PlanEstudio VALUES(19,1,2,2);
INSERT into PlanEstudio VALUES(20,1,2,2);
INSERT into PlanEstudio VALUES(21,1,2,2);
INSERT into PlanEstudio VALUES(22,1,2,2);

--TERCER AÑO 
INSERT into Curso VALUES(23,'Fisiología animal II',5,5);
INSERT into Curso VALUES(24,'Producción animal sostenible II',3,3);
INSERT into Curso VALUES(25,'Nutrición  animal II',3,3);
INSERT into Curso VALUES(26,'Inmunología y Microbiología',4,4);
INSERT into Curso VALUES(27,'Optativo',2,2);
INSERT into PlanEstudio VALUES(23,1,3,1);
INSERT into PlanEstudio VALUES(24,1,3,1);
INSERT into PlanEstudio VALUES(25,1,3,1);
INSERT into PlanEstudio VALUES(26,1,3,1);
INSERT into PlanEstudio VALUES(27,1,3,1);

INSERT into Curso VALUES(28,'Patología General',4,4);
INSERT into Curso VALUES(29,'Microbiología e Infectología',5,5);
INSERT into Curso VALUES(30,'Parasitología y Enfermedades Parasitarias I',3,3);
INSERT into Curso VALUES(31,'Farmacología y terapéutica I',3,3);
INSERT into Curso VALUES(32,'Análisis Clínicos',3,3);
INSERT into PlanEstudio VALUES(28,1,3,2);
INSERT into PlanEstudio VALUES(29,1,3,2);
INSERT into PlanEstudio VALUES(30,1,3,2);
INSERT into PlanEstudio VALUES(31,1,3,2);
INSERT into PlanEstudio VALUES(32,1,3,2);

--CUARTO AÑO 
INSERT into Curso VALUES(33,'Patología Especial',5,5);
INSERT into Curso VALUES(34,'Parasitología y Enfermedades Parasitarias II',3,3);
INSERT into Curso VALUES(35,'Farmacología y terapéutica II',4,4);
INSERT into Curso VALUES(36,'Clínica  propedéutica de especies mayores',3,3);
INSERT into Curso VALUES(37,'Clínica  propedéutica de especies menores',3,3);
INSERT into PlanEstudio VALUES(33,1,4,1);
INSERT into PlanEstudio VALUES(34,1,4,1);
INSERT into PlanEstudio VALUES(35,1,4,1);
INSERT into PlanEstudio VALUES(36,1,4,1);
INSERT into PlanEstudio VALUES(37,1,4,1);

INSERT into Curso VALUES(38,'Toxicología',3,3);
INSERT into Curso VALUES(39,'Medicina interna de especies mayores I',3,3);
INSERT into Curso VALUES(40,'Obstetricia',3,3);
INSERT into Curso VALUES(41,'Andrología',3,3);
INSERT into Curso VALUES(42,'Inspección e higiene de los alimentos I',3,3);
INSERT into Curso VALUES(43,'Enfermedades de las aves de producción',3,3);
INSERT into PlanEstudio VALUES(38,1,4,2);
INSERT into PlanEstudio VALUES(39,1,4,2);
INSERT into PlanEstudio VALUES(40,1,4,2);
INSERT into PlanEstudio VALUES(41,1,4,2);
INSERT into PlanEstudio VALUES(42,1,4,2);
INSERT into PlanEstudio VALUES(43,1,4,2);

--QUINTO AÑO 
INSERT into Curso VALUES(44,'Ginecología',3,3);
INSERT into Curso VALUES(45,'Medicina interna de especies mayores II',3,3);
INSERT into Curso VALUES(46,'Inspección e higiene de los alimentos II',3,3);
INSERT into Curso VALUES(47,'Propedéutica quirúrgica y diagnóstico por imágenes',3,3);
INSERT into Curso VALUES(48,'Medicina interna de especies menores',3,3);
INSERT into Curso VALUES(49,'Optativo',3,3);
INSERT into PlanEstudio VALUES(44,1,5,1);
INSERT into PlanEstudio VALUES(45,1,5,1);
INSERT into PlanEstudio VALUES(46,1,5,1);
INSERT into PlanEstudio VALUES(47,1,5,1);
INSERT into PlanEstudio VALUES(48,1,5,1);
INSERT into PlanEstudio VALUES(49,1,5,1);

INSERT into Curso VALUES(50,'Cirugía de especies mayores',3,3);
INSERT into Curso VALUES(51,'Cirugía de especies menores',3,3);
INSERT into Curso VALUES(52,'Salud de hato',3,3);
INSERT into Curso VALUES(53,'Epidemiología y salud pública veterinaria',3,3);
INSERT into Curso VALUES(54,'Manejo y medicina de animales silvestres',3,3);
INSERT into Curso VALUES(55,'Optativo',3,3);
INSERT into PlanEstudio VALUES(50,1,5,2);
INSERT into PlanEstudio VALUES(51,1,5,2);
INSERT into PlanEstudio VALUES(52,1,5,2);
INSERT into PlanEstudio VALUES(53,1,5,2);
INSERT into PlanEstudio VALUES(54,1,5,2);
INSERT into PlanEstudio VALUES(55,1,5,2);

--SEXTO AÑO
INSERT into Curso VALUES(56,'Internado Rotatorio I*',15,15);
INSERT into PlanEstudio VALUES(56,1,6,1);

INSERT into Curso VALUES(57,'Internado Rotatorio II*',15,15);
INSERT into Curso VALUES(58,'Trabajo Final de Graduación',0,0);
INSERT into PlanEstudio VALUES(57,1,6,2);
INSERT into PlanEstudio VALUES(58,1,6,2);

----------------------Ingeniería em Sistemas----------------------
INSERT into Carrera VALUES(2,'Ingenieria en Sistemas','Bachillerato');
------PRIMER AÑO
INSERT into Curso VALUES(59,'Fundamentos de Informática',3,3);
INSERT into Curso VALUES(60,'Matemática para Informática I',4,4);
INSERT into Curso VALUES(61,'Estudios Generales ',3,3);
INSERT into Curso VALUES(62,'Estudios Generales',3,3);
INSERT into Curso VALUES(63,'Inglés Integrado I',4,4);
INSERT into PlanEstudio VALUES(59,2,1,1);
INSERT into PlanEstudio VALUES(60,2,1,1);
INSERT into PlanEstudio VALUES(61,2,1,1);
INSERT into PlanEstudio VALUES(62,2,1,1);
INSERT into PlanEstudio VALUES(63,2,1,1);

INSERT into Curso VALUES(64,'Programación I',4,4);
INSERT into Curso VALUES(65,'Calculo I',4,4);
INSERT into Curso VALUES(66,'Estudios Generales ',3,3);
INSERT into Curso VALUES(67,'Estudios Generales',3,3);
INSERT into Curso VALUES(68,'Inglés Integrado II',4,4);
INSERT into PlanEstudio VALUES(64,2,1,2);
INSERT into PlanEstudio VALUES(65,2,1,2);
INSERT into PlanEstudio VALUES(66,2,1,2);
INSERT into PlanEstudio VALUES(67,2,1,2);
INSERT into PlanEstudio VALUES(68,2,1,2);

---------------SEGUNDO AÑO------------------------------
INSERT into Curso VALUES(69,'Programación II',4,4);
INSERT into Curso VALUES(70,'Algebra',4,4);
INSERT into Curso VALUES(71,'Soporte Técnico',3,3);
INSERT into Curso VALUES(72,'Estructuras Discretas para Informática',3,3);
INSERT into Curso VALUES(73,'Inglés Integrado III',4,4);
INSERT into PlanEstudio VALUES(69,2,2,1);
INSERT into PlanEstudio VALUES(70,2,2,1);
INSERT into PlanEstudio VALUES(71,2,2,1);
INSERT into PlanEstudio VALUES(72,2,2,1);
INSERT into PlanEstudio VALUES(73,2,2,1);

INSERT into Curso VALUES(74,'Programación III',4,4);
INSERT into Curso VALUES(75,'Estructuras de Datos',4,4);
INSERT into Curso VALUES(76,'Arquitectura de Computadoras',3,3);
INSERT into Curso VALUES(77,'La Organización y su Entorno',3,3);
INSERT into Curso VALUES(78,'Probabilidad y Estadística',3,3);
INSERT into PlanEstudio VALUES(74,2,2,2);
INSERT into PlanEstudio VALUES(75,2,2,2);
INSERT into PlanEstudio VALUES(76,2,2,2);
INSERT into PlanEstudio VALUES(77,2,2,2);
INSERT into PlanEstudio VALUES(78,2,2,2);

---------------TERCER AÑO------------------------------
INSERT into Curso VALUES(79,'Programación IV',4,4);
INSERT into Curso VALUES(80,'Ingenieria de Sistemas  I',4,4);
INSERT into Curso VALUES(81,'Diseño e Implementación de Bases de Dato',4,4);
INSERT into Curso VALUES(82,'Sistemas Operativos',3,3);
INSERT into Curso VALUES(83,'Comunicaciones y Redes de Computadores',3,3);
INSERT into PlanEstudio VALUES(79,2,3,1);
INSERT into PlanEstudio VALUES(80,2,3,1);
INSERT into PlanEstudio VALUES(81,2,3,1);
INSERT into PlanEstudio VALUES(82,2,3,1);
INSERT into PlanEstudio VALUES(83,2,3,1);

INSERT into Curso VALUES(84,'Paradigmas de Programacion',4,4);
INSERT into Curso VALUES(85,'Ingenieria en Sistemas II',4,4);
INSERT into Curso VALUES(86,'Administracion de Bases de Datos',4,4);
INSERT into Curso VALUES(87,'Investigacion de Operaciones y sus Aplicaciones',3,3);
INSERT into Curso VALUES(88,'Liderazgo y Organizacion',3,3);
INSERT into PlanEstudio VALUES(84,2,5,2);
INSERT into PlanEstudio VALUES(85,2,5,2);
INSERT into PlanEstudio VALUES(86,2,5,2);
INSERT into PlanEstudio VALUES(87,2,5,2);
INSERT into PlanEstudio VALUES(88,2,5,2);

---------------CUARTO AÑO------------------------------
INSERT into Curso VALUES(89,'Diseño y programación de plataformas Móviles',4,4);
INSERT into Curso VALUES(90,'Ingenieria de Sistemas  III',4,4);
INSERT into Curso VALUES(91,'Optativo ',3,3);
INSERT into Curso VALUES(92,'Optativo ',3,3);
INSERT into Curso VALUES(93,'Métodos de Investigación Científica en Informática',3,3);
INSERT into PlanEstudio VALUES(89,2,4,1);
INSERT into PlanEstudio VALUES(90,2,4,1);
INSERT into PlanEstudio VALUES(91,2,4,1);
INSERT into PlanEstudio VALUES(92,2,4,1);
INSERT into PlanEstudio VALUES(93,2,4,1);

INSERT into Curso VALUES(94,'Proyectos y su Aplicacion en la Organizacion(PPS)',5,5);
INSERT into Curso VALUES(95,'Aplicaciones Informaticas Globales',4,4);
INSERT into Curso VALUES(96,'Optativo',3,3);
INSERT into Curso VALUES(97,'Optativo',3,3);
INSERT into Curso VALUES(98,'Informatica y Sociedad',2,2);
INSERT into PlanEstudio VALUES(94,2,4,2);
INSERT into PlanEstudio VALUES(95,2,4,2);
INSERT into PlanEstudio VALUES(96,2,4,2);
INSERT into PlanEstudio VALUES(97,2,4,2);
INSERT into PlanEstudio VALUES(98,2,4,2);

INSERT into Carrera VALUES(3,'Administración','Bachillerato');

---PROFESORES
INSERT into Profesor VALUES (1763589,'Juan Perez',87656789,'juanp@gmail.com');
INSERT into Profesor VALUES (6543789,'Margarita Gomez',76427896,'margaritag@gmail.com');
INSERT into Profesor VALUES (7648903,'Lucresia Ramirez',86345678,'lucresiar@gmail.com');
INSERT into Profesor VALUES (2789456,'Pablo Lopez',89345678,'pablol@gmail.com');

-- ALUMNOS
INSERT into Alumno VALUES(4678936,'Edgar Trigeros Arias','edgarta@gmail.com','08/07/1997',1);
INSERT into Alumno VALUES(8362398,'Mirella Martinez','mirellam@gmail.com','15/04/1995',1);
INSERT into Alumno VALUES(9859859,'Lourdes Ramirez','lourdes@gmail.com','04/04/1997',1);
INSERT into Alumno VALUES(4564665,'María Jose Soto','mariasoto@gmail.com','04/04/1997',1);
INSERT into Alumno VALUES(4465656,'Kimberly Hernandez Arce','kimher@gmail.com','04/04/1997',2);
INSERT into Alumno VALUES(5675656,'Jennifer Hernandez Arce','jenniher@gmail.com','04/04/1997',2);
INSERT into Alumno VALUES(9879586,'Karol Hernandez Arce','karolher@gmail.com','04/04/1997',2);
INSERT into Alumno VALUES(4546956,'Estefany Hernandez Arce','estefanyher@gmail.com','04/04/1997',2);
INSERT into Alumno VALUES(4666666,'Walter Ramirez Suniga','walR@gmail.com','04/04/1997',3);
INSERT into Alumno VALUES(8096809,'Lukas Mora','lukasM@gmail.com','04/04/1997',3);
INSERT into Alumno VALUES(8459867,'Marco Perez','marcoP@gmail.com','04/04/1997',3);
INSERT into Alumno VALUES(4564645,'Jorge Alvarado','jorgeA@gmail.com','04/04/1997',3);
INSERT into Alumno VALUES(6456456,'Geisel Alvarado','geiselAlv@gmail.com','04/04/1997',1);
INSERT into Alumno VALUES(3534535,'Maria Jesus Lopez Martinez','mariajesusm@gmail.com','04/04/1997',2);
INSERT into Alumno VALUES(6757576,'Mirella Gomez Lopez','mirellagomez@gmail.com','04/04/1997',3);
INSERT into Alumno VALUES(4343453,'Zoe Montero Hernandez','zoemontero@gmail.com','04/04/1997',1);




