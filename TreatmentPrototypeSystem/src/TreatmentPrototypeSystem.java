import storage.staff.Occupation;
import storage.staff.Staff;
import storage.staff.StaffStorage;


public class TreatmentPrototypeSystem {
    static StaffStorage staffs = new StaffStorage();
    
    private static void createAndShowGUI() {
        staffs.put("tonytony", new Staff("喬巴", "endless-dreaming@hotmail.com",
                Occupation.doctor, "tonytony", "0000") );
        staffs.put("zoro", new Staff("索隆", "endless-dreaming@hotmail.com",
                Occupation.counterStaff, "zoro", "0000") );
        staffs.put("nami", new Staff("娜美", "endless-dreaming@hotmail.com",
                Occupation.nurse, "nami", "0000") );
        staffs.put("franky", new Staff("佛朗基", "endless-dreaming@hotmail.com",
                Occupation.inspector, "franky", "0000") );
        staffs.put("robin", new Staff("羅賓", "endless-dreaming@hotmail.com",
                Occupation.pharmacist, "robin", "0000") );
        
        new LoginFrame(staffs);
    }
    
    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
