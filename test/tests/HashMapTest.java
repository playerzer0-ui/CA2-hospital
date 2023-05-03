/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.HashMap;
import util.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author WildW
 */
public class HashMapTest {

    private HashMap hashMap;
    private final Patient patient = new Patient("John", "Doe",
            LocalDate.of(1990, 1, 1), LocalDate.now());

    private final Patient patient2 = new Patient("Jane", "Smith",
            LocalDate.of(1995, 2, 2), LocalDate.now());

    private final Patient patient3 = new Patient("David", "Johnson",
            LocalDate.of(1985, 3, 3), LocalDate.now());

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    public void setUp() {
        hashMap = new HashMap();
    }

    /**
     * Tests the put() and get() methods of the HashMap class.
     */
    @Test
    public void testPutAndGet() {
        hashMap.put("123", patient);
        Patient retrievedPatient = hashMap.get("123");
        assertEquals(patient, retrievedPatient);
    }

    /**
     * Tests the put() method with a null key, expecting an
     * IllegalArgumentException to be thrown.
     */
    @Test
    public void testPutWithNullKey() {
        try {
            hashMap.put(null, patient);
            fail("Failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Null fields not permitted", e.getMessage());
        }
    }

    /**
     * Tests the put() and updateValue() methods in the HashMap class.
     */
    @Test
    public void testPutAndUpdate() {

        hashMap.put("123", patient);
        hashMap.put("123", patient2);
        Patient retrievedPatient = hashMap.get("123");
        assertEquals(patient2, retrievedPatient);
    }

    /**
     * Tests the get() method with a non-existing key.
     */
    @Test
    public void testGetNonExistingKey() {
        Patient retrievedPatient = hashMap.get("123");
        assertNull(retrievedPatient);
    }

    /**
     * Tests the remove() method in the HashMap class.
     */
    @Test
    public void testRemove() {
        hashMap.put("123", patient);
        Patient removedPatient = hashMap.remove("123");
        assertEquals(patient, removedPatient);
        assertEquals(0, hashMap.size());
    }

    /**
     * Tests the remove() method with a non-existing key.
     */
    @Test
    public void testRemoveNonExistingKey() {
        Patient removedPatient = hashMap.remove("123");
        assertNull(removedPatient);
    }

    /**
     * Tests the containsKey() method in the HashMap class.
     */
    @Test
    public void testContainsKey() {
        hashMap.put("123", patient);
        assertTrue(hashMap.containsKey("123"));
    }

    /**
     * Tests the containsKey() method with a non-existing key.
     */
    @Test
    public void testContainsKeyNonExistingKey() {
        assertFalse(hashMap.containsKey("123"));
    }

    /**
     * Tests the getKeys() method in the HashMap class.
     */
    @Test
    public void testGetKeys() {

        hashMap.put("123", patient);
        hashMap.put("456", patient2);
        hashMap.put("789", patient3);

        String[] keys = hashMap.getKeys();

        // Check if the keys array contains the correct keys
        assertArrayEquals(new String[]{"123", "456", "789"}, keys);
    }

    /**
     * Tests the getValues() method in the HashMap class.
     */
    @Test
    public void testGetValues() {

        hashMap.put("123", patient);
        hashMap.put("456", patient2);
        hashMap.put("789", patient3);

        Patient[] values = hashMap.getValues();

        // Check if the values array contains the correct patients
        assertArrayEquals(new Patient[]{patient, patient2, patient3}, values);
    }

    /**
     * Tests the size() method in the HashMap class.
     */
    @Test
    public void testSize() {

        hashMap.put("123", patient);
        hashMap.put("456", patient2);
        hashMap.put("789", patient3);

        // Check if the size of the hashmap is correct
        assertEquals(3, hashMap.size());

        hashMap.remove("123");

        // Check if the size is updated
        assertEquals(2, hashMap.size());
    }

}
