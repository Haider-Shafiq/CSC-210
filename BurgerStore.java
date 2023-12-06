import java.util.Scanner;
public class BurgerStore {
    private String[][] usersAndPasswords = {{"Wendy", "1120 Flatbush"}};
    private String[] items = {"Burger", "Fries", "Drink", "Dessert"};
    private double[] prices = {5.99, 2.49, 1.99, 3.50};
    private double taxRate = 0.08;

    public boolean validateUser(String username, String password) {
        for (String[] userAndPassword : usersAndPasswords) {
            if (userAndPassword[0].equalsIgnoreCase(username) && userAndPassword[1].equals(password)) { 
                return true;
            }
        }
        return false;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - $" + prices[i]);
        }
    }

    public double calculateCost(String item, int quantity) {
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(item)) {//ignore case means we ignore if its upper case or lower case
                index = i;
                break;
            }
        }
        if (index != -1) {
            return prices[index] * quantity;
        }
        return -1; // Item not found
    }

    public double calculateTaxes(double cost) {
        return cost * taxRate;
    }

    public double calculateTotalCost(double cost, double taxes) {
        return cost + taxes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BurgerStore burgerStore = new BurgerStore();

        // User validation
        String username, password;
        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        } while (!burgerStore.validateUser(username, password));

        // Display menu
        burgerStore.displayMenu();

        // Item selection
        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine(); 

        // Quantity input
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        // Calculate and display costs
        String selectedItem = burgerStore.items[itemNumber - 1];
        double cost = burgerStore.calculateCost(selectedItem, quantity);
        double taxes = burgerStore.calculateTaxes(cost);
        double totalCost = burgerStore.calculateTotalCost(cost, taxes);

        System.out.println("\nReceipt:");
        System.out.println("Item: " + selectedItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Cost: $" + cost);
        System.out.println("Taxes: $" + taxes);
        System.out.println("Total Cost: $" + totalCost);

    }
}
