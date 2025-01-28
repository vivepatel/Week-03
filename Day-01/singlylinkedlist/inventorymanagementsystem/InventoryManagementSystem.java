package singlylinkedlist.inventorymanagementsystem;



public class InventoryManagementSystem {
    private Item head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newItem.next = current.next;
        current.next = newItem;
    }

    // Remove an item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed successfully!");
            return;
        }
        Item current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found!");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed successfully!");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found!");
    }

    // Search for an item by Item ID
    public void searchByItemId(int itemId) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Found: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found!");
    }

    // Search for an item by Item Name
    public void searchByItemName(String itemName) {
        Item current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Found: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with name " + itemName + " not found!");
    }

    // Calculate and display total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Display all items
    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        Item current = head;
        while (current != null) {
            System.out.println("Name: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addAtEnd("Item A", 101, 50, 10.5);
        ims.addAtBeginning("Item B", 102, 30, 15.0);
        ims.addAtPosition(2, "Item C", 103, 20, 12.0);

        System.out.println("All Items:");
        ims.displayItems();

        System.out.println("\nUpdating Quantity of Item ID 102 to 40:");
        ims.updateQuantity(102, 40);
        ims.displayItems();

        System.out.println("\nSearching for Item with ID 103:");
        ims.searchByItemId(103);

        System.out.println("\nSearching for Item with Name 'Item A':");
        ims.searchByItemName("Item A");

        System.out.println("\nCalculating Total Inventory Value:");
        ims.calculateTotalValue();

        System.out.println("\nRemoving Item with ID 103:");
        ims.removeByItemId(103);
        ims.displayItems();
    }
}