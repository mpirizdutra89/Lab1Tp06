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
          try {
              if(validar()){
                int codigo=Integer.parseInt(vgp.getjTxtcodigo().getText());
                String descripcion=vgp.getjTxtcodigo().getText();
                int precio=Integer.parseInt(vgp.getjTxtcodigo().getText());
                int stock=Integer.parseInt(vgp.getjTxtcodigo().getText());
              }else{
                  ControladorMenuPrincipal.viewDialogo("Todo los campos son obligatorios. Respete el tipo de dato y su formato.", 0);
              }
              
          } catch (Exception e) {
          }
      }
      
      public static void EventojBtnEditar(){
          
      }
      
      public static void EventojBtnEliminar(){
          
      }
      
      public static void EventojBtnBuscar(){
          
      }
      
      public static void EventoReset(){
          ControladorMenuPrincipal.resetFormContent(vgp.getjPnltxt());
      }
      
   
      
    private static void promptTxt() {
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtcodigo(), "Codigo numerico");
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtDescripcion(), "Descripcion producto");
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtPrecio(), "Precio - 100.00");
        ControladorMenuPrincipal.textPrompt(vgp.getjTxtStock(), "Stock");
    }
    
    
    public static boolean validar() {
        boolean res = false;
        if (ControladorMenuPrincipal.vacioText(vgp.getjPnltxt())) {
            if (ControladorMenuPrincipal.EventoValidarNumericos(vgp.getjTxtcodigo().getText())
                    && ControladorMenuPrincipal.EventoValidarNumericos(vgp.getjTxtStock().getText())
                    && (ControladorMenuPrincipal.EventoValidarDoubles(vgp.getjTxtPrecio().getText())
                    || ControladorMenuPrincipal.EventoValidarNumericos(vgp.getjTxtPrecio().getText()))) {

                res = true;
            }
        }
        return res;
    }
    
   
      
      //fin
}
