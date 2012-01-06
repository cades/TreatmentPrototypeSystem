package storage.staff;

import list.DiagnosisList;

public class Doctor extends Staff{
    private DiagnosisList diagnosisList;
    
    public Doctor(String name, String email, Occupation occupation, String id,
            String password) {
        super(name, email, occupation, id, password);
        diagnosisList = new DiagnosisList();
    }

    public DiagnosisList diagnosisList() {return diagnosisList;}
}
