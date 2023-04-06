package util;

import java.time.LocalDate;

public class Appointment {

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

    public LocalDate getDoB() {
        return doB;
    }

    public void setDoB(LocalDate doB) {
        this.doB = doB;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

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

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + doB.hashCode();
        result = 31 * result + issue.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

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
