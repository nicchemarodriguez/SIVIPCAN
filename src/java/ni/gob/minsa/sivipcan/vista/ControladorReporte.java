/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import ni.gob.minsa.modelo.estructura.EntidadAdtva;
import ni.gob.minsa.sivipcan.controlador.ExamenEJB;
import ni.gob.minsa.sivipcan.modelo.Examen;
import ni.gob.minsa.sivipcan.modelo.Fxexu;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped

public class ControladorReporte implements Serializable {

    @EJB   
    ExamenEJB examenEjb;
    private Date fechaReporteRango1;
    private Date fechaReporteRango2;

    private StreamedContent graphicImage;
    private List<Fxexu> lista;
    private List<EntidadAdtva> listaSilaisOcurrencia;
    private List<EntidadAdtva> listaSilaisResidencia;
    private Examen exam;
    private String fuma;
    
    
    public ControladorReporte() throws FileNotFoundException {

    }

    
    public String getFuma() {
        for(int i=0; i<lista.size(); i++)
        {
            if(lista.get(i).getExamen().getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria() == BigDecimal.valueOf(7))
            {
                fuma= lista.get(i).getExamen().getResultadoExamenList().get(i).getIdValor().getValor();
                System.out.println("Fuma " + fuma);
            }
        }
        return fuma;
    }

    public void setFuma(String fuma) {
        this.fuma = fuma;
    }
    

    public ControladorReporte(ExamenEJB examenEjb) {
        this.examenEjb = examenEjb;
    }

    public List<Fxexu> getLista() {

        return lista;
    }

    public void setLista(List<Fxexu> lista) {
        this.lista = lista;
    }

    public Examen getExam() {
        return exam;
    }

    public void setExam(Examen exam) {
        this.exam = exam;
    }

    public List<EntidadAdtva> getListaSilaisOcurrencia() {
        return listaSilaisOcurrencia;
    }

    public void setListaSilaisOcurrencia(List<EntidadAdtva> listaSilaisOcurrencia) {
        this.listaSilaisOcurrencia = listaSilaisOcurrencia;
    }

    public List<EntidadAdtva> getListaSilaisResidencia() {
        return listaSilaisResidencia;
    }

    public void setListaSilaisResidencia(List<EntidadAdtva> listaSilaisResidencia) {
        this.listaSilaisResidencia = listaSilaisResidencia;
    }

    
    public Date getFechaReporteRango1() {
        return fechaReporteRango1;
    }

    public void setFechaReporteRango1(Date fechaReporteRango1) {
        this.fechaReporteRango1 = fechaReporteRango1;
    }

    public Date getFechaReporteRango2() {
        return fechaReporteRango2;
    }

    public void setFechaReporteRango2(Date fechaReporteRango2) {
        this.fechaReporteRango2 = fechaReporteRango2;
    }

    public StreamedContent getGraphicImage() throws FileNotFoundException {
        String path = "D:\\imagen\\excelmvc.jpg";
        graphicImage = new DefaultStreamedContent(new FileInputStream(path), "image/png");
        return graphicImage;
    }

    public void setGraphicImage(StreamedContent graphicImage) {
        this.graphicImage = graphicImage;
    }

   

    public void reporte2(){
      

      //  lista.get(0).getExamen().getIdComunidadResidencia().se
        // listareporte.get(0).getExamen().getResultadoExamenList().get(15).getIdSubcategoria().getValor();
        // listareporte.get(0).getExamen().getResultadoExamenList().get(28).getIdValor().getValor();
//         JRExporter exporter = new JRPdfExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte3PDF.pdf"));
//        exporter.exportReport();
//       HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporte.pdf");
//        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
//        FacesContext.getCurrentInstance().responseComplete();
        //listareporte.get(0).getExamen().getCatalogoList().get(0).getDescripcion().
    }

    public void reporte() {

        lista = examenEjb.buscarReporte(fechaReporteRango1, fechaReporteRango2, 1);
//        BigInteger silaisO = lista.get(0).getExamen().getUnidadesXExamenList().get(0).getSilais();
//        BigInteger silaisR = lista.get(0).getExamen().getUnidadesXExamenList().get(1).getSilais();
//        System.out.print("aqui" + silaisR );
        
//        listaSilaisOcurrencia = examenEjb.buscarSilaisReporte(silaisO);
//         listaSilaisResidencia = examenEjb.buscarSilaisReporte(silaisR);
//        listaSilaisOcurrencia.get(0).getNombre();

        //Comparator<Integer> comparador = Collections.reverseOrder();
//          Long b=     lista.get(0).getExamen().getIdExamen();
//          
//         System.out.println("mi variable " + b);
//  
//      for(int i=0; i<b; i++)
//        {
//            System.out.println("Fuma 2222" + fuma);
//            BigDecimal a= new BigDecimal(7);
//             System.out.println("Fuma 2222" + a);
//            if(lista.get(0).getExamen().getResultadoExamenList().get(i).getIdSubcategoria().getIdSubcategoria() == a)
//            {
//                fuma= lista.get(i).getExamen().getResultadoExamenList().get(i).getIdValor().getValor();
//                System.out.println("Fuma wiiiiiiiiiii " + fuma);
//            }
//        }
//      
//      
//        
  //listareporte.get(0).getExamen().getCatalogoList().get(0).getValor();
    }

    
    
}
