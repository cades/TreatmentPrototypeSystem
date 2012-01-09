package storage.inspectionreport;

import java.util.Date;

public class InspectionReport {
    String inspectorInChargeId;
    String patientId;
    InspectionDivision inspectionDivision;
    Date time;
    String content;
    
    public InspectionReport(
            String inspectorInChargeId,
            String patientId,
            InspectionDivision inspectionDivision,
            Date time,
            String content) {
        this.inspectorInChargeId = inspectorInChargeId;
        this.patientId = patientId;
        this.inspectionDivision = inspectionDivision;
        this.time = time;
        this.content = content;
    }
    
    public String inspectorInChargeId() { return inspectorInChargeId; }
    public String patientId() { return patientId; }
    public InspectionDivision inspectionDivision() { return inspectionDivision; }
    public Date time() { return time; }
    public String content() { return content; }
}
