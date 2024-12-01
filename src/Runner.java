import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import DailyFiles.Advent1;

public class Runner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select which day you want to run");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println("-----------------------------------");
        switch (choice) {
            case 1:
                System.out.println("Part 1:");
                System.out.println(Advent1.challenge1(readData(choice)));
                System.out.println("Do you want to see the part 2? Y/n");
                String goOn = scan.nextLine();
                if (goOn.equals("n")) {
                    break;
                }
            case 101:
                System.out.println("Part 2:");
                System.out.println(Advent1.challenge2(readData(choice)));
                break;

                
        }
    }

    public static ArrayList<String> readData(int day) {
        File dataFile = new File(String.format("src/DataFiles/Data%d.txt", day));
        ArrayList<String> output = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile));) {
            while (reader.ready()) {
                output.add(reader.readLine());
            }
            return output;
        } catch (Exception e) {
            System.err.println("Error reading file!");
            return null;
        }
        
        
    }
}