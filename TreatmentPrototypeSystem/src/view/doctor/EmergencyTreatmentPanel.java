package view.doctor;

import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTextField;

import storage.patient.Patient;
import storage.patient.PatientStorage;

public class EmergencyTreatmentPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel2 = null;
    private JLabel jLabel3 = null;
    private JButton submit = null;
    private JTextField patientName = null;
    private JTextField age = null;
    private JTextField sex = null;
    private JTextField id = null;
    private JLabel jLabel4 = null;

    /**
     * This is the default constructor
     */
    public EmergencyTreatmentPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
        gridBagConstraints22.gridx = 1;
        gridBagConstraints22.gridy = 0;
        jLabel4 = new JLabel();
        jLabel4.setText("醫生請詢問病人並填寫");
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
        gridBagConstraints6.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints6.gridy = 4;
        gridBagConstraints6.weightx = 1.0;
        gridBagConstraints6.gridx = 1;
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
        gridBagConstraints5.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints5.gridy = 3;
        gridBagConstraints5.weightx = 1.0;
        gridBagConstraints5.gridx = 1;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints4.gridy = 2;
        gridBagConstraints4.weightx = 1.0;
        gridBagConstraints4.gridx = 1;
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints3.gridy = 1;
        gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.gridx = 1;
        GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
        gridBagConstraints21.gridx = 1;
        gridBagConstraints21.gridy = 5;
        GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
        gridBagConstraints11.gridx = 0;
        gridBagConstraints11.gridy = 4;
        jLabel3 = new JLabel();
        jLabel3.setText("ID");
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 3;
        jLabel2 = new JLabel();
        jLabel2.setText("性別");
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 2;
        jLabel1 = new JLabel();
        jLabel1.setText("年齡");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jLabel = new JLabel();
        jLabel.setText("姓名");
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(jLabel1, gridBagConstraints1);
        this.add(jLabel2, gridBagConstraints2);
        this.add(jLabel3, gridBagConstraints11);
        this.add(getSubmit(), gridBagConstraints21);
        this.add(getPatientName(), gridBagConstraints3);
        this.add(getAge(), gridBagConstraints4);
        this.add(getSex(), gridBagConstraints5);
        this.add(getId(), gridBagConstraints6);
        this.add(jLabel4, gridBagConstraints22);
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("急診完畢");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patientName.getText().equals("") ||
                            age.getText().equals("") ||
                            sex.getText().equals("") ||
                            id.getText().equals("")
                            ) {
                        JOptionPane.showMessageDialog(null, "有欄位還沒填喔！");
                    } else {
                        patients.put(id.getText(),
                                new Patient(
                                        patientName.getText(),
                                        Integer.parseInt( age.getText() ),
                                        sex.getText(),
                                        id.getText()));
                        JOptionPane.showMessageDialog(null, "成功新增一筆資料囉:)");
                    }
                }
            });
        }
        return submit;
    }

    /**
     * This method initializes patientName	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getPatientName() {
        if (patientName == null) {
            patientName = new JTextField();
            patientName.setColumns(10);
        }
        return patientName;
    }

    /**
     * This method initializes age	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getAge() {
        if (age == null) {
            age = new JTextField();
            age.setColumns(10);
        }
        return age;
    }

    /**
     * This method initializes sex	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getSex() {
        if (sex == null) {
            sex = new JTextField();
            sex.setColumns(10);
        }
        return sex;
    }

    /**
     * This method initializes id	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getId() {
        if (id == null) {
            id = new JTextField();
            id.setColumns(10);
        }
        return id;
    }

}
