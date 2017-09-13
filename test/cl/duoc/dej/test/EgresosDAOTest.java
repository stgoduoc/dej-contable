package cl.duoc.dej.test;

import cl.duoc.dej.entity.Egreso;
import cl.duoc.dej.service.EgresosDAO;
import cl.duoc.dej.service.EgresosDAOSessionImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public class EgresosDAOTest {
    
    List<Egreso> egresos = new ArrayList<>();
    
    public EgresosDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    // ###################################################################
    // ###################################################################
    
    @Test
    public void eliminarDAO() {
        Egreso e1 = new Egreso('o', "asdf", true, "", 100000L, "12345678-5");
        Egreso e2 = new Egreso('o', "fdsa", false, "", 99999L, "87654321-5");
        
        egresos.add(e1);
        egresos.add(e2);
        
        egresos.remove(new Egreso(e1.getCodigoEgreso()));
        
        assert egresos.size() == 1;
    }
    
    
}
