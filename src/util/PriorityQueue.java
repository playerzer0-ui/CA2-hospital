package util;

import java.io.Serializable;

public class PriorityQueue extends LinkedList implements Serializable {

    public PriorityQueue(){}

    /**
     * add an appointment in ascending order according to level
     * @param value the appointment
     * @return true
     */
    @Override
    public boolean add(Appointment value){
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;
            last = newNode;
        }
        //if value is smaller than the first
        else if(value.getLevel() < first.data.getLevel()){
            newNode.next = first;
            first = newNode;
        }
        //if value is smaller than the last
        else if(value.getLevel() >= last.data.getLevel()){
            last.next = newNode;
            last = newNode;
        }
        else{
            Node prev = first;
            Node current = first.next;
            while(current.data.getLevel() >= value.getLevel()){
                prev = current;
                current = current.next;
            }
            prev.next = newNode;
            newNode.next = current;
        }
        size++;
        return true;
    }

    /**
     * remove first appointment in queue
     * @return true or false
     */
    public boolean remove(){
        if(isEmpty()){
            return false;
        }
        else{
            super.remove(0);
            return true;
        }
    }

    /**
     *get the first appointment in queue
     * @return the first element
     */
    public Appointment peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return super.get(0);
        }
    }

    /**
     * empty the queue
     */
    public void empty(){
        super.clear();
    }

    ////////////unsupported operations/////////////////////////////

    /**
     * unsupported operation
     */
    @Override
    public int indexOf(Appointment value) {
        throw new UnsupportedOperationException();
    }

    /**
     * unsupported operation
     */
    @Override
    public boolean add(Appointment value, int pos) {
        throw new UnsupportedOperationException();
    }

    /**
     * unsupported operation
     */
    @Override
    public boolean remove(Appointment value) {
        throw new UnsupportedOperationException();
    }

    /**
     * unsupported operation
     */
    @Override
    public Appointment get(int pos){
        throw new UnsupportedOperationException();
    }
}
