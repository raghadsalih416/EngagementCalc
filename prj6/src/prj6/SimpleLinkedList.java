//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package prj6;

import java.util.Comparator;

/**
 * This class creates a linked list
 * to hold people objects
 * 
 * @author raghadsalih (906394954)
 * @version 2022.18.11
 * 
 * @param <Person>
 *            This is the type of object that this class will store
 */
@SuppressWarnings("hiding")
public class SimpleLinkedList<Person> {
    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <Person>
     *            This is the type of object that this class will store
     * @author raghadsalih
     * @version 2022.18.11
     * 
     */
    private class Node<Person> {
        // ~ Fields ...............................................
        private Person data;
        private Node<Person> next;

        /**
         * Creates a new node with the given data
         *
         * @param entry
         *            the entry to put inside the node
         * @param node
         *            the node following it
         */
        public Node(Person entry, Node<Person> node) {
            data = entry;
            this.setNextNode(node);
        }


        /**
         * Creates a new node with the given data
         *
         * @param data
         *            the data to put inside the node
         */
        public Node(Person data) {
            this(data, null);
            this.data = data;
        }


        /**
         * gets the next node
         * 
         * @return the next node
         *
         */
        public Node<Person> getNextNode() {
            return next;
        }


        /**
         * Sets the node after this node
         *
         * @param newNode
         *            the node after this one
         */
        public void setNextNode(Node<Person> newNode) {
            next = newNode;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public Person getData() {
            return data;
        }

    }

    // ~ Fields ...............................................
    private int size;
    private Node<Person> topNode;

    /**
     * Creates a new LinkedList object
     */
    public SimpleLinkedList() {
        topNode = null;
        size = 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int getSize() {
        return size;
    }


    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        if (topNode != null) {
            topNode = null;
            size = 0;
        }

    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(Person obj) {
        Node<Person> current = topNode;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(Person obj) {
        int lastIndex = -1;
        Node<Person> current = topNode;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public Person get(int index) {
        Node<Person> current = topNode;
        int currentIndex = 0;
        Person data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean removeSpecific(Person obj) {
        Node<Person> current = topNode;

        // account for matching head
        if ((null != topNode) && (obj.equals(current.data))) {
            topNode = topNode.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (getSize() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNextNode(current.next.next);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean remove(int index) {
        // if the index is invalid
        if (index < 0 || topNode == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node<Person> current = topNode;
            int currentIndex = 0;
            if (index == 0) {
                topNode = topNode.next;
                size--;
                return true;
            }

            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<Person> newNext = current.next.next;
                    current.setNextNode(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public void add(Person obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<Person> current = topNode;

        // empty stack case
        if (isEmpty()) {
            topNode = new Node<Person>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNextNode(new Node<Person>(obj));
        }
        size++;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public String toString() {
        String result = "{";

        Node<Person> current = topNode;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }

        }
        result += "}";
        return result;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SimpleLinkedList<Person> other = ((SimpleLinkedList<Person>)obj);
            if (other.getSize() == this.getSize()) {
                Node<Person> current = topNode;
                Node<Person> otherCurrent = other.topNode;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next;
                    otherCurrent = otherCurrent.next;
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, Person obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<Person> current = topNode;

        // empty stack case
        if (isEmpty()) {
            topNode = new Node<Person>(obj);
        }

        // all other cases
        else {
            if (index == 0) {
                Node<Person> newNode = new Node<Person>(obj);
                newNode.setNextNode(topNode);
                topNode = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<Person> nextNext = current.next;
                        Node<Person> newNode = new Node<Person>(obj);
                        current.setNextNode(newNode);
                        newNode.setNextNode(nextNext);

                    }
                    current = current.next;
                    currentIndex++;
                }
            }
        }
        size++;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @param str
     *            1 if you want trad engagement, 2 if you want reach
     */
    public void insertionSort(Comparator<Person> comp) {
        if (size > 1) {
            // break chain into 2 pieces
            Node<Person> unsortedPart = topNode.getNextNode();
            Node<Person> sorted = topNode;
            sorted.setNextNode(null);

            while (unsortedPart != null) {
                Node<Person> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNextNode();
                nodeToInsert.next = null;
                insertInOrder(nodeToInsert, comp);
            }

        }
    }

    /**
     * private helper method for when you are using
     * insertion sort
     *
     * @param str
     *            1 if you want trad engagement, 2 if you want reach
     */
    private void insertInOrder(Node<Person> nodeToInsert, Comparator<Person> comp) {
        Person item = nodeToInsert.getData();
        Node<Person> curr = topNode;
        Node<Person> prev = null;
        // find insertion point
        while ((curr != null) && (comp.compare(item, curr.getData()) > 0)) {
            prev = curr;
            curr = curr.getNextNode();
        }

        // insert
        if (prev != null) {
            // insert better aprev and curr
            prev.setNextNode(nodeToInsert);
            nodeToInsert.setNextNode(curr);
        }
        else {
            // insert at beginning
            nodeToInsert.setNextNode(topNode);
            topNode = nodeToInsert;
        }
    }

}
