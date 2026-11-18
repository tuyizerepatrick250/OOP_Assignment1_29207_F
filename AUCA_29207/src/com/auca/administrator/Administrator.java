package com.auca.administrator;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.Person;
import java.time.LocalDate;

public class Administrator extends Person {
    private String staffNumber;
    private String jobTitle;
    private String assignedOffice;
    private LocalDate employmentDate;
    private int accessLevel;
    private boolean active;
    public Administrator(String personId,String firstName,String lastName,String email,String phone,LocalDate dob,String staffNumber,String jobTitle,String assignedOffice,LocalDate employmentDate,int accessLevel,boolean active) { super(personId,firstName,lastName,email,phone,dob); this.staffNumber=staffNumber; this.jobTitle=jobTitle; this.assignedOffice=assignedOffice; this.employmentDate=employmentDate; this.accessLevel=accessLevel; this.active=active; }
    public String getStaffNumber(){return staffNumber;}
    public void setStaffNumber(String v){staffNumber=v;}
    public String getJobTitle(){return jobTitle;}
    public void setJobTitle(String v){jobTitle=v;}
    public String getAssignedOffice(){return assignedOffice;}
    public void setAssignedOffice(String v){assignedOffice=v;}
    public LocalDate getEmploymentDate(){return employmentDate;}
    public void setEmploymentDate(LocalDate v){employmentDate=v;}
    public int getAccessLevel(){return accessLevel;}
    public void setAccessLevel(int v){accessLevel=v;}
    public boolean getActive(){return active;}
    public void setActive(boolean v){active=v;}
    public String getId(){return String.valueOf(staffNumber);}
    public String getDisplayName(){return String.valueOf(jobTitle);}
    public boolean isActive(){return active;}
    public void validate() throws ValidationException { if(staffNumber==null || staffNumber.toString().trim().isEmpty()) throw new ValidationException("ID is required."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}
    public String getRoleDescription(){return "Administrator";}
    public String toString(){return "Administrator{"+getId()+", "+getDisplayName()+"}";}
}
