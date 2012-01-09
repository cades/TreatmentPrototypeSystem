package storage.casehistory;

import java.util.Date;

public class CaseHistory {
    String doctorInChargeId;
    String patientId;
    Date time;
    String content;
    
    public CaseHistory(String pid, String content) {
        doctorInChargeId = "";
        patientId = pid;
        time = null;
        this.content = content;
    }
    
    public void doctorSign(String did) {
        doctorInChargeId = did;
    }
    
    public String doctorInChargeId() { return doctorInChargeId; }
    public String patientId() { return patientId; }
    public Date time() { return time; }
    public String content() { return content; }
}
