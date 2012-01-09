package storage.inspectionreport;

import java.util.ArrayList;

public class InspectionReportStorage extends ArrayList<InspectionReport>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static InspectionReportStorage _instance;
    protected InspectionReportStorage() { super(); }
    public static InspectionReportStorage Instance() {
        if (_instance == null) {
            _instance = new InspectionReportStorage();
        }
        return _instance;
    }
}
