package view.patrolnurse;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

import control.LoginoutControl;

import storage.staff.Staff;
import storage.ward.Sickbed;

public class PatrolNurseMainView extends JFrame {
    private Staff me;
    private Timer timer = new Timer();
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;

    /**
     * This is the default constructor
     */
    public PatrolNurseMainView(Staff aStaff) {
        super();
        me = aStaff;
        me.setMainFrame(this);
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("巡診護士主畫面");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("" + me.name() + me.occupation() + "登出");
                new LoginoutControl().logout(me);
            }
        });
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
        }
        return jContentPane;
    }

    public Timer timer() { return timer; }
}
