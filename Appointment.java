import java.time.LocalDateTime;
import java.io.Serializable;


public class Appointment implements Serializable{

    private LocalDateTime dateTime;
    private String appointmentType;
    private String notes;
    
// constructor
    public Appointment(LocalDateTime dateTime, String appointmentType,String notes){

        this.dateTime = dateTime;
        this.appointmentType = appointmentType;
        this.notes = notes;
    }
// Getters
    public LocalDateTime getDateTime(){
        return dateTime;
    
    }
    public String getAppointmentType(){
        return appointmentType;
    }
    public String getNotes() { 
        return notes; 
    }
//setters
    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime ;
    
    }
    public void setAppointmentType(String appointmentType){
        this.appointmentType = appointmentType ;
    }
    public void setNotes(String notes) { 
        this.notes = notes; 
    }
@Override
    public String toString(){
        return "Appointment Type: " + appointmentType +
       ", Date and Time: " + dateTime +
       ", Notes: " + (notes != null ? notes : "none");

    }
    

}
