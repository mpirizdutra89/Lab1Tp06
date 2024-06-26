package controlador;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import vista.VistaConsultaPrecio;

/**
 *
 * @author nn
 */
public class ControladorCosultaPrecio {
     public static VistaConsultaPrecio vcp ;
     
      public static void CargarInstancia(VistaConsultaPrecio cp) {
           vcp = cp;       
           ControladorMenuPrincipal.validarEntradaNumerica(vcp.getTxtPrecioMin());
           ControladorMenuPrincipal.validarEntradaNumerica(vcp.getTxtPrecioMax());
           ControladorMenuPrincipal.EventoValidarNumericos(vcp.getTxtPrecioMin().getText());
           ControladorMenuPrincipal.EventoValidarNumericos(vcp.getTxtPrecioMax().getText());
           promptTxt();
        }
      
       private static void promptTxt() {
        ControladorMenuPrincipal.textPrompt(vcp.getTxtPrecioMin(), "Precio mín");
        ControladorMenuPrincipal.textPrompt(vcp.getTxtPrecioMax(), "Precio máx");
        }
       
       public static void buscarProductosPorPrecio(){
           
            if (ControladorMenuPrincipal.listaProductos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay productos cargados", "Lista vacia", JOptionPane.WARNING_MESSAGE);
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
        
            ControladorMenuPrincipal.eliminarFilas(vcp.getjTable1());
            
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
}

