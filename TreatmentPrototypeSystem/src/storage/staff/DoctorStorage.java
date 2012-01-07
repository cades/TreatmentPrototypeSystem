package storage.staff;

import java.util.*;

/**
 * DoctorStorage applies singleton pattern
 */
public class DoctorStorage extends HashMap<String, Doctor> {
    private static DoctorStorage _instance = null;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public boolean validate(String id, String password) {
        if (this.containsKey(id) && this.get(id).password().equals(password)) return true;
        return false;
    }
    protected DoctorStorage() {super();}
    public static DoctorStorage Instance() {
        if(_instance == null) {
            _instance = new DoctorStorage();
        }
        return _instance;
    }
}
