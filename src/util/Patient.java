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
//    • The first name of the Patient (a String)
//• The second name of the Patient (a String)
//• The date of birth of the Patient (a LocalDate)
//• The date they joined the practice (a LocalDate)
//• The appointments associated with the Patient (an Appointment LinkedList).

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LinkedList getAppointments() {
        return appointments;
    }

    public void setAppointments(LinkedList appointments) {
        this.appointments = appointments;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.birthDate);
        return hash;
    }

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
