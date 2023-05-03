/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author WildW
 */
public class HashMap implements Serializable {

    private final int DEFAULT_CAPACITY = 16;
    private int capacity;
    private int size;
    private LinkedList<Entry>[] table;

    public HashMap() {
        capacity = DEFAULT_CAPACITY;
        size = 0;
        table = new LinkedList[capacity];
    }

    /**
     * Constructs a HashMap with the specified capacity.
     *
     * @param capacity the initial capacity of the HashMap
     * @throws IllegalArgumentException if the capacity is less than or equal to
     * zero
     */
    public HashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.capacity = capacity;
        size = 0;
        table = new LinkedList[capacity];
    }

    /**
     * @return the size of the HashMap
     */
    public int size() {
        return size;
    }

    /**
     * @param key the key for which to compute the hash code
     * @return the hash code of the key
     * @throws IllegalArgumentException if the key is null
     */
    private int hash(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Null key is not allow");
        }
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % table.length;
        return hash;
    }

    /**
     * @param key the key with value is to be added
     * @param patient the patient value to be added
     * @return the previous value if the key is updated, or null if there was no
     * mapping for the key
     * @throws IllegalArgumentException if the key or value is null
     */
    public Patient put(String key, Patient patient) {
        if (key == null || patient == null) {
            throw new IllegalArgumentException("Null are not allow");
        }
        int slot = hash(key);

        if (table[slot] == null) {
            //n
            table[slot] = new LinkedList();
            Entry newEntry = new Entry(key, patient);
            table[slot].add(newEntry);
            size++;
            return null;
        } else {
            //u
            for (Entry e : table[slot]) {
                if (e.key.equals(key)) {
                    Patient oldValue = e.updateValue(patient);
                    return oldValue;
                }
            }
            Entry newEntry = new Entry(key, patient);
            table[slot].add(newEntry);
            size++;
            return null;
        }
    }

    /**
     * Returns the value to the specified key, or null if the HashMap contains
     * nothing.
     *
     * @param key the key value that want to be returned
     * @return the value of the key that is mapped, or null if this HashMap
     * contains nothing
     */
    public Patient get(String key) {
        int slot = hash(key);
        if (table[slot] != null) {
            for (Entry e : table[slot]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    /**
     * Removes from the specified key input.
     *
     * @param key the key that wanted to be remove from the HashMap
     * @return the previous value of the key that is getting remove, or null if
     * there was no key
     */
    public Patient remove(String key) {
        int slot = hash(key);
        if (table[slot] != null) {
            for (Entry e : table[slot]) {
                if (e.key.equals(key)) {
                    Patient removedPatient = e.value;
                    table[slot].remove(e);
                    size--;
                    return removedPatient;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Checks if the HashMap contains the input key.
     *
     * @param key the key to check if its in the HashMap
     * @return true if the HashMap contains the key, false otherwise
     * @throws IllegalArgumentException if the key is null
     */
    public boolean containsKey(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Null key is not allow");
        }
        int slot = hash(key);
        if (table[slot] != null) {
            for (Entry e : table[slot]) {
                if (e.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return an array with all the keys present in the HashMap
     */
    public String[] getKeys() {
        String[] keys = new String[size];
        int index = 0;
        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry e : list) {
                    keys[index++] = e.key;
                }
            }
        }
        return keys;
    }

    /**
     * @return an array containing with all the values present in the HashMap
     */
    public Patient[] getValues() {
        Patient[] values = new Patient[size];
        int index = 0;
        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry e : list) {
                    values[index++] = e.value;
                }
            }
        }
        return values;
    }

    /**
     * Overrides the default toString() method.
     *
     * @return A string of the HashMap in the format "{key1=value1, key2=value2,
     * ...}". If the HashMap is empty, it returns an empty curly braces "{}".
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String result = "{";
        int index = 0;

        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry e : list) {
                    result += e.getKey() + "=" + e.getValue();
                    index++;

                    if (index != size) {
                        result += ", ";
                    } else {
                        result += "}";
                    }
                }
            }
        }
        return result;
    }

    private static class Entry implements Serializable {

        private final String key;
        private Patient value;

        public Entry(String key, Patient value) {
            this.key = key;
            this.value = value;
        }

        /**
         * @return The key of the entry.
         */
        public String getKey() {
            return key;
        }

        /**
         * @return The value that have something to do with the key.
         */
        public Patient getValue() {
            return value;
        }

        /**
         * Updates the value.
         *
         * @param newValue The new value that have something to do with the key.
         * @return The old value that was replaced.
         */
        public Patient updateValue(Patient newValue) {
            Patient oldValue = value;
            this.value = newValue;
            return oldValue;
        }

    }
}
