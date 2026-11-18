package com.auca.librarybook;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;

public class LibraryBook implements Identifiable, Registrable {
    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
    public LibraryBook(String bookId,String isbn,String title,String author,int totalCopies,int availableCopies) { this.bookId=bookId; this.isbn=isbn; this.title=title; this.author=author; this.totalCopies=totalCopies; this.availableCopies=availableCopies; }
    public String getBookId(){return bookId;}
    public void setBookId(String v){bookId=v;}
    public String getIsbn(){return isbn;}
    public void setIsbn(String v){isbn=v;}
    public String getTitle(){return title;}
    public void setTitle(String v){title=v;}
    public String getAuthor(){return author;}
    public void setAuthor(String v){author=v;}
    public int getTotalCopies(){return totalCopies;}
    public void setTotalCopies(int v){totalCopies=v;}
    public int getAvailableCopies(){return availableCopies;}
    public void setAvailableCopies(int v){availableCopies=v;}
    public String getId(){return String.valueOf(bookId);}
    public String getDisplayName(){return String.valueOf(title);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(bookId==null || bookId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); if(totalCopies<0 || availableCopies<0 || availableCopies>totalCopies) throw new ValidationException("Invalid book copy counts."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "LibraryBook{"+getId()+", "+getDisplayName()+"}";}
}
