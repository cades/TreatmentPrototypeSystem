package storage.medicine;

import java.util.HashMap;

public class MedicineStocks extends HashMap<Medicine, Integer> {
    private static MedicineStocks _instance;
    protected MedicineStocks() {
        super();
    }
    public static MedicineStocks Instance() {
        if (_instance == null) {
            _instance = new MedicineStocks();
            for (Medicine m : Medicine.values()) { //初始庫存
                _instance.put(m, 100);
            }
        }
        return _instance;
    }
}
