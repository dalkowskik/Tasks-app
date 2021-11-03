import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Main01 {


    public static void main(String[] args) {

        options();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        while(!input.equals("quit")){
            switch (input) {
                case "add":
                    addTask();
                    break;
                case "list":
                    showList();
                    break;
                case "remove":
                    remove();
                    break;

            }
            input = scanner.nextLine();
        }



    }

    private static void remove() {
        System.out.println("Which task do you want delete?");
        Scanner scanner = new Scanner(System.in);




    }


    private static void options(){
        System.out.println("\n"+"Select an option:"+"\n"+"add"+"\n"+"list"+"\n"+"remove"+"\n"+"quit"+"\n");
    }

    private static void showList() {
        Path path = Paths.get("tasks.txt");
        List<String> list = new ArrayList<>();
        int counter = 0;
        try {
            for (String line : Files.readAllLines(path)) {
                System.out.println(counter + ": " + line);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        options();
    }


    public static void addTask() {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("tasks.txt");
        StringBuilder task = new StringBuilder();
        System.out.println("Please add task description: ");
        task.append(scanner.nextLine() + " ");
        System.out.println("Please add task due date: ");
        task.append(scanner.nextLine() + " ");
        System.out.println("Is it important? true/false");
        task.append(scanner.nextLine());

        try (FileWriter fileWriter = new FileWriter("tasks.txt", true)) {
            fileWriter.append(task + "\n");
        } catch (IOException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }
        options();
    }


}
