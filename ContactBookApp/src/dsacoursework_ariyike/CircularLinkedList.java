/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework_ariyike;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 * @param <T>  This class is to be able to store any type
 */
public class CircularLinkedList<T> implements IDisplayable{
    
     Node head;
     Node tail;
     int listSize;

    /**
     * Constructor for the CircularLinkedList class
     */
    public CircularLinkedList(){
        head = null;
        tail = null;
        listSize = 0;
    }

    /**
     * prepend method adds a new element to the linked list at the front
     * @param addThis the parameter for this method is the object to be added
     * @return  T  returns the object which was added 
     */
    public T prepend(T addThis){
        Node newNode =  new Node(addThis);
        if (isEmpty()){
            head = newNode;
            tail = head;
            
            head.prev = tail;
            tail.next = head;
            
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            
            head.prev = tail;
            tail.next = head;
        }
        
        listSize = listSize + 1;
        
        return (T) head.data;
    }

    /**
     * prepend method adds a new element to the linked list at the end
     * @param addThis  the parameter for this method is the object to be added
     * @return T  returns the object which was added 
     */
    public T append(T addThis){
        Node newNode =  new Node(addThis);
      
        if (isEmpty()){
            head = newNode;
            tail = head;
            
            head.prev = tail;
            tail.next = head;
        }
        else{
              tail.next = newNode;
              newNode.prev = tail;
              newNode.next = head;
              head.prev = newNode;
              tail = newNode;
        
        }
        listSize = listSize + 1;
        
        return (T) tail.data;
    }

    /**
     * remove method removes objects from the list
     * @param data the parameter for this method is the object to be removed
     * @return  T  returns the object which was removed
     */
     @SuppressWarnings("null")
    public T remove(T data){
        Node current = head;
        Node removed = null;
        if (isEmpty()){
            System.out.println("This List is Empty");
        }
        else if(head.data == data){
            removed = head;
            head = head.next;
        }
        
        else{
            while(current.next != head){
                if(current.next.data == data){
                    removed = current.next;
                    current.next.next.prev = current;
                    current.next = current.next.next;
                    
                }
                current = current.next;
            }
        }
        
        listSize = listSize - 1;
        return (T) removed.data;
    }

    /**
     * This method helps to check that an object exists in a list
     * @param searchByThis  the parameter for this method is the object to be searched
     * @return T  returns object was it's been found to exist in the list
     */
     @SuppressWarnings("null")
    public T search(T searchByThis){
        Node current = head;
        Node searchResult = null;
        
        try{
        if (isEmpty()){
            System.out.println("This List is Empty");
        }
        else{
            do{
                if(current.data == searchByThis){
                    searchResult = current; 
                }
                
                current = current.next;
            }while(current != head);
           if(searchResult == null){
               System.out.println("This element does not exist in the List");
           }
        }
    }
        catch(NullPointerException e) {
            System.out.println("This element does not exist in the List");
        }
        return (T) searchResult.data;
    }

    /**
     * This method checks whether or not the list is empty 
     * @return  Boolean  returns true or false
     */
    public boolean isEmpty(){
        return head == null;   
    }
    
    /**
     * This method returns the size of the list
     * @return returns a value that represents the size of the list
     */
    public int getSize(){
        return listSize;
    }

    /**
     * This method implements the display method from the IDisplayable interface and customizes it for the CircularLinkedList class
     */
    @Override
    public void display() {
        Node current = head;
        
             do{
                current.display();
                current = current.next;
            }while(current != head);
        
    }
    
}
