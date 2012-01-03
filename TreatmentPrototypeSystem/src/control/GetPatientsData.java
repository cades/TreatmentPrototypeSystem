package control;

import storage.staff.*;
import storage.patient.*;

public class GetPatientsData {
    StaffStorage staffs;
    

    public void setEntity(StaffStorage staffs) { this.staffs = staffs; }
    // 回傳值當然不能是void，先檔一下
    // 新議題：如何讓醫生跟櫃檯看到不一樣的東西？（權限）
    public void getData(Staff aStaff, String patientId) {
        
    }
}
