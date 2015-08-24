/*!
 * Author: Erick Escalante Olano
 * Description:
 *      Archivo JS para adminitracion 
 !**/

/*
 * Global variables. If you change any of these vars, don't forget 
 * to change the values in the less files!
 */
/*
 /* INITIALIZE 
 * ------------------------
 */
$(function() {
    initlogin();

    $("#btnLogin").click(function(e) {
        login();
    });

    $('#txtpassword').on('keypress', function(e) {

        if (e.keyCode == 13) {
            login();
        }


    });

    $("#txtusuario").focusout(function(e) {
        if ($("#txtusuario").val() !== '')
        {
            $('#msg').text('');
        }
        else {
            $('#msg').text(Mensajes.camposRequeridos2);
        }
    });

    $("#txtpassword").focusout(function(e) {
        if ($("#txtpassword").val() !== '')
        {
            $('#msg').text('');
        }
        else {
            $('#msg').text(Mensajes.camposRequeridos2);
        }
    });

});


function initlogin() {
    $.ajaxCall(urlApp + '/UsuarioController/initlogin.htm', {}, false, function(response) {
        if (response == null) {
        }
        else {
            window.location.href = urlApp + '/pages/template/portada.jsp';
        }

    });
}


function login() {
    var resulValidacion = 0;
    resulValidacion = $.ValidarData('#form');
    switch (resulValidacion) {
        case 0:
            var Usuario = {
                IndOpSp: 2,
                usuario: $('#txtusuario').val(),
                contrasenia: $('#txtpassword').val()
            };
            $.ajaxCall(urlApp + '/UsuarioController/iniciarsession.htm', {poUsuarioBE: Usuario}, false, function(response) {
                if (response == null) {
                    $('#msg').text("El usuario y/o contraseñas son incorrectas.");
                }
                else {
                    $('#msg').text("");
                    window.location.href = urlApp + '/pages/template/portada.jsp';
                }
            });
            break;
        case -1:
            $('#msg').text(Mensajes.camposRequeridos2);
            break;
        case -2:
            $('#msg').text(Mensajes.camposIncorrectos2);
            break;

    }
}
