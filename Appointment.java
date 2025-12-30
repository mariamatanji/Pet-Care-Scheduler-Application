import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Appointment implements Serializable{

    private LocalDateTime date;
    private String Type;
    private String notes;
    private List<Pet> appointment;

    public Appointment( String Type, String notes){

        this.Type = Type;
        this.notes = notes;
        this.date = LocalDateTime.now();
        this.appointment = new ArrayList<>();
    }
    public String getTypes(){
        return Type;
    
    }
    public String getNotes(){
        return notes;
    }
    public List<Pet> getappointment() { 
        return appointment; 
    }
    public void addAppointment(Pet appointment){

        this.appointment.add(appointment);
        
    }

}
