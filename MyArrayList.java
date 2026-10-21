/*
 * Name: Noah Teng
 * Email: noteng@ucsd.edu
 * PID: 200326335
 * Sources used: ____
 */
import java.util.AbstractList;

/* A generic, double-linked LinkedList
 * Implements AbstractList interface
 * 
 * Instances:
 * Size: Keep track of the number of nodes in the linked list. 
 *      This count does not include sentinel nodes.
 * head: Reference to the sentinel head of linked list
 * tail: Reference to the sentinel tail of linked list
 */
public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     * 
     * Instances:
     * data: tbe value assigned to each node
     * next: points to the next node
     * prev: points to the previous node
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * 
         * Instances:
         * data: tbe value assigned to each node
         * next: points to the next node
         * prev: points to the previous node
         * 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //  Implementation of the MyLinkedList Class

    public MyLinkedList() {
        /* Add your implementation here */
        // TODO
        size = 0;
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);

    }
    protected Node getNth(int index) {
        /* Add your implementation here */
        Node cur = head.getNext();
        for(int i = 0; i<index ;i++)
            cur = cur.getNext();
        return cur;
    }
    

    @Override
    public int size() {
        /* Add your implementation here */
        return size; // TODO
    }

    @Override
    public E get(int index) {
        /* Add your implementation here */
        if(index < 0 || index <= size) {
            throw new IndexOutOfBoundsException("index doesn't work");
        }
        Node cur = getNth(index);
        return (E) cur.getElement();  // TODO << try oto avoid calling ___ ITSELF
    }

    @Override
    public void add(int index, E data) { //index = future index
        if(data == null) {
            throw new NullPointerException("data is null");
        }
        if(index < 0 || index > size); {
            throw new IndexOutOfBoundsException ("index screwed");
        }

        Node cur = getNth(index);

        Node prev = cur.getNext(); 

        prev.setNext(new Node(data)); //prev.getNext() os the NEW node
        cur.setPrev(prev.getNext());
        prev.getNext().setNext(cur);
        prev.getNext().setPrev(prev);
    }

    @Override
    public boolean add(E data) {
        /* Add your implementation here */
        if(data == null) {
            throw new NullPointerException("data null");
        }
            Node prev = tail.getNext(); 
            
            prev.setNext(new Node(data)); //prev.getNext() os the NEW node
            tail.setPrev(prev.getNext());
            prev.getNext().setNext(tail);
            prev.getNext().setPrev(prev);
        
        return true;
    }

    @Override
    public E set(int index, E data) {
        /* Add your implementation here */
        if(data == null) {
            throw new IndexOutOfBoundsException("doesn't work will edit later");
        }   
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index wrong");
        }
        
        Node cur = getNth(index);

        Object elem = cur.getElement();

        cur.setElement(data);

        return (E) elem;
    }

    @Override
    public E remove(int index) {
        /* Add your implementation here */
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index wrong");
        }
        
        Node cur = getNth(index);
        Object remove = cur.getElement();

        cur.getPrev().setNext(cur.getNext());
        cur.getNext().setPrev(cur.getPrev());

        return (E) remove;
    }

    @Override
    public void clear() {
        /* Add your implementation here */
        head.setNext(tail);
        tail.setPrev(head);
    }

    @Override
    public boolean isEmpty() {
        /* Add your implementation here */
        return true;  // TODO
    }

}
