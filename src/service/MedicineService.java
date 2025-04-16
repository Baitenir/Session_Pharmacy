package service;

import models.Medicine;

import java.util.List;

public interface MedicineService {
    void addMedicine ();
    Medicine getMedicineById();
    List<Medicine> getAllMedicine();
    Medicine updateMedicineById();
    void deleteMedicineById();
    void assignMedicineToPharmacy();
}
