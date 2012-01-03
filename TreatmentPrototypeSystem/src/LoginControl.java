import storage.staff.*;


public class LoginControl {
    private StaffStorage staffs;
    
    public void setStorage(StaffStorage staffs) {
        this.staffs = staffs;
    }
    
    /**
     * 主要的Control功能都在這裡啦！
     * 其實這個control根本沒差= =  不曉得為何書上這樣寫
     * 不曉得讓login view直接摸DataStorage好不好
     */
    public Staff login (String id, String password) {
        if ( !staffs.validate(id, password) )
            return null;
        else 
            return staffs.get(id);
    }
}
