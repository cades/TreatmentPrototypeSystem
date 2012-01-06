package storage.staff;
// TODO: 將來五職業要繼承它吧
public class Staff {
    
    protected String name;
    protected String email;
    protected Occupation occupation;
    protected String id;
    protected String password;
    
    public Staff(String name, String email, Occupation occupation, String id, String password) {
        this.name = name;
        this.email = email;
        this.occupation = occupation;
        this.id = id;
        this.password = password;
    }
    
    public String name() { return name; }
    public String email() { return email; }
    public Occupation occupation() { return occupation; }
    public String id() { return id; }
    public String password() { return password; }
}
