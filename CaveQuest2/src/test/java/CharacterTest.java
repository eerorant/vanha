import cavequest2.characters.Character;

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
public class CharacterTest {
    Character character;
    public CharacterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        character = new Character("File:knight.png", 100, 100);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    //I couldn't do tests this week, maybe next week
//    @Test
//    public void hello() {
//        double X = character.getTranslateX();
//        assertEquals(100, X);
//    }
}
