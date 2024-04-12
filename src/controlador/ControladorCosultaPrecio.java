package controlador;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import vista.VistaConsultaPrecio;

/**
 *
 * @author nn
 */
public class ControladorCosultaPrecio {
     public static VistaConsultaPrecio vcp = new VistaConsultaPrecio();
     
      public static void CargarInstancia(VistaConsultaPrecio cp) {
           vcp = cp;
           validarEntradaNumerica(vcp.getTxtPrecioMin());
           validarEntradaNumerica(vcp.getTxtPrecioMax());
           promptTxt();
        }
      
       private static void promptTxt() {
        ControladorMenuPrincipal.textPrompt(vcp.getTxtPrecioMin(), "Precio mín");
        ControladorMenuPrincipal.textPrompt(vcp.getTxtPrecioMax(), "Precio máx");
    }
       
       private static void validarEntradaNumerica(javax.swing.JTextField textField) {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                String text = textField.getText();
                
                boolean puntoExistente = text.contains(".");
                
                if (!((c >= '0' && c <= '9') || (c == '.' && !puntoExistente) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });
    }
       
       public static void buscarProductosPorPrecio(){
           
            if (ControladorMenuPrincipal.listaProductos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay productos en la lista.", "Lista vacía", JOptionPane.WARNING_MESSAGE);
        return;
        }
           
        double precioMin = Double.parseDouble(vcp.getTxtPrecioMin().getText());
        double precioMax = Double.parseDouble(vcp.getTxtPrecioMax().getText());
        
          if (precioMin <= 0 || precioMax < precioMin) {
                if (precioMin <= 0) {
                    ControladorMenuPrincipal.viewDialogo("El precio minimo no puedo ser menor que 0", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ControladorMenuPrincipal.viewDialogo("El precio maximimo debe ser mayor al minimo", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;
          }
        
        eliminarFilas();
            
             for (modelo.Productos prod : ControladorMenuPrincipal.listaProductos) {
                if (prod.getPrecio() >= precioMin && prod.getPrecio() <= precioMax) {
                    ControladorMenuPrincipal.modeloTable.addRow(new Object[]{
                            prod.getCodigo(),
                            prod.getDescripcion(),
                            prod.getPrecio(),
                            prod.getStock()
                    });
            }
         }
       }
       
        private static void eliminarFilas(){
        
        int f = vcp.getjTable1().getRowCount()-1;
        for(;f>=0;f--){
            ControladorMenuPrincipal.modeloTable.removeRow(f);
        }
    }
}
