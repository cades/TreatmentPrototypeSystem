package view.nurse;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import control.LoginoutControl;

import storage.staff.Staff;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NurseMainView extends JFrame {
    Staff me;
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;

    private NurseMainTabbedPane nurseMainTabbedPane = null;

    /**
     * This is the default constructor
     */
    public NurseMainView(Staff aStaff) {
        super();
        me = aStaff;
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(408, 307);
        this.setContentPane(getJContentPane());
        this.setTitle("護士主畫面");
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
            jContentPane.add(getNurseMainTabbedPane(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    private NurseMainTabbedPane getNurseMainTabbedPane() {
        if (nurseMainTabbedPane == null) {
            nurseMainTabbedPane = new NurseMainTabbedPane();
        }
        return nurseMainTabbedPane;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
