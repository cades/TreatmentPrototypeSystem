package storage.prescription;

import java.util.ArrayList;

public class PrescriptionStorage extends ArrayList<Prescription>{

    /**
     * PrescriptionStorage applies singleton pattern
     */
    private static final long serialVersionUID = 1L;
    
    private static PrescriptionStorage _instance = null;
    protected PrescriptionStorage() { super(); }
    public static PrescriptionStorage Instance() {
        if (_instance == null) {
            _instance = new PrescriptionStorage();
        }
        return _instance;
    }
}
