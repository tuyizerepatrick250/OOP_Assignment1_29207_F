package com.auca.course;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
import com.auca.department.Department;
import com.auca.teacher.Teacher;

public class Course implements Identifiable, Registrable {
    private String courseId;
    private String courseCode;
    private String courseTitle;
    private int creditHours;
    private Department department;
    private Teacher assignedTeacher;
    public Course(String courseId,String courseCode,String courseTitle,int creditHours,Department department,Teacher assignedTeacher) { this.courseId=courseId; this.courseCode=courseCode; this.courseTitle=courseTitle; this.creditHours=creditHours; this.department=department; this.assignedTeacher=assignedTeacher; }
    public String getCourseId(){return courseId;}
    public void setCourseId(String v){courseId=v;}
    public String getCourseCode(){return courseCode;}
    public void setCourseCode(String v){courseCode=v;}
    public String getCourseTitle(){return courseTitle;}
    public void setCourseTitle(String v){courseTitle=v;}
    public int getCreditHours(){return creditHours;}
    public void setCreditHours(int v){creditHours=v;}
    public Department getDepartment(){return department;}
    public void setDepartment(Department v){department=v;}
    public Teacher getAssignedTeacher(){return assignedTeacher;}
    public void setAssignedTeacher(Teacher v){assignedTeacher=v;}
    public String getId(){return String.valueOf(courseId);}
    public String getDisplayName(){return String.valueOf(courseTitle);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(courseId==null || courseId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "Course{"+getId()+", "+getDisplayName()+"}";}
}
