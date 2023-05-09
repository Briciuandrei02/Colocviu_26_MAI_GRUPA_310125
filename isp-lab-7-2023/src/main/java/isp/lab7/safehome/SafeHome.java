import java.util.Scanner;

public class SafeHome {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ControllerInterface controller = new Controller();

    public static void main(String[] args) {
        System.out.println("Welcome to SafeHome!");

        while (true) {
            System.out.println("Please select user type:");
            System.out.println("1. Admin");
            System.out.println("2. Tenant");
            System.out.print("> ");
            int userType = scanner.nextInt();

            if (userType == 1) {
                handleAdmin();
            } else if (userType == 2) {
                handleTenant();
            } else {
                System.out.println("Invalid user type selected. Please try again.");
            }
        }
    }

    private static void handleAdmin() {
        while (true) {
            System.out.println("Please select admin action:");
            System.out.println("1. Add tenant");
            System.out.println("2. Remove tenant");
            System.out.println("3. View access logs");
            System.out.println("4. Back to user selection");
            System.out.print("> ");
            int action = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            if (action == 1) {
                System.out.print("Enter tenant name: ");
                String name = scanner.nextLine();
                System.out.print("Enter tenant pin: ");
                String pin = scanner.nextLine();

                try {
                    controller.addTenant(pin, name);
                    System.out.println("Tenant added successfully.");
                } catch (Exception e) {
                    System.out.println("Failed to add tenant: " + e.getMessage());
                }
            } else if (action == 2) {
                System.out.print("Enter tenant name: ");
                String name = scanner.nextLine();

                try {
                    controller.removeTenant(name);
                    System.out.println("Tenant removed successfully.");
                } catch (Exception e) {
                    System.out.println("Failed to remove tenant: " + e.getMessage());
                }
            } else if (action == 3) {
                System.out.println("Access logs:");
                for (AccessLog log : controller.getAccessLog()) {
                    System.out.println(log);
                }
            } else if (action == 4) {
                return;
            } else {
                System.out.println("Invalid admin action selected. Please try again.");
            }
        }
    }

    private static void handleTenant() {
        System.out.print("Enter your pin: ");
        String pin = scanner.nextLine();

        try {
            controller.enterPin(pin);
            System.out.println("Door toggled successfully.");
        } catch (Exception e) {
            System.out.println("Failed to toggle door: " + e.getMessage());
        }
    }
}
