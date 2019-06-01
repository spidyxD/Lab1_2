bplist00�_WebMainResource�	
_WebResourceFrameName_WebResourceData_WebResourceMIMEType_WebResourceTextEncodingName^WebResourceURLPO:�<html><head></head><body><pre style="word-wrap: break-word; white-space: pre-wrap;">CREATE TABLE libro(
id VARCHAR(10),
entrega VARCHAR(50),
recibe VARCHAR(50),
nombre VARCHAR(50),
caracteristicas VARCHAR(50),
condicionEntrega int,
condicionRecibo int,
fechaEntrega VARCHAR(8),
horaEntrega VARCHAR(5),
CONSTRAINTS pklibro PRIMARY KEY (id)
);

CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;
/
CREATE OR REPLACE PROCEDURE insertarlibro(id IN libro.id%TYPE,entrega IN libro.entrega%TYPE,recibe IN libro.recibe%TYPE,nombre IN libro.nombre%TYPE,
caracteristicas IN libro.caracteristicas%TYPE,condicionEntrega IN libro.condicionEntrega%TYPE,condicionRecibo IN libro.condicionRecibo%TYPE,
fechaEntrega in libro.fechaEntrega%type,horaEntrega in libro.horaEntrega%type)
AS
BEGIN
	INSERT INTO libro VALUES(id,entrega,recibe,nombre,caracteristicas,condicionEntrega,condicionRecibo,fechaEntrega,horaEntrega);
END;
/
CREATE OR REPLACE PROCEDURE modificarlibro (idin IN libro.id%TYPE,entregain IN libro.entrega%TYPE,recibein IN libro.recibe%TYPE,nombrein IN libro.nombre%TYPE,
caracteristicasin IN libro.caracteristicas%TYPE,condicionEntregain IN libro.condicionEntrega%TYPE,condicionRecibidoin IN libro.condicionRecibo%TYPE,
fechaEntregain in libro.fechaEntrega%type,horaEntregain in libro.horaEntrega%type)
AS
BEGIN
UPDATE libro SET entrega=entregain,recibe=recibein,nombre=nombrein,caracteristicas=caracteristicasin,condicionEntrega=condicionEntregain,condicionRecibo=condicionRecibidoin,fechaEntrega=fechaEntregain,horaEntrega=horaEntregain WHERE id=idin;
END;
/


CREATE OR REPLACE FUNCTION buscarlibro(idbuscar IN libro.id%TYPE)
RETURN Types.ref_cursor 
AS 
        libro_cursor types.ref_cursor; 
BEGIN 
  OPEN libro_cursor FOR 
       SELECT id,entrega,recibe,nombre,caracteristicas,condicionEntrega,condicionRecibo,fechaEntrega,horaEntrega FROM libro WHERE id=idbuscar; 
RETURN libro_cursor; 
END;
/
CREATE OR REPLACE FUNCTION listarlibro
RETURN Types.ref_cursor 
AS 
        libro_cursor types.ref_cursor; 
BEGIN 
  OPEN libro_cursor FOR 
       SELECT id,entrega,recibe,nombre,caracteristicas,condicionEntrega,condicionRecibo,fechaEntrega,horaEntrega FROM libro ; 
RETURN libro_cursor; 
END;
/
create or replace procedure eliminarlibro(idin IN libro.id%TYPE)
as
begin
    delete from libro where id=idin;
end;
/


CREATE TABLE permisosVacaciones(
id VARCHAR(10),
boletaPermisos int,
boletaVacaciones int,
funcionario VARCHAR(50),
cedulaFuncionario VARCHAR(11),
fechaSolicitud VARCHAR(8),
diaSolicitado VARCHAR(8),
horasSolicitadas int,
motivo VARCHAR(90),
aprobadoLider int,
aprobadoGerencia int,
fechaAprobacion VARCHAR(8),
justNoAprob VARCHAR(90),
CONSTRAINTS pkpermisosVacaciones PRIMARY KEY (id)
);


CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;
/
CREATE OR REPLACE PROCEDURE insertarPermisosVacaciones(id IN permisosVacaciones.id%TYPE,boletaPermisos IN permisosVacaciones.boletaPermisos%TYPE,
boletaVacaciones IN permisosVacaciones.boletaVacaciones%TYPE,funcionario IN permisosVacaciones.funcionario%TYPE,
cedulaFuncionario IN permisosVacaciones.cedulaFuncionario%TYPE,fechaSolicitud IN permisosVacaciones.fechaSolicitud%TYPE,diaSolicitado IN permisosVacaciones.diaSolicitado%TYPE,
horasSolicitadas in permisosVacaciones.horasSolicitadas%type,motivo in permisosVacaciones.motivo%type,
aprobadoLider in permisosVacaciones.aprobadoLider%type,aprobadoGerencia in permisosVacaciones.aprobadoGerencia%type,
justNoAprob in permisosVacaciones.justNoAprob%type)
AS
BEGIN
	INSERT INTO permisosVacaciones VALUES(id,boletaPermisos,boletaVacaciones,funcionario,cedulaFuncionario,fechaSolicitud,diaSolicitado,horasSolicitadas,motivo,aprobadoLider,aprobadoGerencia,fechaAprobacion,justNoAprob);
END;
/
CREATE OR REPLACE PROCEDURE modificarpermisosVacaciones (idin IN permisosVacaciones.id%TYPE,boletaPermisosin IN permisosVacaciones.boletaPermisos%TYPE,boletaVacacionesin IN permisosVacaciones.boletaVacaciones%TYPE,funcionarioin IN permisosVacaciones.funcionario%TYPE,
cedulaFuncionarioin IN permisosVacaciones.cedulaFuncionario%TYPE,fechaSolicitudin IN permisosVacaciones.fechaSolicitud%TYPE,diaSolicitadoin IN permisosVacaciones.diaSolicitado%TYPE,
horasSolicitadasin in permisosVacaciones.horasSolicitadas%type,motivoin in permisosVacaciones.motivo%type,aprobadoLiderin in permisosVacaciones.aprobadoLider%type,aprobadoGerenciain in permisosVacaciones.aprobadoGerencia%type,fechaAprobacionin in permisosVacaciones.fechaAprobacion%type,
justNoAprobin in permisosVacaciones.justNoAprob%type)
AS
BEGIN
UPDATE cliente SET boletaPermisos=boletaPermisosin,boletaVacaciones=boletaVacacionesin,funcionario=funcionarioin,cedulaFuncionario=cedulaFuncionarioin,fechaSolicitud=fechaSolicitudin,diaSolicitado=diaSolicitadoin,horasSolicitadas=horasSolicitadasin,motivo=motivoin, aprobadoLider=aprobadoLiderin,aprobadoGerencia=aprobadoGerenciain, fechaAprobacion=fechaAprobacionin, justNoAprob=justNoAprobin WHERE id=idin;
END;
/


CREATE OR REPLACE FUNCTION buscarpermisosVacaciones(idbuscar IN permisosVacaciones.id%TYPE)
RETURN Types.ref_cursor 
AS 
        permisosVacaciones_cursor types.ref_cursor; 
BEGIN 
  OPEN permisosVacaciones_cursor FOR 
       SELECT id,boletaPermisos,boletaVacaciones,funcionario,cedulaFuncionario,fechaSolicitud,diaSolicitado,horasSolicitadas,motivo,aprobadoLider,aprobadoGerencia,fechaAprobacion,justNoAprob FROM permisosVacaciones WHERE id=idbuscar; 
RETURN permisosVacaciones_cursor; 
END;
/
CREATE OR REPLACE FUNCTION listarpermisosVacaciones
RETURN Types.ref_cursor 
AS 
        permisosVacaciones_cursor types.ref_cursor; 
BEGIN 
  OPEN permisosVacaciones_cursor FOR 
       SELECT id,boletaPermisos,boletaVacaciones,funcionario,cedulaFuncionario,fechaSolicitud,diaSolicitado,horasSolicitadas,motivo,aprobadoLider,aprobadoGerencia,fechaAprobacion,justNoAprob FROM permisosVacaciones ; 
RETURN permisosVacaciones_cursor; 
END;
/
create or replace procedure eliminarpermisosVacaciones(idin IN permisosVacaciones.id%TYPE)
as
begin
    delete from permisosVacaciones where id=idin;
end;
/
create table perfil(
id varchar(11),
nombre varchar2(30),
constraints pkperfil primary key (id));
/
create or replace package types
as
     type ref_cursor is ref cursor;
End;
/
create or replace procedure insertarPerfil (id in varchar,descripcion in varchar) as
begin
insert into perfil values(id,descripcion);
end;
/
create or replace function listar
return Types.ref_cursor 
as 
       perfil_cursor types.ref_cursor; 
begin 
  open perfil_cursor for 
       select id,descripcion from perfil; 
return perfil_cursor; 
end;
/
create or replace procedure modificarPerfil (idin in perfil.id%type,descripin in perfil.descripcion%type) as
begin
update perfil set descripcion=descripin where id=idin;
end;
/
create or replace function buscarID (idbuscar in varchar)
return Types.ref_cursor 
as 
       perfil_cursor types.ref_cursor; 
begin 
  open perfil_cursor for 
       select id,descripcion from perfil where id=idbuscar; 
return perfil_cursor; 
end;
/
create or replace procedure eliminarPorId(idin in varchar)
as
begin
    delete from perfil where id=idin;
end;
/
CREATE TABLE contactos (
id varchar(11),
cedula varchar(11),
nombre VARCHAR(30),
oraganizacion VARCHAR(30),
direccion VARCHAR(30),
cargo VARCHAR(12),
email varchar(15),
telefonoTrabajo VARCHAR(10),
telefonoCasa VARCHAR(10),
telefonoCelular VARCHAR(10),
fax VARCHAR(10),
CONSTRAINTS pkcontactos PRIMARY KEY (id)
);


CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;

CREATE OR REPLACE PROCEDURE insertarContactos(id in varchar,cedula in varchar,nombre in VARCHAR,oraganizacion in VARCHAR, direccion in VARCHAR, cargo in VARCHAR, email in varchar, telefonoTrabajo in VARCHAR,telefonoCasa in VARCHAR, telefonoCelular in VARCHAR, fax in VARCHAR)
AS
BEGIN
	INSERT INTO Contactos VALUES(id ,cedula,nombre,oraganizacion, direccion, cargo, email, telefonoTrabajo,telefonoCasa, telefonoCelular, fax);
END;



CREATE OR REPLACE PROCEDURE modificarContactos(inid in varchar,incedula in varchar,innombre in VARCHAR,inoraganizacion in VARCHAR, indireccion in VARCHAR, incargo in VARCHAR, inemail in varchar, intelefonoTrabajo in VARCHAR,intelefonoCasa in VARCHAR, intelefonoCelular in VARCHAR, infax in VARCHAR)
AS
BEGIN
	update contactos set id=inid ,cedula=incedula,nombre=innombre,oraganizacion=inoraganizacion, direccion=indireccion, cargo=incargo, email=inemail, telefonoTrabajo=intelefonoTrabajo,telefonoCasa=intelefonoCasa, telefonoCelular=intelefonoCelular, fax=infax;
END;



CREATE OR REPLACE FUNCTION buscarContactos(idbuscar IN Contactos.id%TYPE)
RETURN Types.ref_cursor 
AS 
        contactos_cursor types.ref_cursor; 
BEGIN 
  OPEN contactos_cursor FOR 
       SELECT id ,cedula,nombre,oraganizacion, direccion, cargo, email, telefonoTrabajo,telefonoCasa, telefonoCelular, fax FROM Contactos WHERE id=idbuscar; 
RETURN contactos_cursor; 
END;



CREATE OR REPLACE procedure eliminarContactos(idbuscar IN Contactos.id%TYPE)
as
begin
	delete from contactos where id=idbuscar;
end;

CREATE table usuario(
    cedula varchar(11),
    nombre varchar(30),
    nombreUsuario varchar(30),
    contrase�a varchar(10),
    perfil varchar(11),
    constraint PKUSUARIO primary key (cedula)
   -- constraint FKPERFIL2 foreign key (perfil) refences perfil(id)
);

--INSERTAR
------------------------------------------------------
CREATE OR REPLACE PROCEDURE insertarUsuario(cedulain varchar, nombrein varchar,
nombreUsuarioin varchar, contrase�ain varchar, perfilin varchar)
as
BEGIN
 INSERT INTO usuario VALUES(cedulain,nombrein,nombreUsuarioin,contrase�ain,perfilin);
END;
------------------------------------------------------

--ACTUALIZAR
------------------------------------------------------
CREATE OR REPLACE PROCEDURE actualizaUsuario(cedulain in varchar, nombrein in varchar,
nombreUsuarioin in varchar, contrase�ain in varchar, perfilin in varchar)
as
BEGIN
 UPDATE usuario SET nombre=nombrein,nombreUsuario=nombreUsuarioin,
		    contrase�a=contrase�ain,perfil=perfilin WHERE cedula=cedulain;
END;
------------------------------------------------------

--ELIMINAR
------------------------------------------------------
CREATE OR REPLACE PROCEDURE eliminarUsuario(cedulain varchar)
as
BEGIN
 DELETE usuario WHERE cedula=cedulain;
END;
------------------------------------------------------

--LISTAR
------------------------------------------------------
CREATE OR REPLACE function listarUsuarios
return Types.ref_cursor 
as 
        usuario_cursor types.ref_cursor; 
begin 
  open usuario_cursor for 
       select nombre,nombreUsuario,contrase�a,perfil
       FROM usuario ;
return usuario_cursor;
end; 
------------------------------------------------------

--CONSULTAR
------------------------------------------------------
CREATE OR REPLACE function consultarUsuario(cedulain in varchar)
return Types.ref_cursor 
as 
        usuario_cursor types.ref_cursor; 
begin 
  open usuario_cursor for 
       select nombre,nombreUsuario,contrase�a,perfil
       FROM usuario where cedula=cedulain;
return usuario_cursor;
end;  
------------------------------------------------------


----------------------------CREACION DE LA TABLA--------------------------------------------

CREATE TABLE comprobantePago(
id VARCHAR(10),
nombre VARCHAR(50),
cedula VARCHAR(11),
perfil VARCHAR(1),
salarioBruto number(9,5),
ccss number(7,5),
bancoPopular number(7,5),
ingresosAcumulados number(20,10),
fechaIngreso VARCHAR(10),
vacDisfQuinc number(4,3),
vacAcumAno number(4,3),
vacDisfAno number(4,3),
CONSTRAINTS pkComprobantePago PRIMARY KEY (id)
);

------------CREACION DEL PAQUETE QUE CONTIENE EL TIPO REF_CURSOR---------------------------------

CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;

---------------------iNSERTAR UN COMPROBANTE DE PAGO-----------------------------------------------------------------------


CREATE OR REPLACE PROCEDURE insertarComprobantePago(id in varchar,nombre in varchar,cedula in varchar,
perfil in varchar, salarioBruto in number,ccss in number,bancoPopular in number,ingresosAcumulados in number,
fechaIngreso in VARCHAR,vacDisfQuinc in number,vacAcumAno in number,vacDisfAno in number)
AS
BEGIN
	INSERT INTO comprobantePago VALUES(id,nombre,cedula,perfil,salarioBruto,ccss,bancoPopular,ingresosAcumulados,fechaIngreso,vacDisfQuinc,vacAcumAno,vacDisfAno);
END;


/*exec insertarComprobantePago('1','Michael','1-13330581','p',10000,1000,500,500000,'10/10/2007',3,20,15); con esta no sirvio*/
/*exec insertarComprobantePago('1','Michl','1-13330','p',1,1,5,500,'10/10/07',3,20,15); esta si sirvio*/

-----------------------------Modificar un comprobante de pago---------------------------------------------------------------

CREATE OR REPLACE PROCEDURE modificaComprobantePago (id in varchar,nombreX in varchar,cedulaX in varchar,
perfilX in varchar, salarioBrutoX in number,ccssX in number,bancoPopularX in number,ingresosAcumuladosX in number,
fechaIngresoX in VARCHAR,vacDisfQuincX in number,vacAcumAnoX in number,vacDisfAnoX in number)
AS
BEGIN
UPDATE comprobantePago SET nombre = nombreX, cedula = cedulaX, perfil = perfilX, salarioBruto = salarioBrutoX, ccss = ccssX, bancoPopular = bancoPopularX, fechaIngreso = fechaIngresoX, vacDisfQuincX = vacDisfQuincX, vacAcumAno = vacAcumAnoX, vacDisfAno = vacDisfAnoX WHERE id = idX;
END;

--------------------------------Buscar un comprobante de pago------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION buscarComprobantePago(idbuscar IN varchar)
RETURN Types.ref_cursor 
AS 
        cursorComprobante types.ref_cursor; 
BEGIN 
  OPEN cursorComprobante FOR 
       SELECT id,nombre,cedula,perfil,salarioBruto,ccss,bancoPopular,ingresosAcumulados,fechaIngreso,vacDisfQuinc,vacAcumAno,vacDisfAno from comprobantePago WHERE id=idbuscar; 
RETURN cursorComprobante; 
END;

------------------------------Lista todos los comprobantes de pago-------------------------------------------------------------

CREATE OR REPLACE FUNCTION listarComprobantePago
RETURN Types.ref_cursor 
AS 
        cursorComprobante types.ref_cursor; 
BEGIN 
  OPEN cursorComprobante FOR 
       SELECT id,nombre,cedula,perfil,salarioBruto,ccss,bancoPopular,ingresosAcumulados,fechaIngreso,vacDisfQuinc,vacAcumAno,vacDisfAno from comprobantePago; 
RETURN cursorComprobante; 
END;

-------------------------------Eliminar un comprobante de pago------------------------------------------------------------

create or replace procedure eliminarComprobantePago(idin IN varchar)
as
begin
    delete from comprobantePago where id=idin;
end;

--------------------------------------------------------


---Login

CREATE OR REPLACE FUNCTION login(idin IN VARCHAR), passwordin IN VARCHAR)
RETURN Types.ref_cursor 
AS 
        n_cursor types.ref_cursor; 
BEGIN 
  OPEN n_cursor FOR 
	  SELECT COUNT(nombreUsuario) AS esta FROM usuario WHERE nombreUsuario=idin AND contrase�a=passwordin;
	 RETURN n_cursor; 
END;



</pre></body></html>Ztext/plainUUTF-8_^https://www.aulavirtual.una.ac.cr/pluginfile.php/371865/mod_resource/content/1/Script%20BD.sql    ( ? Q g � � �;R;];c                           ;�