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
    initForm();
    crearGrilla();
    cargarGrilla();
        $('#containerGrilla').bind('resize', function () {
            $("#grid").setGridWidth($('#containerGrilla').width());
        }).trigger('resize');
});

     /*EVENTS
     * ------------------------
     */
$(function() {

    $("#btnNuevo").click(function(e) {

        if ($("#btnNuevo").text() === 'Nuevo') {
            $.HabilitarForm('#form');
            $("#btnNuevo").text('Guardar');
            return;
        }
        if ($("#btnNuevo").text() === 'Guardar') {
            save();
            return;
        }

        if ($("#btnNuevo").text() === 'Actualizar') {
            actualizar();
        }
        e.stopPropagation();
    });

    $("#btnCancelar").click(function(e) {
        $.DesabilitarForm('#form');
        $.LimpiarForm('#form');
        $("#btnNuevo").text('Nuevo');
    });


});


     /* FUNCTIONS
     * ------------------------
     */
function initForm() {
    $.DesabilitarForm('#form');
    $.LimpiarForm('#form');
    $("#btnNuevo").text('Nuevo');
    loadCombos();}

function crearGrilla() {
    $("#grid").jqGrid({
        /*data: mydata,*/
        datatype: "local",
        height: 300,
        width: 500,
        caption: "Lista Usuariocargo",
        colNames: ["Edit", "Del","idusuariocargo","idusuario","idcargo","fechaasignado","estado"],
        colModel: [
            {
                name: 'edit',
                index: 'edit',
                editable: false,
                align: "center",
                width: 40,
                search: false,
                hidden: false
            },
            {
                name: 'del',
                index: 'del',
                editable: false,
                align: "center",
                width: 40,
                search: false,
                hidden: false
            },
{
                name: 'idusuariocargo',
                index: 'idusuariocargo',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idusuario',
                index: 'idusuario',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idcargo',
                index: 'idcargo',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'fechaasignado',
                index: 'fechaasignado',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'estado',
                index: 'estado',
                editable: false,
                width: 150,
                hidden: false
            }        ],
        pager: '#pager',
        //onSelectRow: viewGeometry,
        viewrecords: true,
        shrinkToFit: false,
        //multiselect: true
    });
    jQuery("#grid").jqGrid('filterToolbar', {stringResult: true, searchOnEnter: false});
}

function cargarGrilla() {
    $.ajaxCall(urlApp +'/UsuariocargoController/listarRegistrosUsuariocargoBE.htm', {poUsuariocargoBE: {IndOpSp: 1}}, false, function(response) {
        $('#grid').jqGrid('clearGridData');
        jQuery("#grid").jqGrid('setGridParam', {data: response}).trigger('reloadGrid');
    });
}


function save() {
    var resulValidacion = 0;
    resulValidacion = $.ValidarData('#form');
    switch (resulValidacion) {
        case 0:
            var Usuariocargo = {
 idusuariocargo: $('#txtIdusuariocargo').val(),
 idusuario: $('#txtIdusuario').val(),
 idcargo: $('#txtIdcargo').val(),
 fechaasignado: $('#txtFechaasignado').val(),
 estado: true
            };
            $.ajaxCall(urlApp +'/UsuariocargoController/insertarUsuariocargoBE.htm', {poActividadBE: Actividad}, false, function(response) {
                if (response > 0) {
                    bootbox.alert(Mensajes.operacionCorrecta);
                    $("#btnNuevo").text('Nuevo');
                    $.DesabilitarForm('#form');
                    $.LimpiarForm('#form');
                    cargarGrilla();

                }
            });
            break;
        case -1:
            bootbox.alert(Mensajes.camposRequeridos);
            break;
        case -2:
            bootbox.alert(Mensajes.camposIncorrectos);
            break;

    }
}

function edit(id) {
    $('#container').data('idedit', id);
    var rowIds = $('#grid').jqGrid('getDataIDs');

    for (var i = 1; i <= rowIds.length; i++) {
        rowData = $('#grid').jqGrid('getRowData', i);
        if (rowData.idusuariocargo === id.toString()) {
            $('#txtIdusuariocargo').val(rowData.idusuariocargo);
            $('#txtIdusuario').val(rowData.idusuario);
            $('#txtIdcargo').val(rowData.idcargo);
            $('#txtFechaasignado').val(rowData.fechaasignado);
             $('#txtEstado').val(rowData.estado);
            $("#btnNuevo").text('Actualizar');
            $.HabilitarForm('#form');
        } //if
    } //for
}

function actualizar() {

    var resulValidacion = 0;
    resulValidacion = $.ValidarData('#form');
    switch (resulValidacion) {
        case 0:
            var Usuariocargo = {
 idusuariocargo: $('#container').data('idedit'),
 idusuario: $('#txtIdusuario').val(),
 idcargo: $('#txtIdcargo').val(),
 fechaasignado: $('#txtFechaasignado').val(),
 estado: true
};
            $.ajaxCall(urlApp +'/UsuariocargoController/actualizarUsuariocargoBE.htm', {poUsuariocargoBE: Usuariocargo}, false, function(response) {
                if (response > 0) {
                    bootbox.alert(Mensajes.operacionCorrecta);
                    $("#btnNuevo").text('Nuevo');
                    $.DesabilitarForm('#form');
                    $.LimpiarForm('#form');
                    cargarGrilla();

                }
            });
            break;
        case -1:
            bootbox.alert(Mensajes.camposRequeridos);
            break;
        case -2:
            bootbox.alert(Mensajes.camposIncorrectos);
            break;

    }
}

function del(id) {
    var eliminar = function() {
        var Usuariocargo = {
            IndOpSp: 2,
            idusuariocargo: id //1=consulta por ids
        };
        $.ajaxCall(urlApp +'/UsuariocargoController/eliminarUsuariocargoBE.htm', {poUsuariocargoBE: Usuariocargo}, false, function(response) {
            if (response > 0) {
                bootbox.alert(Mensajes.operacionCorrecta);
                $("#btnNuevo").text('Nuevo');
                $.DesabilitarForm('#form');
                $.LimpiarForm('#form');
                cargarGrilla();
            }
        });
    };

    bootbox.confirm(Mensajes.deseaEliminar, function(result) {
        if (result == true) {
            eliminar();
        }
        else {

        }
    });


} function loadCombos() {
$.CargarCombo(urlApp + '/UsuariocargoController/listObjectSectorBE.htm', {poUsuariocargoBE: {IndOpSp: 1}}, '#txtIdusuario');$.CargarCombo(urlApp + '/UsuariocargoController/listObjectSectorBE.htm', {poUsuariocargoBE: {IndOpSp: 1}}, '#txtIdcargo');}
