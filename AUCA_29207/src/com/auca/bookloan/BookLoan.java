package com.auca.bookloan;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;
import java.time.LocalDate;
import com.auca.student.Student;
import com.auca.librarybook.LibraryBook;

public class BookLoan implements Identifiable, Registrable {
    private String loanId;
    private Student student;
    private LibraryBook book;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    public BookLoan(String loanId,Student student,LibraryBook book,LocalDate borrowedDate,LocalDate dueDate,LocalDate returnedDate) { this.loanId=loanId; this.student=student; this.book=book; this.borrowedDate=borrowedDate; this.dueDate=dueDate; this.returnedDate=returnedDate; }
    public String getLoanId(){return loanId;}
    public void setLoanId(String v){loanId=v;}
    public Student getStudent(){return student;}
    public void setStudent(Student v){student=v;}
    public LibraryBook getBook(){return book;}
    public void setBook(LibraryBook v){book=v;}
    public LocalDate getBorrowedDate(){return borrowedDate;}
    public void setBorrowedDate(LocalDate v){borrowedDate=v;}
    public LocalDate getDueDate(){return dueDate;}
    public void setDueDate(LocalDate v){dueDate=v;}
    public LocalDate getReturnedDate(){return returnedDate;}
    public void setReturnedDate(LocalDate v){returnedDate=v;}
    public String getId(){return String.valueOf(loanId);}
    public String getDisplayName(){return String.valueOf(loanId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(loanId==null || loanId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); if(borrowedDate==null || dueDate==null || !dueDate.isAfter(borrowedDate)) throw new ValidationException("Due date must be after borrowed date."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "BookLoan{"+getId()+", "+getDisplayName()+"}";}
}
