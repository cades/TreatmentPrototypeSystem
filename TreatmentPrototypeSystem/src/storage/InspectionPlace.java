package storage;

import storage.inspectionreport.InspectionDivision;
import list.InspectionList;



public class InspectionPlace {
    private InspectionDivision division;
    private InspectionList inspectionList;
    
    public InspectionPlace(InspectionDivision d) {
        division = d;
        inspectionList = new InspectionList();
    }
    
    public InspectionList inspectionList() { return inspectionList; }
}
