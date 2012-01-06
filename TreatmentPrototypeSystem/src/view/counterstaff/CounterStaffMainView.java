package view.counterstaff;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import storage.staff.Staff;
import java.awt.Dimension;

public class CounterStaffMainView extends JFrame {
    private Staff me;
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private CounterStaffMainTabbedPane counterStaffMainTabbedPane = null;

    /**
     * This is the default constructor
     */
    public CounterStaffMainView(Staff aStaff) {
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
        this.setSize(367, 251);
        this.setContentPane(getJContentPane());
        this.setTitle("櫃檯人員主畫面");
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
            jContentPane.add(getCounterStaffMainTabbedPane(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes counterStaffMainTabbedPane	
     * 	
     * @return view.counterstaff.CounterStaffMainTabbedPane
     */
    private CounterStaffMainTabbedPane getCounterStaffMainTabbedPane() {
        if (counterStaffMainTabbedPane == null) {
            counterStaffMainTabbedPane = new CounterStaffMainTabbedPane();
        }
        return counterStaffMainTabbedPane;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
