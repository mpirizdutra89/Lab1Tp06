package controlador;

import static controlador.ControladorMenuPrincipal.modeloTable;
import javax.swing.JOptionPane;
import modelo.Categorias;
import vista.VistaConsultaRubro;



/**
 *
 * @author nn
 * @author agus1
 */
public class ControladorConsultaRubro {
       public static VistaConsultaRubro vcr = new VistaConsultaRubro();
     
      public static void CargarInstancia(VistaConsultaRubro cr) {
           vcr = cr;
        }
      
      
      public static void buscarProductosPorCategoria(Categorias categoria) {
        if (ControladorMenuPrincipal.listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos cargados", "Lista vacía", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ControladorMenuPrincipal.modeloTable.getRowCount() > 0) {
        ControladorMenuPrincipal.eliminarFilas(vcr.getjTableRubro());
    }
        for (modelo.Productos producto : ControladorMenuPrincipal.listaProductos) {
            if (producto.getRubro().equals(categoria)) {
                ControladorMenuPrincipal.modeloTable.addRow(new Object[]{
                        producto.getCodigo(),
                        producto.getDescripcion(),
                        producto.getPrecio(),
                        producto.getStock()
                });
            }
        }
      }
      }
      

