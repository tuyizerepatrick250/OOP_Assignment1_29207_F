package com.auca.main;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.auca.interfaces.*;
import com.auca.exceptions.*;
import com.auca.student.Student;
import com.auca.teacher.Teacher;
import com.auca.administrator.Administrator;
import com.auca.department.Department;
import com.auca.course.Course;
import com.auca.classroom.Classroom;
import com.auca.enrollment.Enrollment;
import com.auca.assessment.Assessment;
import com.auca.feepayment.FeePayment;
import com.auca.librarybook.LibraryBook;
import com.auca.bookloan.BookLoan;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Department> departments=new ArrayList<>();
    private static final List<Student> students=new ArrayList<>();
    private static final List<Teacher> teachers=new ArrayList<>();
    private static final List<Administrator> administrators=new ArrayList<>();
    private static final List<Course> courses=new ArrayList<>();
    private static final List<Classroom> classrooms=new ArrayList<>();
    private static final List<Enrollment> enrollments=new ArrayList<>();
    private static final List<Assessment> assessments=new ArrayList<>();
    private static final List<FeePayment> payments=new ArrayList<>();
    private static final List<LibraryBook> books=new ArrayList<>();
    private static final List<BookLoan> loans=new ArrayList<>();

    public static void main(String[] args) {
        boolean running=true;
        while(running) {
            System.out.println("\n============== AUCA_ID SCHOOL MANAGEMENT ==============");
            System.out.println("1 Register Department       11 Borrow Library Book");
            System.out.println("2 Register Student          12 Return Library Book");
            System.out.println("3 Register Teacher          13 View All Records");
            System.out.println("4 Register Administrator    14 Search Record by ID");
            System.out.println("5 Register Course           15 Update Existing Record");
            System.out.println("6 Register Classroom        16 Student Academic Summary");
            System.out.println("7 Enroll Student            17 Student Payment History");
            System.out.println("8 Record Assessment         18 View Available Books");
            System.out.println("9 Record Fee Payment        19 Demonstrate Polymorphism");
            System.out.println("10 Register Library Book     0 Exit");
            int choice=readInt("Select option: ");
            try {
                switch(choice) {
                    case 1 -> registerDepartment();
                    case 2 -> registerStudent();
                    case 3 -> registerTeacher();
                    case 4 -> registerAdministrator();
                    case 5 -> registerCourse();
                    case 6 -> registerClassroom();
                    case 7 -> enrollStudent();
                    case 8 -> recordAssessment();
                    case 9 -> recordPayment();
                    case 10 -> registerBook();
                    case 11 -> borrowBook();
                    case 12 -> returnBook();
                    case 13 -> viewAll();
                    case 14 -> search();
                    case 15 -> updateRecord();
                    case 16 -> academicSummary();
                    case 17 -> paymentHistory();
                    case 18 -> availableBooks();
                    case 19 -> demonstratePolymorphism();
                    case 0 -> running=false;
                    default -> System.out.println("Choose a number from 0 to 19.");
                }
            } catch(Exception e) { System.out.println("Operation failed: "+e.getMessage()); }
        }
        System.out.println("Thank you for using AUCA_ID.");
    }
    private static String read(String label){System.out.print(label); return sc.nextLine().trim();}
    private static int readInt(String label){while(true){try{return Integer.parseInt(read(label));}catch(NumberFormatException e){System.out.println("Enter a valid whole number.");}}}
    private static double readDouble(String label){while(true){try{return Double.parseDouble(read(label));}catch(NumberFormatException e){System.out.println("Enter a valid number.");}}}
    private static LocalDate date(String label){while(true){try{return LocalDate.parse(read(label));}catch(Exception e){System.out.println("Use YYYY-MM-DD.");}}}
    private static void unique(String id, List<? extends Identifiable> list)throws DuplicateRecordException{for(Identifiable x:list)if(x.getId().equalsIgnoreCase(id))throw new DuplicateRecordException("ID already exists: "+id);}
    private static Department chooseDepartment() throws PrerequisiteMissingException {
        if(departments.isEmpty()) throw new PrerequisiteMissingException("No department exists. Register a department first.");
        for(int i=0;i<departments.size();i++)System.out.println((i+1)+". "+departments.get(i).getRegistrationSummary());
        int n=readInt("Choose department (0 cancel): "); if(n==0||n>departments.size())return null; return departments.get(n-1);
    }
    private static Student chooseStudent() throws PrerequisiteMissingException {
        if(students.isEmpty())throw new PrerequisiteMissingException("No student exists. Register a student first.");
        for(int i=0;i<students.size();i++)System.out.println((i+1)+". "+students.get(i).getRegistrationSummary());
        int n=readInt("Choose student (0 cancel): ");return n>0&&n<=students.size()?students.get(n-1):null;
    }
    private static Teacher chooseTeacher() throws PrerequisiteMissingException {
        if(teachers.isEmpty())throw new PrerequisiteMissingException("No teacher exists. Register a teacher first.");
        for(int i=0;i<teachers.size();i++)System.out.println((i+1)+". "+teachers.get(i).getRegistrationSummary());
        int n=readInt("Choose teacher (0 cancel): ");return n>0&&n<=teachers.size()?teachers.get(n-1):null;
    }
    private static Course chooseCourse() throws PrerequisiteMissingException {
        if(courses.isEmpty())throw new PrerequisiteMissingException("No course exists. Register a course first.");
        for(int i=0;i<courses.size();i++)System.out.println((i+1)+". "+courses.get(i).getRegistrationSummary());
        int n=readInt("Choose course (0 cancel): ");return n>0&&n<=courses.size()?courses.get(n-1):null;
    }
    private static void registerDepartment() throws Exception {
        String id=read("Department ID: ");unique(id,departments);
        Department d=new Department(id,read("Department name: "),read("Department code: "),read("Office location: "),read("Contact email: "),null);
        d.validate(); departments.add(d); System.out.println("Department saved: "+d);
    }
    private static void registerStudent() throws Exception {
        Department dep=chooseDepartment(); if(dep==null)return;
        String pid=read("Person ID: "); unique(pid,students);
        String fn=read("First name: "),ln=read("Last name: "),email=read("Email: "),phone=read("Phone (+ optional): "); LocalDate dob=date("Date of birth: ");
        String member=read("Member number: "); LocalDate join=date("Join date: "); String status=read("Academic status (ACTIVE/INACTIVE): ").toUpperCase();
        String inst=read("Institutional email: "),advisor=read("Advisor name: ");
        String sid=read("Student number: ");
        for(Student s:students)if(s.getStudentNumber().equalsIgnoreCase(sid))throw new DuplicateRecordException("Student number already exists.");
        Student s=new Student(pid,fn,ln,email,phone,dob,member,dep,join,status,inst,advisor,sid,read("Program name: "),date("Admission date: "),readInt("Study year (1-6): "),read("Guardian phone: "),read("Scholarship? (true/false): ").equalsIgnoreCase("true"));
        s.validate(); if(s.getStudyYear()<1||s.getStudyYear()>6)throw new ValidationException("Study year must be 1-6.");
        students.add(s); System.out.println("Student registered: "+s.getRegistrationSummary());
    }
    private static void registerTeacher() throws Exception {
        Department dep=chooseDepartment();if(dep==null)return;
        String pid=read("Person ID: ");unique(pid,teachers);
        Teacher t=new Teacher(pid,read("First name: "),read("Last name: "),read("Email: "),read("Phone: "),date("Date of birth: "),read("Member number: "),dep,date("Join date: "),read("Academic status: "),read("Institutional email: "),read("Advisor name: "),read("Employee number: "),read("Specialization: "),date("Hire date: "),new BigDecimal(read("Salary: ")),read("Office number: "),read("Employment type: "));
        t.validate();teachers.add(t);System.out.println("Teacher saved: "+t.getRegistrationSummary());
    }
    private static void registerAdministrator() throws Exception {
        String id=read("Staff/person ID: ");unique(id,administrators);
        Administrator a=new Administrator(id,read("First name: "),read("Last name: "),read("Email: "),read("Phone: "),date("Date of birth: "),read("Staff number: "),read("Job title: "),read("Assigned office: "),date("Employment date: "),readInt("Access level: "),true);
        a.validate();administrators.add(a);System.out.println("Administrator saved.");
    }
    private static void registerCourse() throws Exception {
        Department d=chooseDepartment();if(d==null)return;Teacher t=chooseTeacher();if(t==null)return;
        String id=read("Course ID: ");unique(id,courses);
        Course c=new Course(id,read("Course code: "),read("Course title: "),readInt("Credit hours (1-6): "),d,t);
        c.validate();if(c.getCreditHours()<1||c.getCreditHours()>6)throw new ValidationException("Credit hours must be 1-6.");courses.add(c);System.out.println("Course saved.");
    }
    private static void registerClassroom() throws Exception {
        String id=read("Classroom ID: ");unique(id,classrooms);
        Classroom c=new Classroom(id,read("Building: "),read("Room number: "),readInt("Capacity: "),readInt("Floor: "),true);c.validate();classrooms.add(c);System.out.println("Classroom saved.");
    }
    private static void enrollStudent() throws Exception {
        Student s=chooseStudent();if(s==null)return;Course c=chooseCourse();if(c==null)return;
        String sem=read("Semester (e.g. 2026-FALL): ");
        for(Enrollment e:enrollments)if(e.getStudent()==s&&e.getCourse()==c&&e.getSemester().equalsIgnoreCase(sem)&&"ACTIVE".equalsIgnoreCase(e.getEnrollmentStatus()))throw new DuplicateRecordException("Duplicate active enrollment.");
        Enrollment e=new Enrollment(read("Enrollment ID: "),s,c,LocalDate.now(),sem,"ACTIVE");e.validate();enrollments.add(e);System.out.println("Enrollment saved.");
    }
    private static void recordAssessment() throws Exception {
        if(enrollments.isEmpty())throw new PrerequisiteMissingException("No enrollment exists.");
        for(int i=0;i<enrollments.size();i++)System.out.println((i+1)+". "+enrollments.get(i));
        int n=readInt("Select enrollment: ");if(n<1||n>enrollments.size())return;Enrollment e=enrollments.get(n-1);
        Assessment a=new Assessment(read("Assessment ID: "),e,read("Assessment type: "),readDouble("Maximum score: "),readDouble("Obtained score: "),date("Assessment date: "));a.validate();assessments.add(a);System.out.println("Assessment saved.");
    }
    private static void recordPayment() throws Exception {
        Student s=chooseStudent();if(s==null)return;
        FeePayment p=new FeePayment(read("Payment ID: "),s,new BigDecimal(read("Amount: ")),date("Payment date: "),read("Payment method: "),read("Receipt number: "));
        for(FeePayment x:payments)if(x.getReceiptNumber().equalsIgnoreCase(p.getReceiptNumber()))throw new DuplicateRecordException("Receipt number already exists.");
        p.validate();payments.add(p);System.out.println("Payment saved.");
    }
    private static void registerBook() throws Exception {
        LibraryBook b=new LibraryBook(read("Book ID: "),read("ISBN: "),read("Title: "),read("Author: "),readInt("Total copies: "),readInt("Available copies: "));
        unique(b.getId(),books);b.validate();books.add(b);System.out.println("Book saved.");
    }
    private static void borrowBook() throws Exception {
        Student s=chooseStudent();if(s==null)return;if(books.isEmpty())throw new PrerequisiteMissingException("No library book exists.");
        for(int i=0;i<books.size();i++)System.out.println((i+1)+". "+books.get(i));
        int n=readInt("Select book: ");if(n<1||n>books.size())return;LibraryBook b=books.get(n-1);
        if(b.getAvailableCopies()<=0)throw new BookUnavailableException("No copies are currently available.");
        LocalDate borrowed=date("Borrowed date: "),due=date("Due date: ");BookLoan loan=new BookLoan(read("Loan ID: "),s,b,borrowed,due,null);loan.validate();
        b.setAvailableCopies(b.getAvailableCopies()-1);loans.add(loan);System.out.println("Book borrowed.");
    }
    private static void returnBook() throws Exception {
        List<BookLoan> active=new ArrayList<>();for(BookLoan l:loans)if(l.getReturnedDate()==null)active.add(l);
        if(active.isEmpty()){System.out.println("No active loans.");return;}
        for(int i=0;i<active.size();i++)System.out.println((i+1)+". "+active.get(i));
        int n=readInt("Select loan: ");if(n<1||n>active.size())return;BookLoan l=active.get(n-1);
        l.setReturnedDate(date("Return date: "));l.getBook().setAvailableCopies(l.getBook().getAvailableCopies()+1);System.out.println("Book returned.");
    }
    private static void viewAll(){
        List<List<?>> groups=List.of(departments,students,teachers,administrators,courses,classrooms,enrollments,assessments,payments,books,loans);
        for(List<?> g:groups)for(Object x:g)System.out.println(x);
        if(groups.stream().allMatch(List::isEmpty))System.out.println("No records have been registered.");
    }
    private static void search(){
        String id=read("Enter ID: ");boolean found=false;
        List<List<?>> groups=List.of(departments,students,teachers,administrators,courses,classrooms,enrollments,assessments,payments,books,loans);
        for(List<?> g:groups)for(Object x:g)if(x instanceof Identifiable && ((Identifiable)x).getId().equalsIgnoreCase(id)){System.out.println(x);found=true;}
        if(!found)System.out.println("No record found with ID "+id);
    }
    private static void updateRecord(){System.out.println("Update baseline: currently supports changing a student's guardian phone.");
        String id=read("Student person ID: ");for(Student s:students)if(s.getId().equalsIgnoreCase(id)){s.setGuardianPhone(read("New guardian phone: "));System.out.println("Updated: "+s);return;}System.out.println("Student not found.");
    }
    private static void academicSummary(){
        Student s;try{s=chooseStudent();}catch(Exception e){System.out.println(e.getMessage());return;}if(s==null)return;
        System.out.println("ACADEMIC SUMMARY: "+s.getDisplayName());
        for(Enrollment e:enrollments)if(e.getStudent()==s)System.out.println(e);
        for(Assessment a:assessments)if(a.getEnrollment().getStudent()==s)System.out.println(a);
    }
    private static void paymentHistory(){
        Student s;try{s=chooseStudent();}catch(Exception e){System.out.println(e.getMessage());return;}if(s==null)return;
        for(FeePayment p:payments)if(p.getStudent()==s)System.out.println(p);
    }
    private static void availableBooks(){for(LibraryBook b:books)if(b.getAvailableCopies()>0)System.out.println(b);if(books.stream().noneMatch(b->b.getAvailableCopies()>0))System.out.println("No books available.");}
    private static void demonstratePolymorphism(){
        List<com.auca.abstracts.Person> people=new ArrayList<>();people.addAll(students);people.addAll(teachers);people.addAll(administrators);
        System.out.println("Superclass polymorphism:");for(var p:people)System.out.println(p.getRegistrationSummary()+" -> "+p.getRoleDescription());
        List<Identifiable> entities=new ArrayList<>();entities.addAll(departments);entities.addAll(courses);entities.addAll(books);
        System.out.println("Interface polymorphism:");for(Identifiable x:entities)System.out.println(x.getId()+" "+x.getDisplayName()+" active="+x.isActive());
    }
}
