package com.auca.classroom;
import com.auca.interfaces.*;
import com.auca.exceptions.ValidationException;
import com.auca.abstracts.*;

public class Classroom implements Identifiable, Registrable {
    private String classroomId;
    private String buildingName;
    private String roomNumber;
    private int capacity;
    private int floorNumber;
    private boolean available;
    public Classroom(String classroomId,String buildingName,String roomNumber,int capacity,int floorNumber,boolean available) { this.classroomId=classroomId; this.buildingName=buildingName; this.roomNumber=roomNumber; this.capacity=capacity; this.floorNumber=floorNumber; this.available=available; }
    public String getClassroomId(){return classroomId;}
    public void setClassroomId(String v){classroomId=v;}
    public String getBuildingName(){return buildingName;}
    public void setBuildingName(String v){buildingName=v;}
    public String getRoomNumber(){return roomNumber;}
    public void setRoomNumber(String v){roomNumber=v;}
    public int getCapacity(){return capacity;}
    public void setCapacity(int v){capacity=v;}
    public int getFloorNumber(){return floorNumber;}
    public void setFloorNumber(int v){floorNumber=v;}
    public boolean getAvailable(){return available;}
    public void setAvailable(boolean v){available=v;}
    public String getId(){return String.valueOf(classroomId);}
    public String getDisplayName(){return String.valueOf(classroomId);}
    public boolean isActive(){return true;}
    public void validate() throws ValidationException { if(classroomId==null || classroomId.toString().trim().isEmpty()) throw new ValidationException("ID is required."); if(capacity<=0 || floorNumber<0) throw new ValidationException("Capacity must be positive and floor nonnegative."); }
    public void printDetails(){System.out.println(this);}
    public String getRegistrationSummary(){return getId()+" | "+getDisplayName();}

    public String toString(){return "Classroom{"+getId()+", "+getDisplayName()+"}";}
}
