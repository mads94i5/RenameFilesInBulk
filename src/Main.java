import java.io.File;
import java.util.Scanner;

public class Main {
    private final String folderPath = "D:/Game Making/Legends of Mythology/Unity/Project/Legends of Mythology/Assets/Sprites/Player/EquippedOverlays/" +
            "RightHand/#OptimizedNew/";
    private final String replace = "Optimized";
    private final String replaceWith = "NewWeapon";
    private boolean isRunning = true;
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
    private void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("##### Welcome to the file rename program #####");
        System.out.println("##### Folder path: " + folderPath + " #####");
        System.out.println("##### Replace: " + replace + " #####");
        System.out.println("##### With: " + replaceWith + " #####");
        System.out.println("##### Do you want to run the program? (y/n) #####");
        while (isRunning) {
            String input = sc.nextLine();
            if (input.equals("y")) {
                System.out.println("##### Program will run. Renaming files.. #####");
                rename();
                isRunning = false;
            } else if (input.equals("n")) {
                System.out.println("##### Program will NOT run. Shutting down.. #####");
                isRunning = false;
            } else {
                System.out.println("##### Try again. Enter (y/n). You entered: " + input + " #####");
            }
        }
    }
    private void rename() {
        try {
            File filePath = new File(folderPath);
            if (filePath.exists() && filePath.isDirectory()) {
                System.out.println("Filepath and directory exists!");
                File[] files = filePath.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].getName().contains(replace)) {
                            System.out.println("File: " + files[i].getName() + " - contains: " + replace + " - replacing with: " + replaceWith);
                            System.out.println("Renaming file [" + i+1 + " of " + files.length+1 + "]: " + files[i].getName());
                            String newFileName = files[i].getName().replace(replace, replaceWith);
                            if (files[i].renameTo(new File(folderPath + newFileName))) {
                                System.out.println("Successfully renamed file to: " + files[i].getName());
                            } else { System.out.println("Failed to rename file: " + files[i].getName()); }
                        } else { System.out.println("File: " + files[i].getName() + " - does NOT contain: " + replace + " - will NOT rename."); }
                    }
                } else { System.out.println("No files found."); }
            } else { System.out.println("Filepath/directory does not exist."); }
        } catch (Exception e) { e.printStackTrace(); }
    }
}