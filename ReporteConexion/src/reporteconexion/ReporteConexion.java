/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteconexion;

// Librerías necesarias
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
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

/**
 *
 * @author dam2
 */
public class ReporteConexion extends JFrame {
    
    // Variables de clase
    private static JPanel jPanel1 = new JPanel();
    private static Exporter exporter;
    
    // Constructor
    public ReporteConexion(){
        iniciarGUI();
    }
    
    // Método iniciarGUI
    public void iniciarGUI(){
        add(jPanel1);
        pack();
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            // Conexión con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection)
            DriverManager.getConnection("jdbc:mysql://localhost:3306/informesdi",
            "root", "campus");

            // Configuración 
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reportSesion1.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
            JasperViewer viewer = new JasperViewer(jasperPrint);
            jPanel1.add(viewer.getContentPane());

             
            // Generación del reporte en PDF
            exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new
            java.io.File("reporteSesion1PDF.pdf")));
            SimplePdfExporterConfiguration configurationPDF = new
            SimplePdfExporterConfiguration();
            exporter.setConfiguration(configurationPDF);
            exporter.exportReport();
            

            // Generación del reporte en HTML
            exporter = new HtmlExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleHtmlExporterOutput(new
            java.io.File("reporteSesion1PDF.html")));
            SimpleHtmlExporterConfiguration configurationHTML = new
            SimpleHtmlExporterConfiguration();
            exporter.setConfiguration(configurationHTML);
            exporter.exportReport();
            
            ReporteConexion prueba = new ReporteConexion();

        }catch(Exception e){
            // Tratamiento de la excepción
            System.out.println("Error!!!");
            e.printStackTrace();
        }
    }
}
