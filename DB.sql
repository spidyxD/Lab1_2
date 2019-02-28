-- Dispositivos mobiles
-- Base de datos para Lab 1 
DROP TABLE Grupo;
DROP TABLE PlanEstudio;
DROP TABLE Rendimiento_Grupo;
DROP TABLE Carrera;
DROP TABLE Alumno;
DROP TABLE Curso;
DROP TABLE Profesor;
DROP TABLE Ciclo;
DROP TABLE Usuario;



CREATE TABLE Curso (
     codigo number NOT NULL ,
     nombre VARCHAR(50),
     creditos number,
     horas_semanales number,
     CONSTRAINT pkCurso PRIMARY KEY (codigo)
);

CREATE Table Carrera (
    codigo number NOT NULL ,
    nombre VARCHAR(50),
    titulo VARCHAR(50),
    CONSTRAINT pkCarrera PRIMARY KEY (codigo)
);

CREATE TABLE Usuario (
    idUser number,
    username VARCHAR(50),
    clave VARCHAR(50),
    rol VARCHAR(50),
    CONSTRAINT pkUser PRIMARY KEY (username)
);

CREATE TABLE PlanEstudio (
    curso number,
    carrera number,
    anno number,
    ciclo number,
    CONSTRAINT pkPlanEst PRIMARY KEY (curso, carrera),
    CONSTRAINT fkCurso1 FOREIGN KEY (curso) REFERENCES Curso(codigo),
    CONSTRAINT fkCurso2 FOREIGN KEY (carrera) REFERENCES Carrera(codigo)
);

CREATE TABLE Profesor (
    cedula number,
    nombre VARCHAR(50),
    telefono number,
    email VARCHAR(50),
    userN number,
    CONSTRAINT pkProfesor PRIMARY KEY (cedula),
    CONSTRAINT fkProfesor FOREIGN KEY (userN) REFERENCES Usuario(idUser)
);

CREATE TABLE Alumno (
    cedula number,
    nombre VARCHAR(50),
    email VARCHAR(50),
    fecha_nacimiento date,
    carrera number,
    userN number,
    CONSTRAINT pkAlumno PRIMARY KEY (cedula),
    CONSTRAINT fkAlumno FOREIGN KEY (userN) REFERENCES Usuario(idUser)
);

CREATE TABLE Ciclo (
    anno VARCHAR(20),
    fecha_inicio date,
    fecha_finalizacion date
);

CREATE TABLE Grupo (
    ciclo VARCHAR(20),
    curso number,
    numero number,
    horario VARCHAR(50),
    profesor number,
    CONSTRAINT pkGrupo PRIMARY KEY(numero),
    CONSTRAINT fkGrupo FOREIGN KEY (curso) REFERENCES Curso(codigo) 
);

CREATE TABLE Rendimiento_Grupo (
    curso number,
    alumno number,
    calificacion number,
    CONSTRAINT fkDesc1 FOREIGN KEY (curso) REFERENCES Curso(codigo),
    CONSTRAINT fkDesc2 FOREIGN KEY (alumno) REFERENCES Alumno(cedula) 
);



CREATE OR REPLACE PROCEDURE crearAlumno (xcedula in VARCHAR, xnombre in VARCHAR, xemail in VARCHAR, xfechaN in DATE, xcarrera in number,xusername in VARCHAR, xclave in VARCHAR )
    IS
    BEGIN
        INSERT into Alumno VALUES(xcedula, xnombre, xemail, xfechaN, xcarrera); 
        INSERT into Usuario VALUES(xusername, xclave, 'ALUMNO');
        COMMIT;
    END crearAlumno;
    /

CREATE OR REPLACE PROCEDURE crearProfesor (xcedula in VARCHAR, xnombre in VARCHAR, xemail in VARCHAR, telefono in VARCHAR,xusername in VARCHAR, xclave in VARCHAR )
    IS
    BEGIN
        INSERT into Profesor VALUES(xcedula, xnombre, xemail, xtelefono); 
        INSERT into Usuario VALUES(xusername, xclave, 'ALUMNO');
        COMMIT;
    END crearProfesor;
    /

CREATE OR REPLACE PROCEDURE crearCurso (xcodigo in VARCHAR, xnombre in VARCHAR, xcreditos in VARCHAR, xhorasS in number)
    IS
    BEGIN
        INSERT into Curso VALUES(xcodigo, xnombre, xcreditos, xhorasS); 
        COMMIT;
    END crearCurso;
    /

CREATE OR REPLACE PROCEDURE reporteNotas (xcurso in number, xalumno in number, xcalificacion in number)
    IS
    BEGIN
        INSERT into Rendimiento_Grupo VALUES(xcurso, xalumno, xcalificacion); 
        COMMIT;
    END crearCurso;
    /

CREATE OR REPLACE PROCEDURE generarPlanEstudio (xcurso in number, xcarrera in VARCHAR, xanno in number, xciclo in number)
    IS
    BEGIN
        INSERT into PlanEstudio VALUES(xcurso, xcurso, xanno, xciclo); 
        COMMIT;
    END generarPlanEstudio;
    /

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_curso_id (xcodigo in number) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT *FROM Curso WHERE codigo = xcodigo;
         RETURN c; 
         CLOSE c;  
    END;
    /

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_curso_nombre (xnombre in VARCHAR) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT *FROM Curso WHERE nombre = xnombre;
            RETURN c; 
            CLOSE c;  
        END;
        /
-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_curso_carrera (xcarrera in number ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT Curso.nombre, Curso.codigo, Curso.creditos, Curso.horas_semanales FROM Curso , Carrera WHERE  Carrera.codigo = xcarrera;
         RETURN c; 
         CLOSE c;  
    END;
    / 

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_Profesor_nombre_cedula (xnombre in VARCHAR, xcedula in number) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT *FROM Profesor WHERE nombre = xnombre AND cedula = xcedula;
            RETURN c; 
        END;
        /

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_Alumno_n_c_c (xnombre in VARCHAR, xcedula in number, xcarrera in VARCHAR) 
    RETURN SYS_REFCURSOR
        AS 
            c1 SYS_REFCURSOR;
        BEGIN
            OPEN c1 FOR 
               SELECT Alumno.cedula, Alumno.nombre, Alumno.email, Alumno.fecha_nacimiento, Alumno.carrera FROM Alumno, Carrera WHERE  Alumno.nombre =xnombre  AND Alumno.cedula = xcedula  AND Carrera.nombre = xnombre;
            RETURN c1;   
        END;
        /
    

CREATE OR REPLACE FUNCTION login(idin IN VARCHAR), passwordin IN VARCHAR)
    RETURN SYS_REFCURSOR 
    AS 
            c SYS_REFCURSOR; 
    BEGIN 
    OPEN c FOR 
        SELECT COUNT(nombreUsuario) AS esta FROM usuario WHERE nombreUsuario=idin AND contrase�a=passwordin;
        RETURN c; 
    END;
    /