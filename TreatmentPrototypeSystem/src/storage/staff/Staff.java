package storage.staff;

import javax.swing.JFrame;

// TODO: 將來五職業要繼承它吧
public class Staff {
    
    protected String name;
    protected String email;
    protected Occupation occupation;
    protected String id;
    protected String password;
    private boolean isLogin = false;
    protected JFrame mainFrameInUse = null;
    
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
    
    public void setMainFrame(JFrame jf) { mainFrameInUse = jf; }
    /**
     * 父類別要知道子類別很詳細的資料耶！這樣設計好嗎？
     * 不過外部只要呼叫login()就好，其餘的細節這裡就handle掉了
     */
//    public void login(JFrame jf) { 
//        isLogin = true;
//        mainFrameInUse = jf;
//        switch(occupation) {
//        case doctor:
//            util.Utility.DEBUG(0, "" + name + "醫生登入, 加入DoctorStorage中");
//            DoctorStorage.Instance().put(id, new Doctor(name, email, occupation, id, password));
//            break;
//        case inspector:
//            util.Utility.DEBUG(0, "" + name + "檢查員登入, 加入InspectorsStorage中");
//            InspectorStorage.Instance().put(id, new Inspector(name, email, occupation, id, password));
//        default:
//            break;
//        }
//    }
//    public void logout() {
//        isLogin = false;
//        mainFrameInUse = null;
//        switch(occupation) {
//        case doctor:
//            util.Utility.DEBUG(0, "" + name + "醫生登出, 移出DoctorStorage");
//            DoctorStorage.Instance().remove(id);
//            break;
//        case inspector:
//            util.Utility.DEBUG(0, "" + name + "檢查員登出, 移出InspectorsStorage");
//            InspectorStorage.Instance().remove(id);
//        default:
//            break;
//        }
//    }
//   public boolean isLogin() { return isLogin; }
//   public JFrame mainFrameInUse() { return mainFrameInUse; } 
}
