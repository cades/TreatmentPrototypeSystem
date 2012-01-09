package list;

import storage.patient.Patient;



public class InspectionRecord {
    private Patient patient;
    private static int nextNumber;
    private int number;
    
    public InspectionRecord(Patient aPatient) {
        patient = aPatient;
        number = nextNumber;
        nextNumber = (nextNumber + 1) % 100;
    }
    
    public Patient patient() { return patient; }
    
    public int number() { return number; }
}
