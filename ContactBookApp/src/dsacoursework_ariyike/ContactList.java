/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework_ariyike;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class ContactList implements IDisplayable {

    /**
     *
     */
    protected CircularLinkedList<Contact> myContacts;

    /**
     *
     */
    protected int contactSize;
    
    /**
     * This constructor contains information for creating a new ContactList object
     */
    public ContactList(){
        this.myContacts = new CircularLinkedList<>();
        this.contactSize = 0;
    }
    
    /**
     * This method returns the size of the ContactList
     * @return returns the size of the ContactList
     */
    public int getContactSize(){
        return this.contactSize;
    }
    
    /**
     * This method returns the head of the ContactList
     * @return Contact returns the head of the ContactList
     */
    public Contact getHead(){
        return (Contact) myContacts.head.getData();
    }
    
    /**
     * This method returns the tail of the ContactList
     * @return Contact returns the tail of the ContactList
     */
    public Contact getTail(){
        return (Contact) myContacts.tail.getData();
    }
    
    /**
     * This method finds the Contact that comes after a specified Contact in the list
     * @param getNext takes in a Contact and finds the Contact that comes after it
     * @return Contact returns the Contact that is next in the list
     */
    public Contact getNextContact(Contact getNext){
        
        Node current = myContacts.head;
        Contact j;
        Contact first = (Contact)myContacts.head.getData();
        Contact nextContact = null;
        
        if( getNext == first){
            
            nextContact = (Contact) myContacts.head.next.getData();
        }
        else{
            while(current.next != myContacts.head){
                j = (Contact) current.getData();
                if(getNext == j){
                    nextContact = (Contact)current.next.getData();
                    
                }
                current = current.next;
            }
        }
        
        return nextContact;
    }
    
    /**
     * This method adds specified Contact to front of the list
     * @param addThis takes in a Contact to be added 
     * @return Contact returns the Contact object added to the front of the list
     */
    public Contact addToFront(Contact addThis){
        Contact prepended = myContacts.prepend(addThis);
        contactSize = contactSize + 1;
        return prepended;
        
    }
    
    /**
     * This method adds specified Contact to end of the list
     * @param addThis takes in a Contact to be added
     * @return Contact returns the Contact object added to the end of the contact list
     */
    public Contact addToEnd(Contact addThis){
        Contact appended = myContacts.append(addThis);
        contactSize = contactSize + 1;
        return appended;
    }
    
    /**
     * This method removes specified Contact from the list
     * @param removeThis takes in a Contact to be removed
     * @return Contact returns the Contact object that was removed by the method
     */
    public Contact removeContact(Contact removeThis){
        Contact removed = myContacts.remove(removeThis);
        contactSize = contactSize - 1;
        return removed;
    }
    
    /**
     * This method searches a contact by its telephone number
     * @param telephone takes in the telephone number to search by
     * @return Contact returns a Contact object that matches provided telephone number
     */
    public Contact searchByTelephone(int telephone){

        Contact searchResult = null;
        Contact temp = new Contact("firstName", "lastName", telephone, "email", "contactType");
        
        Node current = myContacts.head;
        Contact j;
        do{
            j = (Contact) current.getData();
                if(j.equalsTel(temp)){
                    searchResult = j; 
                }
                
                current = current.next;
            }while(current != myContacts.head);
        
        return searchResult;  
   }
    
    /**
     * This method searches a contact by its name
     * @param firstName takes in the first name to search by
     * @param lastName takes in the last name to search by
     * @return Contact returns a Contact object that matches provided first name and last name
     */
    public Contact searchByName(String firstName, String lastName){

        Contact searchResult = null;
        Contact temp = new Contact(firstName, lastName, 00000000, "email", "contactType");
      
        Node current = myContacts.head;
        Contact j;
        do{
            j = (Contact) current.getData();
                if(j.equalsName(temp)){
                
                    searchResult = j;
                }
                
                current = current.next;
            }while(current != myContacts.head);
        
        return searchResult;  
   }
    
    /**
     * This method implements the display method from the IDisplayable interface
     */
    @Override
    public void display() {
        
         Node current = myContacts.head;
        
             do{
                current.display();
                current = current.next;
            }while(current != myContacts.head);
    }
    
    /**
     * This method formats the contents of a ContactList before writing them to a file
     * @param delimeter takes in a delimeter to format data effectively
     * @return String returns a String which contains information about the contents of the ContactList prepared to be written to a file
     */
    public String toString(String delimeter) {
        String toPrint = "";
        
        Node current = myContacts.head;
        Contact j;
        
             do{
                 j = (Contact) current.getData();
                toPrint += j.toString(delimeter);
                current = current.next;
                
            }while(current != myContacts.head);
                 

        return toPrint;
    }
    
}