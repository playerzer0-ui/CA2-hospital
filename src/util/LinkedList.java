package util;

public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public LinkedList(){
        size = 0;
        first = null;
        last = null;
    }

    /**
     * gets the position of the patient
     * @param value the patient to find
     * @return the position
     */
    public int indexOf(Patient value){
        Node current = first;
        int index = 0;
        while(current != null){
            if(value.equals(current.data)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * add a patient to the end of the list
     * @param value the patient
     * @return true
     */
    public boolean add(Patient value){
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;
        }
        else{
            last.next = newNode;
        }
        last = newNode;
        size++;
        return true;
    }


    /**
     * add a patient to the first of the list
     * @param value the patient
     * @return true
     */
    public boolean addFirst(Patient value){
        Node newNode = new Node(value);
        newNode.next = first;
        first = newNode;
        return true;
    }


    /**
     * add a patient to whichever position, as long as it doesn't go
     * out of bounds
     * @param value the patient
     * @param pos the position
     * @return true
     */
    public boolean add(Patient value, int pos){
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;
        }
        else if(pos == 0){
            addFirst(value);
        }
        else{
            Node current = first;
            for(int i = 0; i < pos - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * checks if list is empty
     * @return true or false, check size
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * get the size of list
     * @return size of list
     */
    public int size(){
        return size;
    }

    /**
     * gets a patient from a specified position
     * @param pos the position
     * @return the patient
     * @throws IndexOutOfBoundsException if out of range
     */
    public Patient get(int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("index out of range");
        }
        if(pos == size - 1){
            return last.data;
        }
        Node current = first;
        int index = 0;
        while(index != pos){
            current = current.next;
            index++;
        }
        return current.data;
    }

    /**
     * remove a patient from a list
     * @param value the patient
     * @return true or false, if removed or not
     */
    public boolean remove(Patient value){
        boolean flag = false;
        Node current = first;
        if(size == 0){
            return false;
        }
        if(first.data.equals(value)){
            first = current.next;
        }
        while(current.next != null){
            if(current.next.data.equals(value)){ //check if the next data is the value
                current.next = current.next.next;
                flag = true;
                break;
            }
            current = current.next;
        }
        if(flag){
            size--;
        }
        return flag;
    }

    /**
     * @return the string of list
     */
    @Override
    public String toString() {
        String output = "[";
        Node current = first;
        while(current.next != null){
            output += current.data + ", ";
            current = current.next;
        }
        output += current.data + "]";
        return output;
    }

    private static class Node {
        private Patient data;
        private Node next;

        public Node(Patient data){
            this.data = data;
            next = null;
        }
    }

}
