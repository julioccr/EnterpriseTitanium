function handleSubmit(xhr, status, args, dialog) {
    var jqDialog = jQuery('#'+dialog.id);
    if(args.validationFailed) {
        jqDialog.effect('shake', { times:3 }, 100);
    } else {
        dialog.hide();
    }
}
function fixPFMDialogs() {
    jQuery("body > div[data-role='page']").each(function (i) {
        var pageId = jQuery(this).attr("id");
        jQuery("body > div[id*='" + pageId + "'][class*='ui-popup']").appendTo("#" + pageId);
    });
}

 PrimeFaces.locales['es'] = {
        closeText: 'Cerrar',
        prevText: 'Atras',
        nextText: 'Siguiente',
        currentText: 'Fecha Actual',
        monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
            'Julio','Agosto','Septiempre','Octubre','Noviembre','Dicciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
            'Jul','Ago','Sept','Oct','Nov','Dic'],
        dayNames: ['Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo'],
        dayNamesShort: ['Dom','Lun','Mat','Mierc','Juev','Viern','Sab'],
        dayNamesMin: ['Dm','Ln','Mt','Mc','Jv','Vn','Sb'],
        weekHeader: 'Sem',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        month: 'Mes',
        week: 'Semana',
        day: 'Dia',
        allDayText : 'Todo el Dia'
    };
