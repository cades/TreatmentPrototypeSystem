package view.patrolnurse;

import java.util.TimerTask;

import javax.swing.JOptionPane;

import storage.ward.Sickbed;

public class Patrol extends TimerTask {
    Sickbed bed;
    public Patrol(Sickbed bed) {
        this.bed = bed;
    }
    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "記得去巡視" + bed.number() + "床喔！");
    }

}
