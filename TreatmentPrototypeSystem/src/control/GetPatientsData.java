package control;

import storage.staff.Staff;
import storage.patient.Patient;
import storage.patient.PatientStorage;

public class GetPatientsData {
    PatientStorage patients;
    

    public void setEntity(PatientStorage staffs) { this.patients = patients; }

    public Patient getData(Staff aStaff, String patientId) {
        switch (aStaff.occupation()) { //只有這兩個職業可以看病人個資
        case counterStaff:
        case doctor:
            return patients.get(patientId);
        default:
            return null;
        }
    }
}
