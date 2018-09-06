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
public class CircularLinkedListTest {
    
    CircularLinkedList<Integer> tester ;
    Integer one;
    Integer two;
    Integer three;
    Integer four;
        
    public CircularLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tester = new CircularLinkedList<>();
        one = 1;
        two = 2;
        three = 3;
        four = 4;
    }
    
    @After
    public void tearDown() {
        tester = null;
        one = null;
        two = null;
        three = null;
        four = null;
    }

    /**
     * Test of prepend method, of class CircularLinkedList.
     */
    @Test
    public void testPrepend() {
        System.out.println("prepend");
        Integer addThis = one;
        Object expResult = 1;
        Object result = tester.prepend(addThis);
        assertEquals(expResult, result);
    }

    /**
     * Test of append method, of class CircularLinkedList.
     */
    @Test
    public void testAppend() {
        System.out.println("append");
        Integer addThis = three;
        Object expResult = 3;
        Object result = tester.append(addThis);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class CircularLinkedList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        
        tester.append(one);
        tester.append(two);
        tester.prepend(three);
        tester.append(four);
        
        Integer data = four;
        Object expResult = 4;
        Object result = tester.remove(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of search method, of class CircularLinkedList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        
        tester.append(one);
        tester.append(two);
        tester.prepend(three);
        tester.append(four);
        
        Integer searchByThis = one;
        Object expResult = 1;
        Object result = tester.search(searchByThis);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class CircularLinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        boolean expResult = true;
        boolean result = tester.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class CircularLinkedList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        
        tester.append(one);
        tester.append(two);
        tester.prepend(three);
        tester.append(four);
        
        int expResult = 4;
        int result = tester.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of display method, of class CircularLinkedList.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        
        tester.append(one);
        tester.append(two);
        tester.prepend(three);
        tester.append(four);
        
        tester.display();
    }
    
}
