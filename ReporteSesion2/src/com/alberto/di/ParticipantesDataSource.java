/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.di;

// Librerías necesarias
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterConfiguration;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author dam2
 */
public class ParticipantesDataSource implements JRDataSource {
    
    private List<Participante> listaParticipantes = new ArrayList<>();
    private int indiceParticipanteActual = -1;


    @Override
    public boolean next() throws JRException {
        return ++indiceParticipanteActual<listaParticipantes.size();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object valor = null;
        if("nombre".equals(jrField.getName())) {
        valor = listaParticipantes.get(indiceParticipanteActual).getNombre();
        }
        else if("username".equals(jrField.getName())) {
        valor =
         listaParticipantes.get(indiceParticipanteActual).getUsername(); 
        }
        else if("password".equals(jrField.getName())) {
        valor =
         listaParticipantes.get(indiceParticipanteActual).getPassword();
        }
        else if("id".equals(jrField.getName())) {
        valor =
         listaParticipantes.get(indiceParticipanteActual).getId();
        }
        else if("comentarios".equals(jrField.getName())) {
        valor =
         listaParticipantes.get(indiceParticipanteActual).getComentarios();
        }
        return valor;
    }
    
    // Método addParticipante
    public void addParticipante(Participante participante){
        this.listaParticipantes.add(participante);
    }

    
}
