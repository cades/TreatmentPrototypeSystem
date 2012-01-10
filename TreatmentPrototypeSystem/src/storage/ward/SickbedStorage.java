package storage.ward;

import java.util.HashMap;



public class SickbedStorage extends HashMap<Integer, Sickbed> {
    final int totalNumber = 10;
    private static SickbedStorage _instance;
    protected SickbedStorage() { super(); }
    public static SickbedStorage Instance() {
        if (_instance == null) {
            _instance = new SickbedStorage();
        }
        return _instance;
    }

    
    public int totalNumber() { return totalNumber; }
}
