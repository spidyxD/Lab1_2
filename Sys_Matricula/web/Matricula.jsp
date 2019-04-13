<%-- 
    Document   : Matricula
    Created on : Apr 7, 2019, 1:39:37 PM
    Author     : Addiel
--%>

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
         
      
          <%@ include file="Login.jspf" %>
          <title>Matricula</title>
    </head>
     <header>
          <%@ include file="NavBar.jspf" %>
     </header>
    <body>
        <!-- <//jsp:useBean id="carreras" scope="request" type="List<Ciclo>" class="java.util.ArrayList"/>
        <//jsp:useBean id="ciclos" scope="request" type="List<Carrera>" class="java.util.ArrayList"/> -->
        <div class="container">
            <form>
                <div class="form-row">
                  <div class="col-md-4 mb-3">
                    <label for="validationServer01" id="validationServer05">Ciclo</label>
                      <select class="custom-select">                    
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                  </div>
                  <div class="col-md-4 mb-3">
                    <label for="validationServer02" id="validationServer03">Carrera</label>                  
                      <select class="custom-select">                     
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                      
                  </div>                  
                    <div class="col-md-4 mb-3">
                    <label for="validationServer03" id="validationServer04">Grupo</label>
                     <select class="custom-select">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                  </div>
                  
                </div>
                 <div class="form-row">                 
                    <div class="col-md-6 mb-3">
                    <label for="validationTooltip01">Buscar curso</label>                    
                     <input class="form-control" id="validationTooltip01" type="search" placeholder="Search" aria-label="Search">                       
                    </div>
                    <div class="col-md-6 mb-3">
                        <p>&nbsp</p>   
                        <button class="btn btn-outline-info btn-sm" type="submit" style="width: 100px;">Search</button>                       
                   </div>                    
                </div>
                <div class="form-row">
                    <div class="col-md-12 mb-3">
                        <table class="table table-hover">
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
                          <tr>
                            <th scope="row"><input type="checkbox" id="course" ></th>
                            <td>59</td>
                            <td>Fundamentos de Informatica</td>
                            <td>3</td>
                             <td>3 horas</td>
                          </tr>                         
                        </tbody>
                      </table>                    
                    </div>
                </div>    
                 <button class="btn btn-info btn-sm" type="submit" style="width: auto;">Matricular</button>
              </form>
             
        </div>
    </body>
    <footer >        
      <%@ include file="footer.jspf" %>       
    </footer>
</html>
