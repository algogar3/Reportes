/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.di;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author dam2
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ParticipantesDataSource datasource = new ParticipantesDataSource();
        for (int i = 1; i<= 10; i++){
        Participante p = new Participante("Particpante " + i, "Usuario " +
        i, "Pass " + i, i, "Comentariospara " + i);
        p.setId(Integer.valueOf(i));
        datasource.addParticipante(p);
         }
        try{
        JasperReport reporte = (JasperReport)
        JRLoader.loadObjectFromFile("sesion3.jasper");
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("REPORT_TITLE", "Reporte Participantes");
        parametros.put("REPORT_AUTHOR", "Alberto");

        JasperPrint jasperPrint =
        JasperFillManager.fillReport(reporte, parametros, datasource);
        Exporter exporter = new JRPdfExporter();

         exporter.setExporterInput(new
        SimpleExporterInput(jasperPrint));
         exporter.setExporterOutput(new
        SimpleOutputStreamExporterOutput(new
        java.io.File("reporteSesion3PDF.pdf")));
         SimplePdfExporterConfiguration configuration = new
        SimplePdfExporterConfiguration();
         exporter.setConfiguration(configuration);

         exporter.exportReport();
         } catch (JRException ex) {

        Logger.getLogger(Participante.class.getName()).log(Level.SEVERE,
        null, ex);
        }

    }
    
}
