/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import vista.VistasInformacion;

/**
 *
 * @author Martin
 */
public class ControladorInformacion {
     public static vista.VistasInformacion vi ;
     public static JEditorPane editorPane;
    public static void CargarInstancia(VistasInformacion vi2) {
        //cargar istancia de la vista usando la vaiable de tipo vista
        vi = vi2;
        editorPane = new JEditorPane();
         html();
   }
    
    private static void html() {
        
        editorPane.setContentType("text/html");
        
        editorPane.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    Desktop.getDesktop().browse(e.getURL().toURI());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Cargar un documento HTML que contiene enlaces
        try {
            System.out.println("ssss");
            File htmlFile = new File("src/resources/html/index.html");
            System.out.println(htmlFile.getAbsolutePath());
            editorPane.setPage(htmlFile.toURI().toURL());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        System.out.println(editorPane.getPage());

        // Hacer que el JEditorPane sea solo de lectura (para evitar la edición)
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setBounds(1,1,750,545);
        vi.add(scrollPane);
        
       
        
       
    }
    
}
