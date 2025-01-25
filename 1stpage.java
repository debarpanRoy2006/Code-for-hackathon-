import java.util.ArrayList;
import java.util.List;

class SecurityApp {
    private String userName;
    private String userLocation;
    private List<String> emergencyContacts;

    // Constructor
    public SecurityApp(String userName) {
        this.userName = userName;
        this.emergencyContacts = new ArrayList<>();
    }

    // Add an emergency contact
    public void addEmergencyContact(String contact) {
        emergencyContacts.add(contact);
        System.out.println("Contact added: " + contact);
    }

    // Remove an emergency contact
    public void removeEmergencyContact(String contact) {
        if (emergencyContacts.contains(contact)) {
            emergencyContacts.remove(contact);
            System.out.println("Contact removed: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Update user's location
    public void updateLocation(String location) {
        this.userLocation = location;
        System.out.println("Location updated to: " + location);
    }

    // Send SOS alert
    public void sendSOS() {
        if (emergencyContacts.isEmpty()) {
            System.out.println("No emergency contacts available!");
            return;
        }
        System.out.println("SOS Alert! Sending location to emergency contacts...");
        for (String contact : emergencyContacts) {
            System.out.println("Alert sent to: " + contact + " with location: " + userLocation);
        }
    }

    // Display emergency contacts
    public void displayContacts() {
        System.out.println("Emergency Contacts:");
        for (String contact : emergencyContacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        // Simulating the app
        SecurityApp app = new SecurityApp("John Doe");

        // Adding contacts
        app.addEmergencyContact("Mom: 1234567890");
        app.addEmergencyContact("Dad: 0987654321");

        // Updating location
        app.updateLocation("22.5726° N, 88.3639° E (Kolkata)");

        // Display contacts
        app.displayContacts();

        // Sending an SOS alert
        app.sendSOS();

        // Removing a contact
        app.removeEmergencyContact("Dad: 0987654321");

        // Sending SOS again
        app.sendSOS();
    }
}
