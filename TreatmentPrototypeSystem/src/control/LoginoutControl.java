package control;

import javax.swing.JOptionPane;

import storage.staff.*;
import view.counterstaff.CounterStaffMainView;
import view.doctor.DoctorMainView;
import view.inspector.InspectorMainView;
import view.nurse.NurseMainView;
import view.patrolnurse.PatrolNurseMainView;
import view.pharmacist.PharmacistMainView;


public class LoginoutControl {
    private StaffStorage staffs = StaffStorage.Instance();
    
    public void setStorage(StaffStorage staffs) {
        this.staffs = staffs;
    }
    
    /**
     * 主要的Control功能都在這裡啦！
     * 其實這個control根本沒差= =  不曉得為何書上這樣寫
     * 不曉得讓login view直接摸DataStorage好不好
     */
    public void login (String id, String password) {
        util.Utility.DEBUG(0, "test");
        if (staffs.containsKey(id)) {
            // 有這個人
            if ( staffs.get(id).password().equals(password)) {
                // 密碼正確。開始登入
                Staff aStaff = staffs.get(id);
                
                switch( aStaff.occupation() ) {
                case doctor:
                    util.Utility.DEBUG(0, "" + aStaff.name() + "醫生登入, 加入DoctorStorage中");
                    DoctorStorage.Instance().put(id, new Doctor(aStaff.name(), aStaff.email(), aStaff.occupation(), aStaff.id(), aStaff.password()));
                    new DoctorMainView(aStaff).setVisible(true);
                    break;
                case nurse:
                    new NurseMainView(aStaff).setVisible(true);
                    break;
                case counterStaff:
                    new CounterStaffMainView(aStaff).setVisible(true);
                    break;
                case inspector:
                    util.Utility.DEBUG(0, "" + aStaff.name() + "檢查員登入, 加入InspectorsStorage中");
                    InspectorStorage.Instance().put(id, new Inspector(aStaff.name(), aStaff.email(), aStaff.occupation(), aStaff.id(), aStaff.password()));
                    new InspectorMainView(aStaff).setVisible(true);
                    break;
                case pharmacist:
                    new PharmacistMainView(aStaff).setVisible(true); 
                    break;
                case patrolNurse:
                    util.Utility.DEBUG(0, "" + aStaff.name() + "巡診護士登入, 加入PatrolNurseStorage中");
                    new PatrolNurseMainView(aStaff).setVisible(true);
                    PatrolNurseStorage.Instance().put(id, new PatrolNurse(aStaff.name(), aStaff.email(), aStaff.occupation(), aStaff.id(), aStaff.password()));
                    break;
                default:
                    System.out.println("未知的職業 ？！結束程式...");
                    System.exit(1);
                }
                
                JOptionPane.showMessageDialog(null, "歡迎登入，" + aStaff.name() + aStaff.occupation() + "。");
            } else {
                // 有這個人但密碼打錯了
                JOptionPane.showMessageDialog(null, "密碼錯誤:'<");
            }
        } else {
            // 查無此人
            JOptionPane.showMessageDialog(null, "抱歉，這個id沒有註冊過喔^^\"");
        }
    }
    
    public void logout(Staff aStaff) {
        util.Utility.DEBUG(0, "" + aStaff.name() + aStaff.occupation() + "正在登出...");
        switch( aStaff.occupation() ) {
        case doctor:
            util.Utility.DEBUG(0, "" + aStaff.name() + "醫生登出, 移出DoctorStorage");
            DoctorStorage.Instance().remove(aStaff.id());
            break;
        case nurse:
            break;
        case counterStaff:
            break;
        case inspector:
            util.Utility.DEBUG(0, "" + aStaff.name() + "檢查員登出, 移出InspectorsStorage");
            InspectorStorage.Instance().remove(aStaff.id());
            break;
        case pharmacist:
            break;
        default:
            System.out.println("未知的職業 ？！結束程式...");
            System.exit(1);
        }
    }
}
