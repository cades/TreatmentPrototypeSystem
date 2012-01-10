package storage.prescription;

import java.util.Date;
import java.util.HashMap;

import storage.medicine.Medicine;
import storage.medicine.Price;

public class Prescription {
    String counterStaffInChargeId;
    String doctorInChargeId;
    String patientId;
    Date time;
    HashMap<Medicine, Integer> medicines;
    boolean isPrinted;
    boolean isMoneyPaid;
    boolean isMedicineReceived;
    
    public Prescription(String pid, Date time, HashMap<Medicine, Integer> medicines) {
        counterStaffInChargeId = "";
        doctorInChargeId = "";
        patientId = pid;
        this.time = time;
        this.medicines = medicines;
        isPrinted = false;
        isMoneyPaid = false;
        isMedicineReceived = false;
    }
    
    public void counterStaffSign(String cid) {
        counterStaffInChargeId = cid;
    }
    
    public void doctorSign(String did) {
        doctorInChargeId = did;
    }
    
    public void giveMedicinesToPatient() { isMedicineReceived = true; }
    public void pay() { isMoneyPaid = true; }
    public void print() { isPrinted = true; }
    
    public String patientId() { return patientId; }
    public String counterStaffInChargeId() { return counterStaffInChargeId; }
    public String doctorInChargeId() { return doctorInChargeId; }
    
    public boolean isMoneyPaid() { return isMoneyPaid; }
    public boolean isMedicineReceived() { return isMedicineReceived; }
    public boolean isPrinted() { return isPrinted; }
    
    public Date time() { return time; }
    public HashMap<Medicine, Integer> medicines() { return medicines; }
    
    public static String medicinesToString(HashMap<Medicine, Integer> medicines) {
        String content = "";
        for (Medicine m : Medicine.values()) {
            if(medicines.get(m) != null)
                content = content + "藥品 " + m + " 共 " + medicines.get(m) + " 份\n";
        }
        return content;
    }
    
    public int price() {
        int sum = 0;
        for (Medicine m : Medicine.values()) {
            if(medicines.get(m) != null) sum = sum + medicines.get(m) * Price.get(m); // 數量乘以價格
        }
        return sum;
    }
    
}
