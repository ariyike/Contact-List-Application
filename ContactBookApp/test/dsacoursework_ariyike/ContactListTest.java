/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework_ariyike;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class ContactListTest {
    
    ContactList contactList;
    Contact contact1;
    Contact contact2;
    Contact contact3;
    
    public ContactListTest() {
    }
   
    
    @Before
    public void setUp() {
        contactList = new ContactList();
        contact1 = new Contact ("firstName1" , "lastName1",12345678 , "1email@gmail", "1contactType");
        contact2 = new Contact ("firstName2" , "lastName2",22222222 , "2email@gmail", "2contactType");
        contact3 = new Contact ("firstName3" , "lastName3",33333333 , "3email@gmail", "3contactType");
        
    }
    
    @After
    public void tearDown() {
        contactList = null;
        contact1 = null;
        contact2 = null;
        contact3 = null;
    }

    /**
     * Test of getContactSize method, of class ContactList.
     */
    @Test
    public void testGetContactSize() {
        System.out.println("getContactSize");
        int expResult = 2;
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        int result = contactList.getContactSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHead method, of class ContactList.
     */
    @Test
    public void testGetHead() {
        System.out.println("getHead");
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        Contact expResult = contact2;
        Contact result = contactList.getHead();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTail method, of class ContactList.
     */
    @Test
    public void testGetTail() {
        System.out.println("getTail");
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        Contact expResult = contact1;
        Contact result = contactList.getTail();
        assertEquals(expResult, result);
    }

    /**
     * Test of addToFront method, of class ContactList.
     */
    @Test
    public void testAddToFront() {
        System.out.println("addToFront");
        Contact addThis = contact1;
        Contact expResult = contact1;
        Contact result = contactList.addToFront(addThis);
        assertEquals(expResult, result);
    }

    /**
     * Test of addToEnd method, of class ContactList.
     */
    @Test
    public void testAddToEnd() {
        System.out.println("addToEnd");
        Contact addThis = contact2;
        Contact expResult = contact2;
        Contact result = contactList.addToEnd(addThis);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeContact method, of class ContactList.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        contactList.addToFront(contact3);
        Contact removeThis = contact3;
        Contact expResult = contact3;
        Contact result = contactList.removeContact(removeThis);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchByTelephone method, of class ContactList.
     */
    @Test
    public void testSearchByTelephone() {
        System.out.println("searchByTelephone");
        int telephone = 22222222;
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        Contact expResult = contact2;
        Contact result = contactList.searchByTelephone(telephone);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchByName method, of class ContactList.
     */
    @Test
    public void testSearchByName() {
        System.out.println("searchByName");
        String firstName = "firstName3";
        String lastName = "lastName3";
        contactList.addToFront(contact3);
        contactList.addToFront(contact2);
        Contact expResult = contact3;
        Contact result = contactList.searchByName(firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of display method, of class ContactList.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        contactList.addToFront(contact3);
        contactList.display();
    }

    /**
     * Test of toString method, of class ContactList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String delimeter = ",";
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        contactList.addToFront(contact3);
        String result = contactList.toString(delimeter);
        String expResult = stringIt();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNextContact method, of class ContactList.
     */
    @Test
    public void testGetNextContact() {
        System.out.println("getNextContact");
        contactList.addToFront(contact1);
        contactList.addToFront(contact2);
        contactList.addToFront(contact3);
        Contact getNext = contact2;
        Contact expResult = contact1;
        Contact result = contactList.getNextContact(getNext);
        assertEquals(expResult, result);
    }
    
    private String stringIt() {
         String toPrint = "";
         String delimimi = ",";
         contactList.addToFront(contact1);
         contactList.addToFront(contact2);
         contactList.addToFront(contact3);
         
         Contact current = contactList.getHead();
         
            do{
                toPrint = toPrint.concat(current.toString(delimimi));
                current = contactList.getNextContact(current);
            }while(current != contactList.getHead());
         return toPrint;
    }
    
}