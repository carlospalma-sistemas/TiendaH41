import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class GUI extends JFrame
{
    JTextField txtId, txtNombre, txtMarca, txtPresentacion, txtCantidad, txtPrecio, txtFiltro;
    JComboBox comboTipo;
    JButton btnIngresar, btnModificar, btnEliminar, btnLimpiar, btnFiltrar, btnQuitarFiltro;
    DefaultTableModel dtm;
    JTable tablaProductos;
    
    public GUI()
    {
        iniciarComponentes();
        cargarTodosLosProductos();
        implementarListeners();
    }
    
    public void iniciarComponentes()
    {
        setTitle("Tienda H41");
        setBounds(100, 40, 1200, 600);
        setLayout(null);
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setBounds(5, 5, 405, 600);
        panelFormulario.setBackground(new Color(170, 170, 255));
        panelFormulario.setLayout(null);
        getContentPane().add(panelFormulario);
        
        JPanel panelTabla = new JPanel();
        panelTabla.setBounds(415, 5, 790, 600);
        panelTabla.setBackground(new Color(170, 170, 255));
        panelTabla.setLayout(null);
        getContentPane().add(panelTabla);
        
        JLabel labelId = new JLabel("Id");
        labelId.setBounds(10, 20, 100, 30);
        panelFormulario.add(labelId);
        
        txtId = new JTextField();
        txtId.setBounds(120, 20, 200, 30);
        txtId.setEditable(false);
        panelFormulario.add(txtId);
        
        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(10, 70, 100, 30);
        panelFormulario.add(labelNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(120, 70, 200, 30);
        panelFormulario.add(txtNombre);
        
        JLabel labelMarca = new JLabel("Marca");
        labelMarca.setBounds(10, 120, 100, 30);
        panelFormulario.add(labelMarca);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(120, 120, 200, 30);
        panelFormulario.add(txtMarca);
        
        JLabel labelPresentacion = new JLabel("Presentación");
        labelPresentacion.setBounds(10, 170, 100, 30);
        panelFormulario.add(labelPresentacion);
        
        txtPresentacion = new JTextField();
        txtPresentacion.setBounds(120, 170, 200, 30);
        panelFormulario.add(txtPresentacion);
        
        JLabel labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(10, 220, 100, 30);
        panelFormulario.add(labelTipo);
        
        comboTipo = new JComboBox();
        comboTipo.setBounds(120, 220, 200, 30);
        comboTipo.addItem("");
        comboTipo.addItem("Aseo");
        comboTipo.addItem("Alimento");
        panelFormulario.add(comboTipo);
        
        JLabel labelCant = new JLabel("Cantidad");
        labelCant.setBounds(10, 270, 100, 30);
        panelFormulario.add(labelCant);
        
        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 270, 200, 30);
        panelFormulario.add(txtCantidad);
        
        JLabel labelPrecio = new JLabel("Precio    $");
        labelPrecio.setBounds(10, 320, 100, 30);
        panelFormulario.add(labelPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 320, 200, 30);
        panelFormulario.add(txtPrecio);
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(10, 500, 90, 30);
        panelFormulario.add(btnIngresar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(110, 500, 90, 30);
        panelFormulario.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(210, 500, 90, 30);
        panelFormulario.add(btnEliminar);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(310, 500, 90, 30);
        panelFormulario.add(btnLimpiar);
        
        JLabel labelFiltro = new JLabel("Filtrar por");
        labelFiltro.setBounds(10, 500, 80, 30);
        panelTabla.add(labelFiltro);
        
        txtFiltro = new JTextField();
        txtFiltro.setBounds(100, 500, 300, 30);
        panelTabla.add(txtFiltro);
        
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBounds(410, 500, 90, 30);
        panelTabla.add(btnFiltrar);
        
        btnQuitarFiltro = new JButton("Quitar filtro");
        btnQuitarFiltro.setBounds(510, 500, 120, 30);
        panelTabla.add(btnQuitarFiltro);
        
        //Componentes del panel de la tabla
        Object[][] datos = null;
        String[] columnas = {"Codigo", "Nombre", "Marca", "Presentación", "Tipo", "Cant", "Precio"};     
        dtm= new DefaultTableModel(datos, columnas);
        
        tablaProductos = new JTable(dtm);
        tablaProductos.setPreferredScrollableViewportSize(new Dimension(750, 350));
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(tablaProductos);
        
        JPanel contenidoTabla = new JPanel();
        contenidoTabla.setBounds(10, 20, 750, 350);
        contenidoTabla.setLayout(new GridLayout(1,0));
        contenidoTabla.add(scroll);
        panelTabla.add(contenidoTabla);
        
        setVisible(true);
    }
    
    public void implementarListeners()
    {
        btnFiltrar.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    cargarProductosFiltrados();
                }
            });
            
        btnQuitarFiltro.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    limpiarFiltro();
                }
            });
            
        btnIngresar.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    ingresarNuevoProducto();
                }
            });
            
        btnModificar.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    modificarProducto();
                }
            });
        
        btnLimpiar.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    limpiarFormulario();
                }
            });
            
        tablaProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
            {
                public void valueChanged(ListSelectionEvent e) 
                {
                    if (tablaProductos.getSelectedRowCount() > 0) 
                    {
                        int row = tablaProductos.getSelectedRow();
                        int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
                        cargarProductoEnFormulario(id);
                    }
                }
            });
    }
    
    
    public void cargarTodosLosProductos()
    {
        Almacen a = new Almacen();
        List<Producto> productos = a.getListaProductos();
        dtm.setRowCount(0);
        for(Producto p : productos)
        {
            Object[] row = { p.getCodigo(), p.getNombre(), p.getMarca(), p.getPresentacion(), p.getTipo(), p.getCantidad(), p.getPrecio()};
            dtm.addRow(row);
        }
    }
    
    public void cargarProductosFiltrados()
    {
        String criterio = txtFiltro.getText();
        Almacen a = new Almacen();
        List<Producto> productos = a.buscarProductos(criterio);
        dtm.setRowCount(0);
        for(Producto p : productos)
        {
            Object[] row = { p.getCodigo(), p.getNombre(), p.getMarca(), p.getPresentacion(), p.getTipo(), p.getCantidad(), p.getPrecio()};
            dtm.addRow(row);
        }
    }
    
    public void limpiarFiltro()
    {
        txtFiltro.setText("");
        cargarTodosLosProductos();
    }
    
    public void ingresarNuevoProducto()
    {
        if (!txtId.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar información de un nuevo producto");
            return;
        }
        
        if (txtNombre.getText().equals("") || txtMarca.getText().equals("") || txtPresentacion.getText().equals("") || comboTipo.getSelectedItem().equals("") || txtCantidad.getText().equals("") || txtPrecio.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar los datos completos de un nuevo producto");
            return;
        }
        
        String nombre = txtNombre.getText();
        String marca = txtMarca.getText();
        String presentacion = txtPresentacion.getText();
        String tipo = comboTipo.getSelectedItem().toString();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int precio = Integer.parseInt(txtPrecio.getText());
        Producto p = new Producto(nombre, precio, presentacion, cantidad, marca, tipo);
        Almacen a = new Almacen();
        a.agregarProducto(p);
        limpiarFormulario();
        cargarTodosLosProductos();
    }
    
    public void modificarProducto()
    {
        if (txtNombre.getText().equals("") || txtMarca.getText().equals("") || txtPresentacion.getText().equals("") || comboTipo.getSelectedItem().equals("") || txtCantidad.getText().equals("") || txtPrecio.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Deben estar los datos completos de un producto a modificar");
            return;
        }
        int id = Integer.parseInt(txtId.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int precio = Integer.parseInt(txtPrecio.getText());
        Almacen a = new Almacen();
        a.surtirProducto(id, cantidad, precio);
        limpiarFormulario();
        cargarTodosLosProductos();
    }
    
    
    public void limpiarFormulario()
    {
        txtId.setText("");
        txtNombre.setText("");
        txtMarca.setText("");
        txtPresentacion.setText("");
        comboTipo.setSelectedItem("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        habilitarFormulario();
    }
    
    public void habilitarFormulario()
    {
        txtNombre.setEditable(true);
        txtMarca.setEditable(true);
        txtPresentacion.setEditable(true);
        comboTipo.setEnabled(true);
    }
    
    public void deshabilitarFormulario()
    {
        txtNombre.setEditable(false);
        txtMarca.setEditable(false);
        txtPresentacion.setEditable(false);
        comboTipo.setEnabled(false);
    }
    
    
    public void cargarProductoEnFormulario(int id)
    {
        Almacen a = new Almacen();
        Producto p = a.buscarProducto(id);
        txtId.setText(p.getCodigo() + "");
        txtNombre.setText(p.getNombre());
        txtMarca.setText(p.getMarca());
        txtPresentacion.setText(p.getPresentacion());
        comboTipo.setSelectedItem(p.getTipo());
        txtCantidad.setText(p.getCantidad() + "");
        txtPrecio.setText(p.getPrecio() + "");
        deshabilitarFormulario();
    }
    
}






