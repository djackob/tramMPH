$(document).ready(function() {

    $(':text').each(function() {
        var upp = $(this).attr('UpperCases');
        var low = $(this).attr('LowerCases');
        if (!(upp != undefined && low != undefined)) {
            if (upp != undefined) {
                $(this).css('text-transform', 'uppercase');

                $(this).keyup(function() {
                    if ($(this).val() === '') {

                        $(this).css('text-transform', 'lowercase');
                    }
                    else {

                        $(this).css('text-transform', 'uppercase');
                    }
                    $(this).val($(this).val().toUpperCase());

                });
            }
            if (low != undefined) {
                $(this).css('text-transform', 'lowercase');
                $(this).keyup(function() {
                    $(this).val($(this).val().toLowerCase());
                });
            }
        }
    });

    $('textarea').each(function() {
        var upp = $(this).attr('UpperCase');
        var low = $(this).attr('LowerCase');
        if (!(upp != undefined && low != undefined)) {
            if (upp != undefined) {
                $(this).css('text-transform', 'uppercase');
                $(this).keyup(function() {
                    $(this).val($(this).val().toUpperCase());
                });
            }
            if (low != undefined) {
                $(this).css('text-transform', 'lowercase');
                $(this).keyup(function() {
                    $(this).val($(this).val().toLowerCase());
                });
            }
        }
    });

    $(':text').each(function() {

        var sl = $(this).attr('SoloLetras');
        var sn = $(this).attr('SoloNumeros');
        var sd = $(this).attr('SoloDecimales');
        var rpm = $(this).attr('SoloRpmRpc');

        if (sl != undefined) {
            $(this).keypress(function(event) {
                if (event.which == 209 || event.which == 241 || event.which == 32 || (event.which >= 65 && event.which <= 90) || (event.which >= 97 && event.which <= 122)) {
                }
                else {
                    event.preventDefault();
                }
            });
        }
        if (sn != undefined) {
            $(this).keypress(function(event) {
                //alert(event.which)
                if ((event.which != 8 && event.keyCode != 9 && event.keyCode != 0 && event.which < 48) || event.which > 57 && event.which != 118 && event.which != 86 && event.which != 99 && event.which != 67) {
                    event.preventDefault();
                    $(this).val($(this).val().replace('v', ''));
                    $(this).val($(this).val().replace('V', ''));
                    $(this).val($(this).val().replace('c', ''));
                    $(this).val($(this).val().replace('C', ''));
                }
                else {
                    if (BuscaCadenaCaracter($(this).val(), 'V') || BuscaCadenaCaracter($(this).val(), 'v')) {
                        $(this).val($(this).val().replace('v', ''));
                        $(this).val($(this).val().replace('V', ''));
                    }
                    if (BuscaCadenaCaracter($(this).val(), 'C') || BuscaCadenaCaracter($(this).val(), 'c')) {
                        $(this).val($(this).val().replace('c', ''));
                        $(this).val($(this).val().replace('C', ''));
                    }
                }
            });
        }
        if (rpm != undefined) {
            $(this).keypress(function(event) {
                if (event.which && ((event.which != 8 && event.which != 35 && event.which != 42 && event.which < 48) || event.which > 57 && event.which != 118 && event.which != 86 && event.which != 99 && event.which != 67)) {
                    event.preventDefault();
                    $(this).val($(this).val().replace('v', ''));
                    $(this).val($(this).val().replace('V', ''));
                    $(this).val($(this).val().replace('c', ''));
                    $(this).val($(this).val().replace('C', ''));
                }
                else {
                    if (BuscaCadenaCaracter($(this).val(), 'V') || BuscaCadenaCaracter($(this).val(), 'v')) {
                        $(this).val($(this).val().replace('v', ''));
                        $(this).val($(this).val().replace('V', ''));
                    }
                    if (BuscaCadenaCaracter($(this).val(), 'C') || BuscaCadenaCaracter($(this).val(), 'c')) {
                        $(this).val($(this).val().replace('c', ''));
                        $(this).val($(this).val().replace('C', ''));
                    }
                }

            });
        }

        if (sd != undefined) {
            $(this).keypress(function(event) {
                if (event.which && ((event.which != 8 && event.which != 46 && event.which < 48) || event.which > 57)) {
                    event.preventDefault();
                }
            });
            $(this).keyup(function() {
                var val = $(this).val();
                index = val.indexOf(".");
                if (index > 0) {
                    var valdec = val.substring(index + 1, $(this).val().length);
                    var dif = valdec.length - sd;
                    if (dif > 0) {
                        $(this).val(val.substring(0, $(this).val().length - dif));
                    }
                }
            });
            $(this).change(function() {
                var val = $(this).val();
                index = val.indexOf(".");
                if (index > 0) {
                    var valdec = val.substring(index + 1, $(this).val().length);
                    var dif = sd - valdec.length;
                    if (dif == -1) {
                        $(this).val($(this).val() + ".00");
                    }
                    while (dif > 0) {
                        $(this).val($(this).val() + "0");
                        dif--;
                    }
                } else if (index == -1) {
                    if ($(this).val().length > 0) {
                        $(this).val($(this).val() + ".00");
                    }
                }
            });
        }

        var dt = $(this).attr('date');
        if (dt != undefined) {
            $(this).change(function() {
                if ($(this).val() != "") {
                    var tmp = isDate(this);
                    if (tmp)
                        $(this).removeClass("error");
                    else
                        $(this).addClass("error");
                }
            });
        }
    });
});

//valida que la data sea obligatorio
jQuery.Validar = function(div) {
    var resultado = true;
    //$(div + ' :text').css({ 'background': '' });
    $(div + ' :text').each(function() {
        var obl = $(this).attr('obligatorio');
        if (obl != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());
            if (text.length == 0) {
                $(this).addClass("error");
                $(this).change(function() {
                    $(this).removeClass("error");
                });
                resultado = false;
            }
        }
        var dt = $(this).attr('date');
        if (dt != undefined && $(this).is(":visible")) {
            var tmp = isDate(this);
            if (!tmp) {
                $(this).addClass("error");
                resultado = false;
            }
        }
    });

    //$(div + ' textarea').css({ 'background': '' });
    $(div + ' textarea').each(function() {
        var obl = $(this).attr('obligatorio');
        if (obl != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());
            if (text.length == 0) {
                $(this).addClass("error");
                $(this).change(function() {
                    $(this).removeClass("error");
                });
                resultado = false;
            }
        }
    });


    //$(div + ' select').css({ 'background': '' });
    $(div + ' select').each(function() {
        var obl = $(this).attr('obligatorio');
        if (obl != undefined && $(this).is(":visible")) {
            var val = $(this).val();
            if (val == 0 || val == "000" || val == "00000" || val == "000000000000000") {
                $(this).addClass("error");
                $(this).change(function() {
                    $(this).removeClass("error");
                });
                resultado = false;
            }
        }
    });

    return resultado;
}

//valida que la data sea obligatorio
jQuery.ObligarData = function(div) {
    var resultado = true;
    //$(div + ' :text').css({ 'background': '' });
    $(div + ' :text').each(function() {
        var obl = $(this).attr('obligatorio');
        if (obl != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());
            if (text.length == 0) {
                $(this).addClass("error");
                $(this).change(function() {
                    $(this).removeClass("error");
                });
                resultado = false;
            }
        }
        //UN DATE PUEDE O NO SER INGRESADO
        /*var dt = $(this).attr('date');
         if (dt != undefined && $(this).is(":visible")) {
         var tmp = isDate(this);
         if (!tmp) {
         $(this).addClass("error");
         resultado = false;
         }
         }*/
    });

    //$(div + ' textarea').css({ 'background': '' });
    $(div + ' textarea').each(function() {
        var obl = $(this).attr('obligatorio');
        if (obl != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());
            if (text.length == 0) {
                $(this).addClass("error");
                $(this).change(function() {
                    $(this).removeClass("error");
                });
                resultado = false;
            }
        }
    });

    //$(div + ' select').css({ 'background': '' });
    $(div + ' select').each(function() {
        var obl = $(this).attr('obligatorio');
        if (obl != undefined && $(this).is(":visible")) {
            var val = $(this).val();
            if (val == "000000000000") {
                return;
            }
            if ((val == 0) || (val == "000") || (val == "00000") || (val == "000000000000000")) {
                $(this).addClass("error");
                $(this).change(function() {
                    $(this).removeClass("error");
                });
                resultado = false;
            }
        }
    });

    $(div + ' input').each(function() {
        var obl = $(this).attr('obligatorio');
        if (obl != undefined && $(this).is(":visible")) {
            var val = $(this).val();
            if (val == "") {
                $(this).addClass("error");
                $(this).change(function() {
                    $(this).removeClass("error");
                });
                resultado = false;
            }
        }
    });

    return resultado;
}

//valida que la data ingresada sea el correcto
jQuery.VerificarData = function(div) {
    var resultado = true;
    //$(div + ' :text').css({ 'background': '' });
    $(div + ' :text').each(function() {
        var nro = $(this).attr('validarNumero');
        if (nro != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());

            if (text.length != 0) {

                pat = /^\d*$/;

                if (!pat.test(text)) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }



        var de = $(this).attr('validarDecimal');
        if (de != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());

            if (text.length != 0) {

                pat = /^\d*\.?\d+$/;

                if (!pat.test(text)) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }
        var nro = $(this).attr('validarRpm');
        if (nro != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());

            if (text.length != 0) {

                pat = /^[#|*]{1}\d+$/;

                if (!pat.test(text)) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }
        var dt = $(this).attr('validarFecha');
        if (dt != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());

            if (text.length != 0) {

                if (!validarFecha(text)) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }
        var dt2 = $(this).attr('date');
        if (dt2 != undefined && $(this).is(":visible") && $(this).val().length != 0) {
            var tmp = isDate(this);
            if (!tmp) {
                $(this).addClass("error");
                resultado = false;
            }
        }
        var len = $(this).attr('validarTamanio');
        if (len != undefined && $(this).is(":visible")) {
            var tam = $.trim($(this).val()).length;

            if (tam != 0) {

                if (tam < len) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }
        var de = $(this).attr('validarHora');
        if (de != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());

            if (text.length != 0) {

                pat = /^(0[1-9]|1\d|2[0-3]):([0-5]\d)$/;

                if (!pat.test(text)) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }

        var email = $(this).attr('validarCorreo');
        if (email != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());

            if (text.length != 0) {

                pat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

                if (!pat.test(text)) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }
    });

    return resultado;
}

//valida que la data ingresada sea el correcto
jQuery.VerificarFechaMayor = function(div) {
    var resultado = true;
    //$(div + ' :text').css({ 'background': '' });
    $(div + ' :text').each(function() {

        var dtFecha = $(this).attr('validarFechaMayor');
        if (dtFecha != undefined && $(this).is(":visible")) {
            var text = $.trim($(this).val());

            if (text.length != 0) {

                var fechaActual = getFechaActual();
                var fechaIngresada = text;

                if (fechaMayor(fechaIngresada, fechaActual)) {

                    $(this).addClass("error");
                    $(this).change(function() {
                        $(this).removeClass("error");
                    });

                    resultado = false;
                }
            }
        }
    });

    return resultado;
}

jQuery.ValidarData = function(div) {

    var esValido = false;
    esValido = $.ObligarData(div);

    if (!esValido) {

        return -1;
    }

    var esValidoData = false;
    esValidoData = $.VerificarData(div);

    if (!esValidoData) {

        return -2;
    }

    var esValidoFecha = false;
    esValidoData = $.VerificarFechaMayor(div);

    if (!esValidoData) {

        return -3;
    }

    return 0;
}


//valida que la data ingresada sea el correcto
jQuery.LimpiarForm = function(div) {
    //$(div + ' textarea').css({ 'background': '' });
    $(div + ' textarea').each(function() {
        $(this).val('');
    });

    //$(div + ' select').css({ 'background': '' });
    $(div + ' select').each(function() {
        $(this).val(0);
    });

    $(div + ' input').each(function() {
        $(this).val('');
        $(this).prop('checked', false)
    });
}


function BuscaCadenaCaracter(texto, caracter) {
    for (i = 0; i < texto.length; i++) {
        if (texto.charAt(i) == caracter)
            return true;
    }
    return false
}

jQuery.DesabilitarForm = function(div) {
    //$(div + ' textarea').css({ 'background': '' });
    $(div + ' textarea').each(function() {
        var inafect = $(this).attr('inafecto');
        if (inafect != undefined) {

        }
        else {
            $(this).attr('disabled', 'disabled');
            $(this).removeClass('error');
        }



    });

    //$(div + ' select').css({ 'background': '' });
    $(div + ' select').each(function() {
        var inafect = $(this).attr('inafecto');
        if (inafect != undefined) {

        }
        else {
            $(this).attr('disabled', 'disabled');
            $(this).removeClass('error');
        }
    });

    $(div + ' input').each(function() {
        var inafect = $(this).attr('inafecto');
        if (inafect != undefined) {

        }
        else {
            $(this).attr('disabled', 'disabled');
            $(this).removeClass('error');
        }
    });
}


jQuery.HabilitarForm = function(div) {
    //$(div + ' textarea').css({ 'background': '' });
    $(div + ' textarea').each(function() {
        var inafect = $(this).attr('inafecto');
        if (inafect != undefined) {

        }
        else {
            $(this).removeAttr('disabled');
        }

    });

    //$(div + ' select').css({ 'background': '' });
    $(div + ' select').each(function() {
        var inafect = $(this).attr('inafecto');
        if (inafect != undefined) {

        }
        else {
            $(this).removeAttr('disabled');
        }
    });

    $(div + ' input').each(function() {
        var inafect = $(this).attr('inafecto');
        if (inafect != undefined) {

        }
        else {
            $(this).removeAttr('disabled');
        }
    });
}
