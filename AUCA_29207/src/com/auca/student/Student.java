package com.auca.student;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.AcademicMember;
import com.auca.department.Department;
import java.time.LocalDate;

public class Student extends AcademicMember {
    private String studentNumber;
    private String programName;
    private LocalDate admissionDate;
    private int studyYear;
    private String guardianPhone;
    private boolean scholarshipStatus;
    public Student(String personId,String firstName,String lastName,String email,String phone,LocalDate dob,String memberNumber,Department department,LocalDate joinDate,String academicStatus,String institutionalEmail,String advisorName,String studentNumber,String programName,LocalDate admissionDate,int studyYear,String guardianPhone,boolean scholarshipStatus) { super(personId,firstName,lastName,email,phone,dob,memberNumber,department,joinDate,academicStatus,institutionalEmail,advisorName); this.studentNumber=studentNumber; this.programName=programName; this.admissionDate=admissionDate; this.studyYear=studyYear; this.guardianPhone=guardianPhone; this.scholarshipStatus=scholarshipStatus; }
    public String getStudentNumber(){return studentNumber;}
    public void setStudentNumber(String v){studentNumber=v;}
    public String getProgramName(){return programName;}
    public void setProgramName(String v){programName=v;}
    public LocalDate getAdmissionDate(){return admissionDate;}
    public void setAdmissionDate(LocalDate v){admissionDate=v;}
    public int getStudyYear(){return studyYear;}
    public void setStudyYear(int v){studyYear=v;}
    public String getGuardianPhone(){return guardianPhone;}
    public void setGuardianPhone(String v){guardianPhone=v;}
    public boolean getScholarshipStatus(){return scholarshipStatus;}
    public void setScholarshipStatus(boolean v){scholarshipStatus=v;}
    public String getId(){return String.valueOf(studentNumber);}
    public String getDisplayName(){return String.valueOf(programName);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(studentNumber==null || studentNumber.toString().trim().isEmpty()) throw new ValidationException("ID is required."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}
    public String getRoleDescription(){return "Student";} public String getAcademicCategory(){return "Student";}
    public String toString(){return "Student{"+getId()+", "+getDisplayName()+"}";}
}
