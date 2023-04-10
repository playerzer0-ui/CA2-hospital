/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import org.junit.jupiter.api.Test;
import util.Appointment;
import util.PriorityQueue;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

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
    public void add_normal() {
        PriorityQueue p = new PriorityQueue();
        p.add(b);
        p.add(c);
        p.add(a);
        p.add(d);
        int exp = 4;
        assertEquals(exp, p.size());
        String ex = "[Appointment{level=1, firstName='john', lastName='doe', doB=2003-02-02, issue='broke', "
                + "date=2003-03-04, doctor='doc'}, Appointment{level=2, firstName='jane', lastName='willow', "
                + "doB=2003-02-10, issue='broken knee', date=2003-04-04, doctor='kal'tsit'}, Appointment{level=9, "
                + "firstName='bob', lastName='marley', doB=2003-02-04, issue='dying', date=2003-03-20, doctor='doctor'}, "
                + "Appointment{level=10, firstName='among', lastName='us', doB=2003-02-02, issue='imposter', "
                + "date=2001-03-04, doctor='crew'}]";
        assertEquals(ex, p.toString());
    }

    /**
     * remove method, normal, first element gone
     */
    @Test
    public void remove_normal() {
        PriorityQueue p = new PriorityQueue();
        p.add(b);
        p.add(c);
        p.add(a);
        p.add(d);
        assertTrue(p.remove());
        assertEquals(3, p.size());
    }

    /**
     * remove method, it is empty
     */
    @Test
    public void remove_empty() {
        PriorityQueue p = new PriorityQueue();
        assertFalse(p.remove());
    }

    /**
     * peek method, normal scenario, first element got
     */
    @Test
    public void peek_normal() {
        PriorityQueue p = new PriorityQueue();
        p.add(b);
        p.add(c);
        p.add(a);
        p.add(d);
        assertEquals(a, p.peek());
    }

    /**
     * peek method, nothing to peek at
     */
    @Test
    public void peek_empty() {
        PriorityQueue p = new PriorityQueue();
        assertNull(p.peek());
    }

    /**
     * empty method, does as implied, empty the queue
     */
    @Test
    public void empty_normal() {
        PriorityQueue p = new PriorityQueue();
        p.add(b);
        p.add(c);
        p.add(a);
        p.add(d);
        p.empty();
        assertEquals(0, p.size());
        assertEquals("[]", p.toString());
    }

}
