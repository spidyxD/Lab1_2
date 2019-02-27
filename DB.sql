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
    CONSTRAINT pkProfesor PRIMARY KEY (cedula)
);

CREATE TABLE Alumno (
    cedula number,
    nombre VARCHAR(50),
    email VARCHAR(50),
    fecha_nacimiento date,
    carrera number,
    CONSTRAINT pkAlumno PRIMARY KEY (cedula)
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

CREATE TABLE Usuario (
    cedula number,
    clave VARCHAR(50),
    rol VARCHAR(50),
    CONSTRAINT pkUser PRIMARY KEY (cedula)
);

CREATE OR REPLACE PROCEDURE crearAlumno (xcedula in VARCHAR, xnombre in VARCHAR, xemail in VARCHAR, xfechaN in DATE, xcarrera in number, xclave in VARCHAR )
    IS
    BEGIN
        INSERT into Alumno VALUES(xcedula, xnombre, xemail, xfechaN, xcarrera); 
        INSERT into Usuario VALUES(xcedula, xclave, 'ALUMNO');
        COMMIT;
    END crearAlumno;
    /

CREATE OR REPLACE PROCEDURE crearProfesor (xcedula in VARCHAR, xnombre in VARCHAR, xemail in VARCHAR, telefono in VARCHAR, xclave in VARCHAR )
    IS
    BEGIN
        INSERT into Profesor VALUES(xcedula, xnombre, xemail, xtelefono); 
        INSERT into Usuario VALUES(xcedula, xclave, 'ALUMNO');
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

CREATE OR REPLACE FUNCTION buscar_curso_carrera (xcarrera in number ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT cur.nombre, cur.codigo, cur.creditos, cur.horas_semanales FROM Curso as cur, Carrera as car WHERE  car.codigo = xcarrera;
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

CREATE OR REPLACE FUNCTION buscar_Alumno_n_c_c (xnombre in VARCHAR, xcedula in number, xcarrera in VARCHAR) 
    RETURN SYS_REFCURSOR
        AS 
            c1 SYS_REFCURSOR;
        BEGIN
            OPEN c1 FOR 
                SELECT cedula,nombre,email,fecha_nacimiento, carrera FROM Alumno, Carrera AS c WHERE nombre = xnombre AND cedula = xcedula AND c.nombre = xcarrera;
            RETURN c1;   
        END;
        /
    

   -- ALTER TABLE Profesor
  --ADD nombre VARCHAR(50);