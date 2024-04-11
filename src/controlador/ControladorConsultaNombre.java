package controlador;

import vista.*;

/**
 *
 * @author nn
 */
public class ControladorConsultaNombre {

    // public static  crear una variable de tipo vistaNombre
    public static VistaConsultaNombre vcn = new VistaConsultaNombre();

    public static void CargarInstancia(VistaConsultaNombre vn2) {
        //cargar istancia de la vista usando la vaiable de tipo vista
        vcn = vn2;
        promptTxt();

    }
    //Se crea placeholder
    private static void promptTxt() {
        ControladorMenuPrincipal.textPrompt(vcn.getjTFnombre(), "Ingrese el nombre del producto");
    }
    //Se busca producto
    public static void buscarProducto() {
        eliminarFilas();
        for (modelo.Productos prod : ControladorMenuPrincipal.listaProductos) {

            if (prod.getDescripcion().startsWith(vcn.getjTFnombre().getText())) {
                ControladorMenuPrincipal.modeloTable.addRow(new Object[]{
                        prod.getCodigo(),
                        prod.getDescripcion(),
                        prod.getPrecio(),
                        prod.getStock() 
                });
            }

        }
    }
    //Se elimina filas de la busqueda
    private static void eliminarFilas(){
        
        int f = vcn.getjTblDatos().getRowCount()-1;
        for(;f>=0;f--){
            ControladorMenuPrincipal.modeloTable.removeRow(f);
        }
    
    }
    //fin
}
