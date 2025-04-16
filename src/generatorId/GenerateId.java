package generatorId;

public class GenerateId {
    private static long counterForEmployee = 0L;
    private static long counterForMedicine = 0L;
    private static long counterForPharmacy = 0L;

    public static synchronized long generatorIdForEmployee(){
        return ++counterForEmployee;
    }
    public static synchronized long generatorIdForMedicine(){
        return ++counterForMedicine;
    }
    public static synchronized long generatorIdForPharmacy(){
        return ++counterForPharmacy;
    }
}
