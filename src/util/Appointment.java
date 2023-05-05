package util;

import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Serializable {

    private int level;
    private String firstName;
    private String lastName;
    private LocalDate doB;
    private String issue;
    private LocalDate date;
    private String doctor;

    public Appointment(){}

    public Appointment(int level, String firstName, String lastName, LocalDate doB, String issue, LocalDate date, String doctor) {
        this.level = level;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doB = doB;
        this.issue = issue;
        this.date = date;
        this.doctor = doctor;
    }

    /**
     * get the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set the first name
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    /**
     * get the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set the last name
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        if(lastName == null){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    /**
     * get the date of birth
     * @return the date of birth
     */
    public LocalDate getDoB() {
        return doB;
    }

    /**
     * set the date of birth
     * @param doB the date of birth
     */
    public void setDoB(LocalDate doB) {
        if(doB == null){
            throw new IllegalArgumentException();
        }
        this.doB = doB;
    }

    /**
     * get the issue
     * @return the issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * set the issue
     * @param issue the issue
     */
    public void setIssue(String issue) {
        if(issue == null){
            throw new IllegalArgumentException();
        }
        this.issue = issue;
    }

    /**
     * get the date
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * set the date
     * @param date the date
     */
    public void setDate(LocalDate date) {
        if(date == null){
            throw new IllegalArgumentException();
        }
        this.date = date;
    }

    /**
     * get the level
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * set the level
     * @param level the level
     */
    public void setLevel(int level) {
        if(level <= 0){
            throw new IllegalArgumentException();
        }
        this.level = level;
    }

    /**
     * get the doctor
     * @return the doctor
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * set the doctor
     * @param doctor the doctor
     */
    public void setDoctor(String doctor) {
        if(doctor == null){
            throw new IllegalArgumentException();
        }
        this.doctor = doctor;
    }

    /**
     * checks if two objects are identical
     * @param o the object
     * @return true or false, if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!doB.equals(that.doB)) return false;
        if (!issue.equals(that.issue)) return false;
        return date.equals(that.date);
    }

    /**
     * create hashcode for the attributes required in equals
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + doB.hashCode();
        result = 31 * result + issue.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    /**
     * display appointment in string format
     * @return string of class
     */
    @Override
    public String toString() {
        return "Appointment{" +
                "level=" + level +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", doB=" + doB +
                ", issue='" + issue + '\'' +
                ", date=" + date +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
