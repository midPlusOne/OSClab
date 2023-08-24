/*2 Design an interface named Plugin with a method execute(). Implement
this interface in classes for different types of plugins, such as
TextPlugin, ImagePlugin, and AudioPlugin. Write a program that
dynamically loads and executes plugins based on user input with
exception handling.*/

import java.util.Scanner;

interface Plugin {
    public void execute();
}

class TextPlugin implements Plugin {
    public void execute() {
        System.out.println("Displaying Texts from the text plugin");
    }
}

class ImagePlugin implements Plugin {
    public void execute() {
        System.out.println("Displaying Image from the image plugin");
    }
}

class AudioPlugin implements Plugin {
    public void execute() {
        System.out.println("Playing Audio from the audio plugin");
    }
}

public class as2_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Plugin plugin;

        while (true) {
            System.out.println("1.TextPlugin\n2.ImagePlugin\n3.AudioPlugin\n4.Exit");
            System.out.print("Enter the choice:");
            int ch;
            try {
                ch = scanner.nextInt();

                switch (ch) {
                    case 1:
                        plugin = new TextPlugin();
                        plugin.execute();
                        break;
                    case 2:
                        plugin = new ImagePlugin();
                        plugin.execute();
                        break;
                    case 3:
                        plugin = new AudioPlugin();
                        plugin.execute();
                        break;
                    case 4:
                        System.out.println("Exiting.....");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Enter proper choice number");
                return;
            }
        }
    }
}
