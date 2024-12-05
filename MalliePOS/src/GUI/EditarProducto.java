/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controllers.ProductoController;
import Models.Producto;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Kevin
 */
public class EditarProducto extends javax.swing.JFrame {
    int idCategoriaV, stockV, idProductoV;
    String nombreV, descripcionV, referenciaV;
    float precioV;
    ProductoController productoController;
    
    /**
     * Creates new form EditarProducto
     */
    public EditarProducto() {
        initComponents();
    }
    
    public EditarProducto(int idProducto, int idCategoria, String referencia, String nombre, String descripcion, int stock, float precio){
        initComponents();
        this.txt_referenciaProd.setText(referencia);
        this.txt_nombreProd.setText(nombre);
        this.txt_descripcionProd.setText(descripcion);
        this.txt_categoriaProd.setText(""+idCategoria);
        this.txt_stockProd.setText(""+stock);
        this.txt_precioProd.setText(""+precio);
        
        this.idProductoV=idProducto;
        productoController = new ProductoController();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_precio = new javax.swing.JLabel();
        txt_precioProd = new javax.swing.JTextField();
        btn_atrasProd = new javax.swing.JButton();
        btn_editarProd = new javax.swing.JButton();
        txt_stockProd = new javax.swing.JTextField();
        lbl_stock = new javax.swing.JLabel();
        lbl_categoria = new javax.swing.JLabel();
        txt_categoriaProd = new javax.swing.JTextField();
        txt_descripcionProd = new javax.swing.JTextField();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombreProd = new javax.swing.JTextField();
        txt_referenciaProd = new javax.swing.JTextField();
        lbl_referencia = new javax.swing.JLabel();
        lbl_crearProducto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_precio.setText("Precio");

        btn_atrasProd.setText("Atras");
        btn_atrasProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasProdActionPerformed(evt);
            }
        });

        btn_editarProd.setText("Guardar cambios");
        btn_editarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarProdActionPerformed(evt);
            }
        });

        txt_stockProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stockProdActionPerformed(evt);
            }
        });

        lbl_stock.setText("Stock");

        lbl_categoria.setText("Categoria");

        lbl_descripcion.setText("Descripcion");

        lbl_nombre.setText("Nombre");

        lbl_referencia.setText("Referencia");

        lbl_crearProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_crearProducto.setText("Editar Producto");

        jPanel1.setBackground(new java.awt.Color(142, 225, 132));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("Mallie POS");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("¡Facturar nunca ha sido tan facil!");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cart50.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inventory50.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Crear producto");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Modulo Inventario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(5, 5, 5)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_atrasProd)
                        .addGap(18, 18, 18)
                        .addComponent(btn_editarProd))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_referencia)
                                .addComponent(lbl_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbl_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_referenciaProd)
                            .addComponent(txt_nombreProd)
                            .addComponent(txt_descripcionProd)
                            .addComponent(txt_categoriaProd)
                            .addComponent(txt_stockProd)
                            .addComponent(txt_precioProd, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(lbl_crearProducto)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_crearProducto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_referencia)
                    .addComponent(txt_referenciaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descripcionProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_descripcion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_categoriaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_categoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_stockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_stock))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_precioProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_precio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editarProd)
                    .addComponent(btn_atrasProd))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasProdActionPerformed
        GestionProductos gestionProductos;
        gestionProductos = new GestionProductos();
        gestionProductos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_atrasProdActionPerformed

    private void btn_editarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarProdActionPerformed
        nombreV = txt_nombreProd.getText();
        descripcionV = txt_descripcionProd.getText();
        referenciaV = txt_referenciaProd.getText();

        try {
            // Convertir el texto a un número entero
            idCategoriaV = Integer.parseInt(txt_categoriaProd.getText());
        } catch (NumberFormatException e) {
            // Manejar el caso en que el texto no sea un número válido
            JOptionPane.showMessageDialog(null, "Por favor, ingresa una categoria que sea válida");
        }

        try {
            // Convertir el texto a un número entero
            stockV = Integer.parseInt(txt_stockProd.getText());
        } catch (NumberFormatException e) {
            // Manejar el caso en que el texto no sea un número válido
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un stock que sea válido");
        }

        try {
            // Convertir el texto a un número entero
            precioV = Float.parseFloat(txt_precioProd.getText());
        } catch (NumberFormatException e) {
            // Manejar el caso en que el texto no sea un número válido
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un precio que sea válido");
        }
        
        Producto productoLeido;
        try {
          productoLeido = Producto.buscarPorId(idProductoV); 
          if (productoLeido != null) {
            //Al haber leido el producto correctamente puedo cambiar sus parametros para luego actualizar
            productoLeido.setReferencia(referenciaV);
            productoLeido.setNombre(nombreV);
            productoLeido.setDescripcion(descripcionV); 
            productoLeido.setStock(stockV);
            productoLeido.setPrecio(precioV);
            try {
                productoLeido.actualizar();
                JOptionPane.showMessageDialog(null, "Producto actualizado");
            } catch (SQLException e) {
                System.err.println("Error al actualizar el producto: " + e.getMessage());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
          }
        } catch (SQLException e) {
          System.err.println("Error al leer el producto: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_editarProdActionPerformed

    private void txt_stockProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stockProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stockProdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atrasProd;
    private javax.swing.JButton btn_editarProd;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JLabel lbl_crearProducto;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_referencia;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JTextField txt_categoriaProd;
    private javax.swing.JTextField txt_descripcionProd;
    private javax.swing.JTextField txt_nombreProd;
    private javax.swing.JTextField txt_precioProd;
    private javax.swing.JTextField txt_referenciaProd;
    private javax.swing.JTextField txt_stockProd;
    // End of variables declaration//GEN-END:variables
}
