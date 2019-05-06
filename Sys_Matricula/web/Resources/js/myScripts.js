/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function doLogin() {
    usuario = {username: $("#username").val(), password: $("#clave").val()};
    $.ajax({type: "POST",
        url: "doLogin",
        data: JSON.stringify(usuario),
        dataType: "json",
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                    console.log("success");
                    window.alert("Bienvenido a Sys_Matricula");
                    console.log(usuario);
                },
         error: function (jqXHR, textStatus, errorThrown) {
            window.alert(errorThrown);
            console.log(usuario);
        }
    });
}

function validateLogin() {
    usuario = {username: $("#username").val(), clave: $("#clave").val()};   
    $.ajax({
        type: "POST",
        url: "doLogin",
        data: JSON.stringify(usuario),
        dataType: "text",       
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Bienvenido a Sys_Matricula");
                      location.href = "goPerfil";
                     console.log(usuario);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Datos invalidos");          
            console.log(errorThrown);
            
        }
    });
}

function logout(){
    window.confirm("¿Seguro que desea cerrar sesion?");
    location.href = "doLogout";    
}

   $(document).ready(function () {
       $('#majores').DataTable();
       $('.dataTables_length').addClass('bs-select');
     });
     
      $(document).ready(function () {
       $('#courses').DataTable();
       $('.dataTables_length').addClass('bs-select');
     });
     $(document).ready(function () {
       $('#coursesProf').DataTable();
       $('.dataTables_length').addClass('bs-select');
     });
      $(document).ready(function () {
       $('#students').DataTable();
       $('.dataTables_length').addClass('bs-select');
     });
     
      $(document).ready(function () {
       $('#teachers').DataTable();
       $('.dataTables_length').addClass('bs-select');
     });
     
     
    $(document).ready(function() {
    var t = $('#majores').DataTable();
        $('#add').on( 'click', function () {
            t.row.add( [
                '<input type="checkbox" id="newRow" disabled>',
                '',
                '<input type="text" value="" style="width: 200px">',                                 
                '<input type="text" value="" style="width: 200px">'
            ] ).draw( false );         
        } );
    } );
    
    $(document).ready(function() {
    var t = $('#courses').DataTable();
        $('#add2').on( 'click', function () {
            t.row.add( [
                '<input type="checkbox" id="newRow" disabled>',
                '',
                '<input type="text" value="" style="width: auto">',
                '<input type="text" value="" style="width: 80px">',
                '<input type="text" value="" style="width: 80px">'
            ] ).draw( false );         
        } );
    } );
    
     $(document).ready(function() {
    var t = $('#students').DataTable();
        $('#add4').on( 'click', function () {
            t.row.add( [
                '<input type="checkbox" id="newRow" disabled>',
                '<input type="text" value="" style="width: 120px">',
                '<input type="text" value="" style="width: 200px">',
                '<input type="text" value="" style="width: 80px">',
                '<input type="date" value="" style="width: 200px">',
                 '<input type="text" value="" style="width: 200px">'
            ] ).draw( false );         
        } );
    } );
    
     $(document).ready(function() {
    var t = $('#teachers').DataTable();
        $('#add3').on( 'click', function () {
            t.row.add( [
                '<input type="checkbox" id="newRow" disabled>',
                '<input type="text" value="" style="width: 120px">',
                '<input type="text" value="" style="width: 200px">',
                '<input type="text" value="" style="width: 80px">',
                '<input type="text" value="" style="width: 120px">',
                 '<input type="text" value="" style="width: 200px">'
            ] ).draw( false );         
        } );
    } );
    
     function matriculador(){
        // Loop through grabbing everything
        usuario = {username: $("#usernameAl").val(), clave: $("#claveAl").val()};  
        var table = [];
        var $headers = $("th");
        var $rows = $("#matriculadorTable tr").each(function(index) {
          $cells = $(this).find("td").children("input");
          console.log($(this).find("td").children("input").val());
          table[index] = {};
          $cells.each(function(cellIndex) {
            table[index][$($headers[cellIndex]).html()] = $(this).html();
          });    
        });
        // Let's put this in the object like you want and convert to JSON (Note: jQuery will also do this for you on the Ajax request)
        var info = {};
        info.table = table;
        data = new FormData();
        data.append("Matricula", JSON.stringify(info));
        data.append("Usuario", JSON.stringify(usuario));
       // alert(JSON.stringify(info));
        $.ajax({
        type: "POST",
        url: "doMatricula",
        data: data,
        dataType: "json",       
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Matricula Exitosa!");
                     location.href = "goMatricula";
                     console.log(data);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");          
            console.log(errorThrown);
            console.log(data);
        }
    });
    }
    
    
    function saveChanges(){
        // Loop through grabbing everything
        var table = [];
        var $headers = $("th");
        var $rows = $("#majores tr").each(function(index) {
          $cells = $(this).find("td").children("input");
          console.log($(this).find("td").children("input").val());
          table[index] = {};
          $cells.each(function(cellIndex) {
            table[index][$($headers[cellIndex]).html()] = $(this).html();
          });    
        });
        // Let's put this in the object like you want and convert to JSON (Note: jQuery will also do this for you on the Ajax request)
        var info = {};
        info.table = table;
        alert(JSON.stringify(info));
        $.ajax({
        type: "GET",
        url: "SaveChanges",
        data: JSON.stringify(info),
        dataType: "text",       
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Cambios guadados");
                      //location.href = "goPerfil";
                     console.log(info);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Datos invalidos");          
            console.log(errorThrown);
            
        }
    });
    }
    
   function addAlumno() {
    usuario = {username: $("#usernameAl").val(), clave: $("#claveAl").val()};  
    alumno = {nombre: $("#nombreAl").val(),telefono: $("#telAl").val(),email: $("#emailAl").val(), fechaN: $("#fechaN").val(),edad:$("#edadAl").val()};
    data = new FormData();
    data.append("Usuario", JSON.stringify(usuario));
    data.append("Alumno", JSON.stringify(alumno));
    $.ajax({
        type: "POST",
        url: "RegistroEstudiante",
        data: data,
        dataType: "json",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                      location.href = "goPerfil";
                     console.log(usuario);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");
            console.log(usuario);
            console.log(alumno);
            console.log(errorThrown);
            
        }
    });
} 

function addProfesor() {
    usuario = {username: $("#usernameProf").val(), clave: $("#claveProf1").val()};  
    profesor = {nombre: $("#nombreProf").val(),telefono: $("#telProf").val(),email: $("#emailProf").val(),edad:$("#edadProf").val()};
    data = new FormData();
    data.append("Usuario", JSON.stringify(usuario));
    data.append("Profesor", JSON.stringify(profesor));
    $.ajax({
        type: "POST",
        url: "RegistroProfesor",
        data: data,
        dataType: "json",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                     location.href = "goPerfil";
                     console.log(usuario);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");          
            console.log(usuario);
            console.log(profesor);
            console.log(errorThrown);
            
        }
    });
}
 function updateAlumno() {
    usuario = {username: $("#usernameAl").val(), clave: $("#claveAl").val()};  
    alumno = {nombre: $("#nombreAl").val(),telefono: $("#telAl").val(),email: $("#emailAl").val(), fechaN: $("#fechaN").val(),edad:$("#edadAl").val()};
    data = new FormData();
    data.append("Usuario", JSON.stringify(usuario));
    data.append("Alumno", JSON.stringify(alumno));
    $.ajax({
        type: "POST",
        url: "ModificarEstudiante",
        data: data,
        dataType: "json",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                      location.href = "goPerfil";
                     console.log(usuario);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");
            console.log(usuario);
            console.log(alumno);
            console.log(errorThrown);
            
        }
    });
}   
      

 function updateProfesor() {
    usuario = {username: $("#usernameProf").val(), clave: $("#claveProf1").val()};  
    profesor = {nombre: $("#nombreProf").val(),telefono: $("#telProf").val(),email: $("#emailProf").val(),edad:$("#edadProf").val()};
    data = new FormData();
    data.append("Usuario", JSON.stringify(usuario));
    data.append("Profesor", JSON.stringify(profesor));
    $.ajax({
        type: "POST",
        url: "ModificarProfesor",
        data: data,
        dataType: "json",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                     location.href = "goPerfil";
                     console.log(usuario);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");          
            console.log(usuario);
            console.log(profesor);
            console.log(errorThrown);
            
        }
    });
}

function deleteProfesor() {
    profesor = {cedula: $("#cedProf").val()};  
    $.ajax({
        type: "POST",
        url: "EliminarProfesor",
        data: JSON.stringify(profesor),
        dataType: "json",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Usuario eliminado");
                     location.href = "goPerfil";
                     console.log(profesor);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");          
            console.log(profesor);      
            console.log(errorThrown);
            
        }
    });
}

function deleteAlumno() {
    alumno = {username: $("#cedAlumn").val()};  
    $.ajax({
        type: "POST",
        url: "EliminarAlumno",
        data: JSON.stringify(alumno),
        dataType: "json",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Usuario eliminado");
                     location.href = "goPerfil";
                     console.log(alumno);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");          
            console.log(usuario);      
            console.log(errorThrown);
            
        }
    });
}
    