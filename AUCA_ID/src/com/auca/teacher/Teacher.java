package com.auca.teacher;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.AcademicMember;
import com.auca.department.Department;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Teacher extends AcademicMember {
    private String employeeNumber;
    private String specialization;
    private LocalDate hireDate;
    private BigDecimal salary;
    private String officeNumber;
    private String employmentType;
    public Teacher(String personId,String firstName,String lastName,String email,String phone,LocalDate dob,String memberNumber,Department department,LocalDate joinDate,String academicStatus,String institutionalEmail,String advisorName,String employeeNumber,String specialization,LocalDate hireDate,BigDecimal salary,String officeNumber,String employmentType) { super(personId,firstName,lastName,email,phone,dob,memberNumber,department,joinDate,academicStatus,institutionalEmail,advisorName); this.employeeNumber=employeeNumber; this.specialization=specialization; this.hireDate=hireDate; this.salary=salary; this.officeNumber=officeNumber; this.employmentType=employmentType; }
    public String getEmployeeNumber(){return employeeNumber;}
    public void setEmployeeNumber(String v){employeeNumber=v;}
    public String getSpecialization(){return specialization;}
    public void setSpecialization(String v){specialization=v;}
    public LocalDate getHireDate(){return hireDate;}
    public void setHireDate(LocalDate v){hireDate=v;}
    public BigDecimal getSalary(){return salary;}
    public void setSalary(BigDecimal v){salary=v;}
    public String getOfficeNumber(){return officeNumber;}
    public void setOfficeNumber(String v){officeNumber=v;}
    public String getEmploymentType(){return employmentType;}
    public void setEmploymentType(String v){employmentType=v;}
    public String getId(){return String.valueOf(employeeNumber);}
    public String getDisplayName(){return String.valueOf(specialization);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(employeeNumber==null || employeeNumber.toString().trim().isEmpty()) throw new ValidationException("ID is required."); if(salary==null || salary.signum()<=0) throw new ValidationException("Salary must be positive."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}
    public String getRoleDescription(){return "Teacher";} public String getAcademicCategory(){return "Teacher";}
    public String toString(){return "Teacher{"+getId()+", "+getDisplayName()+"}";}
}
