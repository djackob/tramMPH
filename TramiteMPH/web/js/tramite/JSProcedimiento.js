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
$(function () {
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
$(function () {

    $("#btnNuevo").click(function (e) {

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

    $("#btnCancelar").click(function (e) {
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
    loadCombos();
}

function crearGrilla() {
    $("#grid").jqGrid({
        /*data: mydata,*/
        datatype: "local",
        height: 300,
        width: 500,
        caption: "Lista Procedimiento",
        colNames: ["Edit", "Del", "idprocedimiento", "idarea", "codigo", "denominacion", "plazo(dias)", "idcargoresolutor", "descripcion", "estado"],
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
                name: 'idprocedimiento',
                index: 'idprocedimiento',
                editable: false,
                width: 150,
                hidden: true
            }, {
                name: 'idarea',
                index: 'idarea',
                editable: false,
                width: 150,
                hidden: true
            }, {
                name: 'codigo',
                index: 'codigo',
                editable: false,
                width: 120,
                hidden: false
            }, {
                name: 'denominacion',
                index: 'denominacion',
                editable: false,
                width: 150,
                hidden: false
            }, {
                name: 'plazodias',
                index: 'plazodias',
                editable: false,
                width: 60,
                hidden: false
            }, {
                name: 'idcargoresolutor',
                index: 'idcargoresolutor',
                editable: false,
                width: 150,
                hidden: true
            }, {
                name: 'descripcion',
                index: 'descripcion',
                editable: false,
                width: 150,
                hidden: false
            }, {
                name: 'estado',
                index: 'estado',
                editable: false,
                width: 150,
                hidden: true
            }],
        pager: '#pager',
        //onSelectRow: viewGeometry,
        viewrecords: true,
        shrinkToFit: false,
        //multiselect: true
    });
    jQuery("#grid").jqGrid('filterToolbar', {stringResult: true, searchOnEnter: false});
}

function cargarGrilla() {
    $.ajaxCall(urlApp + '/ProcedimientoController/listarRegistrosProcedimientoBE.htm', {poProcedimientoBE: {IndOpSp: 1}}, false, function (response) {
        $('#grid').jqGrid('clearGridData');
        jQuery("#grid").jqGrid('setGridParam', {data: response}).trigger('reloadGrid');
    });
}


function save() {
    var resulValidacion = 0;
    resulValidacion = $.ValidarData('#form');
    switch (resulValidacion) {
        case 0:
            var Procedimiento = {
                idprocedimiento: $('#txtIdprocedimiento').val(),
                idarea: $('#txtIdarea').val(),
                codigo: $('#txtCodigo').val(),
                denominacion: $('#txtDenominacion').val(),
                plazodias: $('#txtPlazodias').val(),
                idcargoresolutor: $('#txtIdcargoresolutor').val(),
                descripcion: $('#txtDescripcion').val(),
                estado: true
            };
            $.ajaxCall(urlApp + '/ProcedimientoController/insertarProcedimientoBE.htm', {poProcedimientoBE: Procedimiento}, false, function (response) {
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
        if (rowData.idprocedimiento === id.toString()) {
            $('#txtIdprocedimiento').val(rowData.idprocedimiento);
            $('#txtIdarea').val(rowData.idarea);
            $('#txtCodigo').val(rowData.codigo);
            $('#txtDenominacion').val(rowData.denominacion);
            $('#txtPlazodias').val(rowData.plazodias);
            $('#txtIdcargoresolutor').val(rowData.idcargoresolutor);
            $('#txtDescripcion').val(rowData.descripcion);
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
            var Procedimiento = {
                idprocedimiento: $('#container').data('idedit'),
                idarea: $('#txtIdarea').val(),
                codigo: $('#txtCodigo').val(),
                denominacion: $('#txtDenominacion').val(),
                plazodias: $('#txtPlazodias').val(),
                idcargoresolutor: $('#txtIdcargoresolutor').val(),
                descripcion: $('#txtDescripcion').val(),
                estado: true
            };
            $.ajaxCall(urlApp + '/ProcedimientoController/actualizarProcedimientoBE.htm', {poProcedimientoBE: Procedimiento}, false, function (response) {
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
    var eliminar = function () {
        var Procedimiento = {
            IndOpSp: 2,
            idprocedimiento: id //1=consulta por ids
        };
        $.ajaxCall(urlApp + '/ProcedimientoController/eliminarProcedimientoBE.htm', {poProcedimientoBE: Procedimiento}, false, function (response) {
            if (response > 0) {
                bootbox.alert(Mensajes.operacionCorrecta);
                $("#btnNuevo").text('Nuevo');
                $.DesabilitarForm('#form');
                $.LimpiarForm('#form');
                cargarGrilla();
            }
        });
    };

    bootbox.confirm(Mensajes.deseaEliminar, function (result) {
        if (result == true) {
            eliminar();
        }
        else {

        }
    });


}
function loadCombos() {
    $.CargarCombo(urlApp + '/ProcedimientoController/listObjectProcedimientoBE.htm', {poProcedimientoBE: {IndOpSp: 1}}, '#txtIdarea');
    $.CargarCombo(urlApp + '/ProcedimientoController/listObjectProcedimientoBE.htm', {poProcedimientoBE: {IndOpSp: 2}}, '#txtIdcargoresolutor');
}
