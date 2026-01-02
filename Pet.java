import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Pet implements Serializable {
    private String petId;
    private String name;
    private String speciesBreed;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment>appointments;
// constructor
    public Pet(String petId, String name,  String speciesBreed,int age,String ownerName, String contactInfo,LocalDate registrationDate){
        this.petId = petId;
        this.name = name;
        this.age = age; 
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = registrationDate;
        this.appointments = new ArrayList<>();
    }
    
  //Getters
    public String getPetId(){
        return petId;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getSpeciesBreed(){
        return speciesBreed;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public String getContactInfo(){
        return contactInfo;
    }
    public LocalDate getRegistrationDate(){
        return registrationDate;
    }
    public List<Appointment> getAppointments(){
        return appointments;
    }

 // setters(excluding petId as it's unique not changebale)
  
    public void setName(String name){
        this.name = name;
    }
     public void setAge(int age){
        this.age = age;
    }
     public void setSpeciesBreed(String speciesBreed){
        this.speciesBreed = speciesBreed;
    }
     public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
     public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
    }
     public void setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
    }
     public void addAppointment(Appointment appointment){
         
        if(appointment != null){
            appointments.add(appointment);
        }
    }
    @Override
    public String toString(){
        return "Pet ID: " +petId+
            ", Name: "+name+
            ", Species/Breed: "+speciesBreed+
            ", Age: " +age+
            ", Owner: "+ ownerName+
            ", Contact Info: "+contactInfo+
            ", Registred "+ registrationDate+
            ", Appointments "+appointments.size();
    }
     
}    
