/*2 Design an interface named Plugin with a method execute(). Implement
this interface in classes for different types of plugins, such as
TextPlugin, ImagePlugin, and AudioPlugin. Write a program that
dynamically loads and executes plugins based on user input with
exception handling. */
interface Plugin {
    void execute();
}

class TextPlugin implements Plugin {
    @Override
    public void execute() {
        System.out.println("Executing TextPlugin...");
    }
}

class ImagePlugin implements Plugin {
    @Override
    public void execute() {
        System.out.println("Executing ImagePlugin...");
    }
}

class AudioPlugin implements Plugin {
    @Override
    public void execute() {
        System.out.println("Executing AudioPlugin...");
    }
}

public class Assgn2 {
    public static void main(String[] args) {
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);

            while (true) {
                System.out.println("\nChoose a plugin to execute:");
                System.out.println("1. Text Plugin");
                System.out.println("2. Image Plugin");
                System.out.println("3. Audio Plugin");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                if (choice == 4) {
                    break;
                }

                Plugin plugin = null;

                switch (choice) {
                    case 1:
                        plugin = new TextPlugin();
                        break;
                    case 2:
                        plugin = new ImagePlugin();
                        break;
                    case 3:
                        plugin = new AudioPlugin();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

                if (plugin != null) {
                    plugin.execute();
                }
            }

            System.out.println("Exiting the program.");
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
