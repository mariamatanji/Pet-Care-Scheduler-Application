import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;



public class PetCareScheduler {

    private static List<Pet> pets = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        
        loadPetFromFile();

        while (running) {
            System.out.println("\n=== Pet Care Scheduler ===");
            System.out.println("1. Register Pet");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Display Records");
            System.out.println("4. Save and Exit");
            System.out.println("5. Generate Report");


            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case "3":
                    displayRecords();
                    break;
                case "4":
                    savePetToFile();
                    running = false;
                    System.out.println("Data saved. Goodbye!");
                    break;
                case "5":
                    generateReport();
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
    }

    // ================= Methods ===================

    private static void registerPet() {
        System.out.print("Enter Pet ID: ");
        String id = scanner.nextLine().trim();

        for (Pet p : pets) {
            if (p.getPetId().equals(id)) {
                System.out.println("Error: Pet ID already exists.");
                return;
            }
        }

        System.out.print("Enter Pet Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine().trim();

        System.out.print("Enter Pet Age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter Pet Species/Breed: ");
        String speciesBreed = scanner.nextLine().trim();

        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine().trim();

        Pet myPet = new Pet(id, name, speciesBreed, age, ownerName, contactInfo, LocalDate.now());
        pets.add(myPet);

        System.out.println("Pet registered successfully on " + myPet.getRegistrationDate());
    }

    private static void scheduleAppointment() {
        System.out.print("Enter Pet ID: ");
        String id = scanner.nextLine().trim();

        Pet selectedPet = null;
        for (Pet p : pets) {
            if (p.getPetId().equals(id)) {
                selectedPet = p;
                break;
            }
        }

        if (selectedPet == null) {
            System.out.println("Pet ID not found.");
            return;
        }

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine().trim();

        System.out.print("Enter appointment time (HH:MM): ");
        String timeInput = scanner.nextLine().trim();

        System.out.print("Enter appointment type: ");
        String type = scanner.nextLine().trim();

        System.out.print("Enter notes (optional): ");
        String notes = scanner.nextLine().trim();

        // Parse date + time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
       // LocalDateTime dateTime = LocalDateTime.parse(dateInput + " " + timeInput, formatter);
       LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(dateInput + " " + timeInput, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date/time format.");
            return;
    }

        Appointment appt = new Appointment(dateTime, type, notes);
        selectedPet.addAppointment(appt);

        System.out.println("Appointment scheduled successfully for " + selectedPet.getName() +
                " on " + dateTime.format(formatter));
                
                
                
    }

    private static void displayRecords() {
        if (pets.isEmpty()) {
            System.out.println("No pets registered yet.");
            return;
        }

        for (Pet p : pets) {
            System.out.println(p.toString());
            if (!p.getAppointments().isEmpty()) {
                System.out.println("Appointments:");
                for (Appointment a : p.getAppointments()) {
                    System.out.println("  - " + a.toString());
                }
            } else {
                System.out.println("No appointments yet.");
            }
            System.out.println("------------------------");
        }
    }
    
    private static void savePetToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pets.dat"))) {
            out.writeObject(pets);
            System.out.println("Data saved successfully!");
        }catch (Exception e) {
             System.out.println("Error saving data: " + e.getMessage());
            }
    }

    private static void loadPetFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pets.dat"))) {
            pets = (List<Pet>) in.readObject();
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (Exception e) {
        System.out.println("Error loading data: " + e.getMessage());
        }
    }
    
    private static void generateReport() {
        if (pets.isEmpty()) {
            System.out.println("No pets registered.");
            return;
        }

        System.out.println("=== Pets Report ===");
        for (Pet p : pets) {
            System.out.println("Pet: " + p.getName() + " | Owner: " + p.getOwnerName() +
                           " | Appointments: " + p.getAppointments().size());
            for (Appointment a : p.getAppointments()) {
            System.out.println("   - " + a.toString());
            }
        }
        System.out.println("===================");
    }

}
