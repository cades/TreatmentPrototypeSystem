package view.doctor;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import storage.medicine.Medicine;
import storage.patient.PatientStorage;
import storage.prescription.Prescription;
import storage.prescription.PrescriptionStorage;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.util.HashMap;

public class WritePrescriptionPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JTextArea content = null;
    private JButton submit = null;
    private JLabel jLabel1 = null;
    private JButton query = null;
    private JComboBox medicineComboBox = null;
    private JTextField amount = null;
    private JLabel jLabel2 = null;
    private JLabel jLabel3 = null;
    private JButton addButton = null;
    
    private HashMap<Medicine, Integer> medicines = new HashMap<Medicine, Integer>();
    /**
     * This is the default constructor
     */
    public WritePrescriptionPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
        gridBagConstraints12.gridx = 3;
        gridBagConstraints12.gridy = 2;
        GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
        gridBagConstraints10.gridx = 0;
        gridBagConstraints10.gridy = 2;
        jLabel3 = new JLabel();
        jLabel3.setText("劑量");
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
        gridBagConstraints9.gridx = 0;
        gridBagConstraints9.gridy = 1;
        jLabel2 = new JLabel();
        jLabel2.setText("配藥");
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
        gridBagConstraints8.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints8.gridy = 2;
        gridBagConstraints8.weightx = 1.0;
        gridBagConstraints8.gridx = 1;
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
        gridBagConstraints7.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints7.gridy = 1;
        gridBagConstraints7.weightx = 1.0;
        gridBagConstraints7.gridx = 1;
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
        gridBagConstraints5.gridx = 3;
        gridBagConstraints5.gridy = 0;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.gridx = 0;
        gridBagConstraints4.gridy = 3;
        jLabel1 = new JLabel();
        jLabel1.setText("目前藥單內容");
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridx = 3;
        gridBagConstraints3.gridy = 3;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.fill = GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 3;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.weighty = 1.0;
        gridBagConstraints2.gridx = 1;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jLabel = new JLabel();
        jLabel.setText("病人ID");
        this.setSize(418, 224);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getId(), gridBagConstraints1);
        this.add(getContent(), gridBagConstraints2);
        this.add(getSubmit(), gridBagConstraints3);
        this.add(jLabel1, gridBagConstraints4);
        this.add(getQuery(), gridBagConstraints5);
        this.add(getMedicineComboBox(), gridBagConstraints7);
        this.add(getAmount(), gridBagConstraints8);
        this.add(jLabel2, gridBagConstraints9);
        this.add(jLabel3, gridBagConstraints10);
        this.add(getAddButton(), gridBagConstraints12);
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

    /**
     * This method initializes content  
     *  
     * @return javax.swing.JTextArea    
     */
    private JTextArea getContent() {
        if (content == null) {
            content = new JTextArea();
        }
        return content;
    }

    /**
     * This method initializes submit   
     *  
     * @return javax.swing.JButton  
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("確認送出");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        PrescriptionStorage.Instance().add(
                                new Prescription(
                                        id.getText(),
                                        null,
                                        new HashMap<Medicine, Integer>(medicines) // 新的一份
                                        ));
                        JOptionPane.showMessageDialog(null, "您寫好的藥單已經存進系統了！");
                        // 清空
                        medicines.clear();
                        content.setText("");
                    }
                }
            });
        }
        return submit;
    }

    /**
     * This method initializes query    
     *  
     * @return javax.swing.JButton  
     */
    private JButton getQuery() {
        if (query == null) {
            query = new JButton();
            query.setText("查詢");
            query.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        JOptionPane.showMessageDialog(null, "找到：" + patients.get(id.getText()).id());
                    }
                    // 無論是否找到，都清空藥品
                    medicines.clear();
                    content.setText("");
                }
            });
        }
        return query;
    }

    /**
     * This method initializes medicineComboBox	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getMedicineComboBox() {
        if (medicineComboBox == null) {
            medicineComboBox = new JComboBox();
            for (Medicine m : Medicine.values()) {
                medicineComboBox.addItem(m);
            }
        }
        return medicineComboBox;
    }

    /**
     * This method initializes amount	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getAmount() {
        if (amount == null) {
            amount = new JTextField();
            amount.setColumns(6);
        }
        return amount;
    }

    /**
     * This method initializes addButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getAddButton() {
        if (addButton == null) {
            addButton = new JButton();
            addButton.setText("加入藥單");
            addButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    // 確認欄位不是空的
                    if (medicineComboBox.getSelectedItem() == null ||
                            amount.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        // 加入藥品
                        medicines.put(
                                (Medicine) medicineComboBox.getSelectedItem(), 
                                Integer.parseInt(amount.getText()) );
                        // 更新文字框畫面
                        content.setText(Prescription.medicinesToString(medicines));
                    }
                }
            });
        }
        return addButton;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"