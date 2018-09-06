/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact_list_app_controller;

import dsacoursework_ariyike.Contact;
import dsacoursework_ariyike.ContactList;
import dsacoursework_ariyike.IDisplayable;
import inputreader.TextReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class ContactListController implements IDisplayable {
    private Scanner input;
    private final ContactList myList;
   
    /**
     * This Constructor specifies instructions for creating a new controller for the application
     * it loads a file from user input and creates a new contact List
     */
    public ContactListController(){
        input = new Scanner(System.in);
        System.out.println("What contact file do you want to load? please type the name");
        String fileName = input.next();  

        TextReader textReader = new TextReader();
        myList= textReader.load(fileName);
     
    }
    
    /**
     * This method starts the application once a new ContactListContoller has been created and aids display of main menu
     */
    public void start(){
          boolean finished = false;
        
        do {
            char selectedOption = this.mainMenu();
            switch (selectedOption) {
                case 'A': 
                    showContacts();
                    break;
                case 'B':  
                    addContact();
                    break;
                case 'C': 
                    removeContact();
                    break;                    
                case 'D': 
                    searchContactByTelephone();
                    break;
                case 'E': 
                    searchContactByName();
                    break;
                case 'F': 
                    help();
                    break;
                case 'G': 
                    saveToFile();
                    finished = true;
                    
            }
        } while (!finished);
    }
    
    /**
     * This method displays the menu options that the user has and collects their selected option
     * @return char return value holds selected user option and will be passed into the start method for switching
     */
    private char mainMenu() {
        System.out.println("******************************");
        System.out.println("Enter choice A,B,C,D,E,F OR G");
        input = new Scanner(System.in);
        System.out.print("\nA. Show Contacts\n");
        System.out.print("B. Add Contacts\n");        
        System.out.print("C. Remove Contacts\n");
        System.out.print("D. Search contact by phone number\n");
        System.out.print("E. Search contact by name\n");
        System.out.print("F. Help\n");
        System.out.print("G. Quit\n");
        System.out.println("******************************");
       
        char option;
        option = input.nextLine().toUpperCase().charAt(0);
        
        return option;

    }
    
    /**
     * This method shows contacts within the contact list by calling the display method of the ContactList Class
     */
    private void showContacts(){
        this.myList.display();
    }
       
    /**
     * This method adds a new contact to the list from the user, this method will only add unique names to the list
     * duplicate contact names will not be added
     */
    private void addContact(){
           input = new Scanner(System.in);
           System.out.println("Input contact first name");
           String firstName = input.next();
           System.out.println("Input contact last name");
           String lastName = input.next();
           System.out.println("Input contact telephone number");
           int telephoneNumber = input.nextInt();
           System.out.println("Input contact email");
           String email = input.next();
           System.out.println("Input contact type: personal or business");
           String contactType = input.next();
           System.out.println("Input date of contact creation, please use format: yyyy/mm/dd");
           String aDate = input.next();
           
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
           LocalDate dateCreated = LocalDate.parse(aDate, formatter);
           
           Contact newContact = new Contact(firstName, lastName,telephoneNumber, email, dateCreated, contactType);
           
           Contact check = myList.searchByName(firstName, lastName);
           if(check != null){
               System.out.println("You have added a contact with this name. Please use another name");
               addContact();
           }
           else{
           myList.addToFront(newContact);
            System.out.println(firstName+" "+ lastName+" added");
           }
          
    }
       
    /**
     * This method removes a contact from the list on input from the user
     */
    private void removeContact(){
           input = new Scanner(System.in);
           System.out.println("**********************************************************************");
           System.out.println("What contact would you like to delete? please input contact first name");
           String fName = input.next();
           
           System.out.println("now enter contact last name");
           String lName = input.next();
           
           Contact removeThis = myList.searchByName(fName, lName);
           
           System.out.println("You are removing: "+ fName +" "+ lName +", are you sure? Y/N");
           String choice = input.next().toUpperCase();
           
           if("Y".equals(choice)){
                myList.removeContact(removeThis);
                System.out.println(fName+" "+ lName+" removed");
           }
           else if("N".equals(choice)){
                        System.out.println("no contact removed");
                    }
           System.out.println("**************************************************************");
    }

    /**
     * This method searches a contact by their telephone number on input from the user
     */
    private void searchContactByTelephone(){
           input = new Scanner(System.in);
           System.out.println("********************************************************************");
           System.out.println("What contact would you like to find? input the telephone number here");
           int telNumber = input.nextInt();
           
           Contact lookingForThis = myList.searchByTelephone(telNumber);
           lookingForThis.display();
           System.out.println("******************************************************");
    }
       
    /**
     * This method searches a contact by their first name and last name on input from the user
     */
    private void searchContactByName(){
           input = new Scanner(System.in);
           System.out.println("**************************************************************");
           System.out.println("What contact would you like to find? input the first name here");
           String fName = input.next();
           
           System.out.println("now enter contact last name");
           String lName = input.next();
           
           Contact lookingForThis = myList.searchByName(fName, lName);
           lookingForThis.display();
           System.out.println("******************************************************");
    }
    
    /**
     * This method displays a help menu to the user
     */
    private void help(){
            System.out.println("*****************************************************************************************************");
            System.out.println("To show all contacts in your list select option A");
            System.out.println("To add new Contact select option B");
            System.out.println("To remove a Contact select option C");
            System.out.println("To search for a Contact by their telephone number select option D");
            System.out.println("To search for a Contact by their name select option E. Please note that this is case sensitive");
            System.out.println("To save changes made to your contact list select option G, type a new file name in format \"xx.txt\"");
            System.out.println("*****************************************************************************************************");
           
    }
    
    /**
     * This method saves changes made to this contact list or discards them depending on input from the user
     */
    private  void saveToFile(){
                    input = new Scanner(System.in);
                    System.out.println("*************************************");
                    System.out.println("Would you like to save changes? Y | N");
                    String choice = input.next().toUpperCase();
                    if("Y".equals(choice)){
                        System.out.println("Please input file name");
                        String saveHere = input.next(); 
                        TextReader saveChanges = new TextReader();
                        saveChanges.saveToFile(saveHere, myList);
                        System.out.println("your changes have been saved");
                        System.out.println("*****************************");
                    }
  
                    else if("N".equals(choice)){
                        System.out.println("changes discarded");
                        System.out.println("*******************");
                    }
    }
    
    /**
     * This method implements the display method from the IDisplayable interface
     */
    @Override
    public void display(){
        System.out.println("This is where your contact list is contained: ");
        myList.display();
    }
}