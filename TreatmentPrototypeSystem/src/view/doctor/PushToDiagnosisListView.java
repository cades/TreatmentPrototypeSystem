package view.doctor;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import view.counterstaff.CounterStaff;

public class PushToDiagnosisListView extends JFrame {
    CounterStaff parentFrame;

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JComboBox departmentComboBox = null;
    private JLabel jLabel2 = null;
    private JComboBox doctorComboBox = null;
    private JButton submit = null;

    private JTextField patientId = null;

    /**
     * This is the default constructor
     */
    public PushToDiagnosisListView(CounterStaff frame) {
        super();
        initialize();
        parentFrame = frame;
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
        this.setTitle("排進看診列表");
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
            gridBagConstraints13.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints13.gridy = 0;
            gridBagConstraints13.weightx = 1.0;
            gridBagConstraints13.gridx = 1;
            GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
            gridBagConstraints12.gridx = 1;
            gridBagConstraints12.gridy = 3;
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
            gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints11.gridy = 2;
            gridBagConstraints11.weightx = 1.0;
            gridBagConstraints11.gridx = 1;
            GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
            gridBagConstraints10.gridx = 0;
            gridBagConstraints10.gridy = 2;
            jLabel2 = new JLabel();
            jLabel2.setText("選醫生");
            GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
            gridBagConstraints9.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints9.gridy = 1;
            gridBagConstraints9.weightx = 1.0;
            gridBagConstraints9.gridx = 1;
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
            gridBagConstraints5.gridx = 0;
            gridBagConstraints5.gridy = 1;
            jLabel1 = new JLabel();
            jLabel1.setText("選科別");
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            jLabel = new JLabel();
            jLabel.setText("病人ID");
            jContentPane = new JPanel();
            jContentPane.setLayout(new GridBagLayout());
            jContentPane.add(jLabel, gridBagConstraints);
            jContentPane.add(jLabel2, gridBagConstraints10);
            jContentPane.add(getDoctorComboBox(), gridBagConstraints11); // 手動調過位置，因為要先初始化醫生，才能初始化科別。
            jContentPane.add(jLabel1, gridBagConstraints5);
            jContentPane.add(getDepartmentComboBox(), gridBagConstraints9);
            jContentPane.add(getSubmit(), gridBagConstraints12);
            jContentPane.add(getPatientId(), gridBagConstraints13);
        }
        return jContentPane;
    }

    /**
     * This method initializes departmentComboBox	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getDepartmentComboBox() {
        if (departmentComboBox == null) {
            departmentComboBox = new JComboBox();
            departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                    updateDoctorComboBox();
                }
            });
            departmentComboBox.addItem("內科");
            departmentComboBox.addItem("外科");
            departmentComboBox.addItem("內神經科");
            departmentComboBox.addItem("小兒科");
            departmentComboBox.addItem("婦產科");
            departmentComboBox.addItem("泌尿科");
            departmentComboBox.addItem("精神科");
        }
        return departmentComboBox;
    }

    /**
     * This method initializes doctorComboBox	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getDoctorComboBox() {
        if (doctorComboBox == null) {
            doctorComboBox = new JComboBox();
        }
        return doctorComboBox;
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("確定排進看診列表");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                    submit();
                }
            });
        }
        return submit;
    }
    
    /**
     * This method initializes patientId	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getPatientId() {
        if (patientId == null) {
            patientId = new JTextField();
            patientId.setColumns(10);
        }
        return patientId;
    }
    
    
    private void updateDoctorComboBox() {
        String aDepart = (String)departmentComboBox.getSelectedItem();
        doctorComboBox.removeAllItems();
        if (aDepart.equals("內科")) {
            doctorComboBox.addItem("Dr. 古蕾娃");
        } else if  (aDepart.equals("外科")) {
            doctorComboBox.addItem("Dr. 西爾爾克");
        } else if  (aDepart.equals("小兒科")) {
            doctorComboBox.addItem("Dr. 多尼多尼．喬巴");
            doctorComboBox.addItem("Dr. 古蕾娃");
        } else {}
    }
    
    private void submit() {
        if (!patientId.getText().equals("") &&
                departmentComboBox.getSelectedItem() != null &&
                doctorComboBox.getSelectedItem() != null) {
            System.out.println("假裝有掛號"); // TODO: 完成資料結構的插入
        } else {
            JOptionPane.showMessageDialog(null, "不能有欄位空白喔！請再檢查一次:)");
        }
    }
}
