package controlador;

import static controlador.ControladorGestionProducto.vgp;
import java.awt.Component;
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
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        escritorio.setSize(1024, 768);

        vmp.setContentPane(escritorio);
        vmp.setLocationRelativeTo(null);
        vmp.setVisible(true);
        cargaAutomaticaListaProducto();
    }

    public static void jMenuItemProducto() {

        vista.VistaGestionProducto vgp = new vista.VistaGestionProducto();

        for (Categorias rubro : Categorias.values()) {
            vgp.getjCBxRubro().addItem(rubro);
        }
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

        
        for (Categorias rubro : Categorias.values()) {
               cr.getjCBxRubro().addItem(rubro);

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
    
    public static boolean viewDialogoSiNo(){
        return JOptionPane.showConfirmDialog(escritorio, "¿Deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;

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
    
    private static void cargaAutomaticaListaProducto(){
        
            listaProductos.add(new Productos(20,"milanesa",900.0,80,Categorias.COMESTIBLE));
            listaProductos.add(new Productos(21,"hamburgesa paty",5000.0,50,Categorias.COMESTIBLE));
            listaProductos.add(new Productos(22,"Lavandina",1000.0,8,Categorias.LIEMPIEZA));
            listaProductos.add(new Productos(23,"lampaso",3000.0,5,Categorias.LIEMPIEZA));
            listaProductos.add(new Productos(24,"Kin seduccion",10000.0,8,Categorias.PERFUMERIA));
            listaProductos.add(new Productos(25,"avon Triker",30000.0,5,Categorias.PERFUMERIA));
       
    }
    
       public static void textPrompt(JTextField textField,String titulo){
        librerias.TextPrompt placeholder = new librerias.TextPrompt(titulo, textField);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
        
      }
       
     public static void resetFormContent(JPanel jpnl) {
        Component[] components = jpnl.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textField.setText("");
            }
        }
    }
     
     public static boolean vacioText(JPanel jpnl) {
        Component[] components = jpnl.getComponents();
        boolean res = true;
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                if (textField.getText().isEmpty()) {
                    res = true;
                    break;
                }
            }

        }
        return res;
    }
     
     public void resetComboBox(){
         
     }
     
        
     
     public static void EventoSoloNumerico(java.awt.event.KeyEvent e){
          char c = e.getKeyChar();
                   if (!Character.isDigit(c)) {
                    e.consume(); // Consumir el evento para evitar que se ingrese el carácter
                }
               
     }
     
     public static boolean EventoValidarNumericos(String cadena){
         return cadena.matches("^[0-9]+$");
     }
     
      public static boolean EventoValidarDoubles(String cadena){
         return cadena.matches("^[0-9]+\\.[0-9]{2}$");
     }
     
      
      

//fin
}
