import java.util.Vector;

public class Hospital {
    Vector<Doctor> doctorVec;
    Vector<Nurse> nurseVec;
    Vector<Inspector> inspectorVec;
    Vector<Pharmacist> pharmacistVec;
    Vector<CounterStaff> counterStaffVec;
    
    InspectionRoom inspectionRoom;
    
    public Hospital() {
        doctorVec = new Vector<Doctor>();
        nurseVec = new Vector<Nurse>();
        inspectorVec = new Vector<Inspector>();
        pharmacistVec = new Vector<Pharmacist>();
        counterStaffVec = new Vector<CounterStaff>();
    }
    
    public static void main(String[] args) {
        
    }
}
