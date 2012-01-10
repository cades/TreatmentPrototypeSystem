package storage.staff;

import java.util.*;

/**
 * DoctorStorage applies singleton pattern
 */
public class PatrolNurseStorage extends HashMap<String, PatrolNurse> {
    private static PatrolNurseStorage _instance = null;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public boolean validate(String id, String password) {
        if (this.containsKey(id) && this.get(id).password().equals(password)) return true;
        return false;
    }
    protected PatrolNurseStorage() {super();}
    public static PatrolNurseStorage Instance() {
        if(_instance == null) {
            _instance = new PatrolNurseStorage();
        }
        return _instance;
    }
}
