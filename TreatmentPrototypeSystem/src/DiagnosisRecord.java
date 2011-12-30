
public class DiagnosisRecord {
    private String name;
    private int number;
    
    public DiagnosisRecord(String newName, int newNumber) {
        name = newName;
        number = newNumber;
    }
    
    public String name() { return name; }
    
    public int number() { return number; }
}
