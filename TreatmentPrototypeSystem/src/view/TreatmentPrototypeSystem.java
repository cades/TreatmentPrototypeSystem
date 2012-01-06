package view;

import storage.staff.Occupation;
import storage.staff.Staff;
import storage.staff.StaffStorage;
import storage.patient.*;

public class TreatmentPrototypeSystem {
    static StaffStorage staffs = StaffStorage.Instance(); 
    
    public static void main(String[] args) {
        initData();
        
        // 開始冒險囉！！
        new LoginFrame();
        
    }
    
    private static void initData() {
        // 員工班底
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
        
        // 病人班底
        PatientStorage.Instance().put("lufy", new Patient("魯夫", 21, "male", "lufy"));
        PatientStorage.Instance().put("brook", new Patient("布魯克", 50, "male", "brook"));
        
    }
}

//public class TreatmentPrototypeSystem {
//    static StaffStorage staffs = new StaffStorage();
//    
//    public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//    
//    private static void createAndShowGUI() {
//        staffs.put("tonytony", new Staff("喬巴", "endless-dreaming@hotmail.com",
//                Occupation.doctor, "tonytony", "0000") );
//        staffs.put("zoro", new Staff("索隆", "endless-dreaming@hotmail.com",
//                Occupation.counterStaff, "zoro", "0000") );
//        staffs.put("nami", new Staff("娜美", "endless-dreaming@hotmail.com",
//                Occupation.nurse, "nami", "0000") );
//        staffs.put("franky", new Staff("佛朗基", "endless-dreaming@hotmail.com",
//                Occupation.inspector, "franky", "0000") );
//        staffs.put("robin", new Staff("羅賓", "endless-dreaming@hotmail.com",
//                Occupation.pharmacist, "robin", "0000") );
//        
//        new LoginFrame(staffs);
//    }
//}