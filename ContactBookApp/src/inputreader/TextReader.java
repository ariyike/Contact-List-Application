/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputreader;

import dsacoursework_ariyike.Contact;
import dsacoursework_ariyike.ContactList;
import dsacoursework_ariyike.IDisplayable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class TextReader implements IDisplayable{
    
    //a delimeter variable to help split the strings that make up each line of the txt file
    private static final String DELIMETER =",";
   
    /**
     * This method aids the effective loading of data from a text file into a contact list
     * @param filename this string represents the name where data is to be read from
     * @return ContactList returns a new contact list with items from the file as new contacts
     */
    public ContactList load(String filename){
    //ContactList contactsIn = new ContactList(contactListName);
      ContactList contactsIn = new ContactList();
    
        
            try (BufferedReader BufferedReader = new BufferedReader(new FileReader(filename))){
                    String line = BufferedReader.readLine();
                    String[] wordsPerLine;
                    Contact aNewContact;
                    while (line != null){
                        wordsPerLine = line.split(DELIMETER);

                        String firstName = stripQuotes(wordsPerLine[0]);
                        String lastName = stripQuotes(wordsPerLine[1]);
                        int telephoneNumber = Integer.parseInt(wordsPerLine[2]);
                        String email = stripQuotes(wordsPerLine[3]);
                        String aDate = stripQuotes(wordsPerLine[4]);
                        String contactType = stripQuotes(wordsPerLine[5]);
                        
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        LocalDate dateCreated = LocalDate.parse(aDate, formatter);

                        aNewContact = new Contact(firstName, lastName, telephoneNumber, email, dateCreated, contactType);
                        
                        contactsIn.addToFront(aNewContact);

                        line = BufferedReader.readLine();                    
                }
                BufferedReader.close();
            } catch(IOException ex){} 
       
    
        return contactsIn;
    }

    /**
     * This method removes the quotes from around a given string object
     * @param aString takes in a String with quotes around it
     * @return String returns a String without quotes
     */
    public String stripQuotes(String aString){
        String removedQuotes;
        removedQuotes = aString.replace('"', ' ').trim();
        return removedQuotes;
    }

    /**
     * This method implements the display method from the IDisplayable interface
     */
    @Override
    public void display() {
        System.out.println("This is a text reader tool");
    }
    
    /**
     * This method takes a ContactList object and a file name and creates a file with the contents of the ContactList in it
     * @param filename takes in a String which represents file to be written to
     * @param aList takes in a ContactList which represents the contact list to save as a file
     */
    public void saveToFile(String filename, ContactList aList){
        PrintWriter toFile;
        try {
            toFile = new PrintWriter(filename);
            toFile.print(aList.toString(DELIMETER));
            toFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}


