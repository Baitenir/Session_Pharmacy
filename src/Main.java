import db.Database;
import service.EmployeeService;
import service.MedicineService;
import service.PharmacyService;
import service.impl.EmployeeServiceImpl;
import service.impl.MedicineServiceImpl;
import service.impl.PharmacyServiceImpl;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        MedicineService medicineService = new MedicineServiceImpl();
        PharmacyService pharmacyService = new PharmacyServiceImpl();

        System.out.println("Welcome!\nSelect action:");
        while (true) {
            System.out.println("""
                    
                       MAIN MENU
                    1. About employees
                    2. About Medicines
                    3. Get all assigned to pharmacy employees
                    4. Get all assigned to pharmacy medicines
                    5. Exit
                    """);
            int userChoice = Database.getUserChoice();
            if (userChoice == 1) {
                boolean isTrue = true;
                while (isTrue) {
                    System.out.println("""
                            
                            1. Add employee
                            2. Get employee by id
                            3. Get all employee
                            4. Update employee by id
                            5. Delete employee
                            6. Assign employee to pharmacy
                            7. Exit
                            """);
//                    int userChoiceInAboutEmployee = Database.getUserChoice();
                    switch (Database.getUserChoice()){
                        case 1: employeeService.addEmployee(); break;
                        case 2: System.out.println(employeeService.getEmployeeById()); break;
                        case 3:
                            System.out.println(employeeService.getAllEmployees());
                            break;
                        case 4:
                            System.out.println(employeeService.updateEmployeeById());
                            break;
                        case 5: employeeService.deleteEmployeeById(); break;
                        case 6: employeeService.assignEmployeeToPharmacy(); break;
                        case 7: isTrue = false;
                        default: System.out.println("Incorrect value!");
                    }
                }
            } else if (userChoice == 2) {
                boolean isTrue2 = true;
                while (isTrue2){
                    System.out.println("""
                            
                            1. Add medicine
                            2. Get medicine by id
                            3. Get all medicine
                            4. Update medicine by id
                            5. Delete medicine
                            6. Assign medicine to pharmacy
                            7. Exit
                            """);

                    switch (Database.getUserChoice()){
                        case 1: medicineService.addMedicine(); break;
                        case 2: System.out.println(medicineService.getMedicineById()); break;
                        case 3: System.out.println(medicineService.getAllMedicine()); break;
                        case 4: System.out.println(medicineService.updateMedicineById()); break;
                        case 5: medicineService.deleteMedicineById(); break;
                        case 6: medicineService.assignMedicineToPharmacy(); break;
                        case 7: isTrue2 = false; break;
                        default: System.out.println("Incorrect value!");
                    }
                }
            } else if (userChoice == 3) {
                System.out.println(pharmacyService.getAllOnlyAssignedToPharmacyEmployee());
            } else if (userChoice == 4) {
                System.out.println(pharmacyService.getAllOnlyAssignedToPharmacyMedicine());
            } else if (userChoice == 5) {
                return;
            } else {
                System.out.println("Incorrect value!");
            }
        }
    }
}