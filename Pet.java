



/* Pet class with the following attributes:
- Unique Pet ID
- Name
- Species/Breed
- Age
- Owner name
- Contact Info
- Registration date
- List of appointments, using an appropriate collection object.*/

import java.io.Serializable;
import java.time.LocalDate;;

public class Pet implements Serializable {
    private String petID;
    private String name;
    private String Species;
    private double age;
    private String OwnerName;
    private String ContactInfo;
    private LocalDate date;

    public Pet(String petID, String name,  String Species,double age,String OwnerName, String ContactInfo){
        this.petID = petID;
        this.name = name;
        this.age = age;
        this.Species = Species;
        this.OwnerName = OwnerName;
        this.ContactInfo = ContactInfo;
        this.date = LocalDate.now();
    }
    public String getPetID(){
        return petID;
    }

    public String getname(){
        return name;
    }
    public double getage(){
        return age;
    }
    public String getSpecies(){
        return Species;
    }
    public String getOwnerName(){
        return OwnerName;
    }
    public String getContactInfo(){
        return ContactInfo;
    }
    public LocalDate getDate(){
        return date;
    }

    
}    
