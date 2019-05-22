<%-- 
    Document   : Alumno
    Created on : Apr 7, 2019, 1:39:28 PM
    Author     : Addiel
--%>

<%@page import="Dao.Data"%>
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="Resources/js/jquery.dataTables.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.js"></script>        
        <script type="text/javascript" src="Resources/js/bootbox.min.js"></script>
        <script type="text/javascript" src="Resources/js/bootbox.locales.min.js"></script>
         <script type="text/javascript" src="Resources/js/myScripts.js"></script>
        <!-- ESTO ES ORO PARA CONTROLAR DATATABLES CON PAGINACION -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/af-2.3.3/b-1.5.6/b-colvis-1.5.6/b-flash-1.5.6/r-2.2.2/rr-1.2.4/sc-2.0.0/sl-1.3.0/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/af-2.3.3/b-1.5.6/b-colvis-1.5.6/b-flash-1.5.6/r-2.2.2/rr-1.2.4/sc-2.0.0/sl-1.3.0/datatables.min.js"></script>      
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
           <%@ include file="modals.jspf" %>
     </header>
     <body>
    <%if(al.getNombre() != null){%> 
    <% al = Data.instance().getServiciobusquedas().buscarAlumnoId(al.getCedula());%>
      
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
                                           <input class="form-control" id="telAl" type="number" maxlength="8" value="<%= al.getTelefono()%>">
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
    <% prof = Data.instance().getServiciobusquedas().buscarProfeId(prof.getCedula()); %>
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
                                               <input class="form-control" id="telProf" type="number" maxlength="8"  value="<%= prof.getTelefono()%>">
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
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a id="carreras_tab" href="#carreras" data-toggle="tab" role="tab" class="nav-link" aria-controls="carreras" aria-selected="true">Modulo de carreras</a>
                    </li>
                    <li class="nav-item">
                        <a id="cursos_tab" href="#cursos" data-toggle="tab" role="tab" class="nav-link" aria-controls="cursos" aria-selected="false">Modulo de cursos</a>
                    </li>
                    <li class="nav-item">
                        <a id="alumnos_tab" href="#alumnos" data-toggle="tab" role="tab" class="nav-link" aria-controls="alumnos" aria-selected="false">Modulo de alumnos</a>
                    </li>
                    <li class="nav-item">
                        <a id="profesores_tab" href="#profesores" data-toggle="tab" role="tab" class="nav-link" aria-controls="profesores" aria-selected="false">Modulo de profesores</a>
                    </li>
                </ul>
            <div class="tab-content py-6">
                 <div class="tab-pane fade show active" id="carreras" role="tabpanel" aria-labelledby="carreras-tab">
                     <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Carreras</h5>
                     <button type="button"  onclick="callModalCrearCarrera()" id="add" class="btn btn-info" style="width: 90px;">agregar</button>
                     <%int count=0;%>
                     <table id="majores" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">                                    
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre del curso</th>
                                    <th scope="col">Nivel</th>                                    
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Carrera c : carreras){ %>
                                    <tr  id="majore">
                                    <th scope="row">
                                        <a href="javascript:eliminarCarrera(<%= c.getCodigo()%>);"> <img id="trashCarrera" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> 
                                        <a href="javascript:callModalEditarCarrera();"> <img id="editCarrera" src="Resources/images/edit.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"></a></th>
                                    <td><%= c.getCodigo()%></td>
                                    <td><%= c.getNombre() %></td>                                  
                                    <td><%= c.getTitulo()%></td>                                      
                                    </tr>
                                     <%count++;%>
                                    <%}%>                                   
                                </tbody>      
                            </table>   
                                <h1 hidden id="count"><%=count+1%></h1>
                </div>
                <div class="tab-pane fade show" id="cursos" role="tabpanel" aria-labelledby="cursos-tab">
                     <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Cursos</h5>                                      
                     <button type="button" onclick="callModalCrearCurso()" id="add2" class="btn btn-info" style="width: 90px;">agregar</button> 
                     <%int count2=0;%>
                     <table id="courses" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">                                    
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
                                       <th scope="row">
                                        <a href="javascript:eliminarCurso(<%= c.getCodigo()%>);"> <img id="trashCuro" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> 
                                        <a href="javascript:callModalEditarCurso();"> <img id="editCurso" src="Resources/images/edit.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"></a></th>
                                        <td><%= c.getCodigo()%></td>
                                        <td><%= c.getNombre() %></td>
                                    <td><%= c.getCreditos()%></td>  
                                    <td><%= c.getHoras_semanales()%></td> 
                                      </tr>
                                      <%count2++;%>
                                    <%}%>                                   
                                </tbody>      
                            </table> 
                                <h1 hidden id="count2"><%=count2+1%></h1>
                </div>           
                <div class="tab-pane fade show" id="alumnos" role="tabpanel" aria-labelledby="alumnos-tab">
                  <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Alumnos</h5>
                   <button type="button" onclick="callModalCrearAlumno()" id="add4" class="btn btn-info" style="width: 90px;">agregar</button>                  
                    <%int count4=0;%>
                        <table id="students" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">                                   
                                  <tr>
                                     <th scope="col">#</th>
                                    <th scope="col">Cedula</th>
                                    <th scope="col">Nombre del Alumno</th>
                                    <th scope="col">Edad</th>
                                    <th scope="col">Fecha de nacimiento</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Carrera</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Alumno alum : alumnos){ %>
                                    <tr  id="student">
                                    <th scope="row">
                                        <a href="javascript:eliminarAlumno(<%= alum.getCedula() %>);"> <img id="trashAlumno" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> 
                                        <a href="javascript:callModalEditarAlumno();"> <img id="editAlumno" src="Resources/images/edit.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"></a></th>
                                    <td><%= alum.getCedula() %></td>
                                    <td><%= alum.getNombre() %></td>
                                    <td><%= alum.getEdad()%></td>
                                    <td><%= alum.getFecha_nacimiento() %></td>
                                    <td><%= alum.getEmail()%> </td>
                                    <td><%= alum.getTelefono()%></td>
                                    <%int c = Data.instance().getServiciobusquedas().buscarCarreraXAlumno(alum.getCedula()); %>
                                    <%String majore =  Data.instance().getServiciobusquedas().buscarCarreraId(c).getNombre(); %>
                                    <td><%= majore%> </td> 
                                    </tr> 
                                       <%count4++;%>
                                    <%}%>                                   
                                </tbody>      
                        </table>   
                                <h1 hidden id="count4"><%=count4%></h1>
                  </div>
                  <div class="tab-pane fade show" id="profesores" role="tabpanel" aria-labelledby="profesores-tab"v>
                    <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Profesores</h5>
                     <button type="button" onclick="callModalCrearProfesor()" id="add3" class="btn btn-info" style="width: 90px;">agregar</button>                    
                        <%int count3=0;%>
                       <table id="teachers" class="table table-striped table-bordered dataTable table-hover " role="grid" aria-describedby="dtBasicExample_info" style="width: 100%;" width="100%" cellspacing="0">
                                  <thead class="thead-dark">                                       
                                    <tr id="teacher">
                                      <th scope="col">#</th>
                                      <th scope="col">Cedula</th>
                                      <th scope="col">Nombre del Profesor</th>
                                      <th scope="col">Edad</th>
                                      <th scope="col">Telefono</th>
                                      <th scope="col">Email</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                      <% for(Profesor p : profes){ %>
                                      <tr  id="course">
                                        <th scope="row">
                                        <a href="javascript:eliminarProfesor(<%= p.getCedula() %>);"> <img id="trashProfesor" src="Resources/images/delete.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"> 
                                        <a href="javascript:callModalEditarProfesor();"> <img id="editProfesor" src="Resources/images/edit.png" class="mx-auto img-fluid img-circle d-block" alt="avatar"></a></th>
                                          <td><%= p.getCedula() %></td>
                                      <td><%= p.getNombre() %></td>
                                      <td><%= p.getEdad()%></td>
                                      <td><%= p.getTelefono()%></td>
                                      <td><%= p.getEmail()%></td>
                                        </tr>  
                                         <%count3++;%>
                                      <%}%>                                   
                                  </tbody>      
                        </table>      
                                  <h1 hidden id="count3"><%=count3%></h1>
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
    .modal-backdrop {
	position: relative;
	top: 0;
	left: 0;
	z-index: 1040;
	width: 100vw;
	height: 100vh;
	background-color: #000;
    }
    .close {
	float: right!important;
	font-size: 1.40625rem!important;
	font-weight: 600!important;
	line-height: 1!important;
	color: #000!important;
	text-shadow: none!important;
	opacity: .5!important;
    }
    button {
       width: auto!important; 
        
    }
</style>