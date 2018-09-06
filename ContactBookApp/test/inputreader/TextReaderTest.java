/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputreader;

import dsacoursework_ariyike.Contact;
import dsacoursework_ariyike.ContactList;
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
public class TextReaderTest {
    TextReader readText;
    
    public TextReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        readText = new TextReader();
    }
    
    @After
    public void tearDown() {
        readText = null;
    }

    /**
     * Test of load method, of class TextReader.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        String filename = "testContacts.txt";
        
        ContactList thisInstance = new ContactList();
        Contact contact1 = new Contact ("firstName1" , "lastName1",12345678 , "1email@gmail", "2018/07/01", "1contactType"); 
        Contact contact2 = new Contact ("firstName2" , "lastName2",22222222 , "2email@gmail", "2018/07/02", "2contactType");
        Contact contact3 = new Contact ("firstName3" , "lastName3",33333333 , "3email@gmail", "2018/07/03", "3contactType");
        
        thisInstance.addToFront(contact1);
        thisInstance.addToFront(contact2);
        thisInstance.addToFront(contact3);
        
        String expResult = thisInstance.getHead().getFirstName();
        String result = readText.load(filename).getHead().getFirstName();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of stripQuotes method, of class TextReader.
     */
    @Test
    public void testStripQuotes() {
        System.out.println("stripQuotes");
        String aString = "\"mint\"";
        String expResult = "mint";
        String result = readText.stripQuotes(aString);
        assertEquals(expResult, result);
    }

    /**
     * Test of display method, of class TextReader.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        readText.display();
    }

    /**
     * Test of saveToFile method, of class TextReader.
     */
    @Test
    public void testSaveToFile() {
        System.out.println("saveToFile");
        String filename = "testReadTo.txt";
        
        ContactList thisInstance = new ContactList();
        Contact contact1 = new Contact ("firstName1" , "lastName1",12345678 , "1email@gmail", "2018/07/01", "1contactType"); 
        Contact contact2 = new Contact ("firstName2" , "lastName2",22222222 , "2email@gmail", "2018/07/02", "2contactType");
        Contact contact3 = new Contact ("firstName3" , "lastName3",33333333 , "3email@gmail", "2018/07/03", "3contactType");
        
        thisInstance.addToFront(contact1);
        thisInstance.addToFront(contact2);
        thisInstance.addToFront(contact3);
        
        ContactList aList = thisInstance;
        readText.saveToFile(filename, aList);
    }
    
}
