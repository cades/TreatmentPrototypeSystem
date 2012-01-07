package storage.staff;

import list.InspectionList;

public class Inspector extends Staff{
    private InspectionList inspectionList;
    
    public Inspector(String name, String email, Occupation occupation, String id,
            String password) {
        super(name, email, occupation, id, password);
        inspectionList = new InspectionList();
    }

    public InspectionList inspectionList() {return inspectionList;}
}
