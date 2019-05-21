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
                      location.href = "goPerfil?idUser="+usuario.username+"&type=undefined";
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
     
     
  /*  $(document).ready(function() {
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
    */
     /*$(document).ready(function() {
    var t = $('#students').DataTable();
        $('#add4').on( 'click', function () {
            t.row.add( [
                '<input type="checkbox" id="newRow" disabled>',
                '<input type="text" value="" style="width: 120px">',
                '<input type="text" value="" style="width: 200px">',
                '<input type="text" value="" style="width: 80px">',
                '<input type="date" value="" style="width: 200px">',
                '<input type="text" value="" style="width: 200px">',
                '<input type="text" value="" style="width: 200px">',
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
    } );*/
    
     function matriculador(){
        // Loop through grabbing everything
        tableData = $("#matriculadorTable").DataTable();  
        data = tableData.data().toArray();
        info = JSON.stringify(data);
         console.log(tableData);
        console.log(data);
        console.log(info);
        
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
       var myTable = $('#matriculadorTable').DataTable();
 
    $('#matriculadorTable').on( 'click', 'tbody tr', function () {
        myTable.row( this ).delete();
    } );
    
    
    
   function addAlumno() {
    usuario = {username: $("#usernameAl").val(), clave: $("#claveAl").val()};  
    alumno = {nombre: $("#nombreAl").val(),telefono: $("#telAl").val(),email: $("#emailAl").val(), fechaN: $("#fechaN").val(),edad:$("#edadAl").val()};
    carrera = {carrera: $("#carrera").val()};
    data = new FormData();
    data.append("Usuario", JSON.stringify(usuario));
    data.append("Alumno", JSON.stringify(alumno));
    data.append("Carrera", JSON.stringify(carrera));
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
        dataType: "text",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados ");
                      location.href = "goPerfil?idUser="+usuario.username+"&type=Alumno";                    
                },
        error: function (res,status) {
            window.alert("Error del servidor...");
            console.log(usuario);
            console.log(alumno);
            console.log(status +", " +res);
            
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
        dataType: "text",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                     location.href = "goPerfil?idUser="+usuario.username+"&type=Profesor";                    
                },
        error: function (status) {
            window.alert("Error del servidor...");          
            console.log(usuario);
            console.log(profesor);
            console.log(status);
            
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
        error: function (res,status) {
            window.alert("Error del servidor...");          
            console.log(profesor);      
            console.log(status);
            
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

function callModalCrearCarrera(){
  
    $("#crearCarrera").show();
}    
function callModalEditarCarrera(){
    var table = $('#majores').DataTable();
    $('#majores tbody').on( 'click', 'tr', function () {
         $("#codigoCarrera").val(table.row( this ).data()[1]);
         $("#nombreCarrera").val(table.row( this ).data()[2]);
          $("#nivelCarrera").val(table.row( this ).data()[3]);
    } );
   
    $("#edicionCarrera").show();
}
function updateCarrera() {    
    carrera = {codigo:$("#codigoCarrera").val(),nombre: $("#nombreCarrera").val(),titulo: $("#nivelCarrera").val()};
    data = new FormData();  
    data.append("Carrera", JSON.stringify(carrera));
    $.ajax({
        type: "POST",
        url: "ModificarCarrera",
        data: data,
        dataType: "text",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                     location.href = "goPerfil?idUser=116360595"+"&type=undefined";                    
                },
        error: function (status) {
            window.alert("Error del servidor...");          
            console.log(usuario);
            console.log(profesor);
            console.log(status);
            
        }
    });
}

function callModalCrearCurso(){
  
    $("#crearCurso").show();
}    
function callModalEditarCurso(){
     var table = $('#courses').DataTable();
    $('#courses tbody').on( 'click', 'tr', function () {
         $("#codigoCurso").val(table.row( this ).data()[1]);
         $("#nombreCurso").val(table.row( this ).data()[2]);
         $("#creditosCurso").val(table.row( this ).data()[3]);
         $("#horasCurso").val(table.row( this ).data()[4]);
    } );
    $("#edicionCurso").show();
}
function updateCurso() {    
    curso = {codigo:$("#codigoCurso").val(),nombre: $("#nombreCurso").val(),creditos: $("#creditosCurso").val(),horas_semanales: $("#horasCurso").val()};
    data = new FormData();  
    data.append("Curso", JSON.stringify(curso));
    $.ajax({
        type: "POST",
        url: "ModificarCurso",
        data: data,
        dataType: "text",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                     location.href = "goPerfil?idUser=116360595"+"&type=undefined";                    
                },
        error: function (status) {
            window.alert("Error del servidor...");          
            console.log(usuario);
            console.log(profesor);
            console.log(status);
            
        }
    });
}
function callModalCrearAlumno(){   
    $("#crearAlumno").show();
}

function callModalEditarAlumno(){
      var table = $('#students').DataTable();
    $('#students tbody').on( 'click', 'tr', function () {
         $("#cedulalumno").val(table.row( this ).data()[1]);
         $("#nombreAlumno").val(table.row( this ).data()[2]);
         $("#edadAlumno").val(table.row( this ).data()[3]);
         $("#fechaAlumno").val(table.row( this ).data()[4]);
         $("#emailAlumno").val(table.row( this ).data()[5]);
         $("#telefonoAlumno").val(table.row( this ).data()[6]);
         $("#carreraAlumno").val(table.row( this ).data()[7]); 
    } );
    $("#edicionAlumno").show();
}



function updateAlumnoAdmin() {   
    alumno = {cedula: $("#cedulalumno").val(),nombre: $("#nombreAlumno").val(),telefono: $("#telefonoAlumno").val(),email: $("#emailAlumno").val(), fechaN: $("#fechaAlumno").val(),edad:$("#edadAlumno").val()};
    carrera = $("#carreraAlumno").val();
    data = new FormData();   
    data.append("Alumno", JSON.stringify(alumno));
    data.append("Carrera",JSON.stringify(carrera));
    $.ajax({
        type: "POST",
        url: "ModificarAlumnoAdmin",
        data: data,
        dataType: "text",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados ");
                      location.href = "goPerfil?idUser=116360595"+"&type=undefined";                    
                },
        error: function (res,status) {
            window.alert("Error del servidor...");
            console.log(usuario);
            console.log(alumno);
            console.log(status +", " +res);
            
        }
    });
}   

function callModalCrearProfesor(){
  
    $("#crearProfesor").show();
}    

  function callModalEditarProfesor(){
     var table = $('#teachers').DataTable();
    $('#teachers tbody').on( 'click', 'tr', function () {
         $("#cedulaProfesor").val(table.row( this ).data()[1]);
         $("#nombreProfesor").val(table.row( this ).data()[2]);
         $("#edadProfesor").val(table.row( this ).data()[3]); 
         $("#telefonoProfesor").val(table.row( this ).data()[4]);  
         $("#emailProfesor").val(table.row( this ).data()[5]);
              
    } );
    $("#edicionProfesor").show();
}    

 function updateProfesorAdmin() {    
    profesor = {cedula:$("#cedulaProfesor").val(),nombre: $("#nombreProfesor").val(),telefono: $("#telefonoProfesor").val(),email: $("#emailProfesor").val(),edad:$("#edadProfesor").val()};
    data = new FormData();  
    data.append("Profesor", JSON.stringify(profesor));
    $.ajax({
        type: "POST",
        url: "ModificarProfesorAdmin",
        data: data,
        dataType: "text",
        processData: false,
        contentType: false,
        //contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                     window.alert("Datos actualizados");
                     location.href = "goPerfil?idUser=116360595"+"&type=undefined";                    
                },
        error: function (status) {
            window.alert("Error del servidor...");          
            console.log(usuario);
            console.log(profesor);
            console.log(status);
            
        }
    });
}




function closeModalCrearCarrera(){
    $("#crearCarrera").hide();
}

function closeModalCrearCurso(){
    $("#crearCurso").hide();
}

function closeModalEditarCarrera(){
    $("#edicionCarrera").hide();
}

function closeModalEditarCurso(){
    $("#edicionCurso").hide();
}

function closeModalEditarAlumno(){
    $("#edicionAlumno").hide();
}

function closeModalEditarProfesor(){
    $("#edicionProfesor").hide();
}

function closeModalCrearAlumno(){
    $("#crearAlumno").hide();
}

function closeModalCrearProfesor(){
    $("#crearProfesor").hide();
}



function eliminarCarrera(){
    var codigo;
    var table = $('#majores').DataTable();
    $('#majores tbody').on( 'click', 'tr', function () {
     codigo = table.row( this ).data()[1];  
     console.log(codigo);
    } );
   
    bootbox.confirm({
    message: "¿Seguro que desea eliminar el elemento?",
    buttons: {
        confirm: {
            label: 'Yes',
            className: 'btn-success'
        },
        cancel: {
            label: 'No',
            className: 'btn-danger'
        }
    },
    callback: function (result) {
           if(result){
                location.href = "EliminarCarrera?codigo="+codigo;   
           };
    }
});
}
function eliminarCurso(){
    var codigo;
     var table = $('#courses').DataTable();
    $('#courses tbody').on( 'click', 'tr', function () {
         codigo = table.row( this ).data()[1];       
    } );
    bootbox.confirm({
    message: "¿Seguro que desea eliminar el elemento?",
    buttons: {
        confirm: {
            label: 'Yes',
            className: 'btn-success'
        },
        cancel: {
            label: 'No',
            className: 'btn-danger'
        }
    },
    callback: function (result) {
           if(result){
                location.href = "EliminarCurso?codigo="+codigo;   
           };
    }
});
    
}

function eliminarAlumno(){
    var id;
     var table = $('#students').DataTable();
    $('#students tbody').on( 'click', 'tr', function () {
        id =  table.row( this ).data()[1];        
    } );
    bootbox.confirm({
    message: "¿Seguro que desea eliminar el elemento?",
    buttons: {
        confirm: {
            label: 'Yes',
            className: 'btn-success'
        },
        cancel: {
            label: 'No',
            className: 'btn-danger'
        }
    },
    callback: function (result) {
           if(result){
                location.href = "EliminarEstudiante?id="+id;   
           };
    }
});
   
}

function eliminarProfesor(){
    var id;
     var table = $('#teachers').DataTable();
    $('#teachers tbody').on( 'click', 'tr', function () {
      id = table.row( this ).data()[1];                   
    } );
   bootbox.confirm({
    message: "¿Seguro que desea eliminar el elemento?",
    buttons: {
        confirm: {
            label: 'Yes',
            className: 'btn-success'
        },
        cancel: {
            label: 'No',
            className: 'btn-danger'
        }
    },
    callback: function (result) {
           if(result){
                location.href = "EliminarProfesor?id="+id;   
           };
    }
});
    
}

function addAlumno1() {
    alumno = {cedula: $("#cedulalumno1").val(),nombre: $("#nombreAlumno1").val(),telefono: $("#telefonoAlumno1").val(),email: $("#emailAlumno1").val(), fechaN: $("#fechaAlumno1").val(),edad:$("#edadAlumno1").val()};
    carrera = $("#carreraAlumno").val(); 
    data = new FormData();
    data.append("Alumno", JSON.stringify(alumno));
    data.append("Carrera", JSON.stringify(carrera));
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
                       location.href = "goPerfil?idUser=116360595"+"&type=undefined";                       
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");           
            console.log(alumno);
            console.log(errorThrown);
            
        }
    });
} 

function addProfesor1() {
    profesor = {cedula:$("#cedulaProfesor1").val(),nombre: $("#nombreProfesor1").val(),telefono: $("#telefonoProfesor1").val(),email: $("#emailProfesor1").val(),edad:$("#edadProfesor1").val()};
    data = new FormData();
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
                      location.href = "goPerfil?idUser=116360595"+"&type=undefined";                       
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Error del servidor...");                   
            console.log(profesor);
            console.log(errorThrown);
            
        }
    });
}

