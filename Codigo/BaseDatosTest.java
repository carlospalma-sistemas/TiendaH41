import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseDatosTest
{
    public BaseDatosTest()
    {
    }

    @BeforeEach
    public void setUp()
    {
    }

    @Test
    public void probarConexionBD()
    {
        BaseDatos bd = new BaseDatos();
        assertEquals(true, bd.crearConexion());
        assertEquals(true, bd.cerrarConexion());
    }
    
    @AfterEach
    public void tearDown()
    {
    }
}
