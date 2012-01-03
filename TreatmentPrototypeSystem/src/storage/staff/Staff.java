package storage.staff;

public class Staff {
    
    String name;
    String email;
    Occupation occupation;
    String id;
    String password;
    
    public Staff(String name, String email, Occupation occupation, String id, String password) {
        this.name = name;
        this.email = email;
        this.occupation = occupation;
        this.id = id;
        this.password = password;
    }
    
    public String name() { return name; }
    public String password() { return password; }
    public Occupation occupation() { return occupation; }
}