package com.auca.assessment;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
import java.time.LocalDate;
import com.auca.enrollment.Enrollment;

public class Assessment implements Identifiable, Registrable {
    private String assessmentId;
    private Enrollment enrollment;
    private String assessmentType;
    private double maximumScore;
    private double obtainedScore;
    private LocalDate assessmentDate;
    public Assessment(String assessmentId,Enrollment enrollment,String assessmentType,double maximumScore,double obtainedScore,LocalDate assessmentDate) { this.assessmentId=assessmentId; this.enrollment=enrollment; this.assessmentType=assessmentType; this.maximumScore=maximumScore; this.obtainedScore=obtainedScore; this.assessmentDate=assessmentDate; }
    public String getAssessmentId(){return assessmentId;}
    public void setAssessmentId(String v){assessmentId=v;}
    public Enrollment getEnrollment(){return enrollment;}
    public void setEnrollment(Enrollment v){enrollment=v;}
    public String getAssessmentType(){return assessmentType;}
    public void setAssessmentType(String v){assessmentType=v;}
    public double getMaximumScore(){return maximumScore;}
    public void setMaximumScore(double v){maximumScore=v;}
    public double getObtainedScore(){return obtainedScore;}
    public void setObtainedScore(double v){obtainedScore=v;}
    public LocalDate getAssessmentDate(){return assessmentDate;}
    public void setAssessmentDate(LocalDate v){assessmentDate=v;}
    public String getId(){return String.valueOf(assessmentId);}
    public String getDisplayName(){return String.valueOf(assessmentId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(assessmentId==null || assessmentId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); if(maximumScore<=0 || obtainedScore<0 || obtainedScore>maximumScore) throw new ValidationException("Assessment score is outside the valid range."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "Assessment{"+getId()+", "+getDisplayName()+"}";}
}
