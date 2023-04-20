import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create a new MyArrayList
        MyList<Integer> arrayList = new MyArrayList<>();

        // create a new MyLinkedList
        MyList<Integer> linkedList = new MyLinkedList<>();

        while (true) {
            System.out.println("Choose a list to check:");
            System.out.println("1. MyArrayList");
            System.out.println("2. MyLinkedList");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("You are working with MyArrayList");
                System.out.println("Choose operation:");
                System.out.println("1. Add an element");
                System.out.println("2. Get an element");
                System.out.println("3. Remove an element");
                System.out.println("4. Print the list");
                System.out.println("5. Back to main menu");

                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Enter the element to add:");
                        int element = scanner.nextInt();
                        arrayList.add(element);
                        System.out.println("Element added successfully");
                        break;
                    case 2:
                        System.out.println("Enter the index of the element to get:");
                        int index = scanner.nextInt();
                        System.out.println("Element at index " + index + ": " + arrayList.get(index));
                        break;
                    case 3:
                        System.out.println("Enter the index of the element to remove:");
                        int removeIndex = scanner.nextInt();
                        arrayList.remove(removeIndex);
                        System.out.println("Element removed successfully");
                        break;
                    case 4:
                        System.out.println("Elements in the list:");
                        for (int i = 0; i < arrayList.size(); i++) {
                            System.out.println(arrayList.get(i));
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else if (choice == 2) {
                System.out.println("You are working with MyLinkedList");
                System.out.println("Choose operation:");
                System.out.println("1. Add an element");
                System.out.println("2. Get an element");
                System.out.println("3. Remove an element");
                System.out.println("4. Print the list");
                System.out.println("5. Back to main menu");

                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Enter the element to add:");
                        int element = scanner.nextInt();
                        linkedList.add(element);
                        System.out.println("Element added successfully");
                        break;
                    case 2:
                        System.out.println("Enter the index of the element to get:");
                        int index = scanner.nextInt();
                        System.out.println("Element at index " + index + ": " + linkedList.get(index));
                        break;
                    case 3:
                        System.out.println("Enter the index of the element to remove:");
                        int removeIndex = scanner.nextInt();
                        linkedList.remove(removeIndex);
                        System.out.println("Element removed successfully");
                        break;
                    case 4:
                        System.out.println("Elements in the list:");
                        for (int i = 0; i < linkedList.size(); i++) {
                            System.out.println(linkedList.get(i));
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid operation");
                        break;
                }
            } else if (choice == 3) {
                System.out.println();
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}