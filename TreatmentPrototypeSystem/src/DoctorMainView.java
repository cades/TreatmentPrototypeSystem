import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import storage.staff.Staff;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class DoctorMainView extends JFrame {

    LoginFrame loginFrame;
    Staff me;
    DiagnosisList diagnosisList;
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JButton logoutButton = null;
    private JButton seePatientFoundamentalDataButton = null;
    private JButton seeCaseHistoryButton = null;
    private JButton writePrescriptionButton = null;
    private JButton hospitalizeButton = null;

    /**
     * This is the default constructor
     */
    public DoctorMainView(LoginFrame loginFrame) {
        super();
        initialize();
        this.loginFrame = loginFrame;
        diagnosisList = new DiagnosisList();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
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
            jContentPane.setLayout(new FlowLayout());
            jContentPane.add(getSeePatientFoundamentalDataButton(), null);
            jContentPane.add(getSeeCaseHistoryButton(), null);
            jContentPane.add(getWritePrescriptionButton(), null);
            jContentPane.add(getHospitalizeButton(), null);
            jContentPane.add(getLogoutButton(), null);
        }
        return jContentPane;
    }

    public void makePatientLiveInHospital(){
        new DEBUG(0, "[醫生] 決定病人要住院");
    }
    public void editMedicalRecord(){
        
        new DEBUG(0, "[醫生] 查看病歷");
    }
    public void showPetientInformation(){
        // 屬增刪修查，不新增controller
        // 噢，又要開個JFrame:<
        new SeePatientFoundamentalDataView(this);
        this.setVisible(false);
        new DEBUG(0, "[醫生] 查看基本資料");
    }
    public void showDrugStocks(){
        new DEBUG(0, "[醫生] 查看藥品庫存");
    }
    public void makePrescriptions(){
        new DEBUG(0, "[醫生] 開藥單");
    }

    /**
     * This method initializes logoutButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getLogoutButton() {
        if (logoutButton == null) {
            logoutButton = new JButton();
            logoutButton.setText("登出");
        }
        return logoutButton;
    }

    /**
     * This method initializes seePatientFoundamentalDataButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSeePatientFoundamentalDataButton() {
        if (seePatientFoundamentalDataButton == null) {
            seePatientFoundamentalDataButton = new JButton();
            seePatientFoundamentalDataButton.setText("查看病人基本資料");
            seePatientFoundamentalDataButton
                    .addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                            showPetientInformation();
                        }
                    });
        }
        return seePatientFoundamentalDataButton;
    }

    /**
     * This method initializes seeCaseHistoryButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSeeCaseHistoryButton() {
        if (seeCaseHistoryButton == null) {
            seeCaseHistoryButton = new JButton();
            seeCaseHistoryButton.setText("看病歷");
        }
        return seeCaseHistoryButton;
    }

    /**
     * This method initializes writePrescriptionButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getWritePrescriptionButton() {
        if (writePrescriptionButton == null) {
            writePrescriptionButton = new JButton();
            writePrescriptionButton.setText("寫藥單（處方）");
        }
        return writePrescriptionButton;
    }

    /**
     * This method initializes hospitalizeButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getHospitalizeButton() {
        if (hospitalizeButton == null) {
            hospitalizeButton = new JButton();
            hospitalizeButton.setText("讓病人住院");
        }
        return hospitalizeButton;
    }
}
