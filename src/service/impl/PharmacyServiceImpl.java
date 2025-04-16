package service.impl;
import db.Database;
import models.Employee;
import models.Medicine;
import models.Pharmacy;
import service.PharmacyService;
import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {

    @Override
    public List<Employee> getAllOnlyAssignedToPharmacyEmployee() {
        return Database.employees;
    }

    @Override
    public List<Medicine> getAllOnlyAssignedToPharmacyMedicine() {
        return Database.medicines;
    }
}
