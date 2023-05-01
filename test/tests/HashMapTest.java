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

    @BeforeEach
    public void setUp() {
        hashMap = new HashMap();
    }

    @Test
    public void testPutAndGet() {
        Patient patient = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
        hashMap.put("123", patient);
        Patient retrievedPatient = hashMap.get("123");
        assertEquals(patient, retrievedPatient);
    }

    @Test
    public void testPutWithNullKey() {
        Patient patient = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
        try {
            hashMap.put(null, patient);
            fail("Failed");
        } catch (IllegalArgumentException e) {
            assertEquals("Null fields not permitted", e.getMessage());
        }
    }

    @Test
    public void testPutAndUpdate() {
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
        Patient patient2 = new Patient("Jane", "Smith", LocalDate.of(1995, 2, 2), LocalDate.now());
        hashMap.put("123", patient1);
        hashMap.put("123", patient2);
        Patient retrievedPatient = hashMap.get("123");
        assertEquals(patient2, retrievedPatient);
    }

    @Test
    public void testGetNonExistingKey() {
        Patient retrievedPatient = hashMap.get("123");
        assertNull(retrievedPatient);
    }

    @Test
    public void testRemove() {
        Patient patient = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
        hashMap.put("123", patient);
        Patient removedPatient = hashMap.remove("123");
        assertEquals(patient, removedPatient);
        assertEquals(0, hashMap.size());
    }

    @Test
    public void testRemoveNonExistingKey() {
        Patient removedPatient = hashMap.remove("123");
        assertNull(removedPatient);
    }

    @Test
    public void testContainsKey() {
        Patient patient = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
        hashMap.put("123", patient);
        assertTrue(hashMap.containsKey("123"));
    }

@Test
public void testContainsKeyNonExistingKey() {
    assertFalse(hashMap.containsKey("123"));
}

@Test
public void testGetKeys() {
    Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
    Patient patient2 = new Patient("Jane", "Smith", LocalDate.of(1995, 2, 2), LocalDate.now());
    Patient patient3 = new Patient("David", "Johnson", LocalDate.of(1985, 3, 3), LocalDate.now());
    hashMap.put("123", patient1);
    hashMap.put("456", patient2);
    hashMap.put("789", patient3);

    String[] keys = hashMap.getKeys();

    // Check if the keys array contains the correct keys
    assertArrayEquals(new String[]{"123", "456", "789"}, keys);
}

@Test
public void testGetValues() {
    Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
    Patient patient2 = new Patient("Jane", "Smith", LocalDate.of(1995, 2, 2), LocalDate.now());
    Patient patient3 = new Patient("David", "Johnson", LocalDate.of(1985, 3, 3), LocalDate.now());

    hashMap.put("123", patient1);
    hashMap.put("456", patient2);
    hashMap.put("789", patient3);

    Patient[] values = hashMap.getValues();

    // Check if the values array contains the correct patients
    assertArrayEquals(new Patient[]{patient1, patient2, patient3}, values);
}

@Test
public void testSize() {
    Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 1, 1), LocalDate.now());
    Patient patient2 = new Patient("Jane", "Smith", LocalDate.of(1995, 2, 2), LocalDate.now());
    Patient patient3 = new Patient("David", "Johnson", LocalDate.of(1985, 3, 3), LocalDate.now());


    hashMap.put("123", patient1);
    hashMap.put("456", patient2);
    hashMap.put("789", patient3);

    // Check if the size of the hashmap is correct
    assertEquals(3, hashMap.size());

    hashMap.remove("123");

    // Check if the size is updated
    assertEquals(2, hashMap.size());
}

}
