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
        ControladorMenuPrincipal.textPrompt(vgp2.getjTxtcodigo(), "Codigo numerico");
        ControladorMenuPrincipal.textPrompt(vgp2.getjTxtDescripcion(), "Descripcion producto");
        ControladorMenuPrincipal.textPrompt(vgp2.getjTxtPrecio(), "Precio - 100.00");
        ControladorMenuPrincipal.textPrompt(vgp2.getjTxtStock(), "Stock");
    }
      
      public static void EventojBtnNuevo(){
          
      }
      
      public static void EventojBtnEditar(){
          
      }
      
      public static void EventojBtnEliminar(){
          
      }
      
      public static void EventojBtnBuscar(){
          
      }
      
   
      
//      
//      TextPrompt placeholder = new TextPrompt("Apellido Paterno", textField);
//    placeholder.changeAlpha(0.75f);
//    placeholder.changeStyle(Font.ITALIC);
//    JOptionPane.showMessageDialog(null, textField);
      
      
      //fin
}
