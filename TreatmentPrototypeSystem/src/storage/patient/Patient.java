package storage.patient;

public class Patient {
    String name;
    int age;
    String sex;
    String id;
    
    public Patient(String name, int age, String sex, String id) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id = id;
    }
    
    public String name() {return name;}
}
