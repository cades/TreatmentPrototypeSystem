package view.counterstaff;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import list.DiagnosisRecord;

import storage.patient.Patient;
import storage.patient.PatientStorage;
import storage.staff.Doctor;
import storage.staff.DoctorStorage;



public class RegisterPanel extends JPanel {

    private static final long serialVersionUID = 1L;
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
    public RegisterPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
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
        this.add(jLabel, gridBagConstraints);
        this.add(jLabel2, gridBagConstraints10);
        this.add(getDoctorComboBox(), gridBagConstraints11); // 手動調過位置，因為要先初始化醫生，才能初始化科別。
        this.add(jLabel1, gridBagConstraints5);
        this.add(getDepartmentComboBox(), gridBagConstraints9);
        this.add(getSubmit(), gridBagConstraints12);
        this.add(getPatientId(), gridBagConstraints13);
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
                    updateDoctorComboBox();
                }
            });
            departmentComboBox.addItem("內科"); // TODO: 用for loop加入科別，防止不同步
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
                    Patient p;
                    if (patientId.getText().equals("") ||
                            departmentComboBox.getSelectedItem() == null ||
                            doctorComboBox.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "不能有欄位空白喔！請再檢查一次:)");
                    } else if((p = PatientStorage.Instance().get(patientId.getText())) == null) {
                        JOptionPane.showMessageDialog(null, "找不到這個病人耶！你確定ID是對的嗎？");
                    } else {
                        Collection<Doctor> c = DoctorStorage.Instance().values();
                        Iterator<Doctor> iter = c.iterator();
                        Doctor d = null;
                        // 用名字找醫生
                        while(iter.hasNext()) {
                            d = iter.next();
                            if(d.name().equals(doctorComboBox.getSelectedItem())) {
                                //掛號：把病人加到他的看診列表
                                d.diagnosisList().add(new DiagnosisRecord(p));
                                // TODO: 如果醫生正在納涼，要通知他有病人上門了
                                JOptionPane.showMessageDialog(null, "成功加入看診列表！YA!");
                                return;
                            } // TODO: 有潛在的bug. 如果有兩個同名醫生怎辦？
                        }
                        JOptionPane.showMessageDialog(null, "Sorry, 這個醫生現在沒有上班喔！");
                        
                        if(d == null) JOptionPane.showMessageDialog(null, "其實，這家醫院...\n沒 有 醫 生 上 班");
                        // TODO: 可以去StaffStorage找是不是有這個人
                        //JOptionPane.showMessageDialog(null, "找不到"+ doctorComboBox.getSelectedItem() + "醫生耶!他應該不在這裡上班吧？");
                    }
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
        if (aDepart.equals("內科")) { // TODO: 這裡藥做到自動化恐怕是很以後的事了  就先將吧
            doctorComboBox.addItem("Dr. 古蕾娃");
            doctorComboBox.addItem("黑傑克");
        } else if  (aDepart.equals("外科")) {
            doctorComboBox.addItem("Dr. 西爾爾克");
        } else if  (aDepart.equals("小兒科")) {
            doctorComboBox.addItem("喬巴");
            doctorComboBox.addItem("Dr. 古蕾娃");
        } else {}
    }
}
