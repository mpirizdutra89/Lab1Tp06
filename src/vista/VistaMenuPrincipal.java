
package vista;



import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 *
 * @author nn
 */
public class VistaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenuPrincipal
     */
    public VistaMenuPrincipal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/logoSuper.png")).getImage());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMiProductos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMiRubro = new javax.swing.JMenuItem();
        jMiNombre = new javax.swing.JMenuItem();
        jMiPrecio = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemInformacion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 800));

        jMenu1.setText("Administracion");
        jMenu1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        jMiProductos.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jMiProductos.setText("Productos");
        jMiProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiProductosActionPerformed(evt);
            }
        });
        jMenu1.add(jMiProductos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");
        jMenu2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        jMiRubro.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jMiRubro.setText("Por Rubro");
        jMiRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiRubroActionPerformed(evt);
            }
        });
        jMenu2.add(jMiRubro);

        jMiNombre.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jMiNombre.setText("Por Nombre");
        jMiNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiNombreActionPerformed(evt);
            }
        });
        jMenu2.add(jMiNombre);

        jMiPrecio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jMiPrecio.setText("Por Precio");
        jMiPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiPrecioActionPerformed(evt);
            }
        });
        jMenu2.add(jMiPrecio);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Info");
        jMenu3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        jMenuItemInformacion.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jMenuItemInformacion.setText("Informacion del equipo");
        jMenuItemInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInformacionActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemInformacion);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMiRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiRubroActionPerformed
      controlador.ControladorMenuPrincipal.jMenuItemRubro();
    }//GEN-LAST:event_jMiRubroActionPerformed

    private void jMiNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiNombreActionPerformed
       controlador.ControladorMenuPrincipal.jMenuItemNombre();
    }//GEN-LAST:event_jMiNombreActionPerformed

    private void jMiPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiPrecioActionPerformed
       controlador.ControladorMenuPrincipal.jMenuItemPrecio();
    }//GEN-LAST:event_jMiPrecioActionPerformed

    private void jMenuItemInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInformacionActionPerformed
       controlador.ControladorMenuPrincipal.jMenuInformacion();
    }//GEN-LAST:event_jMenuItemInformacionActionPerformed

    private void jMiProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiProductosActionPerformed
         controlador.ControladorMenuPrincipal.jMenuItemProducto();
    }//GEN-LAST:event_jMiProductosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemInformacion;
    private javax.swing.JMenuItem jMiNombre;
    private javax.swing.JMenuItem jMiPrecio;
    private javax.swing.JMenuItem jMiProductos;
    private javax.swing.JMenuItem jMiRubro;
    // End of variables declaration//GEN-END:variables

   


    
}
