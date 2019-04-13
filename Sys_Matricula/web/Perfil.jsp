<%-- 
    Document   : Alumno
    Created on : Apr 7, 2019, 1:39:28 PM
    Author     : Addiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
         
      
          <%@ include file="Login.jspf" %>
           
        <title>Perfil</title>
    </head>
     <header>
          <%@ include file="NavBar.jspf" %>
     </header>
     <body>
        <div class="container">
    <div class="row my-2">
        <div class="col-lg-8 order-lg-2">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Perfil</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#messages" data-toggle="tab" class="nav-link">Información</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Editar información</a>
                </li>
            </ul>
            <div class="tab-content py-4">
                <div class="tab-pane active" id="profile">
                    <h5 class="mb-3">Descripción</h5>
                    <div class="row">
                        <div class="col-md-6">
                            <h6><strong>Datos personales</strong></h6>
                            <p>
                                Nombre:
                                <br>
                                Cedula:
                                 <br>
                                Edad:
                                 <br>
                                Fecha de nacimiento:
                                 <br>
                                Telefono:
                                 <br>
                                Email:
                                 <br>
                            </p>
                            <h6><strong>Datos de la carrera</strong></h6>
                            <p>
                                Carrera que cursa:
                                 <br>
                                Cursos matriculados:
                                 <br>
                                Total creditos:
                                 <br>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <h6>Cursos matriculados</h6>
                            <a href="#" class="badge badge-dark badge-pill">Programacion</a>
                            <a href="#" class="badge badge-dark badge-pill">Bases de datos</a>
                            <a href="#" class="badge badge-dark badge-pill">Redes</a>
                            <a href="#" class="badge badge-dark badge-pill">Operativos</a>
                            <a href="#" class="badge badge-dark badge-pill">Robotica</a>                            
                            <hr>                            
                        </div>
                        <div class="col-md-12">
                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Detalle de Cursos</h5>
                            <table class="table table-sm table-hover table-striped">
                                <tbody>                                    
                                    <tr>
                                        <td>
                                            <strong>Programacion</strong> Horario: <strong>Creditos:  </strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Bases de datos</strong> Horario: <strong>Creditos:  </strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Redes</strong> Horario: <strong>Creditos:  </strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Operativos</strong> Horario: <strong>Creditos:  </strong>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <strong>Robotica</strong> Horario: <strong>Creditos:  </strong>
                                        </td>
                                    </tr>
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
                  
                    <form role="form">  
                          <div class="row">
                                <div class="col s6">
                                     <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Nombre Completo</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" value="Jane">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Apellido</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" value="Bishop">
                                        </div>
                                    </div>
                                     <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Cedula</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="number" value="">
                                        </div>
                                    </div>
                                </div>
                              
                              <div class="col s6">
                                   <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Telefono</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" type="number" value="">
                                       </div>
                                   </div>
                                   <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Fecha de nacimiento</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" type="date" value="" placeholder="Fecha">
                                       </div>
                                   </div>
                                   <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label">Email</label>
                                       <div class="col-lg-9">
                                           <input class="form-control" type="email" value="email@gmail.com">
                                       </div>
                                   </div>
                                </div>
                             </div>    
                             
                            
                               
                            <div class="row">   
                                <div class="col s6">
                                     <div class="form-group row">
                                    <label class="col-lg-3 col-form-label form-control-label">Username</label>
                                    <div class="col-lg-9">
                                        <input class="form-control" type="text" value="janeuser">
                                    </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-3 col-form-label form-control-label">Password</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="password" value="11111122333">
                                        </div>
                                    </div>
                                </div>
                                 <br />
                                <div class="col s6">  
                                   <div class="form-group row">
                                   <label class="col-lg-3 col-form-label form-control-label">Confirm password</label>
                                   <div class="col-lg-9">
                                       <input class="form-control" type="password" value="11111122333">
                                       </div>
                                   </div>
                                   <div class="form-group row">
                                       <label class="col-lg-3 col-form-label form-control-label"></label>
                                       <div class="col-lg-9">
                                           <input type="reset" class="btn btn-secondary" value="Cancel">
                                           <input type="button" class="btn btn-primary" value="Save Changes">
                                       </div>
                                   </div>
                               </div>       
                                   
                            </div>                                                                                                                                                                                      
                    </form>
                  </div>
                </div>
            </div>
            <div class="col-lg-4 order-lg-1 text-center" >
                        <img id="photo" src="Resources/images/user2.png" class="mx-auto img-fluid img-circle d-block" alt="avatar">
                        <!--h6 class="mt-2">Upload a different photo</h6>
                        <label class="custom-file">
                            <input type="file" id="file" class="custom-file-input">
                            <span class="custom-file-control">Choose file</span>
                        </label-->
            </div>
        </div>                                
</div>
    </body>
     <footer >        
      <%@ include file="footer.jspf" %>       
    </footer>
</html>
<style>
    #photo{
        width: 200px;
        height: 200px;
        
    }
</style>