-- Dispositivos mobiles
-- Base de datos para Lab 1 
DROP TABLE Grupo CASCADE CONSTRAINTS;
DROP TABLE PlanEstudio CASCADE CONSTRAINTS;
DROP TABLE Rendimiento_Grupo CASCADE CONSTRAINTS;
DROP TABLE Inscripcion CASCADE CONSTRAINTS;
DROP TABLE Matricula CASCADE CONSTRAINTS;
DROP TABLE Administrador CASCADE CONSTRAINTS;
DROP TABLE Carrera CASCADE CONSTRAINTS;
DROP TABLE Alumno CASCADE CONSTRAINTS;
DROP TABLE Curso CASCADE CONSTRAINTS;
DROP TABLE Profesor CASCADE CONSTRAINTS;
DROP TABLE Ciclo CASCADE CONSTRAINTS;
DROP TABLE Usuario CASCADE CONSTRAINTS;



CREATE TABLE Curso (
     codigo number NOT NULL,
     nombre VARCHAR(100),
     creditos number,
     horas_semanales number,
     CONSTRAINT pkCurso PRIMARY KEY (codigo)
);

CREATE Table Carrera (
    codigo number NOT NULL,
    nombre VARCHAR(100),
    titulo VARCHAR(50),
    CONSTRAINT pkCarrera PRIMARY KEY (codigo)
);

CREATE TABLE Usuario (
    id number,
    clave VARCHAR(50),
    rol VARCHAR(50),
	CONSTRAINT pkUsuario PRIMARY KEY (id)
);

CREATE TABLE Administrador (
    id number,
    nombre varchar(30),
	CONSTRAINT pAdministrador PRIMARY KEY (id)
);

CREATE TABLE Profesor (
    cedula number NOT NULL,
    nombre VARCHAR(100),
    edad number,
    telefono number,
    email VARCHAR(50),
    CONSTRAINT pkProfesor PRIMARY KEY (cedula)
);

CREATE TABLE Alumno (
    cedula number NOT NULL,
    nombre VARCHAR(100),
    fecha_nacimiento date,
    edad number,
    email VARCHAR(50),
    telefono number,
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
    curso number NOT NULL,
    capacidad number,
    horario VARCHAR(50),
    profesor number,
	ciclo int , 
    CONSTRAINT pkGrupo PRIMARY KEY(nrc,curso),
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
    CONSTRAINT fkInscrip1 FOREIGN KEY (alumno) REFERENCES Alumno(cedula)  ON DELETE CASCADE,
    CONSTRAINT fkInscrip2 FOREIGN KEY (carrera) REFERENCES Carrera(codigo)  ON DELETE CASCADE
);

CREATE TABLE Matricula (
    alumno number,
    carrera number,
    curso number,
    grupo number,
    ciclo number,
    CONSTRAINT pkMatricula PRIMARY KEY (carrera, alumno, curso, ciclo),
    CONSTRAINT fkMat1 FOREIGN KEY (alumno) REFERENCES Alumno(cedula),
    CONSTRAINT fkMat2 FOREIGN KEY (carrera) REFERENCES Carrera(codigo),
    CONSTRAINT fkMat3 FOREIGN KEY (grupo,curso) REFERENCES Grupo(nrc,curso),
    CONSTRAINT fkMat4 FOREIGN KEY (curso) REFERENCES Curso(codigo),
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
CREATE OR REPLACE PROCEDURE crearAlumno (xcedula in Alumno.cedula%TYPE, xnombre in Alumno.nombre%TYPE, xedad in Alumno.edad%TYPE, xemail in Alumno.email%TYPE, xfechaN in varchar,xtelefono in Alumno.telefono%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE, xcarrera in Carrera.codigo%TYPE )
    IS 
    BEGIN
        INSERT into Alumno VALUES(xcedula, xnombre, TO_DATE(xfechaN, 'YYYY-MM-DD'), xedad,xemail,xtelefono); 
        INSERT into Usuario VALUES(xcedula, xclave, 'Alumno');
        INSERT into Inscripcion VALUES(xcedula,xcarrera);
        COMMIT;
    END;
    /

CREATE OR REPLACE PROCEDURE modificarAlumno (xnombre in Alumno.nombre%TYPE,xedad in Alumno.edad%TYPE, xemail in Alumno.email%TYPE, xfechaN in varchar,xtelefono in Alumno.telefono%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE )
    IS 
    BEGIN
        UPDATE  Alumno set nombre = xnombre, edad = xedad, email = xemail, fecha_nacimiento = TO_DATE(xfechaN, 'YYYY-MM-DD'), telefono = xtelefono where cedula = xusername; 
        UPDATE  Usuario set clave = xclave where id = xusername;
        COMMIT;
    END;
    /
	
CREATE OR REPLACE PROCEDURE modificarAlumnoAdmin (xcedula in Alumno.cedula%TYPE, xnombre in Alumno.nombre%TYPE,xedad in Alumno.edad%TYPE, xemail in Alumno.email%TYPE, xfechaN in varchar,xtelefono in Alumno.telefono%TYPE, xcarrera in Inscripcion.carrera%TYPE )
    IS 
    BEGIN
        UPDATE  Alumno set nombre = xnombre, edad = xedad, email = xemail, fecha_nacimiento = TO_DATE(xfechaN, 'YYYY-MM-DD'), telefono = xtelefono where cedula = xcedula; 
        UPDATE Inscripcion set carrera = xcarrera where alumno = xcedula;
        COMMIT;
    END;
    /


CREATE OR REPLACE PROCEDURE eliminarAlumno (xcedula in Alumno.cedula%TYPE)
    IS 
    BEGIN
        DELETE Alumno WHERE cedula = xcedula;
        DELETE Usuario WHERE id = xcedula;
        COMMIT;
    END;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE crearProfesor (xcedula in Profesor.cedula%TYPE, xnombre in Profesor.nombre%TYPE,xedad in Profesor.edad%TYPE, xemail in Profesor.email%TYPE, xtelefono in Profesor.telefono%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE )
    IS
    BEGIN
        INSERT into Profesor VALUES(xcedula, xnombre, xedad, xtelefono, xemail); 
        INSERT into Usuario VALUES(xcedula, xclave, 'Profesor');
        COMMIT;
    END;
    /

CREATE OR REPLACE PROCEDURE modificarProfesor (xnombre in Profesor.nombre%TYPE,xedad in Alumno.edad%TYPE, xemail in Profesor.email%TYPE, xtelefono in Profesor.telefono%TYPE,xusername in Usuario.id%TYPE, xclave in Usuario.clave%TYPE )
    IS
    BEGIN
        UPDATE  Profesor SET nombre = xnombre, edad = xedad, telefono = xtelefono, email = xemail where cedula = xusername;
        UPDATE  Usuario SET clave = xclave where id = xusername;
        COMMIT;
    END;
    /

CREATE OR REPLACE PROCEDURE modificarProfesorAdmin (xcedula in Profesor.cedula%TYPE, xnombre in Profesor.nombre%TYPE,xedad in Alumno.edad%TYPE, xemail in Profesor.email%TYPE, xtelefono in Profesor.telefono%TYPE)
    IS
    BEGIN
        UPDATE  Profesor SET nombre = xnombre, edad = xedad, telefono = xtelefono, email = xemail where cedula = xcedula;       
        COMMIT;
    END;
    /

CREATE OR REPLACE PROCEDURE eliminarProfesor (xcedula in Alumno.cedula%TYPE)
    IS 
    BEGIN
        DELETE Profesor WHERE cedula = xcedula;
        DELETE Usuario WHERE id = xcedula;
        COMMIT;
    END;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE crearCurso (xcodigo in Curso.codigo%TYPE, xnombre in Curso.nombre%TYPE, xcreditos in Curso.creditos%TYPE, xhorasS in Curso.horas_semanales%TYPE)
    IS
    BEGIN
        INSERT into Curso VALUES(xcodigo, xnombre, xcreditos, xhorasS); 
        COMMIT;
    END crearCurso;
    /

CREATE OR REPLACE PROCEDURE modificarCurso (xcodigo in Curso.codigo%TYPE,xnombre in Curso.nombre%TYPE, xcreditos in Curso.creditos%TYPE, xhorasS in Curso.horas_semanales%TYPE)
    IS
    BEGIN
        UPDATE Curso set  nombre =  xnombre, creditos = xcreditos, horas_semanales = xhorasS  where codigo = xcodigo;
        COMMIT;
    END;
    /


CREATE OR REPLACE PROCEDURE crearCarrera (xcodigo in Carrera.codigo%TYPE, xnombre in Carrera.nombre%TYPE, xtitulo in Carrera.titulo%TYPE)
    IS
    BEGIN
        INSERT into Carrera VALUES(xcodigo, xnombre, xtitulo); 
        COMMIT;
    END;
    /
CREATE OR REPLACE PROCEDURE modificarCarrera (xcodigo in Carrera.codigo%TYPE ,xnombre in Carrera.nombre%TYPE, xtitulo in Carrera.titulo%TYPE)
    IS
    BEGIN
        UPDATE Carrera set  nombre =  xnombre, titulo = xtitulo where codigo = xcodigo; 
        COMMIT;
    END;
    /

CREATE OR REPLACE PROCEDURE eliminarCurso (xcodigo in Alumno.cedula%TYPE)
    IS 
    BEGIN
        DELETE Curso WHERE codigo = xcodigo;
        COMMIT;
    END;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE reporteNotas (xcurso in Curso.codigo%TYPE, xalumno in Alumno.cedula%TYPE, xprofesor in Profesor.cedula%TYPE, xcalificacion in Rendimiento_Grupo.calificacion%TYPE)
    IS
    BEGIN
        INSERT into Rendimiento_Grupo VALUES(xcurso, xalumno, xprofesor, xcalificacion); 
        COMMIT;
    END;
    /
-- SI FUNCIONA
CREATE OR REPLACE PROCEDURE generarPlanEstudio (xcurso in Curso.codigo%TYPE, xcarrera in Carrera.codigo%TYPE,xanno in PlanEstudio.anno%TYPE, xciclo in Ciclo.id%TYPE)
    IS
    BEGIN
        INSERT into PlanEstudio VALUES(xcurso, xcarrera, xanno, xciclo); 
        COMMIT;
    END;
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
CREATE OR REPLACE FUNCTION buscar_carrera_id (xcodigo in Carrera.codigo%TYPE) 
RETURN SYS_REFCURSOR
    AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT *FROM Carrera WHERE codigo = xcodigo;
         RETURN c; 
         CLOSE c;  
    END;
    /

CREATE OR REPLACE FUNCTION buscar_curso_carrera(xcarrera in Carrera.codigo%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Curso, PlanEstudio WHERE PlanEstudio.curso =  Curso.codigo  AND PlanEstudio.carrera = xcarrera;
         RETURN c; 
         CLOSE c;  
    END;
    / 

CREATE OR REPLACE FUNCTION buscar_grupo_curso(xcurso in Grupo.curso%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Grupo WHERE Grupo.curso=xcurso;
         RETURN c; 
         CLOSE c;  
    END;
    / 
CREATE OR REPLACE FUNCTION buscar_cursoXAlumno(xcedula in Alumno.cedula%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Curso, Matricula WHERE Matricula.curso =  Curso.codigo  AND Matricula.alumno = xcedula;
         RETURN c; 
         CLOSE c;  
    END;
    / 
	CREATE OR REPLACE FUNCTION buscar_grupoXAlumno(xcedula in Alumno.cedula%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Grupo, Matricula WHERE Matricula.grupo =  Grupo.nrc  AND Matricula.alumno = xcedula;
         RETURN c; 
         CLOSE c;  
    END;
    / 
	

	CREATE OR REPLACE FUNCTION buscar_Matriculados(xAlumno in Alumno.cedula%TYPE) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT * FROM Matricula WHERE alumno=xAlumno;
         RETURN c; 
    END;
    / 

CREATE OR REPLACE FUNCTION buscar_AlumnoXCurso(xcodigo in Curso.codigo%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Alumno, Matricula WHERE Matricula.alumno =  Alumno.cedula  AND Matricula.curso = xcodigo;
         RETURN c; 
         CLOSE c;  
    END;
    / 
	
	CREATE OR REPLACE FUNCTION buscar_AlumnoXGrupo(xnrc in Grupo.nrc%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Alumno, Matricula WHERE Matricula.alumno =  Alumno.cedula  AND Matricula.grupo = xnrc;
         RETURN c;  
         CLOSE c;  
    END;
    / 

CREATE OR REPLACE FUNCTION buscar_cursoXProfesor(xcedula in Profesor.cedula%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Curso, Grupo WHERE Grupo.curso =  Curso.codigo  AND Grupo.profesor = xcedula;
         RETURN c; 
         CLOSE c;  
    END;
    / 
CREATE OR REPLACE FUNCTION buscar_grupoXProfesor(xcedula in Profesor.cedula%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT * FROM Grupo WHERE Grupo.profesor = xcedula;
         RETURN c; 
         CLOSE c;  
    END;
    / 
CREATE OR REPLACE FUNCTION buscar_inscritoCarrera(xcodigo in Carrera.codigo%TYPE ) 
     RETURN SYS_REFCURSOR
     AS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT DISTINCT * FROM Alumno, Inscripcion WHERE Inscripcion.alumno =  Alumno.cedula  AND Inscripcion.carrera = xcodigo;
         RETURN c; 
         CLOSE c;  
    END;
    / 


-- SI FUNCIONA

    CREATE OR REPLACE FUNCTION buscar_Alumno_nombre (xnombre in VARCHAR) 
            RETURN SYS_REFCURSOR
                AS 
                    c1 SYS_REFCURSOR;
                BEGIN
                    OPEN c1 FOR 
                    SELECT  * FROM Alumno WHERE nombre = xnombre;  
                    RETURN c1;   
                END;
                /
				
				
    CREATE OR REPLACE FUNCTION buscar_Profesor_nombre (xnombre in VARCHAR) 
            RETURN SYS_REFCURSOR
                AS 
                    c1 SYS_REFCURSOR;
                BEGIN
                    OPEN c1 FOR 
                    SELECT  * FROM Profesor WHERE nombre = xnombre;  
                    RETURN c1;   
                END;
                /
-- SI FUNCIONA
   CREATE OR REPLACE FUNCTION buscar_Alumno_ced (xcedula in Alumno.cedula%TYPE) 
         RETURN SYS_REFCURSOR
                AS 
                    c1 SYS_REFCURSOR;
                BEGIN
                    OPEN c1 FOR 
                    SELECT  *
                    FROM   Alumno
                    WHERE cedula =  xcedula;  
                    RETURN c1;   
                END;
            /
 CREATE OR REPLACE FUNCTION buscar_Admin_ced (xid in Administrador.id%TYPE) 
         RETURN SYS_REFCURSOR
                AS 
                    c1 SYS_REFCURSOR;
                BEGIN
                    OPEN c1 FOR 
                    SELECT  *
                    FROM   Administrador
                    WHERE id =  xid;  
                    RETURN c1;   
                END;
            /
CREATE OR REPLACE FUNCTION buscar_Profesor_cedula (xcedula in Profesor.cedula%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT * FROM Profesor WHERE cedula = xcedula;
            RETURN c; 
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
CREATE OR REPLACE PROCEDURE hacerMatricula (xalumno in Alumno.cedula%TYPE, xcarrera in Carrera.codigo%TYPE,xcurso in Curso.codigo%TYPE, xgrupo in Grupo.nrc%TYPE, xciclo in Ciclo.id%TYPE)
    IS
        BEGIN 
        INSERT INTO Matricula VALUES(xalumno, xcarrera,xcurso,xgrupo, xciclo);
        COMMIT;
    END hacerMatricula;
    /
	
CREATE OR REPLACE FUNCTION buscar_Usuario_id (xid in Usuario.id%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT * FROM Usuario WHERE id = xid;
            RETURN c; 
        END;
        /
		
CREATE OR REPLACE FUNCTION buscar_Matricula_Ciclo(xCiclo in Matricula.ciclo%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT * FROM Matricula WHERE ciclo = xCiclo;
            RETURN c; 
        END;
        /
		
		
CREATE OR REPLACE FUNCTION buscar_Administrador_id (xid in Administrador.id%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT * FROM Administrador WHERE id = xid;
            RETURN c; 
        END;
        /
CREATE OR REPLACE FUNCTION buscar_Ciclo_id (xid in Ciclo.id%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT * FROM Ciclo WHERE id = xid;
            RETURN c; 
        END;
        /
CREATE OR REPLACE FUNCTION buscar_Grupo_id (xid in Grupo.nrc%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT * FROM Grupo WHERE nrc = xid;
            RETURN c; 
        END;
        /
		
CREATE OR REPLACE FUNCTION buscar_CarreraXAlumno (xid in Inscripcion.alumno%TYPE) 
    RETURN SYS_REFCURSOR
        AS 
        c SYS_REFCURSOR;
        BEGIN
            OPEN c FOR SELECT carrera FROM Inscripcion WHERE alumno = xid;
            RETURN c; 
        END;
        /


CREATE OR REPLACE PROCEDURE eliminarCarrera (xcodigo in Carrera.codigo%TYPE)
    IS 
    BEGIN
        DELETE Carrera WHERE codigo = xcodigo;
        COMMIT;
    END;
    /        

CREATE OR REPLACE PROCEDURE eliminarCurso (xcodigo in Curso.codigo%TYPE)
    IS 
    BEGIN
        DELETE Curso WHERE codigo = xcodigo;
        COMMIT;
    END;
    /     