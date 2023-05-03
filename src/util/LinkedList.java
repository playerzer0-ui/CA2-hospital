package util;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class LinkedList implements Serializable {

    protected Node first;
    protected Node last;
    protected int size;

    public LinkedList(){
        size = 0;
        first = null;
        last = null;
    }

    /**
     * gets the position of the appointment
     * @param value the appointment to find
     * @return the position / -1 if not found
     */
    public int indexOf(Appointment value){
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
     * add an appointment to the end of the list
     * @param value the appointment
     * @return true
     */
    public boolean add(Appointment value){
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
     * add an appointment to the first of the list
     * @param value the appointment
     * @return true
     */
    public boolean addFirst(Appointment value){
        Node newNode = new Node(value);
        newNode.next = first;
        first = newNode;
        return true;
    }


    /**
     * add an appointment to whichever position, as long as it doesn't go
     * out of bounds
     * @param value the appointment
     * @param pos the position
     * @return true
     */
    public boolean add(Appointment value, int pos){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException();
        }
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
     * set the appointment based on position
     * @param pos the position
     * @param value the appointment to change
     * @return true
     */
    public boolean set(int pos, Appointment value){
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException("index out of range");
        }
        if(pos == 0){
            first.data = value;
        }
        else if(pos == size - 1){
            last.data = value;
        }
        else{
            Node current = first.next;
            int index = 1;
            while(index != pos){
                current = current.next;
                index++;
            }
            current.data = value;
        }
        return true;
    }


    /**
     * get the size of list
     * @return size of list
     */
    public int size(){
        return size;
    }

    /**
     * gets an appointment from a specified position
     * @param pos the position
     * @return the appointment
     * @throws IndexOutOfBoundsException if out of range
     */
    public Appointment get(int pos){
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
     * remove an appointment from a list
     * @param value the appointment
     * @return true or false, if removed or not
     */
    public boolean remove(Appointment value){
        boolean flag = false;
        Node current = first;
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(value.equals(first.data)){
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
     * remove an appointment from a list
     * @param pos the position
     * @return true or false, if removed or not
     */
    public boolean remove(int pos){
        int index = 0;
        Node current = first;
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(pos < 0 || pos >= size){
            throw new IndexOutOfBoundsException();
        }
        if(pos == 0){
            first = current.next;
            size--;
            return true;
        }
        while(current.next != null){
            if(index == pos){ //check if the next data is the value
                current.next = current.next.next;
                size--;
                break;
            }
            current = current.next;
            index++;
        }
        return true;
    }

    /**
     * clear the list
     */
    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    /**
     * @return the string of list
     */
    @Override
    public String toString() {
        if(isEmpty()){
            return "[]";
        }
        String output = "[";
        Node current = first;
        while(current.next != null){
            output += current.data + ", ";
            current = current.next;
        }
        output += current.data + "]";
        return output;
    }

    protected static class Node implements Serializable {
        protected Appointment data;
        protected Node next;

        public Node(Appointment data){
            this.data = data;
            next = null;
        }
    }

}
