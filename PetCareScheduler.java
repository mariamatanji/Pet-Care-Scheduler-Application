
import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class PetCareScheduler {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Pet> Pet = new HashMap<>();
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Pet Care Scheduler ===");
            System.out.println("1. Register Pet");
            System.out.println("2. Schedule Appointment ");
            System.out.println("3. Store Data");
            System.out.println("4. Display records");
            System.out.println("5. Generate records");

            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            loadPetFromFile();
            
                 switch (choice) {
                    case "1":
                        RegisterPet();
                        break;
                    case "2":
                       // ScheduleAppointment();
                        break;
                    case "3":
                        //StoreData();
                        break;
                    case "4":
                       // DisplayRecords();
                        break;
                    case "5":
                       // GenerateRecords();
                        break;
                    case "6":
                        //savePetToFile();
                        running = false;
                        System.out.println("Data saved. Goodbye!");
                        break;
                    default:
                    System.out.println("Invalid choice. Please select 1-6.");
                }
            
            }
        }
        public static void loadPetFromFile() {
    File file = new File("pets.txt");
    if (!file.exists()) {
        System.out.println("No saved data found.");
        return;
    }

    try (Scanner fileScanner = new Scanner(file)) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(","); // Assumes comma-separated data

            if (data.length == 6) {
                String id = data[0];
                String name = data[1];
                String owner = data[2];
                double age = Double.parseDouble(data[3]);
                String breed = data[4];
                String type = data[5];

                // Create the pet and add it to your map
                Pet loadedPet = new Pet(id, name, owner, age, breed, type);
                Pet.put(id, loadedPet); 
            }
        }
        System.out.println("Data loaded successfully.");
    } catch (Exception e) {
        System.out.println("Error loading file: " + e.getMessage());
    }
}
        
        //   RegisterPet()
        private static void RegisterPet(){
        System.out.print("Enter Pet ID: ");
        String id = scanner.nextLine().trim();
        
             if (Pet.containsKey(id)) {
                 System.out.println("Error: Household ID already exists.");
                return;  
            }
        System.out.print("Enter Pet name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Owner name: ");
        String Ownername = scanner.nextLine().trim();
        
        System.out.print("Enter Pet age: ");
        double age = Double.parseDouble(scanner.nextLine().trim());
        
        System.out.print("Enter Pet Species/breed: ");
        String breed = scanner.nextLine().trim();
        
         System.out.print("Enter Pet type: ");
        String type = scanner.nextLine().trim();
        
        Pet myPet = new Pet(id, name, Ownername, age, breed, type);
        
        Pet.put(id, myPet);
       System.out.println("Pet registered successfully on " + myPet.getDate());
       
        }
        
//ScheduleAppointment()

//StoreData()
 //DisplayRecords()
// GenerateRecords()
 //saveHPetToFile()
        
    }











