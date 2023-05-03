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

    public HashMap(int capacity) {
        this.capacity = capacity;
        size = 0;
        table = new LinkedList[capacity];
    }

    public int size() {
        return size;
    }

    /**
     * @param capacity the initial capacity of the HashMap
     */
    private int hash(String key) {
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
            throw new IllegalArgumentException("Null fields not permitted");
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
            return null;
        } else {
            return null;
        }
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
     * Returns true if this HashMap contains the key entered.
     *
     * @param key a string key
     * @return true if this HashMap contains a the key, false otherwise
     */
    public boolean containsKey(String key) {
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

    @Override
    public String toString() {
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

        public String getKey() {
            return key;
        }

        public Patient getValue() {
            return value;
        }

        public Patient updateValue(Patient newValue) {
            Patient oldValue = value;
            this.value = newValue;
            return oldValue;
        }

    }
}
