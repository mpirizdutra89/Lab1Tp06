package controlador;

import java.util.TreeSet;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Categorias;
import modelo.EncabezadoTbl;
import modelo.EscritorioPersonalizado;
import modelo.Productos;
import vista.VistaMenuPrincipal;

/**
 *
 * @author nn
 */
public class ControladorMenuPrincipal {

    //variables
    public static VistaMenuPrincipal vmp = new VistaMenuPrincipal();
    public static final EscritorioPersonalizado escritorio = new EscritorioPersonalizado();
    public static TreeSet<Productos> listaProductos;
    //Tablas
    public static DefaultTableModel modeloTable;
    private static DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    private static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

    public static void CargarVistaPrincipal() {
        listaProductos = new TreeSet<>();
        escritorio.setSize(800, 600);

        vmp.setContentPane(escritorio);
        vmp.setLocationRelativeTo(null);
        vmp.setVisible(true);
    }

    public static void jMenuItemProducto() {

        vista.VistaGestionProducto vgp = new vista.VistaGestionProducto();
        //seteo el comboBox
        vgp.getjCBxRubro().addItem("Seleccione Rubro");
        for (Categorias rubro : Categorias.values()) {
            vgp.getjCBxRubro().addItem(rubro.toString());

        }
        //cargo la vista
        cargarVistasInternas(vgp);

    }

    public static void jMenuItemNombre() {
        vista.VistaConsultaNombre cn = new vista.VistaConsultaNombre();

        armarEncabesados();
         cn.getjTblDatos().setModel(modeloTable);
         //alinea las columnas
         alinearCabeceras(2, "right", cn.getjTblDatos());
         alinearCabeceras(3, "center", cn.getjTblDatos());
        //cargo la vista
        cargarVistasInternas(cn);

    }

    public static void jMenuItemPrecio() {
        vista.VistaConsultaPrecio cp = new vista.VistaConsultaPrecio();

        //armarEncabesados();
        //cp.getjTblDatos().setModel(modeloTable);
        //alinearCabeceras(2, "right", cp.getjTblDatos());
        //alinearCabeceras(3, "center", cp.getjTblDatos());
        //cargo la vista
        cargarVistasInternas(cp);

    }

    public static void jMenuItemRubro() {

        vista.VistaConsultaRubro cr = new vista.VistaConsultaRubro();

         cr.getjCBxRubro().addItem("Seleccione Rubro");
        for (Categorias rubro : Categorias.values()) {
               cr.getjCBxRubro().addItem(rubro.toString());

        }
        //tabla

        //  armarEncabesados();
        //cr.getjTblDatos().setModel(modeloTable);
        //alinearCabeceras(2, "right", cr.getjTblDatos());
        //alinearCabeceras(3, "center", cr.getjTblDatos());
        //cargo la vista
        cargarVistasInternas(cr);

    }

    //Funciones para tablas
        private static void alinearCabeceras(int indiceColumna, String dir, JTable tablet) {
        //  columnAlign.setHorizontalAlignment(SwingConstants.RIGHT);
        // jTblDatos.getColumnModel().getColumn(1).setCellRenderer(columnAlign);
        switch (dir) {
            case "center":
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                tablet.getColumnModel().getColumn(indiceColumna).setCellRenderer(centerRenderer);
                break;
            case "right":
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                tablet.getColumnModel().getColumn(indiceColumna).setCellRenderer(rightRenderer);
                break;

            default:
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                tablet.getColumnModel().getColumn(indiceColumna).setCellRenderer(centerRenderer);
                break;
        }

    }
    
          
     private static void armarEncabesados(){
         
          modeloTable= new DefaultTableModel(){
              public boolean isCellEditable(int f,int c){
                  return false;
              }
          };
         
          for (EncabezadoTbl cellProducto : EncabezadoTbl.values()) {
           
                 modeloTable.addColumn(cellProducto);
        }
     }  
     
     private static void resetColumn(JTable tablet){
          for (int i = tablet.getColumnCount() - 1; i >= 0; i--) {
                tablet.removeColumn(tablet.getColumnModel().getColumn(i));
            }
     }
    
  
    
    public static void viewDialogo(String msj, String titulo, int tipo) {
        JOptionPane.showMessageDialog(escritorio, msj, titulo, tipo);
    }

    public static void viewDialogo(String msj, int tipo) {
        JOptionPane.showMessageDialog(escritorio, msj, "", tipo);
    }
    
    
    private static void cargarVistasInternas(JInternalFrame view) {
        escritorio.removeAll();
        escritorio.repaint();
        view.setVisible(true);
        int w = escritorio.getWidth();
        int h = escritorio.getHeight();
        int x = (w - view.getWidth()) / 2;
        int y = (h - view.getHeight()) / 2;
        view.setLocation(x, y);

        escritorio.add(view);

        escritorio.moveToFront(view);

    }

//fin
}
