import cavequest2.Border;
import cavequest2.CaveQuest2App;
import cavequest2.characters.Character;
import cavequest2.characters.Knight;
import javafx.embed.swing.JFXPanel;


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
        //I don't quite know what this does, but the tests don't work without it
        JFXPanel fxPanel = new JFXPanel();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.knight = new Knight(100, 100);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
}
