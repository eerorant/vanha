/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cavequest2.characters.Character;

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
public class CharacterTest {
    Character character;
    public CharacterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        JFXPanel fxPanel = new JFXPanel();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.character = new Character("file:", 100, 100);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void locationAtStartTest() {
        double X = this.character.getTranslateX();
        double Y = this.character.getTranslateY();
        assertEquals(100, X, 0);
        assertEquals(100, Y, 0);
    }
    
    @Test
    public void rotationAtStartTest() {
        double rotate = this.character.getRotate();
        assertEquals(0, rotate, 0);
    }
    
    @Test
    public void faceUpTest() {
        this.character.faceUp();
        double rotate = this.character.getRotate();
        assertEquals(0, rotate, 0);
    }
    
    @Test
    public void faceUpRightTest() {
        this.character.faceUpRight();
        double rotate = this.character.getRotate();
        assertEquals(45, rotate, 0);
    }
    
    @Test
    public void faceRightTest() {
        this.character.faceRight();
        double rotate = this.character.getRotate();
        assertEquals(90, rotate, 0);
    }
    
    @Test
    public void faceDownRightTest() {
        this.character.faceDownRight();
        double rotate = this.character.getRotate();
        assertEquals(135, rotate, 0);
    }
    
    @Test
    public void faceDownTest() {
        this.character.faceDown();
        double rotate = this.character.getRotate();
        assertEquals(180, rotate, 0);
    }
    
    @Test
    public void faceDownLeftTest() {
        this.character.faceDownLeft();
        double rotate = this.character.getRotate();
        assertEquals(225, rotate, 0);
    }
    
    @Test
    public void faceLeftTest() {
        this.character.faceLeft();
        double rotate = this.character.getRotate();
        assertEquals(270, rotate, 0);
    }
    
    @Test
    public void faceUpLeftTest() {
        this.character.faceUpLeft();
        double rotate = this.character.getRotate();
        assertEquals(315, rotate, 0);
    }
    
    @Test
    public void turnTest() {
        this.character.turnLeft();
        double rotate = this.character.getRotate();
        assertEquals(315, rotate, 0);
    }
    
    @Test
    public void moveTest() {
        this.character.move();
        double X = this.character.getTranslateX();
        double Y = this.character.getTranslateY();
        
        assertEquals(100, X, 0);
        assertEquals(99, Y, 0);
    }
    
    @Test
    public void moveTest2() {
        this.character.faceRight();
        this.character.move();
        
        double X = this.character.getTranslateX();
        double Y = this.character.getTranslateY();

        assertEquals(101, X, 0);
        assertEquals(100, Y, 0);
    }
}
