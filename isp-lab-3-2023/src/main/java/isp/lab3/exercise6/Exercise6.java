import java.util.HashMap;

public class VendingMachine {

    private static VendingMachine instance;

    private HashMap<Integer, String> products;
    private int credit;

    private VendingMachine() {
        this.products = new HashMap<Integer, String>();
        this.credit = 0;
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void addProduct(int id, String name) {
        products.put(id, name);
    }

    public void displayProducts() {
        System.out.println("Available products:");
        for (int id : products.keySet()) {
            System.out.println(id + ": " + products.get(id));
        }
    }

    public void insertCoin(int value) {
        credit += value;
    }

    public String selectProduct(int id) {
        if (products.containsKey(id)) {
            if (credit >= 1) {
                String selectedProduct = products.get(id);
                credit -= 1;
                return "Dispensing " + selectedProduct;
            } else {
                return "Insufficient credit";
            }
        } else {
            return "Invalid selection";
        }
    }

    public void displayCredit() {
        System.out.println("Current credit: " + credit);
    }

    public void userMenu() {
        System.out.println("Welcome to the vending machine!");
        boolean running = true;
        while (running) {
            System.out.println("Please select an option:");
            System.out.println("1. Display available products");
            System.out.println("2. Insert coin");
            System.out.println("3. Select product");
            System.out.println("4. Display current credit");
            System.out.println("5. Quit");
            String input = System.console().readLine();
            if (input.equals("1")) {
                displayProducts();
            } else if (input.equals("2")) {
                System.out.print("Enter coin value: ");
                int coinValue = Integer.parseInt(System.console().readLine());
                insertCoin(coinValue);
            } else if (input.equals("3")) {
                System.out.print("Enter product selection: ");
                int selection = Integer.parseInt(System.console().readLine());
                System.out.println(selectProduct(selection));
            } else if (input.equals("4")) {
                displayCredit();
            } else if (input.equals("5")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid selection");
            }
        }
    }
}
