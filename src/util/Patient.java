/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author WildW
 */
public class Patient implements Serializable {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate joinDate;
    private LinkedList appointments;

    public Patient(String firstName, String lastName, LocalDate birthDate, LocalDate joinDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.appointments = new LinkedList();
    }

    public Patient() {
    }

    /**
     * Gets the first name of the patient.
     *
     * @return the first name of the patient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the patient.
     *
     * @param firstName the first name of the patient
     * @throws IllegalArgumentException if the first name is null or empty
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the patient.
     *
     * @return the last name of the patient
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the patient.
     *
     * @param lastName the last name of the patient
     * @throws IllegalArgumentException if the last name is null or empty
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    /**
     * Gets the birth date of the patient.
     *
     * @return the birth date of the patient
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the patient.
     *
     * @param birthDate the birth date of the patient
     * @throws IllegalArgumentException if the birth date is null
     */
    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null.");
        }
        this.birthDate = birthDate;
    }

    /**
     * Gets the join date of the patient.
     *
     * @return the join date of the patient
     */
    public LocalDate getJoinDate() {
        return joinDate;
    }

    /**
     * Sets the join date of the patient.
     *
     * @param joinDate the join date of the patient
     * @throws IllegalArgumentException if the join date is null
     */
    public void setJoinDate(LocalDate joinDate) {
        if (joinDate == null) {
            throw new IllegalArgumentException("Join date cannot be null.");
        }
        this.joinDate = joinDate;
    }

    /**
     * Gets the list of appointments for the patient.
     *
     * @return the list of appointments for the patient
     */
    public LinkedList getAppointments() {
        return appointments;
    }

    /**
     * Sets the list of appointments for the patient.
     *
     * @param appointments the list of appointments for the patient
     * @throws IllegalArgumentException if the appointments list is null
     */
    public void setAppointments(LinkedList appointments) {
        if (appointments == null) {
            throw new IllegalArgumentException("Appointments cannot be null.");
        }
        this.appointments = appointments;
    }

    /**
     * Returns a string of the Patient object.
     *
     * @return a string of the Patient object
     */
    @Override
    public String toString() {
        return "Patient{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", birthDate=" + birthDate
                + ", joinDate=" + joinDate
                + ", appointments=" + appointments
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.birthDate);
        return hash;
    }

    /**
     * Checks whether the Patient object is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.birthDate, other.birthDate);
    }

}
