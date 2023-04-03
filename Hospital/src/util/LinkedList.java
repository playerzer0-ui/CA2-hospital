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



    private static class Node {
        private Patient data;
        private Node next;

        public Node(Patient data){
            this.data = data;
            next = null;
        }
    }

}
