/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework_ariyike;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class ContactTest {
    Contact contact;
    public ContactTest() {
    }

    
    @Before
    public void setUp() {
        contact = new Contact ("firstName" , "lastName",12345678 , "email@gmail", "contactType");
    }
    
    @After
    public void tearDown() {
        contact = null;
    }

    /**
     * Test of getFirstName method, of class Contact.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "firstName";
        String result = contact.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Contact.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "lastName";
        String result = contact.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelephoneNumber method, of class Contact.
     */
    @Test
    public void testGetTelephoneNumber() {
        System.out.println("getTelephoneNumber");
        int expResult = 12345678;
        int result = contact.getTelephoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Contact.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "email@gmail";
        String result = contact.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateCreated method, of class Contact.
     */
    @Test
    public void testGetDateCreated() {
        System.out.println("getDateCreated");
        LocalDate expResult = LocalDate.now();
        LocalDate result = contact.getDateCreated();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateCreatedAsString method, of class Contact.
     */
    @Test
    public void testGetDateCreatedAsString() {
        System.out.println("getDateCreatedAsString");
        LocalDate dateToSet = LocalDate.now();
        String expResult = dateToSet.toString();
        String result = contact.getDateCreatedAsString(dateToSet);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactType method, of class Contact.
     */
    @Test
    public void testGetContactType() {
        System.out.println("getContactType");
        String expResult = "contactType";
        String result = contact.getContactType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Contact.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "kiki";
        String expResult = "kiki";
        contact.setFirstName(firstName);
        assertEquals(expResult, contact.firstName);
        
    }

    /**
     * Test of setlastName method, of class Contact.
     */
    @Test
    public void testSetlastName() {
        System.out.println("setlastName");
        String lastName = "kamanu";
        String expResult = "kamanu";
        contact.setlastName(lastName);
        assertEquals(expResult, contact.lastName);
    }

    /**
     * Test of setTelephoneNumber method, of class Contact.
     */
    @Test
    public void testSetTelephoneNumber() {
        System.out.println("setTelephoneNumber");
        int telephoneNumber = 33334444;
        int expResult = 33334444;
        contact.setTelephoneNumber(telephoneNumber);
        assertEquals(expResult, contact.telephoneNumber);
    }

    /**
     * Test of setEmail method, of class Contact.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "g@gmail";
        String expResult = "g@gmail";
        contact.setEmail(email);
        assertEquals(expResult, contact.email);
    }

    /**
     * Test of setDateCreated method, of class Contact.
     */
    @Test
    public void testSetDateCreated() {
        System.out.println("setDateCreated");
        String dateCreated = "2018/07/19";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate expResult = LocalDate.parse(dateCreated, dateFormat);
        contact.setDateCreated(dateCreated);
        assertEquals(expResult, contact.dateCreated);
    }

    /**
     * Test of setContactType method, of class Contact.
     */
    @Test
    public void testSetContactType() {
        System.out.println("setContactType");
        String contactType = "personal";
        String expResult = "personal";
        contact.setContactType(contactType);
        assertEquals(expResult, contact.contactType);
    }

    /**
     * Test of toString method, of class Contact.
     */
    @Test
    public void testToString_0args() {
        System.out.println("toString");
        String expResult = "First Name: " +contact.firstName+ " |Last Name: " +contact.lastName+ " |Email Address: " +contact.email + 
                            " |Telephone Number: " +contact.telephoneNumber+ " |Date Created: " +contact.dateCreated+ " |Contact Type: "
                            +contact.contactType;
        String result = contact.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Contact.
     */
    @Test
    public void testToString_String() {
        System.out.println("toString");
        String delimeter = ",";
        String expResult = "\"" + contact.firstName + "\"" + delimeter + "\"" + contact.lastName + "\"" + delimeter 
                + Integer.toString(contact.telephoneNumber) + delimeter + "\"" + contact.email + "\"" 
                + delimeter + "\"" + getDateCreatedAsString(contact.dateCreated) + "\"" + delimeter + "\"" 
                + contact.contactType + "\"" + "\n";
        String result = contact.toString(delimeter);
        assertEquals(expResult, result);
    }

    /**
     * Test of display method, of class Contact.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        contact.display();
    }

    /**
     * Test of equalsTel method, of class Contact.
     */
    @Test
    public void testEqualsTel() {
        System.out.println("equalsTel");
        Contact checkThis = new Contact ("firstName" , "lastName",22334455 , "email@gmail", "contactType");
        boolean expResult = false;
        boolean result = contact.equalsTel(checkThis);
        assertEquals(expResult, result);
    }

    /**
     * Test of equalsName method, of class Contact.
     */
    @Test
    public void testEqualsName() {
        System.out.println("equalsName");
        Contact checkThis = new Contact ("firstName" , "lastName",22334455 , "email@gmail", "contactType");
        boolean expResult = true;
        boolean result = contact.equalsName(checkThis);
        assertEquals(expResult, result);
    }

    private String getDateCreatedAsString(LocalDate dateCreated) {
      return dateCreated.toString();
    }
    
}
