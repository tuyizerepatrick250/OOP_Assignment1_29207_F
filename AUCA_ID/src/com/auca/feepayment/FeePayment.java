package com.auca.feepayment;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.auca.student.Student;

public class FeePayment implements Identifiable, Registrable {
    private String paymentId;
    private Student student;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String receiptNumber;
    public FeePayment(String paymentId,Student student,BigDecimal amount,LocalDate paymentDate,String paymentMethod,String receiptNumber) { this.paymentId=paymentId; this.student=student; this.amount=amount; this.paymentDate=paymentDate; this.paymentMethod=paymentMethod; this.receiptNumber=receiptNumber; }
    public String getPaymentId(){return paymentId;}
    public void setPaymentId(String v){paymentId=v;}
    public Student getStudent(){return student;}
    public void setStudent(Student v){student=v;}
    public BigDecimal getAmount(){return amount;}
    public void setAmount(BigDecimal v){amount=v;}
    public LocalDate getPaymentDate(){return paymentDate;}
    public void setPaymentDate(LocalDate v){paymentDate=v;}
    public String getPaymentMethod(){return paymentMethod;}
    public void setPaymentMethod(String v){paymentMethod=v;}
    public String getReceiptNumber(){return receiptNumber;}
    public void setReceiptNumber(String v){receiptNumber=v;}
    public String getId(){return String.valueOf(paymentId);}
    public String getDisplayName(){return String.valueOf(paymentId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(paymentId==null || paymentId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); if(amount==null || amount.signum()<=0) throw new ValidationException("Payment amount must be positive."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "FeePayment{"+getId()+", "+getDisplayName()+"}";}
}
