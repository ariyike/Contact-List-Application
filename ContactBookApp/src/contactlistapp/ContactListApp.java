/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactlistapp;

import contact_list_app_controller.ContactListController;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 */
public class ContactListApp {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactListApp contactListAppInstance = new ContactListApp();  
        
        contactListAppInstance.startProgram();
    }
    
    /**
     * This method is where the entire application starts. It is called by the main method and initializes a new ContactListController
     */
    public  void startProgram(){
        System.out.println("******************");
        System.out.println("Contact List App");
        
        ContactListController contactListController = new ContactListController();
        contactListController.start();
        
        System.out.println("Good bye.\n");
        System.out.println("***********");
    }
}
