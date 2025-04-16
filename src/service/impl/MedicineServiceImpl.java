package service.impl;
import db.Database;
import generatorId.GenerateId;
import models.Medicine;
import models.Pharmacy;
import service.MedicineService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MedicineServiceImpl implements MedicineService {
    Scanner scannerForNum = new Scanner(System.in);
    Scanner scannerForLine = new Scanner(System.in);
    Pharmacy pharmacy = new Pharmacy();

    @Override
    public void addMedicine() {
        Medicine medicine = new Medicine();
        medicine.setId(GenerateId.generatorIdForMedicine());
        System.out.println("Write name:");
        medicine.setName(scannerForLine.nextLine());
        System.out.println("Write price:");
        while (true){
            try {
                medicine.setPrice(scannerForNum.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Write number!");
                scannerForNum.nextLine();
            }
        }
        System.out.println("Write description:");
        medicine.setDescription(scannerForLine.nextLine());
        while (true) {
            try {
                System.out.println("Write year: ");
                int year = scannerForNum.nextInt();
                System.out.println("Write month: ");
                int month = scannerForNum.nextInt();
                System.out.println("Write day: ");
                int day = scannerForNum.nextInt();
                medicine.setExpirationDate(LocalDate.of(year, month, day));
                break;
            } catch (InputMismatchException e){
                System.out.println("Write numbers!");
                scannerForNum.nextLine();
            }
        }
        Database.medicines.add(medicine);
        System.out.println("Medicine added");
    }

    @Override
    public Medicine getMedicineById() {
        System.out.println("Write id:");
        long id = -1;
        while (true) {
            try {
                id = scannerForNum.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Write number!");
                scannerForNum.nextLine();
            }
        }
        for (Medicine medicine : Database.medicines) {
            if (medicine.getId() == id){
                return medicine;
            }
        }
        System.out.println("Medicine not founded!");
        return null;
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return Database.medicines;
    }

    @Override
    public Medicine updateMedicineById() {
        long id = Database.forId();
        for (Medicine medicine : Database.medicines) {
            if (medicine.getId() == id){
                System.out.println("Write name:");
                medicine.setName(scannerForLine.nextLine());
                System.out.println("Write price:");
                while (true) {
                    try {
                        medicine.setPrice(scannerForNum.nextInt());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Write number!");
                        scannerForNum.nextLine();
                    }
                }
                System.out.println("Write description:");
                medicine.setDescription(scannerForLine.nextLine());
                while (true) {
                    try {
                        System.out.println("Write year: ");
                        int year = scannerForNum.nextInt();
                        System.out.println("Write month: ");
                        int month = scannerForNum.nextInt();
                        System.out.println("Write day: ");
                        int day = scannerForNum.nextInt();
                        medicine.setExpirationDate(LocalDate.of(year, month, day));
                        System.out.println("Successfully updated!");
                        return medicine;
                    } catch (InputMismatchException e){
                        System.out.println("Write numbers!");
                        scannerForNum.nextLine();
                    }
                }
            }
        }
        System.out.println("Medicine not founded!");
        return null;
    }

    @Override
    public void deleteMedicineById() {
        long id = Database.forId();
        int c = 0;
        for (Medicine medicine : Database.medicines) {
            if (medicine.getId() == id){
                Database.medicines.remove(medicine);
                System.out.println("Successfully deleted!");
                c++;
                break;
            }
        }
        if (c == 0) System.out.println("Medicine not founded!");
    }

    @Override
    public void assignMedicineToPharmacy() {
        Medicine medicine = getMedicineById();
        if (medicine != null) {
            pharmacy.setMedicines(new ArrayList<>(List.of(medicine)));
            System.out.println("Successfully assigned!");
        } else {
            System.out.println("Please check Database!");
        }
    }
}
