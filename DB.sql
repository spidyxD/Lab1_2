-- Dispositivos mobiles
-- Base de datos para Lab 1 
DROP TABLE Grupo;
DROP TABLE PlanEstudio;
DROP TABLE Rendimiento_Grupo;
DROP TABLE Inscripcion;
DROP TABLE Matricula;
DROP TABLE Carrera CASCADE CONSTRAINTS;
DROP TABLE Alumno CASCADE CONSTRAINTS;
DROP TABLE Curso CASCADE CONSTRAINTS;
DROP TABLE Profesor CASCADE CONSTRAINTS;
DROP TABLE Ciclo CASCADE CONSTRAINTS;
DROP TABLE Usuario CASCADE CONSTRAINTS;



CREATE TABLE Curso (
     codigo number NOT NULL,
     nombre VARCHAR(50),
     creditos number,
     horas_semanales number,
     CONSTRAINT pkCurso PRIMARY KEY (codigo)
);

CREATE Table Carrera (
    codigo number NOT NULL,
    nombre VARCHAR(50),
    titulo VARCHAR(50),
    CONSTRAINT pkCarrera PRIMARY KEY (codigo)
);

CREATE TABLE Usuario (
    id number NOT NULL UNIQUE,
    clave VARCHAR(50),
    rol VARCHAR(50)
);

CREATE TABLE Administrador (
    id number,
    nombre varchar(30)
);

CREATE TABLE Profesor (
    cedula number NOT NULL,
    nombre VARCHAR(50),
    telefono number,
    email VARCHAR(50),
    CONSTRAINT pkProfesor PRIMARY KEY (cedula)
);

CREATE TABLE Alumno (
    cedula number NOT NULL,
    nombre VARCHAR(50),
    email VARCHAR(50),
    fecha_nacimiento date,
    CONSTRAINT pkAlumno PRIMARY KEY (cedula)
); 

CREATE TABLE Ciclo (
    id number NOT NULL,
    descripcion VARCHAR(30),
    fecha_inicio date,
    fecha_finalizacion date,
     CONSTRAINT pkCiclo PRIMARY KEY(id)
);

CREATE TABLE Grupo (
    nrc number NOT NULL,
    curso number,
    capacidad number,
    horario VARCHAR(50),
    profesor number,
    CONSTRAINT pkGrupo PRIMARY KEY(nrc),
    CONSTRAINT fkGrupo FOREIGN KEY (curso) REFERENCES Curso(codigo)
);

CREATE TABLE Rendimiento_Grupo (
    curso number,
    alumno number,
    profesor number,
    calificacion number,
    CONSTRAINT fkDesc1 FOREIGN KEY (curso) REFERENCES Curso(codigo),
    CONSTRAINT fkDesc2 FOREIGN KEY (alumno) REFERENCES Alumno(cedula),
    CONSTRAINT fkDesc3 FOREIGN KEY (profesor) REFERENCES Profesor(cedula) 
);

CREATE TABLE Inscripcion (
    alumno number NOT NULL,
    carrera number NOT NULL,
    PRIMARY KEY (alumno,carrera),
    CONSTRAINT fkInscrip1 FOREIGN KEY (alumno) REFERENCES Alumno(cedula),
    CONSTRAINT fkInscrip2 FOREIGN KEY (carrera) REFERENCES Carrera(codigo)
);

CREATE TABLE Matricula (
    alumno number,
    carrera number,
    grupo number,
    ciclo number,
    CONSTRAINT pkMatricula PRIMARY KEY (carrera, alumno, grupo),
    CONSTRAINT fkMat1 FOREIGN KEY (alumno) REFERENCES Alumno(cedula),
    CONSTRAINT fkMat2 FOREIGN KEY (carrera) REFERENCES Carrera(codigo),
    CONSTRAINT fkMat5 FOREIGN KEY (ciclo) REFERENCES Ciclo(id)
);

CREATE TABLE PlanEstudio (
    curso number,
    carrera number,
    anno number,
    ciclo number,
    CONSTRAINT pkPlanEst PRIMARY KEY (curso, carrera),
    CONSTRAINT fkPlanEst1 FOREIGN KEY (curso) REFERENCES Curso(codigo),
    CONSTRAINT fkPlanEst2 FOREIGN KEY (carrera) REFERENCES Carrera(codigo),
    CONSTRAINT fkPlanEst3 FOREIGN KEY (ciclo) REFERENCES Ciclo(id)
);

-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE crearAlumno (xcedula in VARCHAR, xnombre in VARCHAR, xemail in VARCHAR, xfechaN in DATE, xcarrera in number,xusername in VARCHAR, xclave in VARCHAR )
    IS 
    BEGIN
        INSERT into Alumno VALUES(xcedula, xnombre, xemail, xfechaN); 
        INSERT into Usuario VALUES(xcedula, xclave, 'Alumno');
        COMMIT;
    END crearAlumno;
    /


-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE crearProfesor (xcedula in VARCHAR, xnombre in VARCHAR, xemail in VARCHAR, xtelefono in VARCHAR,xusername in VARCHAR, xclave in VARCHAR )
    IS
    BEGIN
        INSERT into Profesor VALUES(xcedula, xnombre, xtelefono, xemail); 
        INSERT into Usuario VALUES(xcedula, xclave, 'Profesor');
        COMMIT;
    END crearProfesor;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE crearCurso (xcodigo in VARCHAR, xnombre in VARCHAR, xcreditos in VARCHAR, xhorasS in number)
    IS
    BEGIN
        INSERT into Curso VALUES(xcodigo, xnombre, xcreditos, xhorasS); 
        COMMIT;
    END crearCurso;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE reporteNotas (xcurso in number, xalumno in number, xprofesor in number, xcalificacion in number)
    IS
    BEGIN
        INSERT into Rendimiento_Grupo VALUES(xcurso, xalumno, xprofesor, xcalificacion); 
        COMMIT;
    END reporteNotas;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE generarPlanEstudio (xcurso in number, xcarrera in VARCHAR, xanno in number, xciclo in number)
    IS
    BEGIN
        INSERT into PlanEstudio VALUES(xcurso, xcarrera, xanno, xciclo); 
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
        OPEN c FOR SELECT Curso.nombre, Curso.codigo, Curso.creditos, Curso.horas_semanales FROM Carrera, PlanEstudio, Curso WHERE  Carrera.codigo = xcarrera AND PlanEstudio.carrera = Carrera.codigo AND PlanEstudio.curso = Curso.codigo;
         RETURN c; 
         CLOSE c;  
    END;
    / 

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_Profesor_cedula (xcedula in number) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT *FROM Profesor WHERE cedula = xcedula;
            RETURN c; 
        END;
        /

-- SI FUNCIONA
   CREATE OR REPLACE FUNCTION buscar_Alumno_ced (xcedula in number) 
         RETURN SYS_REFCURSOR
                AS 
                    c1 SYS_REFCURSOR;
                BEGIN
                    OPEN c1 FOR 
                    SELECT  Alumno.cedula, Alumno.nombre, Alumno.email, Alumno.fecha_nacimiento, Carrera.nombre, Curso.nombre  FROM    
                    Alumno, Inscripcion, Carrera, Matricula, Curso, Grupo  
                    WHERE Alumno.cedula =  xcedula AND Alumno.cedula = Inscripcion.alumno  AND Inscripcion.carrera = Carrera.codigo AND Inscripcion.carrera = Matricula.carrera AND Matricula.grupo = Grupo.nrc AND Grupo.curso = Curso.codigo;  
                    RETURN c1;   
                END;
            /

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION login(xid IN VARCHAR, xpassword IN VARCHAR)
    RETURN SYS_REFCURSOR 
    AS 
            c SYS_REFCURSOR; 
    BEGIN 
    OPEN c FOR 
        SELECT COUNT(id) AS exist FROM Usuario WHERE id = xid AND clave = xpassword;
        RETURN c; 
    END;
    /

-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE hacerMatricula (xalumno in number, xcarrera in number, xgrupo in number, xciclo in VARCHAR)
    IS
        BEGIN 
        INSERT INTO Matricula VALUES(xalumno, xcarrera,xgrupo, xciclo);
        COMMIT;
    END hacerMatricula;
    /


 

        /*CREATE OR REPLACE FUNCTION buscar_Alumno_nombre (xnombre in VARCHAR) 
            RETURN SYS_REFCURSOR
                AS 
                    c1 SYS_REFCURSOR;
                BEGIN
                    OPEN c1 FOR 
                    SELECT  Alumno.cedula, Alumno.nombre, Alumno.email, Alumno.fecha_nacimiento, Carrera.nombre  FROM    
                    Alumno, Inscripcion, Carrera 
                    WHERE Alumno.nombre =  xnombre AND Alumno.cedula = Inscripcion.alumno  AND Inscripcion.carrera = Carrera.codigo;  
                    RETURN c1;   
                END;
                /*/