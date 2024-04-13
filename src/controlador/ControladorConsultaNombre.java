package controlador;

import vista.*;

/**
 *
 * @author nn
 */
public class ControladorConsultaNombre {

    // public static  crear una variable de tipo vistaNombre
    public static VistaConsultaNombre vcn ;

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
        try {

            ControladorMenuPrincipal.eliminarFilas(vcn.getjTblDatos());
            String busqueda = vcn.getjTFnombre().getText().toLowerCase();
            if (!busqueda.isEmpty()) {

                for (modelo.Productos prod : ControladorMenuPrincipal.listaProductos) {
                    String descripcion = prod.getDescripcion().toLowerCase();

                    if (descripcion.startsWith(busqueda)) {
                        ControladorMenuPrincipal.modeloTable.addRow(new Object[]{
                            prod.getCodigo(),
                            prod.getDescripcion(),
                            prod.getPrecio(),
                            prod.getStock()
                        });
                    }

                }
            }
        } catch (Exception e) {
             ControladorMenuPrincipal.viewDialogo("Ocurrio una falla inesperada", "", 0);
        }
    }
    //fin
}
