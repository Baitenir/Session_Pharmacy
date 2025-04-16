package db;
import models.Employee;
import models.Medicine;
import models.Pharmacy;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Database {
//    public static List<Pharmacy> pharmacies = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();
    public static List<Medicine> medicines = new ArrayList<>();
    public static Pharmacy pharmacy = new Pharmacy(1, "HelpPeople", "Kok-Jar");


    public static long forId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write id:");
        long id = -1;
        while (true) {
            try {
                id = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Write number!");
                scanner.nextLine();
            }
        }
        return id;
    }
    public static int getUserChoice(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int num = scanner.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Write number!");
                scanner.nextLine();
            }
        }
    }
}
