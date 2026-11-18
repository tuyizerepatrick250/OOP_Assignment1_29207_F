package com.auca.department;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
import com.auca.teacher.Teacher;

public class Department implements Identifiable, Registrable {
    private String departmentId;
    private String departmentName;
    private String departmentCode;
    private String officeLocation;
    private String contactEmail;
    private Teacher headTeacher;
    public Department(String departmentId,String departmentName,String departmentCode,String officeLocation,String contactEmail,Teacher headTeacher) { this.departmentId=departmentId; this.departmentName=departmentName; this.departmentCode=departmentCode; this.officeLocation=officeLocation; this.contactEmail=contactEmail; this.headTeacher=headTeacher; }
    public String getDepartmentId(){return departmentId;}
    public void setDepartmentId(String v){departmentId=v;}
    public String getDepartmentName(){return departmentName;}
    public void setDepartmentName(String v){departmentName=v;}
    public String getDepartmentCode(){return departmentCode;}
    public void setDepartmentCode(String v){departmentCode=v;}
    public String getOfficeLocation(){return officeLocation;}
    public void setOfficeLocation(String v){officeLocation=v;}
    public String getContactEmail(){return contactEmail;}
    public void setContactEmail(String v){contactEmail=v;}
    public Teacher getHeadTeacher(){return headTeacher;}
    public void setHeadTeacher(Teacher v){headTeacher=v;}
    public String getId(){return String.valueOf(departmentId);}
    public String getDisplayName(){return String.valueOf(departmentName);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(departmentId==null || departmentId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "Department{"+getId()+", "+getDisplayName()+"}";}
}
