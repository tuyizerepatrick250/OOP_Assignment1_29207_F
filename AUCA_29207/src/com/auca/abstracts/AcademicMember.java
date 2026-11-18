package com.auca.abstracts;

import com.auca.department.Department;
import java.time.LocalDate;

public abstract class AcademicMember extends Person {
    private String memberNumber;
    private Department department;
    private LocalDate joinDate;
    private String academicStatus, institutionalEmail, advisorName;
    protected AcademicMember(String personId,String firstName,String lastName,String email,String phone,
      LocalDate dob,String memberNumber,Department department,LocalDate joinDate,String academicStatus,
      String institutionalEmail,String advisorName) {
        super(personId,firstName,lastName,email,phone,dob);
        this.memberNumber=memberNumber; this.department=department; this.joinDate=joinDate;
        this.academicStatus=academicStatus; this.institutionalEmail=institutionalEmail; this.advisorName=advisorName;
    }
    public abstract String getAcademicCategory();
    public String getMemberNumber(){return memberNumber;} public void setMemberNumber(String v){memberNumber=v;}
    public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
    public LocalDate getJoinDate(){return joinDate;} public void setJoinDate(LocalDate v){joinDate=v;}
    public String getAcademicStatus(){return academicStatus;} public void setAcademicStatus(String v){academicStatus=v;}
    public String getInstitutionalEmail(){return institutionalEmail;} public void setInstitutionalEmail(String v){institutionalEmail=v;}
    public String getAdvisorName(){return advisorName;} public void setAdvisorName(String v){advisorName=v;}
    public String toString(){return super.toString()+" AcademicMember{"+memberNumber+", department="+(department==null?"none":department.getDepartmentName())+", "+joinDate+", "+academicStatus+", "+institutionalEmail+", "+advisorName+"}";}
}
