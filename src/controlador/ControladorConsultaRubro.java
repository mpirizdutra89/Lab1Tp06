package controlador;




import modelo.Categorias;
import modelo.Productos;
import vista.VistaConsultaRubro;



/**
 *
 * @author nn
 * @author agus1
 */
public class ControladorConsultaRubro {
       public static VistaConsultaRubro vcr;
     
      public static void CargarInstancia(VistaConsultaRubro cr) {
           vcr = cr;
        }
      
      
    public static void buscarProductosPorCategoria() {
        if (ControladorMenuPrincipal.listaProductos.size()<=0) {
          ControladorMenuPrincipal.viewDialogo( "No hay productos cargados", "Lista vacía", 0);
            return;
        }
        //System.out.println("Se ejecuto una ves");
        if (vcr.getjCBxRubro().getSelectedIndex() > 0) {
           // System.out.println("Entro");
             ControladorMenuPrincipal.eliminarFilas(vcr.getjTableRubro());
            Categorias categoria = (Categorias) vcr.getjCBxRubro().getSelectedItem();

            for (Productos producto : ControladorMenuPrincipal.listaProductos) {
                
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
    
  
    
    
    //fin
}
      

