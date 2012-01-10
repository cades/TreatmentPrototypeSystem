package storage.staff;

import storage.ward.Sickbed;
import util.DingTimer;
import view.patrolnurse.Patrol;
import view.patrolnurse.PatrolNurseMainView;

public class PatrolNurse extends Staff {
    DingTimer dt;
    
    public PatrolNurse(String name, String email, Occupation occupation,
            String id, String password) {
        super(name, email, occupation, id, password);
        // TODO Auto-generated constructor stub
    }
    
    public PatrolNurse(Staff aStaff) {
        super(aStaff.name(), aStaff.email(), aStaff.occupation(), aStaff.id(), aStaff.password());
        // TODO Auto-generated constructor stub
    }
    
    public void startLoop(Sickbed bed) { // 如果有兩個病人住院，第一個的Timer指標會弄丟，就再也無法cancle了QQ
        dt = new DingTimer(name + "護士", 5000 , "請去巡視" + bed.number() + "號床喔！");
    }
    
    public void stopLoop() {
        dt.cancel();
    }
}
