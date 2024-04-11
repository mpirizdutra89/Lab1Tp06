package controlador;


import vista.VistaGestionProducto;

/**
 *
 * @author nn
 */
public class ControladorGestionProducto {
     public static  VistaGestionProducto vgp;
     
     public static void CargarInstancia(VistaGestionProducto vgp2) {
        vgp = vgp2;
        promptTxt();
    }
      
      public static void EventojBtnNuevo(){
          
      }
      
      public static void EventojBtnEditar(){
          
      }
      
      public static void EventojBtnEliminar(){
          
      }
      
      public static void EventojBtnBuscar(){
          
      }
      
   
      
    private static void promptTxt() {
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtcodigo(), "Codigo numerico");
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtDescripcion(), "Descripcion producto");
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtPrecio(), "Precio - 100.00");
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtStock(), "Stock");
    }
      
      //fin
}
