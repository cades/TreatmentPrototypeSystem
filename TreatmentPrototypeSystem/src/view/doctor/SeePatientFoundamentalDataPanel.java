package view.doctor;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import storage.patient.PatientStorage;


public class SeePatientFoundamentalDataPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton submit = null;
    
    /**
     * This is the default constructor
     */
    public SeePatientFoundamentalDataPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        jLabel = new JLabel();
        jLabel.setText("病人ID");
        this.setSize(300, 200);
        this.setLayout(new BorderLayout());
        this.add(jLabel, BorderLayout.WEST);
        this.add(getId(), BorderLayout.CENTER);
        this.add(getSubmit(), BorderLayout.EAST);
    }

    /**
     * This method initializes id   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getId() {
        if (id == null) {
            id = new JTextField();
        }
        return id;
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
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        JOptionPane.showMessageDialog(null, "找到：" + patients.get(id.getText()).id());
                    }
                }
            });
        }
        return submit;
    }

}
