package list;

import storage.patient.Patient;



public class DiagnosisRecord {
    private Patient patient;
    private static int nextNumber;
    private int number;
    
    public DiagnosisRecord(Patient aPatient) {
        patient = aPatient;
        number = nextNumber;
        nextNumber = (nextNumber + 1) % 100;
    }
    
    public Patient patient() { return patient; }
    
    public int number() { return number; }
}
