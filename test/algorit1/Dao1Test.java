/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arnoldas
 */
public class Dao1Test {
    
    public Dao1Test() {
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

    /**
     * Test of open method, of class Dao1.
     */
    @Test
    public void testOpen() {
        System.out.println("open");
        String fileName = "";
        String pointersFile = "";
        Dao1 instance = new Dao1();
        instance.open(fileName, pointersFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDydis method, of class Dao1.
     */
    @Test
    public void testGetDydis() {
        System.out.println("getDydis");
        Dao1 instance = new Dao1();
        int expResult = 0;
        int result = instance.getDydis();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDydis1 method, of class Dao1.
     */
    @Test
    public void testGetDydis1() {
        System.out.println("getDydis1");
        Dao1 instance = new Dao1();
        int expResult = 0;
        int result = instance.getDydis1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class Dao1.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        Dao1 instance = new Dao1();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pirmyn method, of class Dao1.
     */
    @Test
    public void testPirmyn() {
        System.out.println("pirmyn");
        Dao1 instance = new Dao1();
        instance.pirmyn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atgal method, of class Dao1.
     */
    @Test
    public void testAtgal() {
        System.out.println("atgal");
        Dao1 instance = new Dao1();
        instance.atgal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Dao1.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int i = 0;
        Dao1 instance = new Dao1();
        int expResult = 0;
        int result = instance.get(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Dao1.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int i = 0;
        int value = 0;
        Dao1 instance = new Dao1();
        int expResult = 0;
        int result = instance.set(i, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set1 method, of class Dao1.
     */
    @Test
    public void testSet1() {
        System.out.println("set1");
        int i = 0;
        int value = 0;
        Dao1 instance = new Dao1();
        int expResult = 0;
        int result = instance.set1(i, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Dao1.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Dao1.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeFile method, of class Dao1.
     */
    @Test
    public void testMakeFile() {
        System.out.println("makeFile");
        String filename = "";
        Dao1.makeFile(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeFilePointers method, of class Dao1.
     */
    @Test
    public void testMakeFilePointers() {
        System.out.println("makeFilePointers");
        String filename = "";
        Dao1.makeFilePointers(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bubbleSort method, of class Dao1.
     */
    @Test
    public void testBubbleSort() {
        System.out.println("bubbleSort");
        Dao dao1 = null;
        Dao1.bubbleSort(dao1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
