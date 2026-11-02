package vista;

import controller.InventarioController;
import model.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmInventario extends javax.swing.JFrame {
    
    private final InventarioController controller;
    private JTabbedPane tabbedPaneInventario;
    
    private JTable tablaAros, tablaLunas, tablaAccesorios;
    private DefaultTableModel modeloAros, modeloLunas, modeloAccesorios;

    public FrmInventario() {
        setTitle("Inventario de Productos");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new InventarioController();
        tabbedPaneInventario = new JTabbedPane();

        configurarPestanaAros();
        configurarPestanaLunas();
        configurarPestanaAccesorios();

        add(tabbedPaneInventario, BorderLayout.CENTER);
    }

    // ==========================================
    // PESTAÑA AROS 
    // ==========================================
    private void configurarPestanaAros() {
        JPanel panelAros = new JPanel(new BorderLayout());
        
        JPanel panelForm = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtNombre = new JTextField(8);
        JTextField txtMarca = new JTextField(8);
        JTextField txtPrecio = new JTextField(5);
        JTextField txtStock = new JTextField(4);
        
        panelForm.add(new JLabel("Nombre:")); panelForm.add(txtNombre);
        panelForm.add(new JLabel("Marca:")); panelForm.add(txtMarca);
        panelForm.add(new JLabel("Precio:")); panelForm.add(txtPrecio);
        panelForm.add(new JLabel("Stock:")); panelForm.add(txtStock);
        
        JButton btnAgregar = new JButton("Agregar Aro");
        panelForm.add(btnAgregar);
        
        String[] cols = {"ID", "Nombre", "Marca", "Material", "Forma", "Precio", "Stock"};
        modeloAros = new DefaultTableModel(cols, 0);
        tablaAros = new JTable(modeloAros);
        
        panelAros.add(panelForm, BorderLayout.NORTH);
        panelAros.add(new JScrollPane(tablaAros), BorderLayout.CENTER);
        
        tabbedPaneInventario.addTab("Aros", panelAros);
        cargarTabla("ARO", modeloAros, true);

        btnAgregar.addActionListener(e -> {
            try {
                if (txtNombre.getText().trim().isEmpty() || txtMarca.getText().trim().isEmpty() || 
                    txtPrecio.getText().trim().isEmpty() || txtStock.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Producto p = new Producto();
                p.setNombre(txtNombre.getText().trim());
                p.setTipoProducto("ARO"); 
                p.setMarca(txtMarca.getText().trim());
                p.setMaterial("Mixto"); // Valor por defecto
                p.setForma("Redondo");  // Valor por defecto
                p.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
                p.setStock(Integer.parseInt(txtStock.getText().trim()));
                
                if (controller.registrarProducto(p)) {
                    cargarTabla("ARO", modeloAros, true);
                    txtNombre.setText(""); txtMarca.setText(""); txtPrecio.setText(""); txtStock.setText("");
                    JOptionPane.showMessageDialog(this, "Aro agregado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo guardar. Revisa la consola.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número decimal y el stock un entero.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    // ==========================================
    // PESTAÑA LUNAS
    // ==========================================
    private void configurarPestanaLunas() {
        JPanel panelLunas = new JPanel(new BorderLayout());
        
        // Formulario para agregar Luna
        JPanel panelForm = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtNombre = new JTextField(8);
        JTextField txtMarca = new JTextField(8);
        JTextField txtPrecio = new JTextField(5);
        JTextField txtStock = new JTextField(4);
        
        panelForm.add(new JLabel("Nombre:")); panelForm.add(txtNombre);
        panelForm.add(new JLabel("Marca:")); panelForm.add(txtMarca);
        panelForm.add(new JLabel("Precio:")); panelForm.add(txtPrecio);
        panelForm.add(new JLabel("Stock:")); panelForm.add(txtStock);
        
        JButton btnAgregar = new JButton("Agregar Luna");
        panelForm.add(btnAgregar);

        String[] cols = {"ID", "Nombre", "Marca", "Material", "Precio", "Stock"};
        modeloLunas = new DefaultTableModel(cols, 0);
        tablaLunas = new JTable(modeloLunas);
        
        panelLunas.add(panelForm, BorderLayout.NORTH);
        panelLunas.add(new JScrollPane(tablaLunas), BorderLayout.CENTER);
        tabbedPaneInventario.addTab("Lunas", panelLunas);
        cargarTabla("LUNA", modeloLunas, false);

        // Evento del botón Agregar Luna
        btnAgregar.addActionListener(e -> {
            try {
                if (txtNombre.getText().trim().isEmpty() || txtMarca.getText().trim().isEmpty() || 
                    txtPrecio.getText().trim().isEmpty() || txtStock.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Producto p = new Producto();
                p.setNombre(txtNombre.getText().trim());
                p.setTipoProducto("LUNA"); 
                p.setMarca(txtMarca.getText().trim());
                p.setMaterial("Resina"); // Valor por defecto para lunas
                p.setForma("N/A");       // Las lunas no tienen forma
                p.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
                p.setStock(Integer.parseInt(txtStock.getText().trim()));
                
                if (controller.registrarProducto(p)) {
                    cargarTabla("LUNA", modeloLunas, false);
                    txtNombre.setText(""); txtMarca.setText(""); txtPrecio.setText(""); txtStock.setText("");
                    JOptionPane.showMessageDialog(this, "Luna agregada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo guardar. Revisa la consola.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número decimal y el stock un entero.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    // ==========================================
    // PESTAÑA ACCESORIOS
    // ==========================================
    private void configurarPestanaAccesorios() {
        JPanel panelAcc = new JPanel(new BorderLayout());
        
        // Formulario para agregar Accesorio
        JPanel panelForm = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtNombre = new JTextField(8);
        JTextField txtMarca = new JTextField(8);
        JTextField txtPrecio = new JTextField(5);
        JTextField txtStock = new JTextField(4);
        
        panelForm.add(new JLabel("Nombre:")); panelForm.add(txtNombre);
        panelForm.add(new JLabel("Marca:")); panelForm.add(txtMarca);
        panelForm.add(new JLabel("Precio:")); panelForm.add(txtPrecio);
        panelForm.add(new JLabel("Stock:")); panelForm.add(txtStock);
        
        JButton btnAgregar = new JButton("Agregar Accesorio");
        panelForm.add(btnAgregar);

        String[] cols = {"ID", "Nombre", "Marca", "Precio", "Stock"};
        modeloAccesorios = new DefaultTableModel(cols, 0);
        tablaAccesorios = new JTable(modeloAccesorios);
        
        panelAcc.add(panelForm, BorderLayout.NORTH);
        panelAcc.add(new JScrollPane(tablaAccesorios), BorderLayout.CENTER);
        tabbedPaneInventario.addTab("Accesorios", panelAcc);
        cargarTabla("ACCESORIO", modeloAccesorios, false);

        // Evento del botón Agregar Accesorio
        btnAgregar.addActionListener(e -> {
            try {
                if (txtNombre.getText().trim().isEmpty() || txtMarca.getText().trim().isEmpty() || 
                    txtPrecio.getText().trim().isEmpty() || txtStock.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Producto p = new Producto();
                p.setNombre(txtNombre.getText().trim());
                p.setTipoProducto("ACCESORIO"); 
                p.setMarca(txtMarca.getText().trim());
                p.setMaterial("N/A"); // Los accesorios no suelen tener material
                p.setForma("N/A");    // Los accesorios no tienen forma
                p.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
                p.setStock(Integer.parseInt(txtStock.getText().trim()));
                
                if (controller.registrarProducto(p)) {
                    cargarTabla("ACCESORIO", modeloAccesorios, false);
                    txtNombre.setText(""); txtMarca.setText(""); txtPrecio.setText(""); txtStock.setText("");
                    JOptionPane.showMessageDialog(this, "Accesorio agregado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo guardar. Revisa la consola.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número decimal y el stock un entero.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    // ==========================================
    // MÉTODO GENERAL PARA LLENAR TABLAS
    // ==========================================
    private void cargarTabla(String tipo, DefaultTableModel modelo, boolean tieneMaterialYForma) {
        modelo.setRowCount(0);
        for (Producto p : controller.listarPorTipo(tipo)) {
            if (tieneMaterialYForma) {
                // Para Aros (7 columnas)
                modelo.addRow(new Object[]{
                    p.getIdProducto(), p.getNombre(), p.getMarca(), 
                    p.getMaterial(), p.getForma(), p.getPrecio(), p.getStock()
                });
            } else if (tipo.equals("LUNA")) {
                // Para Lunas (6 columnas)
                modelo.addRow(new Object[]{
                    p.getIdProducto(), p.getNombre(), p.getMarca(), 
                    p.getMaterial(), p.getPrecio(), p.getStock()
                });
            } else {
                // Para Accesorios (5 columnas)
                modelo.addRow(new Object[]{
                    p.getIdProducto(), p.getNombre(), p.getMarca(), 
                    p.getPrecio(), p.getStock()
                });
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmInventario().setVisible(true));
    }
}