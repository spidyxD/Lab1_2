/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function doLogin() {
    usuario = {username: $("#username").val(), password: $("#password").val()};
    $.ajax({type: "POST",
        url: "doLogin",
        data: JSON.stringify(usuario),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success:
                function () {
                    console.log("success");
                    console.log(usuario);
                },
         error: function (jqXHR, textStatus, errorThrown) {
            window.alert(errorThrown);
            console.log(usuario);
        }
    });
}

function validateLogin() {
    usuario = {username: $("#username").val(), clave: $("#password").val()};
    //data = new FormData();
    //data.append("usuario", JSON.stringify(usuario));
    $.ajax({
        type: "POST",
        url: "doLogin",
        data: JSON.stringify(usuario),
        dataType: "json",       
        contentType: "application/json; charset=utf-8",
        success:
                function () {
                     console.log("success");
                      console.log(usuario);
                },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert(errorThrown);
            console.log(usuario);
            
        }
    });
}