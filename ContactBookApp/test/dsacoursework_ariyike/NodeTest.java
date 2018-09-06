/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework_ariyike;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class NodeTest {
    Node<String> testNode;
    
    public NodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       testNode = new Node<>("I'm a Node"); 
    }
    
    @After
    public void tearDown() {
        testNode = null;
    }

    /**
     * Test of display method, of class Node.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        testNode.display();
    }

    /**
     * Test of getData method, of class Node.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Object expResult = "I'm a Node";
        Object result = testNode.getData();
        assertEquals(expResult, result);
    }
    
}
