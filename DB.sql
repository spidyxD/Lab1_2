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
CREATE OR REPLACE PROCEDURE crearAlumno (xcedula in Alumno.cedula%TYPE, xnombre in Alumno.nombre%TYPE, xemail in Alumno.email%TYPE, xfechaN in Alumno.fecha_nacimiento%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE )
    IS 
    BEGIN
        INSERT into Alumno VALUES(xcedula, xnombre, xemail, xfechaN); 
        INSERT into Usuario VALUES(xcedula, xclave, 'Alumno');
        COMMIT;
    END crearAlumno;
    /

CREATE OR REPLACE PROCEDURE modificarAlumno (xcedula in Alumno.cedula%TYPE, xnombre in Alumno.nombre%TYPE, xemail in Alumno.email%TYPE, xfechaN in Alumno.fecha_nacimiento%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE )
    IS 
    BEGIN
        UPDATE  Alumno set cedula = xcedula, nombre = xnombre, email = xemail, fecha_nacimiento = xfechaN; 
        UPDATE  Usuario set id = xcedula, clave = xclave, rol ='Alumno';
        COMMIT;
    END modificarAlumno;
    /

-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE crearProfesor (xcedula in Profesor.cedula%TYPE, xnombre in Profesor.nombre%TYPE, xemail in Profesor.email%TYPE, xtelefono in Profesor.telefono%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE )
    IS
    BEGIN
        INSERT into Profesor VALUES(xcedula, xnombre, xtelefono, xemail); 
        INSERT into Usuario VALUES(xcedula, xclave, 'Profesor');
        COMMIT;
    END crearProfesor;
    /
CREATE OR REPLACE PROCEDURE modificarProfesor (xcedula in Profesor.cedula%TYPE, xnombre in Profesor.nombre%TYPE, xemail in Profesor.email%TYPE, xtelefono in Profesor.telefono%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE )
    IS
    BEGIN
        UPDATE  Profesor SET cedula = xcedula, nombre = xnombre, telefono = xtelefono, email = xemail; 
        UPDATE  Usuario SET id = xcedula, clave = xclave, rol = 'Profesor';
        COMMIT;
    END modificarProfesor;
    /

-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE crearCurso (xcodigo in Curso.codigo%TYPE, xnombre in Curso.nombre%TYPE, xcreditos in Curso.creditos%TYPE, xhorasS in Curso.horas_semanales%TYPE)
    IS
    BEGIN
        INSERT into Curso VALUES(xcodigo, xnombre, xcreditos, xhorasS); 
        COMMIT;
    END crearCurso;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE reporteNotas (xcurso in Curso.codigo%TYPE, xalumno in Alumno.cedula%TYPE, xprofesor in Profesor.cedula%TYPE, xcalificacion in Rendimiento_Grupo.calificacion%TYPE)
    IS
    BEGIN
        INSERT into Rendimiento_Grupo VALUES(xcurso, xalumno, xprofesor, xcalificacion); 
        COMMIT;
    END reporteNotas;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE generarPlanEstudio (xcurso in Curso.codigo%TYPE, xcarrera in Carrera.codigo%TYPE, xanno in PlanEstudio.anno%TYPE, xciclo in Ciclo.id%TYPE)
    IS
    BEGIN
        INSERT into PlanEstudio VALUES(xcurso, xcarrera, xanno, xciclo); 
        COMMIT;
    END generarPlanEstudio;
    /

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_curso_id (xcodigo in Curso.codigo%TYPE) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT *FROM Curso WHERE codigo = xcodigo;
         RETURN c; 
         CLOSE c;  
    END;
    /

-- SI FUNCIONA
CREATE OR REPLACE FUNCTION buscar_curso_nombre (xnombre in Curso.nombre%TYPE) 
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
CREATE OR REPLACE FUNCTION buscar_curso_carrera (xcarrera in Carrera.codigo%TYPE ) 
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
CREATE OR REPLACE FUNCTION buscar_Profesor_cedula (xcedula in Profesor.cedula%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT *FROM Profesor WHERE cedula = xcedula;
            RETURN c; 
        END;
        /

-- SI FUNCIONA
   CREATE OR REPLACE FUNCTION buscar_Alumno_ced (xcedula in Alumno.cedula%TYPE) 
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
CREATE OR REPLACE FUNCTION login(xid IN Usuario.id%TYPE, xpassword IN Usuario.clave%TYPE)
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
CREATE OR REPLACE PROCEDURE hacerMatricula (xalumno in Alumno.cedula%TYPE, xcarrera in Carrera.codigo%TYPE, xgrupo in Grupo.nrc%TYPE, xciclo in Ciclo.id%TYPE)
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