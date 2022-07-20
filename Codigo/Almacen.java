import java.util.List;
import java.util.ArrayList;

public class Almacen 
{
    private List<Producto> listaProductos;
    
    public Almacen() 
    {
        
    }
    
    public List<Producto> getListaProductos()
    {
        return this.listaProductos;
    }
    
    public void agregarProducto(Producto p) 
    {
        
    }
  
    public Producto buscarProducto(int codigo) 
    {
        return null;
    }
    
    public ArrayList<Producto> buscarProductos(String criterio) 
    {
        ArrayList<Producto> listaResultado = new ArrayList<Producto>();
        return listaResultado;
    }
    
    public void eliminarProducto(int codigo) 
    {
        
    }

    public void aumentarCantProducto(int codigo, int cant) 
    {
        
    }

    public void disminuirCantProducto(int codigo, int cant) 
    {
        
    }
    
    
    public void modificarPrecio(int codigo, int precio) 
    {
        
    }

}