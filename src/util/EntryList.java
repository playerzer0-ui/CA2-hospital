//package util;
//
//import java.util.NoSuchElementException;
//
//public class EntryList {
//    private static Node first;
//    private static Node last;
//    private int size;
//
//    public EntryList(){
//        size = 0;
//        first = null;
//        last = null;
//    }
//
//    /**
//     * loop through list and update the entry
//     * @param entry the entry to update
//     * @return true or false, if update or not
//     */
//    public static boolean updateList(Entry entry){
//        Node current = first;
//        while(current != null){
//            if(entry.getKey().equals(current.data.getKey())){
//                current.data = entry;
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
//    }
//
//    /**
//     * gets the position of the Entry
//     * @param value the Entry to find
//     * @return the position / -1 if not found
//     */
//    public int indexOf(Entry value){
//        Node current = first;
//        int index = 0;
//        while(current != null){
//            if(value.equals(current.data)){
//                return index;
//            }
//            current = current.next;
//            index++;
//        }
//        return -1;
//    }
//
//    /**
//     * add an Entry to the end of the list
//     * @param value the appointment
//     * @return true
//     */
//    public boolean add(Entry value){
//        Node newNode = new Node(value);
//        if(first == null){
//            first = newNode;
//        }
//        else{
//            last.next = newNode;
//        }
//        last = newNode;
//        size++;
//        return true;
//    }
//
//
//    /**
//     * add an appointment to the first of the list
//     * @param value the appointment
//     * @return true
//     */
//    public boolean addFirst(Entry value){
//        Node newNode = new Node(value);
//        newNode.next = first;
//        first = newNode;
//        return true;
//    }
//
//
//    /**
//     * add an Entry to whichever position, as long as it doesn't go
//     * out of bounds
//     * @param value the appointment
//     * @param pos the position
//     * @return true
//     */
//    public boolean add(Entry value, int pos){
//        if(pos < 0 || pos >= size){
//            throw new IndexOutOfBoundsException();
//        }
//        Node newNode = new Node(value);
//        if(first == null){
//            first = newNode;
//        }
//        else if(pos == 0){
//            addFirst(value);
//        }
//        else{
//            Node current = first;
//            for(int i = 0; i < pos - 1; i++){
//                current = current.next;
//            }
//            newNode.next = current.next;
//            current.next = newNode;
//        }
//        size++;
//        return true;
//    }
//
//    /**
//     * checks if list is empty
//     * @return true or false, check size
//     */
//    public boolean isEmpty(){
//        return size == 0;
//    }
//
//    /**
//     * set the entry based on position
//     * @param pos the position
//     * @param value the entry to change
//     * @return true
//     */
//    public boolean set(int pos, Entry value){
//        if(pos < 0 || pos >= size){
//            throw new IndexOutOfBoundsException("index out of range");
//        }
//        if(pos == 0){
//            first.data = value;
//        }
//        else if(pos == size - 1){
//            last.data = value;
//        }
//        else{
//            Node current = first.next;
//            int index = 1;
//            while(index != pos){
//                current = current.next;
//                index++;
//            }
//            current.data = value;
//        }
//        return true;
//    }
//
//
//    /**
//     * get the size of list
//     * @return size of list
//     */
//    public int size(){
//        return size;
//    }
//
//    /**
//     * gets an entry from a specified position
//     *
//     * @param pos the position
//     * @return the entry
//     * @throws IndexOutOfBoundsException if out of range
//     */
//    public Entry get(int pos){
//        if(pos < 0 || pos >= size){
//            throw new IndexOutOfBoundsException("index out of range");
//        }
//        if(pos == size - 1){
//            return last.data;
//        }
//        Node current = first;
//        int index = 0;
//        while(index != pos){
//            current = current.next;
//            index++;
//        }
//        return current.data;
//    }
//
//    /**
//     * remove an entry from a list
//     * @param value the appointment
//     * @return true or false, if removed or not
//     */
//    public boolean remove(Entry value){
//        boolean flag = false;
//        Node current = first;
//        if(isEmpty()){
//            throw new NoSuchElementException();
//        }
//        if(value.equals(first.data)){
//            first = current.next;
//        }
//        while(current.next != null){
//            if(current.next.data.equals(value)){ //check if the next data is the value
//                current.next = current.next.next;
//                flag = true;
//                break;
//            }
//            current = current.next;
//        }
//        if(flag){
//            size--;
//        }
//        return flag;
//    }
//
//    /**
//     * remove an entry from a list
//     * @param pos the position
//     * @return true or false, if removed or not
//     */
//    public boolean remove(int pos){
//        int index = 0;
//        Node current = first;
//        if(isEmpty()){
//            throw new NoSuchElementException();
//        }
//        if(pos < 0 || pos >= size){
//            throw new IndexOutOfBoundsException();
//        }
//        if(pos == 0){
//            first = current.next;
//            size--;
//            return true;
//        }
//        while(current.next != null){
//            if(index == pos){ //check if the next data is the value
//                current.next = current.next.next;
//                size--;
//                break;
//            }
//            current = current.next;
//            index++;
//        }
//        return true;
//    }
//
//    /**
//     * clear the list
//     */
//    public void clear(){
//        first = null;
//        last = null;
//        size = 0;
//    }
//
//    /**
//     * @return the string of list
//     */
//    @Override
//    public String toString() {
//        if(isEmpty()){
//            return "[]";
//        }
//        String output = "[";
//        Node current = first;
//        while(current.next != null){
//            output += current.data + ", ";
//            current = current.next;
//        }
//        output += current.data + "]";
//        return output;
//    }
//
//    private static class Node {
//        private Entry data;
//        private Node next;
//
//        public Node(Entry data){
//            this.data = data;
//            next = null;
//        }
//    }
//}
