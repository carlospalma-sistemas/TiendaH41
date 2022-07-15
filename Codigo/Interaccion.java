import javax.swing.JOptionPane;
import java.util.List;

public class Interaccion
{
    private Almacen a;
    
    public Interaccion()
    {
        a = new Almacen();
    }
    
    public void presentarMenuPrincipal()
    {
        int opcion = 0;
        do
        {
            String menu = "PROGRAMA DEL TENDERO DE MI BARRIO \n" +
                          "1. Productos \n" + 
                          "2. Ventas \n" + 
                          "0. Salir del programa";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Seleccione opci�n", JOptionPane.QUESTION_MESSAGE));
            switch(opcion)
            {
                case 1:
                    this.presentarMenuProductos();
                    break;
                case 2:
                    this.generarVenta();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opci�n incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                          
            }             
        }
        while(opcion != 0);
    }
    
    public void presentarMenuProductos()
    {
        int opcion = 0;
        do
        {
            String menu = "MENU PRODUCTOS \n" +
                          "1. Ingresar un producto \n" + 
                          "2. Mostrar productos \n" + 
                          "3. Buscar productos \n" +
                          "4. Surtir producto \n" +
                          "0. Volver al men� principal";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Seleccione opci�n", JOptionPane.QUESTION_MESSAGE));
            switch(opcion)
            {
                case 1:
                    this.ingresarProducto();
                    break;
                case 2:
                    this.mostrarProductos();
                    break;
                case 3:
                    this.buscarProductos();
                    break;
                case 4:
                    this.surtirProducto();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opci�n incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion != 0);
    }
    
    public void ingresarProducto()
    {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        int codigo = a.getSiguienteCodigo();
        String marca = JOptionPane.showInputDialog(null, "Ingrese marca de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion = JOptionPane.showInputDialog(null, "Ingrese presentacion de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String [] tipos = {"Aseo", "Alimento"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione tipo de producto", "Nuevo producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese precio de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        
        Producto p = new Producto(nombre, codigo, precio, presentacion, cantidad, marca, tipos[tipo]);
        a.agregarProducto(p);
        JOptionPane.showMessageDialog(null, "Se ha a�adido el producto al almac�n", "Producto creado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarProductos()
    {
        List<Producto> listaProductos = a.getListaProductos();
        String lista = "";
        for (Producto p: listaProductos)
        {
            lista = lista + p.toString() + "\n";
        }
         JOptionPane.showMessageDialog(null, lista, "Productos en el almac�n", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void buscarProductos()
    {
        String criterio = JOptionPane.showInputDialog(null, "Ingrese dato de producto a buscar (nombre, marca, present o tipo)", "Buscar productos", JOptionPane.QUESTION_MESSAGE);
        List<Producto> listaProductos = a.buscarProductos(criterio);
        String lista = "";
        for (Producto p: listaProductos)
        {
            lista = lista + p.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista, "Productos encontrados", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void surtirProducto()
    {
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo de producto a surtir", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de producto a surtir", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        a.aumentarCantProducto(codigo, cantidad); 
    }
    
    public void generarVenta()
    {
        Venta v = new Venta();
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo de producto a surtir", "Vender producto", JOptionPane.QUESTION_MESSAGE));
        Producto p = a.buscarProducto(codigo);
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de producto a vender", "Vender producto", JOptionPane.QUESTION_MESSAGE));
        boolean agregado = v.agregarACarrito(p, cantidad);
        if (agregado)
        {
            JOptionPane.showMessageDialog(null, "Producto agregado al carrito", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}






