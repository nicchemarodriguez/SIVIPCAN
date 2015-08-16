
function generarRpt_click(){
        
    var iUrl
    var reporte="";
    var mes= smMeses.getSelectedValue();
    var anio= smAnio.getSelectedValue();
    var silais= smSilais.getSelectedValue();
    
    
    if(document.getElementById('frmReportes:checkPN').checked===true){
        reporte='pacientes_nuevos';
    }
    if(document.getElementById('frmReportes:checkPC1').checked===true){
        reporte='pacientes_conf1';
    }
    if(document.getElementById('frmReportes:checkPC2').checked===true){
        reporte='pacientes_conf2';
    }

    if(reporte=='pacientes_nuevos'){

        iUrl = '../frameset?__report=reportes/menejo_pacientes_nuevos.rptdesign&mesDiag='+mes+'&anioDiag='+anio+'&silais='+silais;
 
    }
    if(reporte=='pacientes_conf1'){

        iUrl = '../frameset?__report=reportes/pacientes_confirmados1.rptdesign&mesParameter='+mes+'&yearParameter='+anio+'&silaisParameter='+silais;
 
    }
    if(reporte=='pacientes_conf2'){

        iUrl = '../frameset?__report=reportes/pacientes_confirmados2.rptdesign&mesParameter='+mes+'&yearParameter='+anio+'&silaisParameter='+silais;
 
    }
    
    if(iUrl !=""){
        openModalWindow(iUrl,'Reporte','800','600');
    }
    
    return false;
}


