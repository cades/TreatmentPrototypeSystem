package view.doctor;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;

import storage.staff.Staff;
import view.LoginFrame;
import java.awt.Dimension;

import list.DiagnosisList;


public class DoctorMainView extends JFrame {

    LoginFrame loginFrame;
    public LoginFrame loginFrame() {return loginFrame; }
    Staff me;
    DiagnosisList diagnosisList;
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private DoctorMainTabbedPane doctorMainTabbedPane = null;

    /**
     * This is the default constructor
     */
    public DoctorMainView(LoginFrame f) {
        super();
        loginFrame = f;   // 自定的變數必須在initialize()前設定好！！
        diagnosisList = new DiagnosisList();
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
        this.setVisible(true);
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
            doctorMainTabbedPane.setParent(this);
        }
        return doctorMainTabbedPane;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
