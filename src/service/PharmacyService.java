package service;
import models.Employee;
import models.Medicine;
import models.Pharmacy;
import java.util.List;

public interface PharmacyService {
    List<Employee> getAllOnlyAssignedToPharmacyEmployee();
    List<Medicine> getAllOnlyAssignedToPharmacyMedicine();
}
