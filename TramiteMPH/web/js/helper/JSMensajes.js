
var Mensajes = {
    zoom: '<i class="fa fa-search-plus fa-2x"></i> Mantener presionado la tecla <b>Shift</b> y dibuje sobre el mapa.',
    contraseniaNoCoincide: 'La contraseña no coincide con el del usuario',
    correctoCambioContrsenia: 'Se realizo correctamente el cambio de contraseña.',
    contraseniasNoCoinciden: 'Las contraseñas no coinciden',
    errorConeccionBD: 'Error en la coneccion de la base de datos',
    errorUsuarioPass: '<i class="fa fa-exclamation-triangle fa-2x"></i> Error en el usuario o password.',
    ingresoCorrecto: '<i class="fa fa-check fa-2x"></i> Ingreso correcto.',
    camposRequeridos: '<i class="fa fa-exclamation-triangle fa-2x"></i> Existen campos requeridos.',
    camposRequeridos2: 'Existen campos requeridos.',
    camposIncorrectos: '<i class="fa fa-exclamation-triangle fa-2x"></i> Existen campos icorrectos.',
    camposIncorrectos2: 'Existen campos icorrectos.',
    operacionCorrecta: '<i class="fa fa-check fa-2x"></i> Operacion correcta.',
    operacionErronea: '<i class="fa fa-exclamation-triangle fa-2x"></i> Error en la operacion.',
    salio: '<i class="fa fa-check-square fa-2x"></i> Salio del sistema.',
    configuracionGuardada: '<i class="fa fa-exclamation-triangle fa-2x"></i> La configuracion fue correctamente guardada.',
    errorguardarConfig: '<i class="fa fa-check fa-2x"></i> Error el intertar guardar la configuracion.',
    reinicioSistema: '<i class="fa fa-exclamation-triangle fa-2x"></i> El sistema se reiniciara.',
    sinresultado: '<i class="fa fa-exclamation-triangle fa-2x"></i> Nose encontraron resultados para esta busqueda.',
    deseaEliminar: '¿Desea eliminar este registro.?',
    deseaEditar: '¿Desea editar este registro.?',
    correctoActualizacionDia: '<i class="fa fa-exclamation-triangle fa-2x"></i> La actualizacion del Dia fue correctamente ejecutado.',
    correctoEliminacionDia: '<i class="fa fa-check-square"> Se elimino correctamente el Dia.',
    deseaEliminarDia: '¿Desea eliminar layer Dia?',
    actualizacionMesaCorrecta: '<i class="fa fa-exclamation-triangle fa-2x"></i> La actualizacion del Mesa fue correctamente ejecutado.',
    anioDuplicado: '<i style="color:red "class="fa fa-exclamation-triangle fa-2x"></i>  El año registrado ya existe.',
};

var Texto = {
    txtleyendaDias: 'Mostrar Leyenda de Dias',
    captionGrillaCliente: 'Lista de Clientes Filtrados',
    infoClienteText: 'Pase el mouse sobre una Dia',
    tituloCapaDias: 'Capa de Dias',
    infoClienteTextCapa: 'Capa',
    infoClienteTextCantidadClientes: 'Cantidad clientes',
    //
    textLeyendRutas: 'Mostrar Legend Rutas',
    infoLayerRutasHover: 'Pase el mouse sobre una Ruta',
    infoLayerRutastituloCapaRutas: 'Capa de Rutas',
    infoLayerRutasDia: 'Dia',
    infoLayerRutasMesa: 'Mesa',
    infoLayerRutasRuta: 'Ruta',
    infoLayerRutasCantClientes: 'Cantidad clientes',
    //
    textLeyendMesas: ' Mostrar Legend Mesas',
    infoLayerMesasHover: 'Pase el mouse sobre una Mesa',
    infoLayerMesasTitulo: 'Capa de Mesas',
    infoLayerMesasMesa: 'Mesa',
    infoLayerMesasClientes: 'Cantidad clientes',
    //
    textLeyendSquare0005: ' Mostrar Legend Square0005',
    infoClienteSquare0005Hover: 'Pase el mouse sobre una Square0005',
    infoClienteSquare0005Titulo: 'Capa de Square0005',
    infoClienteSquare0005NCliente: 'Nº Clientes',
    textLeyendSquare00025: ' Mostrar Legend Square00025',
    infoClienteSquare00025Hover: 'Pase el mouse sobre una Square00025',
    infoClienteSquare00025Titulo: 'Capa de Square00025',
    infoClienteSquare00025NCliente: 'Nº Clientes',
    textLeyendHexagono0005: ' Mostrar Legend Hexagono0005',
    infoClienteHexagono0005Hover: 'Pase el mouse sobre una Hexagono0005',
    infoClienteHexagono0005Titulo: 'Capa de Hexagono0005',
    infoClienteHexagono0005NCliente: 'Nº Clientes',
    textLeyendHexagono00025: ' Mostrar Legend Hexagono00025',
    infoClienteHexagono00025Hover: 'Pase el mouse sobre una Hexagono00025',
    infoClienteHexagono00025Titulo: 'Capa de Hexagono00025',
    infoClienteHexagono00025NCliente: 'Nº Clientes',
    ctxMenuMap_coordenadas: 'Coordenadas',
    ctxMenuMap_CentrarMapa: 'Centrar mapa aqui',
    ctxMenuMap_separador: '-',
    ctxMenuMap_Acercar: 'Acercar',
    ctxMenuMap_Alejar: 'Alejar',
    ctxMenuMap_StreetView: 'Ver calle',
    mapAtribution1: '&copy; <a href="http://openstreetmap.org">OpenStreetMap</a>',
    mapAtribution2: '&copy; <a href="http://www.opencyclemap.org">OpenCycleMap</a>',
    mapAtribution3: 'Imagery from <a href="http://giscience.uni-hd.de/">GIScience Research Group @ University of Heidelberg</a> &mdash; Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>',
    mapAtribution4: 'Tiles &copy; Esri &mdash;',
    mapAtribution5: 'Tiles &copy; Esri &mdash;',
    LRutas: 'Rutas',
    LMesas: 'Mesas',
    LDias: 'Dias',
    errorDrawPolygon: '<strong>No es posible el cruce, elija otra cordenada<strong>',
    ctxMenuonDraw_consultarClientesFiltrados: 'Consultar clientes filtrados',
    ctxMenuonDraw_mostrarTodosClientes: 'Mostrar todos los clientes',
    ctxMenuonDraw_consultarClienteS: 'Consultar Clientes S',
    ctxMenuonDraw_consultarClienteSE: 'Exportar Clientes S',
    ctxMenuonDraw_consultarClienteQ: 'Consultar Clientes Q',
    ctxMenuonDraw_consultarClienteQE: 'Exportar Clientes Q',
    ctxMenuonDraw_consultarClienteM: 'Consultar Clientes M',
    ctxMenuonDraw_consultarClienteME: 'Exportar Clientes M',
    ctxMenuonDraw_consultarClienteSQM: 'Consultar Clientes S Q M',
    ctxMenuonDraw_consultarClienteSQME: 'Exportar Clientes S Q M',
    ctxMenuonDraw_exportarTodosClientes: 'Exportar todos los clientes',
    ctxMenuonDraw_ConsultarVentasFiltradas: 'Consultar Ventas Filtradas',
    ctxMenuonDraw_DetalleVentasFiltradas: 'Exportar detalle de ventas',
    ctxMenuonDraw_ExportarClientesFacturados: 'Exportar clientes facturados',
    ctxMenuonDraw_MostrarClienteFacturados: 'Mostrar clientes facturados',
    ctxMenuonDraw_ExportarClientesNoFacturados: 'Exportar clientes no facturados',
    ctxMenuonDraw_MostrarClienteNoFacturados: 'Mostrar clientes no facturados',
    ctxMenuonDraw_MostrarEstadisticasGrupoVenta: 'Mostrar Estadisticas Grupo Ventas',
    ctxMenuonDraw_MostrarEstadisticasFuerzaVenta: 'Mostrar Estadisticas Fuerza Ventas',
    ctxMenuonDraw_guardarGeometria: 'Guardar geometria',
    ctxMenuonDraw_editarGeometria: 'Editar geometria',
    ctxMenuonDraw_eliminarGeometria: 'Eliminar geometria',
    ctxMenuonDraw_guardarLdia: 'Guardar Ldia',
    ctxMenuonDraw_guardarLmesa: 'Guardar Lmesa',
    ctxMenuonDraw_guardarLruta: 'Guardar Lruta',
    calendarSeparadorRango: ' hasta ',
    nonSelectedText: 'Seleccione una o varias opciones',
    charGrupoVentaTitle: 'Grupos de Venta',
    charFuerzaVentaTitle: 'Fuerza de Venta',
    textLeyendVentaDias: ' Mostrar Legend Dias',
    infoLayerVentaDiasHover: 'Pase el mouse sobre un Dia',
    infoLayerVentaDiasTitulo: 'Capa de Dias',
    infoLayerVentaDiasDia: 'Dia',
    infoLayerVentaDiasCosto: 'COSTO VENTA',
    infoLayerVentaDiasVenta: 'VENTA',
    infoLayerVentaDiasUtilidad: 'UTILIDAD',
    textLeyendVentaMesas: ' Mostrar Legend Dias',
    infoLayerVentaMesasHover: 'Pase el mouse sobre un Dia',
    infoLayerVentaMesasTitulo: 'Capa de Mesas',
    infoLayerVentaMesasMesa: 'Mesa',
    infoLayerVentaMesasCosto: 'COSTO VENTA',
    infoLayerVentaMesasVenta: 'VENTA',
    infoLayerVentaMesasUtilidad: 'UTILIDAD',
    textLeyendVentaRutas: ' Mostrar Legend Rutas',
    infoLayerVentaRutasHover: 'Pase el mouse sobre una Ruta',
    infoLayerVentaRutasTitulo: 'Capa de Rutas',
    infoLayerVentaRutasRuta: 'RUTA',
    infoLayerVentaRutasCosto: 'COSTO VENTA',
    infoLayerVentaRutasVenta: 'VENTA',
    infoLayerVentaRutasUtilidad: 'UTILIDAD',
    infoGemonetriaHover: 'Geometria',
    infoGemonetriaTitle: 'Geometria',
    infoGemonetriaNombre: 'Nombre',
    gridGeometriaCaption: 'Capas del sistema',
    gridClienteGeometriaCaption: 'Lista de Clientes Filtrados',
    popupModificarDia: 'Modificar Dia',
    popupGuardarModificarDia: 'Guardar Modificacion',
    popupEliminarDia: 'Eliminar Dia',
    popupCancelarModificacionDia: 'Cancelar Modificacion',
    popupModificarMesa: 'Modificar Mesa',
    popupGuardarModificarMesa: 'Guardar Modificacion',
    popupEliminarMesa: 'Eliminar Mesa',
    popupCancelarModificacionMesa: 'Cancelar Modificacion',
    popupMostrarTodoMesa: 'Mostrar Todos clientes'

}


var Valores={
    
    uitvigente:3650
}
