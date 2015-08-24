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
        caption: "Lista Expediente",
        colNames: ["Edit", "Del","idexpediente","idusuariocargo","idprocedimiento","idarea","codigo","dni_ruc","nombre_razonsocial","apellidos","direccion","telefono","correo","asunto","estado"],
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
                name: 'idexpediente',
                index: 'idexpediente',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idusuariocargo',
                index: 'idusuariocargo',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idprocedimiento',
                index: 'idprocedimiento',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idarea',
                index: 'idarea',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'codigo',
                index: 'codigo',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'dni_ruc',
                index: 'dni_ruc',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'nombre_razonsocial',
                index: 'nombre_razonsocial',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'apellidos',
                index: 'apellidos',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'direccion',
                index: 'direccion',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'telefono',
                index: 'telefono',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'correo',
                index: 'correo',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'asunto',
                index: 'asunto',
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
    $.ajaxCall(urlApp +'/ExpedienteController/listarRegistrosExpedienteBE.htm', {poExpedienteBE: {IndOpSp: 1}}, false, function(response) {
        $('#grid').jqGrid('clearGridData');
        jQuery("#grid").jqGrid('setGridParam', {data: response}).trigger('reloadGrid');
    });
}


function save() {
    var resulValidacion = 0;
    resulValidacion = $.ValidarData('#form');
    switch (resulValidacion) {
        case 0:
            var Expediente = {
 idexpediente: $('#txtIdexpediente').val(),
 idusuariocargo: $('#txtIdusuariocargo').val(),
 idprocedimiento: $('#txtIdprocedimiento').val(),
 idarea: $('#txtIdarea').val(),
 codigo: $('#txtCodigo').val(),
 dni_ruc: $('#txtDni_ruc').val(),
 nombre_razonsocial: $('#txtNombre_razonsocial').val(),
 apellidos: $('#txtApellidos').val(),
 direccion: $('#txtDireccion').val(),
 telefono: $('#txtTelefono').val(),
 correo: $('#txtCorreo').val(),
 asunto: $('#txtAsunto').val(),
 estado: true
            };
            $.ajaxCall(urlApp +'/ExpedienteController/insertarExpedienteBE.htm', {poActividadBE: Actividad}, false, function(response) {
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
        if (rowData.idexpediente === id.toString()) {
            $('#txtIdexpediente').val(rowData.idexpediente);
            $('#txtIdusuariocargo').val(rowData.idusuariocargo);
            $('#txtIdprocedimiento').val(rowData.idprocedimiento);
            $('#txtIdarea').val(rowData.idarea);
            $('#txtCodigo').val(rowData.codigo);
            $('#txtDni_ruc').val(rowData.dni_ruc);
            $('#txtNombre_razonsocial').val(rowData.nombre_razonsocial);
            $('#txtApellidos').val(rowData.apellidos);
            $('#txtDireccion').val(rowData.direccion);
            $('#txtTelefono').val(rowData.telefono);
            $('#txtCorreo').val(rowData.correo);
            $('#txtAsunto').val(rowData.asunto);
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
            var Expediente = {
 idexpediente: $('#container').data('idedit'),
 idusuariocargo: $('#txtIdusuariocargo').val(),
 idprocedimiento: $('#txtIdprocedimiento').val(),
 idarea: $('#txtIdarea').val(),
 codigo: $('#txtCodigo').val(),
 dni_ruc: $('#txtDni_ruc').val(),
 nombre_razonsocial: $('#txtNombre_razonsocial').val(),
 apellidos: $('#txtApellidos').val(),
 direccion: $('#txtDireccion').val(),
 telefono: $('#txtTelefono').val(),
 correo: $('#txtCorreo').val(),
 asunto: $('#txtAsunto').val(),
 estado: true
};
            $.ajaxCall(urlApp +'/ExpedienteController/actualizarExpedienteBE.htm', {poExpedienteBE: Expediente}, false, function(response) {
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
        var Expediente = {
            IndOpSp: 2,
            idexpediente: id //1=consulta por ids
        };
        $.ajaxCall(urlApp +'/ExpedienteController/eliminarExpedienteBE.htm', {poExpedienteBE: Expediente}, false, function(response) {
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
$.CargarCombo(urlApp + '/ExpedienteController/listObjectSectorBE.htm', {poExpedienteBE: {IndOpSp: 1}}, '#txtIdusuariocargo');$.CargarCombo(urlApp + '/ExpedienteController/listObjectSectorBE.htm', {poExpedienteBE: {IndOpSp: 1}}, '#txtIdprocedimiento');$.CargarCombo(urlApp + '/ExpedienteController/listObjectSectorBE.htm', {poExpedienteBE: {IndOpSp: 1}}, '#txtIdarea');}
