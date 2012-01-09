package storage.prescription;

import java.util.Date;

public class Prescription {
    String counterStaffInChargeId;
    String doctorInChargeId;
    String patientId;
    Date time;
    String content;
    boolean isPrinted;
    boolean isMoneyPaid;
    boolean isMedicineReceived;
    
    public Prescription(String pid, Date time, String content) {
        counterStaffInChargeId = "";
        doctorInChargeId = "";
        patientId = pid;
        this.time = time;
        this.content = content;
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
    
    public String patientId() { return patientId; }
    public boolean isMoneyPaid() { return isMoneyPaid; }
    public String counterStaffInChargeId() { return counterStaffInChargeId; }
    public boolean isMedicineReceived() { return isMedicineReceived; }
    public String doctorInChargeId() { return doctorInChargeId; }
    public Date time() { return time; }
    public String content() { return content; }
    
}
