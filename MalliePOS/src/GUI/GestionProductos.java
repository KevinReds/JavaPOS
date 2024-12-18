package GUI;

import Controllers.ProductoController;
import Models.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * Ventana de gestión de productos.
 *
 * @author Kevin
 */
public class GestionProductos extends javax.swing.JFrame {

    private ProductoController productoController;
    private List<Producto> productosOriginales; // Lista para mantener los datos originales

    /**
     * Creates new form GestionProductos
     */
    public GestionProductos() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Inicializar controlador
        productoController = new ProductoController();

        // Configurar tbl_consulta
        tbl_consulta.setModel(new NonEditableTableModel());
        DefaultTableModel tableModelConsulta = (DefaultTableModel) tbl_consulta.getModel();
        tableModelConsulta.setColumnIdentifiers(new String[]{"ID", "Categoría", "Referencia", "Nombre", "Descripción", "Stock", "Precio"});

        // Configurar tbl_seleccionado
        tbl_seleccionado.setModel(new NonEditableTableModel());
        DefaultTableModel tableModelSeleccionado = (DefaultTableModel) tbl_seleccionado.getModel();
        tableModelSeleccionado.setColumnIdentifiers(new String[]{"ID", "Categoría", "Referencia", "Nombre", "Descripción", "Stock", "Precio"});

        // Cargar productos automáticamente al iniciar
        cargarProductos();

        // Agregar listener de doble clic a tbl_consulta
        agregarListenerTablaConsulta();

        // Agregar listener al campo txt_consulta
        agregarListenerCampoConsulta();
    }

    private void agregarListenerTablaConsulta() {
        tbl_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Verificar si es un doble clic
                    int filaSeleccionada = tbl_consulta.getSelectedRow(); // Obtener fila seleccionada

                    if (filaSeleccionada >= 0) {
                        // Obtener datos de la fila seleccionada
                        DefaultTableModel model = (DefaultTableModel) tbl_consulta.getModel();
                        Object idProducto = model.getValueAt(filaSeleccionada, 0);
                        Object categoria = model.getValueAt(filaSeleccionada, 1);
                        Object referencia = model.getValueAt(filaSeleccionada, 2);
                        Object nombre = model.getValueAt(filaSeleccionada, 3);
                        Object descripcion = model.getValueAt(filaSeleccionada, 4);
                        Object stock = model.getValueAt(filaSeleccionada, 5);
                        Object precio = model.getValueAt(filaSeleccionada, 6);

                        // Mostrar datos en tbl_seleccionado
                        DefaultTableModel modelSeleccionado = (DefaultTableModel) tbl_seleccionado.getModel();
                        modelSeleccionado.setRowCount(0); // Limpiar la tabla
                        modelSeleccionado.addRow(new Object[]{idProducto, categoria, referencia, nombre, descripcion, stock, precio});
                    }
                }
            }
        });
    }

    private void cargarProductos() {
        try {
            // Obtener lista de productos desde el controlador
            productosOriginales = productoController.obtenerTodosLosProductos();

            // Mostrar productos en la tabla
            actualizarTabla(productosOriginales);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los productos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla(List<Producto> productos) {
        // Obtener el modelo de la tabla
        DefaultTableModel tableModel = (DefaultTableModel) tbl_consulta.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        tableModel.setRowCount(0);

        // Agregar los productos al modelo de la tabla
        for (Producto producto : productos) {
            tableModel.addRow(new Object[]{
                    producto.getIdProducto(),
                    producto.getIdCategoria(),
                    producto.getReferencia(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getStock(),
                    producto.getPrecio()
            });
        }
    }

    private void filtrarProductos() {
        String texto = txt_consulta.getText().toLowerCase(); // Texto del campo de búsqueda

        // Lista para almacenar productos filtrados
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productosOriginales) {
            // Verificar coincidencia exacta dentro de las cadenas
            if (producto.getReferencia().toLowerCase().contains(texto)
                    || producto.getNombre().toLowerCase().contains(texto)
                    || producto.getDescripcion().toLowerCase().contains(texto)
                    || String.valueOf(producto.getIdCategoria()).toLowerCase().contains(texto)) {
                productosFiltrados.add(producto);
            }
        }

        // Actualizar la tabla con los productos filtrados
        actualizarTabla(productosFiltrados);
    }

    private void agregarListenerCampoConsulta() {
        txt_consulta.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarProductos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarProductos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarProductos();
            }
        });
    }

    /**
     * Clase personalizada para desactivar la edición de celdas en las tablas.
     */
    private static class NonEditableTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas no son editables
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_crearProd = new javax.swing.JButton();
        btn_editarProd = new javax.swing.JButton();
        btn_eliminarProd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_inicio = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_seleccionado = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_consulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_consulta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(142, 225, 132));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("Mallie POS");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("¡Facturar nunca ha sido tan facil!");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cart50.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inventory50.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Gestione sus productos");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        btn_crearProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/new-file50.png"))); // NOI18N
        btn_crearProd.setText("Crear");
        btn_crearProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_crearProd.setPreferredSize(new java.awt.Dimension(100, 100));
        btn_crearProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_crearProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearProdActionPerformed(evt);
            }
        });

        btn_editarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/edit50.png"))); // NOI18N
        btn_editarProd.setText("Editar");
        btn_editarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_editarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_editarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarProdActionPerformed(evt);
            }
        });

        btn_eliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete50.png"))); // NOI18N
        btn_eliminarProd.setText("Eliminar");
        btn_eliminarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_eliminarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_eliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_crearProd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_editarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_eliminarProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_editarProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_crearProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navegacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        btn_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/home50.png"))); // NOI18N
        btn_inicio.setText("Inicio");
        btn_inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_inicio.setPreferredSize(new java.awt.Dimension(100, 100));
        btn_inicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/undo50.png"))); // NOI18N
        btn_atras.setText("Atras");
        btn_atras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_atras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/log-out50.png"))); // NOI18N
        jButton6.setText("Salir");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_atras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_inicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Nombre: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Version n°: 1.0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tbl_seleccionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Referencia", "Nombre", "Descripcion", "Categoria", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_seleccionado);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tbl_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Referencia", "Nombre", "Descripcion", "Categoria", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_consulta);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Buscar Producto:");

        txt_consulta.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Categoria:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_consulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarProdActionPerformed
        // Obtener el modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tbl_seleccionado.getModel();

        // Verificar si la tabla está vacía
        if (modeloTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "La tabla está vacía. No hay productos para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método
        }

        // Extraer los valores de la primera fila de la tabla
        try {
            int idProducto = Integer.parseInt(modeloTabla.getValueAt(0, 0).toString());
            int idCategoria = Integer.parseInt(modeloTabla.getValueAt(0, 1).toString());
            String referencia = modeloTabla.getValueAt(0, 2).toString();
            String nombre = modeloTabla.getValueAt(0, 3).toString();
            String descripcion = modeloTabla.getValueAt(0, 4).toString();
            int stock = Integer.parseInt(modeloTabla.getValueAt(0, 5).toString());
            float precio = Float.parseFloat(modeloTabla.getValueAt(0, 6).toString());

            // Crear el objeto EditarProducto
            EditarProducto editarProducto = new EditarProducto(idProducto, idCategoria, referencia, nombre, descripcion, stock, precio);
            editarProducto.setVisible(true);
            this.setVisible(false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al procesar los datos de la tabla. Verifica los valores.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_editarProdActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        ModuloInventario inventario = new ModuloInventario();
        inventario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        Bienvenida bienvenida = new Bienvenida();
        bienvenida.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_inicioActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_crearProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearProdActionPerformed
        CrearProducto crearProducto = new CrearProducto();
        crearProducto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_crearProdActionPerformed

    private void btn_eliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarProdActionPerformed
        
        int idProducto;
        // Obtener el modelo de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tbl_seleccionado.getModel();

        // Verificar si la tabla está vacía
        if (modeloTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "La tabla está vacía. No hay productos para Eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método
        }
        
        try {
            idProducto = Integer.parseInt(modeloTabla.getValueAt(0, 0).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al procesar los datos de la tabla. Verifica los valores.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        
        Producto productoLeido;
        try {
          productoLeido = Producto.buscarPorId(idProducto); 
          if (productoLeido != null) {
            try {
                productoLeido.eliminar();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al procesar los datos de la tabla. Verifica los valores."+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
          } else {
            System.out.println("Producto a eliminar no encontrado con ID: " + idProducto);
          }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(this, "Error al procesar los datos de la tabla. Verifica los valores."+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarProductos();
    }//GEN-LAST:event_btn_eliminarProdActionPerformed

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
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_crearProd;
    private javax.swing.JButton btn_editarProd;
    private javax.swing.JButton btn_eliminarProd;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_consulta;
    private javax.swing.JTable tbl_seleccionado;
    private javax.swing.JTextField txt_consulta;
    // End of variables declaration//GEN-END:variables
}
