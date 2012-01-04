package view.doctor;




import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SeePatientFoundamentalDataView extends JFrame {
    DoctorMainView parentFrame;
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jLabel = null;
    private JTextField jTextField = null;
    private JButton submit = null;

    /**
     * This is the default constructor
     */
    public SeePatientFoundamentalDataView(DoctorMainView p) {
        super();
        parentFrame = p;
        initialize();
        this.setVisible(true);
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("查看病人資料");
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel = new JLabel();
            jLabel.setText("病人ID");
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(jLabel, BorderLayout.WEST);
            jContentPane.add(getJTextField(), BorderLayout.CENTER);
            jContentPane.add(getSubmit(), BorderLayout.EAST);
        }
        return jContentPane;
    }

    /**
     * This method initializes jTextField	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getJTextField() {
        if (jTextField == null) {
            jTextField = new JTextField();
        }
        return jTextField;
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("查詢");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    query();
                }
            });
        }
        return submit;
    }

    private void query() {
        System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
        System.out.println(jTextField.getText());
        System.out.println(parentFrame.loginFrame.patients().get(jTextField.getText()).toString());
        parentFrame.setVisible(true);
        this.dispose();
    }
}
