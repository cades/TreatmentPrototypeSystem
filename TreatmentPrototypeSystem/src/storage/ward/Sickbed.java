package storage.ward;

import java.util.Date;

public class Sickbed {
    int number;
    String patientId = null;
    String nurseInCharge = null;
    Date checkinTime;
    boolean inUse = false;
    
    public Sickbed(int num, String pid, String nid, Date time) {
        number = num;
        patientId = pid;
        nurseInCharge = nid;
        checkinTime = time;
    }
    
    public int number() { return number; }
    public void checkin() { inUse = true; }
    public void checkout() { inUse = false; }
    public boolean isEmpty() { return !inUse; }
    public String patientId() { return patientId; }
}
