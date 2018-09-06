/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework_ariyike;

/**
 *
 * @author Anjolaoluwa Ariyike Adetimehin
 * @param <T> This class is to be able to store any type
 */
public class Node<T> implements IDisplayable{
     
        Node next;
        Node prev;
        T data;

    /**
     * node class constructor 1
     * @param next takes in a Node object which points to the succeeding node
     * @param prev takes in a Node object which points to the preceeding node
     * @param data takes in data of any type T and encloses it within the node
     */
        public Node(Node next, Node prev, T data){
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

    /**
     * node class constructor 2
     * @param data takes data of any type T and encloses it within the node
     */
        public Node(T data){
            this.next = null;
            this.prev = null;
            this.data = data;
        }

    /**
     * This method implements the display method from the IDisplayable interface
     */
        @Override
        public void display(){
            System.out.println(this.data);
        }
        
    /**
     * This method when called provides the object/data contained within a Node
     * @return T returns a type T which represents the data contained within a Node
     */
    public T getData(){
            return this.data;
        }
        
    }

