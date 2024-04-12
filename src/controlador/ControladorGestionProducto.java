package controlador;



import modelo.Categorias;
import modelo.Productos;
import vista.VistaGestionProducto;

/**
 *
 * @author nn
 */
public class ControladorGestionProducto {
     public static  VistaGestionProducto vgp;
     private static Productos productoActual;
     
     public static void CargarInstancia(VistaGestionProducto vgp2) {
        vgp = vgp2;
        promptTxt();
        resetBtn(false);
    }
      
      public static void EventojBtnNuevo(){
          try {
              if(validar()){
                int codigo=Integer.parseInt(vgp.getjTxtcodigo().getText());
                String descripcion=vgp.getjTxtcodigo().getText();
                double precio=Integer.parseInt(vgp.getjTxtcodigo().getText());
                int stock=Integer.parseInt(vgp.getjTxtcodigo().getText());
                Categorias rubro=(Categorias)vgp.getjCBxRubro().getSelectedItem();
                
                ControladorMenuPrincipal.listaProductos.add(new Productos(codigo, descripcion, precio, stock, rubro));
                
              }else{
                  ControladorMenuPrincipal.viewDialogo("Todo los campos son obligatorios. Respete el tipo de dato y su formato.", 0);
              }
              
          } catch (Exception e) {
                msjGeneral();
          }
      }
      
      public static void EventojBtnEditar(){
           //resetBtn(false);
      }
      
    public static void EventojBtnEliminar() {
        //
        if (productoActual != null) {
            System.out.println(productoActual);
            if (ControladorMenuPrincipal.viewDialogoSiNo()) {
                ControladorMenuPrincipal.listaProductos.remove(productoActual);
                productoActual=null;//si no le doy null , la referencia de memoria sigue exitiendo, por ende en el treeSet sigue esstando ya q ue apunda a la misma referencia en memoria
                resetBtn(false);
                EventoReset();
            }

        }
    }

    public static void EventojBtnBuscar() {
        try {

            buscarPorCodigo();
            if (productoActual != null) {
                resetBtn(true);
                vgp.getjTxtcodigo().setText(productoActual.getCodigo() + "");
                vgp.getjTxtDescripcion().setText(productoActual.getDescripcion());
                vgp.getjTxtPrecio().setText(productoActual.getPrecio() + "");
                vgp.getjTxtStock().setText(productoActual.getStock() + "");
                vgp.getjCBxRubro().setSelectedItem(productoActual.getRubro());

            } else {
                ControladorMenuPrincipal.viewDialogo("El codigo no exite", 0);
                vgp.getjTxtcodigo().requestFocus();
            }
        } catch (Exception e) {
            msjGeneral();
        }
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
    
    
    private static boolean validar() {
        boolean res = false;
        if (ControladorMenuPrincipal.vacioText(vgp.getjPnltxt())) {
            if (vgp.getjCBxRubro().getSelectedIndex() > 0 && ControladorMenuPrincipal.EventoValidarNumericos(vgp.getjTxtcodigo().getText())
                    && ControladorMenuPrincipal.EventoValidarNumericos(vgp.getjTxtStock().getText())
                    && (ControladorMenuPrincipal.EventoValidarDoubles(vgp.getjTxtPrecio().getText())
                    || ControladorMenuPrincipal.EventoValidarNumericos(vgp.getjTxtPrecio().getText()))) {

                res = true;
            }
           
        }
        return res;
    }
    
    private static boolean validarCodigo(){
        return (!vgp.getjTxtcodigo().getText().isEmpty()) && ControladorMenuPrincipal.EventoValidarNumericos(vgp.getjTxtcodigo().getText());
    }
    
    private static void buscarPorCodigo(){
      
        if(validarCodigo()){
                  int codigo=Integer.parseInt(vgp.getjTxtcodigo().getText());
                  for (Productos producto : ControladorMenuPrincipal.listaProductos) {
                      if(codigo==producto.getCodigo()){
                          productoActual=producto;
                          
                          break;
                          
                      }
                  }
              }
    }
    
    
    private static void resetBtn(boolean op) {
        vgp.getjBtnEditar().setEnabled(false);
        vgp.getjBtnEliminar().setEnabled(false);
        vgp.getjBtnNuevo().setEnabled(true);

        if (op) {
            vgp.getjBtnEditar().setEnabled(true);
            vgp.getjBtnEliminar().setEnabled(true);
            vgp.getjBtnNuevo().setEnabled(false);
        }
    }
    
    private static void msjGeneral(){
          ControladorMenuPrincipal.viewDialogo("Ocurio una falla inesperada", 0);
              
    }
      
      //fin
}
