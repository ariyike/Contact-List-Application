/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework_ariyike;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class Contact implements IDisplayable{

    /**
     *stores the first name of a contact object
     */
    protected String firstName;

    /**
     *stores the last name of a contact object
     */
    protected String lastName;

    /**
     *stores the telephone number of a contact object
     */
    protected int telephoneNumber;

    /**
     *stores the email address of a contact object
     */
    protected String email;

    /**
     *stores the date a contact object was created
     */
    protected LocalDate dateCreated;

    /**
     *stores the contact type of a contact object
     */
    protected String contactType;
          
    static final String QUOTE="\""; 
    
    /**
     *
     * @param firstName  first name field for initialization of a new contact object
     * @param lastName  last name field for initialization of a new contact object
     * @param telephoneNumber  telephone number field for initialization of a new contact object
     * @param email  email field for initialization of a new contact object
     * @param dateCreated  date field for initialization of a new contact object
     * @param contactType  contact type field for initialization of a new contact object
     */
    public Contact(String firstName, String lastName, int telephoneNumber, String email, LocalDate dateCreated, String contactType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.dateCreated = dateCreated;
        this.contactType = contactType;
    }
    
      /**
     *
     * @param firstName  first name field for initialization of a new contact object
     * @param lastName  last name field for initialization of a new contact object
     * @param telephoneNumber  telephone number field for initialization of a new contact object
     * @param email  email field for initialization of a new contact object
     * @param dateCreated  date field for initialization of a new contact object
     * @param contactType  contact type field for initialization of a new contact object
     */
    public Contact(String firstName, String lastName, int telephoneNumber, String email, String dateCreated, String contactType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        
        LocalDate formatedDate;
        formatedDate = LocalDate.parse(dateCreated, dateFormat);
        this.dateCreated = formatedDate;
        this.contactType = contactType;
    }
    
    /**
     *
     * @param firstName  first name field for initialization of a new contact object
     * @param lastName  last name field for initialization of a new contact object
     * @param telephoneNumber  telephone number field for initialization of a new contact object
     * @param email  email field for initialization of a new contact object
     * @param contactType  contact type field for initialization of a new contact object
     */
    public Contact(String firstName, String lastName, int telephoneNumber, String email, String contactType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.dateCreated = LocalDate.now(); 
        this.contactType = contactType;
    }
    
//Getters for field values of the class

    /**
     * Getter method for the first name field
     * @return String returns a String first name of the Contact
     */
    public String getFirstName(){
        return this.firstName;
    }
    
    /**
     * Getter method for the last name field
     * @return String returns a String last name of the Contact
     */
    public String getLastName(){
        return this.lastName;
    }
     
    /**
     * Getter method for the telephone number field
     * @return returns a integer telephone number of the Contact
     */
    public int getTelephoneNumber(){
        return this.telephoneNumber;
    }
    
    /**
     * Getter method for the email field
     * @return String returns a String email of the Contact
     */
    public String getEmail(){
        return this.email;
    }
     
    /**
     * Getter method for the date a contact was created field
     * @return LocalDate returns a date date created of the Contact
     */
    public LocalDate getDateCreated(){
        return this.dateCreated;
    }
     
    /**
     * This method takes a LocalDate parameter and coerces it to a string
     * @param dateToSet this is the date we would like to change to a String
     * @return String this method returns a date turned string
     */
    public String getDateCreatedAsString(LocalDate dateToSet){
         return dateToSet.toString();
     }
    
    /**
     * Getter method for the contact type field
     * @return String value containing desired contact type
     */
    public String getContactType(){
        return this.contactType;
    }
    
//Setters for field values of the class

    /**
     * Setter method for the first name field, takes the name to be substituted as a String
     * @param firstName takes in a String firstName to substitute as Contact new first name
     */
     public void setFirstName(String firstName){
        this.firstName = firstName;
    }
     
    /**
     * Setter method for the last name field, takes the name to be substituted as a String
     * @param lastName takes in a String lastName to substitute as Contact new last name
     */
    public void setlastName(String lastName){
        this.lastName = lastName;
    }
     
    /**
     * Setter method for the telephone number field, takes the number to be substituted as an integer
     * @param telephoneNumber takes in a integer telephoneNumber to substitute as Contact new telephone number
     */
    public void setTelephoneNumber(int telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }
     
    /**
     * Setter method for the email field, takes the email to be substituted as a String
     * @param email takes in a String email to substitute as Contact new email
     */
    public void setEmail(String email){
        this.email = email;
    }
     
    /**
     * Setter method for the date field, takes the date to be substituted as a String and created a well formatted LocalDate object
     * @param dateCreated takes in a String dateCreated to substitute as Contact new date created
     */
    public void setDateCreated(String dateCreated){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        
        LocalDate formatedDate;
        formatedDate = LocalDate.parse(dateCreated, dateFormat);
        
        this.dateCreated = formatedDate;
    }
     
    /**
     * Setter method for the contact type field, takes the contact type to be substituted as a String
     * @param contactType takes in a String contactType to substitute as Contact new contact type
     */
    public void setContactType(String contactType){
        this.contactType = contactType;
    }

    
    @Override
     public String toString(){
         String display = "";
         display += "First Name: " +this.firstName+ " |Last Name: " +this.lastName+ " |Email Address: " +this.email+ 
                 " |Telephone Number: " +this.telephoneNumber+ " |Date Created: " +this.dateCreated+ 
                 " |Contact Type: " +this.contactType;
         return display;
     }
     
    /**
     * This method makes the process of saving changes to a file easier  by providing a format
     * @param delimeter  the delimeter parameter acts as a separator between field elements
     * @return  returns a well formatted String
     */
    public String toString(String delimeter){
     
        String aString;
        aString = QUOTE + this.firstName + QUOTE + delimeter + QUOTE + this.lastName + QUOTE + delimeter 
                + Integer.toString(this.telephoneNumber) + delimeter + QUOTE + this.email + QUOTE 
                + delimeter + QUOTE + getDateCreatedAsString(this.dateCreated) + QUOTE + delimeter + QUOTE 
                + this.contactType + QUOTE + "\n";
       
        
        return aString;
    }
     
    /**
     * This method displays everything about the Contact class instances, implements display method from IDisplayable
     */
    @Override
    public void display() {
        System.out.println(this.toString());
    }
    
    /**
     * This method checks the equality of two contacts using their telephone number attributes
     * @param checkThis  parameter to be compared with
     * @return  returns a boolean value which confirms whether or not the values being compared are equal
     */
    public boolean equalsTel(Contact checkThis) {
        int x = this.telephoneNumber;
        int y = checkThis.telephoneNumber;
        return ((x==y));
       
    }
    
    /**
     * This method checks the equality of two contacts using their name attributes
     * @param checkThis  parameter to be compared with
     * @return  returns a boolean value which confirms whether or not the values being compared are equal
     */
    public boolean equalsName(Contact checkThis) {
        String x = this.firstName;
        String xx = this.lastName;
        
        String y = checkThis.firstName;
        String yy = checkThis.lastName;
        
        return ((yy.equals(xx)) && (x.equals(y)));
    }
   
}

