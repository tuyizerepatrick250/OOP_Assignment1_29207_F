package com.auca.enrollment;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
import java.time.LocalDate;
import com.auca.student.Student;
import com.auca.course.Course;

public class Enrollment implements Identifiable, Registrable {
    private String enrollmentId;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private String semester;
    private String enrollmentStatus;
    public Enrollment(String enrollmentId,Student student,Course course,LocalDate enrollmentDate,String semester,String enrollmentStatus) { this.enrollmentId=enrollmentId; this.student=student; this.course=course; this.enrollmentDate=enrollmentDate; this.semester=semester; this.enrollmentStatus=enrollmentStatus; }
    public String getEnrollmentId(){return enrollmentId;}
    public void setEnrollmentId(String v){enrollmentId=v;}
    public Student getStudent(){return student;}
    public void setStudent(Student v){student=v;}
    public Course getCourse(){return course;}
    public void setCourse(Course v){course=v;}
    public LocalDate getEnrollmentDate(){return enrollmentDate;}
    public void setEnrollmentDate(LocalDate v){enrollmentDate=v;}
    public String getSemester(){return semester;}
    public void setSemester(String v){semester=v;}
    public String getEnrollmentStatus(){return enrollmentStatus;}
    public void setEnrollmentStatus(String v){enrollmentStatus=v;}
    public String getId(){return String.valueOf(enrollmentId);}
    public String getDisplayName(){return String.valueOf(enrollmentId);}
    public boolean isActive(){return "ACTIVE".equalsIgnoreCase(enrollmentStatus);}
    public void validate() throws ValidationException { if(enrollmentId==null || enrollmentId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "Enrollment{"+getId()+", "+getDisplayName()+"}";}
}
