<%-- 
    Document   : Alumno
    Created on : Apr 7, 2019, 1:39:28 PM
    Author     : Addiel
--%>

<%@page import="Entities.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Carrera"%>
<%@page import="Entities.Profesor"%>
<%@page import="Entities.Alumno"%>
<%@page import="Entities.Usuario"%>
<%@page import="Entities.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <!-- ESTO ES ORO PARA CONTROLAR DATATABLES CON PAGINACION -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>        
         <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
         <script type="text/javascript" src="Resources/js/myScripts.js"></script>
         
           
         <!-- FIN https://datatables.net/ -->
          <%@ include file="Login.jspf" %>
          <title>Perfil</title>
    </head>
         
         <%Usuario u = (Usuario) session.getAttribute("user");%>  
         <%ArrayList<Alumno> alumnos = (ArrayList<Alumno>)session.getAttribute("alumnos");%>
         <%ArrayList<Profesor> profes = (ArrayList<Profesor>)session.getAttribute("profes");%>
         <%ArrayList<Carrera> carreras = (ArrayList<Carrera>)session.getAttribute("carreras");%>
         <%ArrayList<Curso> cursos = (ArrayList<Curso>)session.getAttribute("cursos");%>
         <%ArrayList<Curso> cursosProf = (ArrayList<Curso>)session.getAttribute("cursosProf");%>
         <%ArrayList<Curso> cursosAlumn = (ArrayList<Curso>)session.getAttribute("cursosAlum");%>
         <%Carrera car = (Carrera)session.getAttribute("carrera");%>
     <header>
          <%@ include file="NavBar.jspf" %>
     </header>
     <body>
    <%if(al.getNombre() != null){%>             
        <div class="container">
        <div class="row my-2">
            <div class="col-lg-10 order-lg-2">
                <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Perfil</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#messages" data-toggle="tab" class="nav-link">Información del estudiante</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Editar Perfil</a>
                </li>
            </ul>
            <div class="tab-content py-4">
                <div class="tab-pane active" id="profile">
                   
                    <h5 class="mb-3">Descripción</h5>
                    <div class="row">
                        <div class="col-md-6">
                           
                            <h6><strong>Datos personales</strong></h6>
                            <p>
                                Nombre: <%= al.getNombre() %>
                                <br>
                                Cedula: <%= al.getCedula() %>
                                 <br>
                                Edad:   <%= al.getEdad() %>
                                 <br>
                                Fecha de nacimiento:  <%= al.getFecha_nacimiento()%>
                                 <br>
                                <%if(al.getTelefono() > 0 ){%> 
                                Telefono:  <%=al.getTelefono() %>
                                <%}else{%>
                                Telefono: 8888-8888
                                <%}%>
                                 <br>
                                Email:  <%= al.getEmail()%>
                                 <br>
                            </p>
                            <h6><strong>Datos de la carrera</strong></h6>
                            <p>
                                Carrera que cursa: <%= car.getNombre() %>
                                 <br>
                                Cursos matriculados: <%= cursosAlumn.size() %>
                                 <br>
                                Total creditos: 12
                                 <br>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <h6><strong>Cursos matriculados</strong></h6>
                            <%for(Curso c : cursosAlumn){%>
                            <a href="#" class="badge badge-dark badge-pill"><%= c.getNombre() %></a>                                                                                              
                            <%}%>
                            <hr> 
                        </div>
                        <div class="col-md-12">
                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Cursos</h5>
                            <table class="table table-sm table-hover table-striped">
                                <tbody>  
                                     <%for(Curso c : cursosAlumn){%>
                                    <tr>
                                        <td>
                                            <strong><%=c.getNombre() %></strong> Horario: L,X 8:00am - 10:00am <strong>Creditos:  <%=c.getCreditos()%>  </strong>
                                        </td>
                                    </tr>                                   
                                     <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--/row-->
                </div>
                <div class="tab-pane" id="messages">
                    <div class="alert alert-info alert-dismissable">
                        <a class="panel-close close" data-dismiss="alert">×</a> Esta informacion <strong>no es oficial</strong>. Vease solo como referencia.
                    </div>
                    <table class="table table-hover table-striped">
                        <tbody>                                    
                            <tr>
                                <td>
                                   <span class="float-right font-weight-bold">3 nvl</span> Nivel de carrera
                                </td>
                            </tr>
                            <tr>
                                <td>
                                   <span class="float-right font-weight-bold"> Ciclo 1, 2019 </span>Ciclo actual:
                                </td>
                            </tr>
                            <tr>
                                <td>
                                   <span class="float-right font-weight-bold"> 7.85</span> PGA:
                                </td>
                            </tr>
                            <tr>
                                <td>
                                   <span class="float-right font-weight-bold">ninguno</span>  Pendientes de pago:
                                </td>
                            </tr>
                            <tr>
                                <td>
                                   <span class="float-right font-weight-bold">48 creditos</span> Total de creditos globales 
                                </td>
                            </tr>
                        </tbody> 
                    </table>
                </div>
                <div class="tab-pane" id="edit">                 
                    <form role="form" action="javascript:;" onsubmit="updateAlumno(this)" method="POST">  
                          <div class="row">
                                <div class="col s6">
                                     <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Nombre Completo</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" id="nombreAl" type="text" value="<%= al.getNombre() %>">
                                        </div>
                                    </div>                                   
                                    <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Email</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" id="emailAl" type="email" value="<%= al.getEmail()%>">
                                       </div>
                                   </div>                                    
                                </div>                             
                              <div class="col s6">
                                   <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Telefono</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" id="telAl" type="number" value="<%= al.getTelefono()%>">
                                       </div>
                                   </div>
                                   <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Fecha de nacimiento</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" type="date" id="fechaN" value="<%= al.getFecha_nacimiento()%>" placeholder="">
                                       </div>
                                   </div> 
                                    <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Edad</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" type="number" id="edadAl" value="<%= al.getEdad() %>" placeholder="">
                                       </div>
                                   </div>       
                                </div>
                             </div>    
                            <div class="row">   
                                <div class="col s6">
                                     <div class="form-group row">
                                    <label class="col-lg-3 col-form-label form-control-label">Username</label>
                                    <div class="col-lg-9">
                                        <input class="form-control" id="usernameAl" type="text" value="<%= u.getUsername() %>" readonly>
                                    </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Password</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" id="claveAl" type="password" value="<%= u.getClave()%>">
                                        </div>
                                    </div>
                                </div>
                                 <br />
                                <div class="col s6">  
                                   <div class="form-group row">
                                   <label class="col-lg-3 col-form-label form-control-label">Confirm password</label>
                                   <div class="col-lg-9">
                                       <input class="form-control" id="claveAl2" type="password" value="<%= u.getClave()%>">
                                       </div>
                                   </div>
                                   
       
                                   <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label"></label>
                                       <div class="col-lg-9">                                         
                                           <input type="submit"  class="btn btn-primary" value="Save Changes">
                                       </div>
                                   </div>
                               </div>                                         
                            </div>                                                                                                                                                                                      
                    </form>
                  </div>
                </div>                      
        </div>
       <div class="col-lg-2 order-lg-1 text-center" >
           <img id="photo" src="Resources/images/user2.png" class="mx-auto img-fluid img-circle d-block" alt="avatar">                        
       </div>
    </div> 
    </div>                                    
    <%}else if(prof.getNombre() != null){%>
        <div class="container">
            <div class="row my-2">
                <div class="col-lg-10 order-lg-2">
                    <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Perfil de profesor</a>
                    </li>
                    <li class="nav-item">
                        <a href="" data-target="#cursosAsign" data-toggle="tab" class="nav-link">Cursos asignados</a>
                    </li>
                    <li class="nav-item">
                        <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Editar Perfil</a>
                    </li>
                </ul>
                <div class="tab-content py-4">
                    <div class="tab-pane active" id="profile">

                        <h5 class="mb-3">Descripción</h5>
                        <div class="row">
                            <div class="col-md-12">

                                <h6><strong>Datos personales</strong></h6>
                                <p>
                                    Nombre: <%= prof.getNombre() %>
                                    <br>
                                    Cedula: <%= prof.getCedula() %>
                                     <br>
                                    Edad:   <%= prof.getEdad() %>
                                     <br>

                                    Email:  <%= prof.getEmail()%>
                                     <br>
                                </p>
                            </div>                        
                        </div>
                        <!--/row-->
                    </div>
                     <br/>
                    <div class="tab-pane" id="cursosAsign">
                         <div class="row">
                               <div class="col-md-12">
                                <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Cursos asignados</h5>
                                 <table id="coursesProf" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">
                                     </th></tr>
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre del curso</th>
                                    <th scope="col">Creditos</th>
                                    <th scope="col">Horas semanales</th>
                                    
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Curso c : cursosProf){ %>
                                    <tr  id="course">
                                    <th scope="row"><input type="checkbox" ></th>
                                    <td><%= c.getCodigo()%></td>
                                    <td><%= c.getNombre() %></td>
                                    <td><%= c.getCreditos()%></td>  
                                    <td><%= c.getHoras_semanales()%></td> 
                                      </tr>                              
                                    <%}%>                                   
                                </tbody>      
                            </table>
                            </div>
                         </div>
                    </div>                    
                    <div class="tab-pane" id="edit">                 
                        <form role="form">  
                              <div class="row">
                                    <div class="col s6">
                                         <div class="form-group row">
                                            <label class="col-lg-3 col-form-label form-control-label"> Nombre</label>
                                            <div class="col-lg-9">
                                                <input class="form-control" id="nombreProf" type="text" value="<%= prof.getNombre() %>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Email</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" id="emailProf" type="email" value="<%= prof.getEmail()%>">
                                        </div>
                                       </div>
                                    </div>
                                  <div class="col s6">
                                       <div class="form-group row">
                                           <label class="col-lg-3 col-form-label form-control-label">Telefono</label>
                                           <div class="col-lg-9">
                                               <input class="form-control" id="telProf" type="number" value="<%= prof.getTelefono()%>">
                                           </div>
                                       </div>
                                       <div class="form-group row">
                                           <label class="col-lg-3 col-form-label form-control-label">Edad</label>
                                           <div class="col-lg-9">
                                               <input class="form-control" id="edadProf" type="number" value="<%= prof.getEdad()%>" placeholder="Edad">
                                           </div>
                                       </div>                                      
                                    </div>
                                 </div>    
                                <div class="row">   
                                    <div class="col s6">
                                         <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Username</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" id="usernameProf" type="text" value="<%= u.getUsername()%>" readonly>
                                        </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-3 col-form-label form-control-label">Password</label>
                                            <div class="col-lg-9">
                                                <input class="form-control" id="claveProf1" type="password" value="<%= u.getClave()%>">
                                            </div>
                                        </div>
                                    </div>
                                     <br />
                                    <div class="col s6">  
                                       <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Confirm password</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" id="claveProf2" type="password" value="<%= u.getClave() %>">
                                           </div>
                                       </div>
                                       <div class="form-group row">
                                           <label class="col-lg-3 col-form-label form-control-label"></label>
                                           <div class="col-lg-9">                                              
                                               <input type="button" onclick="updateProfesor(this)" class="btn btn-primary" value="Save Changes">
                                           </div>
                                       </div>
                                   </div>                                         
                                </div>                                                                                                                                                                                      
                        </form>
                      </div>
                    </div>
                </div>
            <div class="col-lg-2 order-lg-1 text-center" >
                    <img id="photo" src="Resources/images/profe.png" class="mx-auto img-fluid img-circle d-block" alt="avatar">                           
            </div>
        </div> 
    </div>
   <%}else if(a.getNombre() != null){%>
        <div class="container">
        <div class="row my-2">
            <div class="col-lg-10 order-lg-2">
                <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="" data-target="#carreras" data-toggle="tab" class="nav-link">Modulo de carreras</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#cursos" data-toggle="tab" class="nav-link">Modulo de cursos</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#alumnos" data-toggle="tab" class="nav-link">Modulo de alumnos</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#profesores" data-toggle="tab" class="nav-link">Modulo de profesores</a>
                </li>
            </ul>
            <div class="tab-content py-6">
                 <div class="tab-pane active" id="carreras">
                     <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Carreras</h5>
                     <button type="button" id="add" class="btn btn-info" style="width: 90px;">agregar</button>
                     <button type="button" id="save" onclick="javascript:saveChanges()"  class="btn btn-success" value="Save Changes"  style="width: 90px;">Guardar</button>
                     <%int count=0;%>
                     <table id="majores" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">
                                     </th></tr>
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre del curso</th>
                                    <th scope="col">Nivel</th>                                    
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Carrera c : carreras){ %>
                                    <tr  id="course">
                                        <th scope="row"><input type="checkbox" checked="true" id="row<%=count%>" disabled><a href="#"> <img id="trash" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> </a></th>
                                    <td><input type="text" value="<%= c.getCodigo()%>" style="width: 80px" readonly></td>
                                    <td><input type="text" value="<%= c.getNombre() %>" style="width: 200px"></td>                                  
                                    <td><input type="text" value="<%= c.getTitulo()%>" style="width: 200px"></td>                                      
                                     </tr>
                                     <%count++;%>
                                    <%}%>                                   
                                </tbody>      
                            </table>                                          
                </div>
                <div class="tab-pane" id="cursos">
                     <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Cursos</h5>
                     <button type="button" id="add2" class="btn btn-info" style="width: 90px;">agregar</button>
                     <button type="button" id="save2" class="btn btn-success" value="Save Changes"  style="width: 90px;">Guardar</button>
                      <%int count2=0;%>
                     <table id="courses" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">
                                     </th></tr>
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre del curso</th>
                                    <th scope="col">Creditos</th>
                                    <th scope="col">Horas semanales</th>
                                    
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Curso c : cursos){ %>
                                    <tr  id="course">
                                        <th scope="row"><input type="checkbox" id="row<%=count2%>" checked="true" disabled><a href="#"> <img id="trash" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> </a></th>
                                    <td><input type="text" value="<%= c.getCodigo()%>" style="width: 80px" readonly></td>
                                    <td><input type="text" value="<%= c.getNombre() %>" style="width: auto"></td>
                                    <td><input type="text" value="<%= c.getCreditos()%>" style="width: 80px"></td>  
                                    <td><input type="text" value="<%= c.getHoras_semanales()%>" style="width: 80px"></td> 
                                      </tr>
                                      <%count2++;%>
                                    <%}%>                                   
                                </tbody>      
                            </table>                                        
                </div>
                <div class="tab-pane" id="profesores">
                  <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Profesores</h5>
                   <button type="button" id="add3" class="btn btn-info" style="width: 90px;">agregar</button>
                     <button type="button" id="save3" class="btn btn-success" value="Save Changes"  style="width: 90px;">Guardar</button>
                      <%int count3=0;%>
                     <table id="teachers" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">
                                     </th></tr>
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Cedula</th>
                                    <th scope="col">Nombre del alumno</th>
                                    <th scope="col">Edad</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Email</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Profesor p : profes){ %>
                                    <tr  id="course">
                                        <th scope="row"><input type="checkbox" id="row<%=count3%>" checked="true" disabled><a href="#"> <img id="trash" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> </a></th>
                                    <td><input type="text" value="<%= p.getCedula() %>" style="width: 120px;" readonly></td>
                                    <td><input type="text" value="<%= p.getNombre() %>" style="width: 200px;"></td>
                                    <td><input type="text" value="<%= p.getEdad()%>" style="width: 80px;"></td>
                                    <td><input type="text" value="<%= p.getTelefono()%>" style="width: 120px;"></td>
                                    <td><input type="text" value="<%= p.getEmail()%>" style="width: 200px"> </td>
                                      </tr>  
                                       <%count3++;%>
                                    <%}%>                                   
                                </tbody>      
                            </table>                                            
                  </div>
                 <div class="tab-pane" id="alumnos">
                  <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Alumnos</h5>
                   <button type="button" id="add4" class="btn btn-info" style="width: 90px;">agregar</button>
                   <button type="button" onclick="javascript:saveChanges()" id="save4" class="btn btn-success" value="Save Changes"  style="width: 90px;">Guardar</button>
                    <%int count4=0;%>
                   <table id="students" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">
                                     </th></tr>
                                  <tr>
                                     <th scope="col">#</th>
                                    <th scope="col">Cedula</th>
                                    <th scope="col">Nombre del Profesor</th>
                                    <th scope="col">Edad</th>
                                    <th scope="col">Fecha de nacimiento</th>
                                    <th scope="col">Email</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Alumno alum : alumnos){ %>
                                    <tr  id="course">
                                        <th scope="row"><input type="checkbox" id="row<%=count4%>" checked="true" disabled><a href="#"> <img id="trash" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> </a></th>
                                    <td><input type="text" value="<%= alum.getCedula() %>" style="width: 120px;" readonly></td>
                                    <td><input type="text" value="<%= alum.getNombre() %>" style="width: 200px;"></td>
                                    <td><input type="text" value="<%= alum.getEdad()%>" style="width: 80px;"></td>
                                    <td><input type="date" value="<%= alum.getFecha_nacimiento() %>" style="width: 200px;"></td>
                                    <td><input type="text" value="<%= alum.getEmail()%>" style="width: 200px" ></td>
                                      </tr> 
                                       <%count4++;%>
                                    <%}%>                                   
                                </tbody>      
                        </table>                            
                  </div>
                </div>
            </div>
        <div class="col-lg-2 order-lg-1 text-center" >
              <img id="photo" src="Resources/images/admin.png" class="mx-auto img-fluid img-circle d-block" alt="avatar">                       
        </div>
    </div> 
    
  </div>
                             
   <%}else{}%>
    </body>   
     
</html>
<script>
    
</script>
<style>
    #photo{
        width: 175px;
        height: 175px;
        
    }
     #trash{
        width: 25px;
        height: 25px;
        
    }
</style>