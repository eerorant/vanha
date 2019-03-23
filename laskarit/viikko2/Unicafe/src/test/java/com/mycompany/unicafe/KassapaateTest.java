/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void kassassaRahaaAluksi() {
        int rahaa = kassa.kassassaRahaa();
        assertEquals(100000, rahaa);
    }
    
    @Test
    public void edullisiaMyytyAluksi() {
        int edullisiaMyyty = kassa.edullisiaLounaitaMyyty();
        assertEquals(0, edullisiaMyyty);
    }
    
    @Test
    public void maukkaitaMyytyAluksi() {
       int maukkaitaMyyty = kassa.maukkaitaLounaitaMyyty();
       assertEquals(0, maukkaitaMyyty);
    }
    
    @Test
    public void kateisTesti1() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisTesti2() {
        int maksu = 500;
        int vaihtoraha = kassa.syoEdullisesti(maksu);
        assertEquals(maksu - 240, vaihtoraha);
    }
    
    @Test
    public void kateisTesti3() {
        kassa.syoEdullisesti(500);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisTesti4() {
        int vaihtoraha = kassa.syoEdullisesti(200);
        assertEquals(200, vaihtoraha);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisTesti5() {
        int maksu = 500;
        int vaihtoraha = kassa.syoMaukkaasti(maksu);
        assertEquals(maksu - 400, vaihtoraha);
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisTeisti6() {
        int vaihtoraha = kassa.syoMaukkaasti(200);
        assertEquals(200, vaihtoraha);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    //Sitten korttitestit
    
    @Test
    public void korttiTesti1() {
        boolean osto = kassa.syoEdullisesti(kortti);
        assertTrue(osto);
        assertEquals(760, kortti.saldo());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        
    }
    
    @Test
    public void korttiTesti2() {
        boolean osto = kassa.syoMaukkaasti(kortti);
        assertTrue(osto);
        assertEquals(600, kortti.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiTesti3() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        //nyt kortilla on 2 euroa, maukkaita annoksia on myyty 2
        
        boolean osto = kassa.syoEdullisesti(kortti);
        assertFalse(osto);
        assertEquals(200, kortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiTesti4() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        //nyt kortilla on 2 euroa, maukkaita annoksia on myyty 2
        
        boolean osto = kassa.syoMaukkaasti(kortti);
        assertFalse(osto);
        assertEquals(200, kortti.saldo());
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiTesti5() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiTesti6() {
        kassa.lataaRahaaKortille(kortti, 1500);
        assertEquals(2500, kortti.saldo());
        assertEquals(101500, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiTesti7() {
        kassa.lataaRahaaKortille(kortti, -1000);
        assertEquals(1000, kortti.saldo());
    }
}
