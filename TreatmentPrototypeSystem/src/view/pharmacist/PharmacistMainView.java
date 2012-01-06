package view.pharmacist;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import storage.staff.Staff;

public class PharmacistMainView extends JFrame {
    Staff me;

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private PharmacistMainTabbedPane pharmacistMainTabbedPane = null;

    /**
     * This is the default constructor
     */
    public PharmacistMainView(Staff aStaff) {
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
        this.setSize(300, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("藥劑師主畫面");
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
            jContentPane.add(getPharmacistMainTabbedPane(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes pharmacistMainTabbedPane	
     * 	
     * @return javax.swing.JTabbedPane	
     */
    private PharmacistMainTabbedPane getPharmacistMainTabbedPane() {
        if (pharmacistMainTabbedPane == null) {
            pharmacistMainTabbedPane = new PharmacistMainTabbedPane();
        }
        return pharmacistMainTabbedPane;
    }

}
