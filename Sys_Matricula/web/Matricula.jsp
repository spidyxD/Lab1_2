<%-- 
    Document   : Matricula
    Created on : Apr 7, 2019, 1:39:37 PM
    Author     : Addiel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Grupo"%>
<%@page import="Entities.Curso"%>
<%@page import="Entities.Carrera"%>
<%@page import="Entities.Ciclo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
         <script type="text/javascript" src="Resources/js/myScripts.js"></script>
        <!-- ESTO ES ORO PARA CONTROLAR DATATABLES CON PAGINACION -->
         <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/af-2.3.3/b-1.5.6/b-colvis-1.5.6/b-flash-1.5.6/r-2.2.2/rr-1.2.4/sc-2.0.0/sl-1.3.0/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/af-2.3.3/b-1.5.6/b-colvis-1.5.6/b-flash-1.5.6/r-2.2.2/rr-1.2.4/sc-2.0.0/sl-1.3.0/datatables.min.js"></script>      
        
         <!-- FIN https://datatables.net/ -->
          <%@ include file="Login.jspf" %>
          <title>Matricula</title>
    </head>
     <header>
          <%@ include file="NavBar.jspf" %>
     </header>
    <body>
        
         <%ArrayList<Ciclo> ciclos = (ArrayList<Ciclo>)session.getAttribute("ciclos");%>
         <%ArrayList<Carrera> carreras = (ArrayList<Carrera>)session.getAttribute("carreras");%>
         <%ArrayList<Curso> cursos = (ArrayList<Curso>)session.getAttribute("cursos");%>
        <div class="container">
            <form role="form" action="javascript:;" onsubmit="matriculador(this)" method="POST">
                <div class="form-row">
                  <div class="col-md-4 mb-3">
                    <label for="validationServer01" id="validationServer05">Ciclo</label>
                      <select class="custom-select">
                       <option selected readonly>Escoge un ciclo</option>
                        < <% for(Ciclo cl: ciclos){ %>                      
                        <option value="1"> <%= cl.getDescripcion() %></option>
                        <%}%> 
                      </select>
                  </div>
                  <div class="col-md-4 mb-3">
                    <label for="validationServer02" id="validationServer03">Carrera</label>                  
                      <select class="custom-select" id="carrera">
                       <option selected readonly>Escoge una carrera</option>
                        <% for(Carrera ca : carreras){ %>                      
                         <option value="1"> <%= ca.getNombre() %></option>
                        <%}%> 
                      </select>
                  </div>                  
                                 
                </div>              
                <div class="form-row">
                    <div class="col-md-12 mb-3">
                          
                        <div id="matriculadorTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                           
                            <div class="row">
                                <div class="col-sm-12">
                            <table id="matriculadorTable" class="table table-striped table-bordered dataTable table-hover fade show" role="grid" aria-describedby="matriculadorTable_info" style="width: 100%;" width="100%" cellspacing="0">
                                <thead class="thead-dark">
                                     </th></tr>
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nombre del curso</th>
                                    <th scope="col">Creditos</th>
                                    <th scope="col">Horas semanales</th>
                                    <th scope="col">Grupo</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <% for(Curso c : cursos){ %>
                                    <tr  id="course">
                                    <th scope="row"><input type="checkbox" ></th>
                                    <td><%= c.getCodigo()%></td>
                                    <td><%= c.getNombre() %></td>
                                    <td><%= c.getCreditos()%></td>
                                    <td><%= c.getHoras_semanales()%></td>
                                      <td>
                                        <select class="custom-select">
                                        <option selected disabled>Seleccione ...</option> 
                                        <option >1</option> 
                                        <option >2</option>   
                                        <option >3</option>  
                                        <option >4</option> 
                                        <option >5</option> 
                                              
                                     </select>
                                        </td>
                                      </tr>                              
                                    <%}%>
                                   
                                </tbody>      
                            </table>
                        </div>
                    </div>                   
                    </div>
                    </div>
                    <script>
                         $(document).ready(function () {
                        $('#matriculadorTable').DataTable();
                        $('.dataTables_length').addClass('bs-select');
                      });
                    </script>
                </div>
                          <button class="btn btn-info btn-sm" type="submit" style="width: auto;">Matricular</button>        
              </form>               
        </div>
    </body>
    
</html>
