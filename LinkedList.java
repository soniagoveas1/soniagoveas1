/***
 * Created by Ellen Veomett, using code from David Galles
 * for CS 245
 * A good deal of this code is from:
 * https://www.cs.usfca.edu/~galles/cs245/lecture/LinkedList.java.html
 */

public class LinkedList {

    public static void main(String[] args) {
        /***
         * Creating and printing a linked list.
         */
        LinkedList myLL = new LinkedList();
        myLL.add(3);
        myLL.add(0);
        myLL.add(-2);
        myLL.print();
        myLL.reverseList();
        myLL.print();

        /***
         * LinkedList class allows for different objects.
         */
        LinkedList stringLL = new LinkedList();
        stringLL.add("hello");
        stringLL.add("world");
        stringLL.print();
        stringLL.reverseList();
        stringLL.print();

    }

    /*----------------------------------------------------- */
    /* Private Data Members -- LinkedList                   */
    /*----------------------------------------------------- */

    //Reference to first element in linked list
    private Link head;

    //Reference to the last element of the linked list
    private Link tail;

    //Current length of linked list
    private int length;

    /*----------------------------------------------------- */
    /* Constructor -- LinkedList                            */
    /*----------------------------------------------------- */

    LinkedList() {
        //initializing head and tail to a new link (empty list)
        head = tail = new Link();
        length = 0;
    }

    /**
     * @param: N/A
     * @return: N/A --> void methos
     * returns a reversed list
     * works with all types 
     * ex: ints, strings, etc. 
     */

     //https://www.geeksforgeeks.org/reverse-a-linked-list/#
     //idea of beginning part from website above 
    public void reverseList() {
        //if list has 0 or 1 elements, nothing to reverse
        if(head.next == null || head.next.next == null) {
            return;
        }

        Link prev = null;
        Link curr = head.next;
        Link next;

        //checks whether we are still in the list
        //Traverse the list and reverse direction of each link
        while(curr != null){

            //keep connection between next and curr
            next = curr.next;

            //reverses direction of the link
            curr.next = prev;

            //move to next
            prev = curr;
            curr = next;
        }

        //Updates the head and tail references to reflect new order
        tail = head.next;
        head.next = prev;
    }

    /*----------------------------------------------------- */
    /* Public Methods -- LinkedList                         */
    /*----------------------------------------------------- */

    //Method to clear linked list
    public void clear() {
        head.setNext(null);
        tail = head;
        length = 0;
    }

    //Method to get size of the linked list
    public int size() {
        return length;
    }

    //Method to add an element to the end of the linked list
    public void add(Object elem) {
        tail.setNext(new Link(elem, null));
        tail = tail.next();
        length++;
    }

    //Method to add an element at a specific index in linked list
    public void add(int index, Object elem)  {
        assert (index >= 0 && index <= length) : "Index not in list";
        Link tmp = head;
        for (int i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        tmp.next = new Link(elem, tmp.next);
        length++;
    }

    //Method to remove an element at a specified index from the linked list
    public void remove(int index) {
        assert (index >= 0 && index < length) : "Index not in list";
        Link tmp = head;
        for (int  i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        length--;
    }

    //Method to remove the first occurence of a specific element from the linked list
    public void remove(Object elem) {
        Link tmp = head;
        while (tmp.next != null && !tmp.next.element.equals(elem))
        {
            tmp = tmp.next;
        }
        if (tmp.next != null)
        {
            tmp.next = tmp.next.next;
            length--;
        }

    }

    //Method to get an element at a specified index from the linked list
    public Object get(int index) {
        assert (index >= 0 && index < length) : "Index not in list";
        Link tmp = head.next;
        for (int i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        return tmp.element;
    }


    //Method to print the elements of the linked list
    public void print() {
        Link curLink = head;
        while (curLink.next != null){
            curLink = curLink.next;
            System.out.print(curLink.element + " ");
        }
        System.out.print("\n");
    }


    /*----------------------------------------------------- */
    /* Nested class -- Link                                 */
    /*----------------------------------------------------- */

    //Nested class represenmting each element in linked list
    private class Link {

        /*----------------------------------------------------- */
        /*  Private Data Members -- Link                        */
        /*----------------------------------------------------- */

        private Object element; 
        private Link next;

        /*----------------------------------------------------- */
        /*  Constructors -- Link                                */
        /*----------------------------------------------------- */

        //Constructor intializing the link with element and next link
        Link(Object elem, Link nextelem) {
            element = elem;
            next = nextelem;
        }

        //Constructor initializing a link with just an element
        Link(Object elem) {
            element = elem;
        }

        //Default constructor
        Link() { 
        }

        /*----------------------------------------------------- */
        /*  Access Methods -- Link                              */
        /*----------------------------------------------------- */

        //Method to get the next link
        Link next() {
            return next;
        }

        //Method to get an element stored in this link
        Object element() {
            return element;
        }

        //Method to set the next link
        void setNext(Link nextelem) {
            next = nextelem;
        }

        //Method to set the element of the link
        void setElement(Object elem) {
            element = elem;
        }
    }

}