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
        caption: "Lista Rolmodulo",
        colNames: ["Editar", "Eliminar", "idRolModulo", "Rol", "Modulo","Pagina Inicio", "Fecha de asignacion", "estado"],
        colModel: [
            {
                name: 'edit',
                index: 'edit',
                editable: false,
                align: "center",
                width: 45,
                search: false,
                hidden: false
            },
            {
                name: 'del',
                index: 'del',
                editable: false,
                align: "center",
                width: 60,
                search: false,
                hidden: false
            },
            {
                name: 'idrolmodulo',
                index: 'idrolmodulo',
                editable: false,
                width: 150,
                hidden: true
            }, {
                name: 'denominacionrol',
                index: 'denominacionrol',
                editable: false,
                width: 150,
                hidden: false
            }, {
                name: 'denominacionmodulo',
                index: 'denominacionmodulo',
                editable: false,
                width: 150,
                hidden: false
            }, {
                name: 'paginainiciomodulo',
                index: 'paginainiciomodulo',
                editable: false,
                width: 150,
                hidden: false
            }, {
                name: 'fechaasignacion',
                index: 'fechaasignacion',
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
    $.ajaxCall(urlApp + '/RolmoduloController/listarRegistrosRolmoduloBE.htm', {poRolmoduloBE: {IndOpSp: 1}}, false, function (response) {
       //alert(JSON.stringify(response));
        $('#grid').jqGrid('clearGridData');
        jQuery("#grid").jqGrid('setGridParam', {data: response}).trigger('reloadGrid');
    });
}


function save() {
    var resulValidacion = 0;
    resulValidacion = $.ValidarData('#form');
    switch (resulValidacion) {
        case 0:
            var Rolmodulo = {
                idrolmodulo: $('#txtIdrolmodulo').val(),
                idrol: $('#txtIdrol').val(),
                idmodulo: $('#txtIdmodulo').val(),
                fechaasignacion: $('#txtFechaasignacion').val(),
                estado: true
            };
            $.ajaxCall(urlApp + '/RolmoduloController/insertarRolmoduloBE.htm', {poRolmoduloBE: Rolmodulo}, false, function (response) {
                if (response > 0) {
                    bootbox.alert(Mensajes.operacionCorrecta);
                    $("#btnNuevo").text('Nuevo');
                    $.DesabilitarForm('#form');
                    $.LimpiarForm('#form');
                    cargarGrilla();

                }
                
                //alert(JSON.stringify(response));

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
        if (rowData.idrolmodulo === id.toString()) {
            $('#txtIdrolmodulo').val(rowData.idrolmodulo);
            $('#txtIdrol').val(rowData.idrol);
            $('#txtIdmodulo').val(rowData.idmodulo);
            $('#txtFechaasignacion').val(rowData.fechaasignacion);
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
            var Rolmodulo = {
                idrolmodulo: $('#container').data('idedit'),
                idrol: $('#txtIdrol').val(),
                idmodulo: $('#txtIdmodulo').val(),
                fechaasignacion: $('#txtFechaasignacion').val(),
                estado: true
            };
            $.ajaxCall(urlApp + '/RolmoduloController/actualizarRolmoduloBE.htm', {poRolmoduloBE: Rolmodulo}, false, function (response) {
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
        var Rolmodulo = {
            IndOpSp: 2,
            idrolmodulo: id //1=consulta por ids
        };
        $.ajaxCall(urlApp + '/RolmoduloController/eliminarRolmoduloBE.htm', {poRolmoduloBE: Rolmodulo}, false, function (response) {
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
    $.CargarCombo(urlApp + '/RolmoduloController/listObjectRolmoduloBE.htm', {poRolmoduloBE: {IndOpSp: 2}}, '#txtIdrol');
    $.CargarCombo(urlApp + '/RolmoduloController/listObjectRolmoduloBE.htm', {poRolmoduloBE: {IndOpSp: 3}}, '#txtIdmodulo');
}
