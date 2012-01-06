package view.doctor;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;

import storage.staff.Staff;
import java.awt.Dimension;

import list.DiagnosisList;


public class DoctorMainView extends JFrame {

    Staff me;
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private DoctorMainTabbedPane doctorMainTabbedPane = null;

    /**
     * This is the default constructor
     */
    public DoctorMainView(Staff aStaff) {
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
        this.setSize(521, 208);
        this.setContentPane(getJContentPane());
        this.setTitle("醫生主畫面");
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
            jContentPane.add(getDoctorMainTabbedPane(), BorderLayout.CENTER);
        }
        return jContentPane;
    }
    
    private DoctorMainTabbedPane getDoctorMainTabbedPane() {
        if (doctorMainTabbedPane == null) {
            doctorMainTabbedPane = new DoctorMainTabbedPane();
        }
        return doctorMainTabbedPane;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
