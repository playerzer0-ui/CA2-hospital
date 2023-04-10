/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;
import org.junit.jupiter.api.Test;
import util.Appointment;
import util.LinkedList;
import util.Patient;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private final Appointment a = new Appointment(1, "john", "doe",
            LocalDate.parse("2003-02-02"),
            "broke", LocalDate.parse("2003-03-04"), "doc");
    private final Appointment b = new Appointment(2, "jane", "willow",
            LocalDate.parse("2003-02-10"),
            "broken knee", LocalDate.parse("2003-04-04"), "kal'tsit");
    private final Appointment c = new Appointment(9, "bob", "marley",
            LocalDate.parse("2003-02-04"),
            "dying", LocalDate.parse("2003-03-20"), "doctor");
    private final Appointment d = new Appointment(10, "among", "us",
            LocalDate.parse("2003-02-02"),
            "imposter", LocalDate.parse("2001-03-04"), "crew");

    /**
     * add method, normal scenario
     */
    @Test
    public void add_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(a);
        int exp = 3;
        int act = l.size();
        assertEquals(exp, act);
        assertEquals(a, l.get(act - 1));
    }

    /**
     * add method with additional pos, normal scenario
     */
    @Test
    public void add_twoParameters_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(a, 2);
        assertEquals(a, l.get(2));
    }

    /**
     * add method with additional pos, out of range
     */
    @Test
    public void add_twoParameters_out_of_range(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(new Appointment());
        assertThrows(IndexOutOfBoundsException.class, ()->{l.add(a, 10000);});
    }

    /**
     * addFirst method, normal scenario
     */
    @Test
    public void addFirst_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.addFirst(a);
        assertEquals(a, l.get(0));
    }

    /**
     * indexOf method, normal scenario
     */
    @Test
    public void indexOf_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(a);
        l.add(new Appointment());
        int exp = 1;
        assertEquals(exp, l.indexOf(a));
    }

    /**
     * indexOf method, but it's not found
     */
    @Test
    public void indexOf_not_found(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(new Appointment());
        int exp = -1;
        assertEquals(exp, l.indexOf(a));
    }

    /**
     * indexOf method, but list is empty
     */
    @Test
    public void indexOf_empty(){
        LinkedList l = new LinkedList();
        int exp = -1;
        assertEquals(exp, l.indexOf(a));
    }

    /**
     * isEmpty method, is empty
     */
    @Test
    public void isEmpty_normal(){
        LinkedList l = new LinkedList();
        boolean exp = true;
        assertEquals(exp, l.isEmpty());
    }

    /**
     * isEmpty method, is NOT empty
     */
    @Test
    public void isEmpty_not_empty(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        boolean exp = false;
        assertEquals(exp, l.isEmpty());
    }

    /**
     * size method, normal scenario
     */
    @Test
    public void size_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(new Appointment());
        int exp = 3;
        assertEquals(exp, l.size());
    }

    /**
     * size method, it is empty, so it should return 0
     */
    @Test
    public void size_empty(){
        LinkedList l = new LinkedList();
        int exp = 0;
        assertEquals(exp, l.size());
    }

    /**
     * get method, normal scenario
     */
    @Test
    public void get_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(a);
        l.add(new Appointment());
        l.add(new Appointment());
        assertEquals(a, l.get(2));
    }

    /**
     * get method, but there is nothing to get
     */
    @Test
    public void get_empty(){
        LinkedList l = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, ()-> {l.get(3);});
    }

    /**
     * get method, but out of range
     */
    @Test
    public void get_outRanged(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        l.add(a);
        assertThrows(IndexOutOfBoundsException.class, ()-> {l.get(100);});
    }

    /**
     * remove with value method, normal scenario
     */
    @Test
    public void remove_value_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(a);
        l.add(new Appointment());
        assertTrue(l.remove(a));
        assertEquals(2, l.size());
    }

    /**
     * remove with value method, but it's not there
     */
    @Test
    public void remove_value_not_there(){
        LinkedList l = new LinkedList();
        l.add(b);
        l.add(c);
        l.add(d);
        assertFalse(l.remove(a));
        assertEquals(3, l.size());
    }

    /**
     * remove with value method, but it's empty
     */
    @Test
    public void remove_value_empty(){
        LinkedList l = new LinkedList();
        assertThrows(NoSuchElementException.class, ()->{l.remove(a);});
    }

    /**
     * remove with position, normal scenario
     */
    @Test
    public void remove_pos_normal(){
        LinkedList l = new LinkedList();
        l.add(b);
        l.add(c);
        l.add(d);
        assertTrue(l.remove(1));
        assertEquals(2, l.size());
    }

    /**
     * remove with position, but it's empty
     */
    @Test
    public void remove_pos_empty(){
        LinkedList l = new LinkedList();
        assertThrows(NoSuchElementException.class, ()->{l.remove(1);});
    }

    /**
     * remove with position, but it's out of bounds
     */
    @Test
    public void remove_pos_outRange(){
        LinkedList l = new LinkedList();
        l.add(b);
        l.add(c);
        l.add(d);
        assertThrows(IndexOutOfBoundsException.class, ()->{l.remove(10000);});
    }

    /**
     * clear method, just clear it
     */
    @Test
    public void clear_normal(){
        LinkedList l = new LinkedList();
        l.add(new Appointment());
        l.add(new Appointment());
        int exp = 0;
        l.clear();
        int act = l.size();
        assertEquals(exp, act);
    }
}
