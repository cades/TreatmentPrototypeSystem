package storage.patient;


import java.util.*;

/**
 * 存病人資料的資料庫
 */
public class PatientStorage extends HashMap<String, Patient> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static PatientStorage _instance = null;
    public static PatientStorage Instance() {
        if(_instance == null) {
            _instance = new  PatientStorage();
        }
        return _instance;
    }
    protected PatientStorage() {
        super();
    }
}

