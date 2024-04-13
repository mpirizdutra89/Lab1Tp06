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
       
         vgp.getjTxtcodigo().setFocusable(true);
         vgp.getjTxtcodigo().requestFocus();
    }
      
      public static void EventojBtnNuevo(){
          try {
              if(validar()){
                int codigo=Integer.parseInt(vgp.getjTxtcodigo().getText());
                String descripcion=vgp.getjTxtDescripcion().getText();
                double precio=Integer.parseInt(vgp.getjTxtPrecio().getText());
                int stock=Integer.parseInt(vgp.getjTxtStock().getText());
                Categorias rubro=(Categorias)vgp.getjCBxRubro().getSelectedItem();
                            
                  ControladorMenuPrincipal.listaProductos.add(new Productos(codigo, descripcion, precio, stock, rubro));
                
                 resetBtn(false);
                  EventoReset();
                  cargarTabla();
                
                
              }else{
                  ControladorMenuPrincipal.viewDialogo("Todo los campos son obligatorios. Respete el tipo de dato y su formato.", 0);
                    vgp.getjTxtcodigo().setFocusable(true);
                    vgp.getjTxtcodigo().requestFocus();
              }
              
          } catch (Exception e) {
                msjGeneral();
          }
      }
      
      public static void EventojBtnEditar() {
          try {

              if (productoActual != null) {
                  for (Productos producto : ControladorMenuPrincipal.listaProductos) {
                      if (productoActual.equals(producto)) {
                         
                          producto.setCodigo(productoActual.getCodigo());
                          producto.setDescripcion(vgp.getjTxtDescripcion().getText());
                          producto.setPrecio(Double.valueOf(vgp.getjTxtPrecio().getText()));
                          producto.setStock(Integer.parseInt(vgp.getjTxtStock().getText()));
                          producto.setRubro((Categorias) vgp.getjCBxRubro().getSelectedItem());
                           productoActual=null;
                          break;

                      }
                  }
                  resetBtn(false);
                  EventoReset();
                  cargarTabla();
              }
          } catch (Exception e) {
              msjGeneral();
          }
    }
      
    public static void EventojBtnEliminar() {
        //
        if (productoActual != null) {
           
            if (ControladorMenuPrincipal.viewDialogoSiNo()) {
                ControladorMenuPrincipal.listaProductos.remove(productoActual);
                productoActual=null;//si no le doy null , la referencia de memoria sigue exitiendo, por ende en el treeSet sigue esstando ya q ue apunda a la misma referencia en memoria
                resetBtn(false);
                EventoReset();
                cargarTabla();
            }

        }
    }
    
    public static void EventjBtnSalir(){
        vgp.dispose();
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
                ControladorMenuPrincipal.viewDialogo("El codigo no se encuentra o es invalido.", 0);
                vgp.getjTxtcodigo().requestFocus();
            }
        } catch (Exception e) {
            msjGeneral();
        }
    }
    
    
    public static void EventoCeldaCliked(){
        int filaSelect=vgp.getjTblDatos().getSelectedRow();
        if(filaSelect!=-1){
            int codigo=(Integer) vgp.getjTblDatos().getValueAt(filaSelect, 0);
            BuscarXCodigo(codigo);
            if (productoActual != null) {
                resetBtn(true);
                vgp.getjTxtcodigo().setText(productoActual.getCodigo() + "");
                vgp.getjTxtDescripcion().setText(productoActual.getDescripcion());
                vgp.getjTxtPrecio().setText(productoActual.getPrecio() + "");
                vgp.getjTxtStock().setText(productoActual.getStock() + "");
                vgp.getjCBxRubro().setSelectedItem(productoActual.getRubro());

            } 
        }
    }
    
  
      
    public static void EventoReset(){
          resetBtn(false);
          ControladorMenuPrincipal.resetFormContent(vgp.getjPnltxt());
          vgp.getjCBxRubro().setSelectedIndex(0);
          productoActual=null;
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
        productoActual = null;
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
    
    private static void BuscarXCodigo(int codigo) {
        productoActual = null;
        for (Productos producto : ControladorMenuPrincipal.listaProductos) {
            if (codigo == producto.getCodigo()) {
                productoActual = producto;

                break;

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
      
    
    private static void cargarTabla() {
        ControladorMenuPrincipal.eliminarFilas(vgp.getjTblDatos());
        for (Productos prod : ControladorMenuPrincipal.listaProductos) {
            ControladorMenuPrincipal.modeloTable.addRow(new Object[]{
                prod.getCodigo(),
                prod.getDescripcion(),
                prod.getPrecio(),
                prod.getStock()
            });
        }
    }
      //fin
}
