package storage.staff;

import java.util.*;

/**
 * InspectorStorage applies singleton pattern
 */
public class InspectorStorage extends HashMap<String, Inspector> {
    private static InspectorStorage _instance = null;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public boolean validate(String id, String password) {
        if (this.containsKey(id) && this.get(id).password().equals(password)) return true;
        return false;
    }
    protected InspectorStorage() {super();}
    public static InspectorStorage Instance() {
        if(_instance == null) {
            _instance = new InspectorStorage();
        }
        return _instance;
    }
}
