/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.LinkedList;
import util.Patient;

/**
 *
 * @author WildW
 */
public class HashMap {

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

    private int hash(String key) {
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % table.length;
        return hash;
    }

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

                    if(index != size){
                        result += ", ";
                    }
                    else{
                        result += "}";
                    }
                }
            }
        }
//ending with comma dont know how to fix
        return result;
    }

    private static class Entry {

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
