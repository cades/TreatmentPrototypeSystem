package storage.medicine;

// 這是一個和Medicine極度相關的類別
// 它只提供一個靜態函數，作為藥的價格對應
public class Price {
    
    public static int get(Medicine medicine) {
        switch(medicine) {
        case A:
            return 100;
        case B:
            return 200;
        case C:
            return 300;
        default:
            return 0;
        }
    }
}
