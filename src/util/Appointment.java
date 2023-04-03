package util;

import java.time.LocalDate;

public class Appointment {

    private int level;
    private Patient patient;
    private String issue;
    private LocalDate date;
    private String doctor;

    public Appointment(){}

    public Appointment(Patient patient, String issue, LocalDate date, int level, String doctor) {
        this.patient = patient;
        this.issue = issue;
        this.date = date;
        this.level = level;
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

        if (!patient.equals(that.patient)) return false;
        if (!issue.equals(that.issue)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = patient.hashCode();
        result = 31 * result + issue.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "level=" + level +
                ", patient=" + patient +
                ", issue='" + issue + '\'' +
                ", date=" + date +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
