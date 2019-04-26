import cavequest2.characters.Knight;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eero
 */
public class KnightTest {
    Knight knight;
    public KnightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        knight = new Knight(100, 100);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    //These tests dont work and I have no idea how to make them work
    @Test
    public void hello() {
        double X = knight.getTranslateX();
        assertEquals(100, X);
    }
}
