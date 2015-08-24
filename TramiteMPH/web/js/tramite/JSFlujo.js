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
        caption: "Lista Flujo",
        colNames: ["Edit", "Del","idflujo","idexpediente","idestadoflujo","idusuario","idusuarioenvia","idusuariorecepciona","fechaenvio","fechalectura","asunto","descripcion","observacion","binderror","estado"],
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
                name: 'idflujo',
                index: 'idflujo',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idexpediente',
                index: 'idexpediente',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idestadoflujo',
                index: 'idestadoflujo',
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
                name: 'idusuarioenvia',
                index: 'idusuarioenvia',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'idusuariorecepciona',
                index: 'idusuariorecepciona',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'fechaenvio',
                index: 'fechaenvio',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'fechalectura',
                index: 'fechalectura',
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
                name: 'descripcion',
                index: 'descripcion',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'observacion',
                index: 'observacion',
                editable: false,
                width: 150,
                hidden: false
            },{
                name: 'binderror',
                index: 'binderror',
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
    $.ajaxCall(urlApp +'/FlujoController/listarRegistrosFlujoBE.htm', {poFlujoBE: {IndOpSp: 1}}, false, function(response) {
        $('#grid').jqGrid('clearGridData');
        jQuery("#grid").jqGrid('setGridParam', {data: response}).trigger('reloadGrid');
    });
}


function save() {
    var resulValidacion = 0;
    resulValidacion = $.ValidarData('#form');
    switch (resulValidacion) {
        case 0:
            var Flujo = {
 idflujo: $('#txtIdflujo').val(),
 idexpediente: $('#txtIdexpediente').val(),
 idestadoflujo: $('#txtIdestadoflujo').val(),
 idusuario: $('#txtIdusuario').val(),
 idusuarioenvia: $('#txtIdusuarioenvia').val(),
 idusuariorecepciona: $('#txtIdusuariorecepciona').val(),
 fechaenvio: $('#txtFechaenvio').val(),
 fechalectura: $('#txtFechalectura').val(),
 asunto: $('#txtAsunto').val(),
 descripcion: $('#txtDescripcion').val(),
 observacion: $('#txtObservacion').val(),
 binderror: $('#txtBinderror').val(),
 estado: true
            };
            $.ajaxCall(urlApp +'/FlujoController/insertarFlujoBE.htm', {poActividadBE: Actividad}, false, function(response) {
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
        if (rowData.idflujo === id.toString()) {
            $('#txtIdflujo').val(rowData.idflujo);
            $('#txtIdexpediente').val(rowData.idexpediente);
            $('#txtIdestadoflujo').val(rowData.idestadoflujo);
            $('#txtIdusuario').val(rowData.idusuario);
            $('#txtIdusuarioenvia').val(rowData.idusuarioenvia);
            $('#txtIdusuariorecepciona').val(rowData.idusuariorecepciona);
            $('#txtFechaenvio').val(rowData.fechaenvio);
            $('#txtFechalectura').val(rowData.fechalectura);
            $('#txtAsunto').val(rowData.asunto);
            $('#txtDescripcion').val(rowData.descripcion);
            $('#txtObservacion').val(rowData.observacion);
            $('#txtBinderror').val(rowData.binderror);
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
            var Flujo = {
 idflujo: $('#container').data('idedit'),
 idexpediente: $('#txtIdexpediente').val(),
 idestadoflujo: $('#txtIdestadoflujo').val(),
 idusuario: $('#txtIdusuario').val(),
 idusuarioenvia: $('#txtIdusuarioenvia').val(),
 idusuariorecepciona: $('#txtIdusuariorecepciona').val(),
 fechaenvio: $('#txtFechaenvio').val(),
 fechalectura: $('#txtFechalectura').val(),
 asunto: $('#txtAsunto').val(),
 descripcion: $('#txtDescripcion').val(),
 observacion: $('#txtObservacion').val(),
 binderror: $('#txtBinderror').val(),
 estado: true
};
            $.ajaxCall(urlApp +'/FlujoController/actualizarFlujoBE.htm', {poFlujoBE: Flujo}, false, function(response) {
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
        var Flujo = {
            IndOpSp: 2,
            idflujo: id //1=consulta por ids
        };
        $.ajaxCall(urlApp +'/FlujoController/eliminarFlujoBE.htm', {poFlujoBE: Flujo}, false, function(response) {
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
$.CargarCombo(urlApp + '/FlujoController/listObjectSectorBE.htm', {poFlujoBE: {IndOpSp: 1}}, '#txtIdexpediente');$.CargarCombo(urlApp + '/FlujoController/listObjectSectorBE.htm', {poFlujoBE: {IndOpSp: 1}}, '#txtIdestadoflujo');$.CargarCombo(urlApp + '/FlujoController/listObjectSectorBE.htm', {poFlujoBE: {IndOpSp: 1}}, '#txtIdusuario');$.CargarCombo(urlApp + '/FlujoController/listObjectSectorBE.htm', {poFlujoBE: {IndOpSp: 1}}, '#txtIdusuarioenvia');$.CargarCombo(urlApp + '/FlujoController/listObjectSectorBE.htm', {poFlujoBE: {IndOpSp: 1}}, '#txtIdusuariorecepciona');}
