package view.pharmacist;

import java.awt.GridBagLayout;

import javax.swing.*;
import java.awt.GridBagConstraints;

import storage.medicine.Medicine;
import storage.medicine.MedicineStocks;
import storage.patient.PatientStorage;
import storage.prescription.Prescription;
import storage.prescription.PrescriptionStorage;

import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PrintPrescriptionPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton query = null;
    private JTextArea prescriptionTextArea = null;
    private JButton submit = null;
    private JLabel jLabel1 = null;
    
    private Prescription aPres = null;

    /**
     * This is the default constructor
     */
    public PrintPrescriptionPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
        gridBagConstraints17.gridx = 2;
        gridBagConstraints17.gridy = 3;
        jLabel1 = new JLabel();
        jLabel1.setText("注意，開藥就會扣庫存喔！");
        GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
        gridBagConstraints15.gridx = 2;
        gridBagConstraints15.gridy = 2;
        GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
        gridBagConstraints14.fill = GridBagConstraints.BOTH;
        gridBagConstraints14.gridy = 2;
        gridBagConstraints14.weightx = 1.0;
        gridBagConstraints14.weighty = 1.0;
        gridBagConstraints14.gridx = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 2;
        gridBagConstraints2.gridy = 0;
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
        this.setSize(553, 249);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getId(), gridBagConstraints1);
        this.add(getQuery(), gridBagConstraints2);
        this.add(getPrescriptionTextArea(), gridBagConstraints14);
        this.add(getSubmit(), gridBagConstraints15);
        this.add(jLabel1, gridBagConstraints17);
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
     * This method initializes query	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getQuery() {
        if (query == null) {
            query = new JButton();
            query.setText("查詢藥單");
            /* by 丁丁 
        	 * 學習view.doctor.SeePatientFoundamentalDataPanel.java的寫法
        	 */
            query.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    aPres = null;
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        Iterator<Prescription> iter = PrescriptionStorage.Instance().iterator();
                        Prescription pres = null;
                        while (iter.hasNext()) {
                            pres = (Prescription)iter.next();
                            if (pres.isMedicineReceived()) continue;
                            if (pres.patientId().equals(id.getText())) {
                                //JOptionPane.showMessageDialog(null,
                                prescriptionTextArea.setText(
                                        "是否已繳費：" + pres.isMoneyPaid() +  "\n" +
                                        "收費者：" + pres.counterStaffInChargeId() + "\n" +
                                        "是否領藥：" + pres.isMedicineReceived() + "\n" +
                                        "開藥人：" + pres.doctorInChargeId() + "\n" +
                                        "日期：" + pres.time() + "\n" +
                                        "內容：\n\n" + Prescription.medicinesToString(pres.medicines()) + "\n");
                                aPres = pres;
                            }
                        }
                    }
                }
            });
            /* by 丁丁 
        	 * 學習view.doctor.SeePatientFoundamentalDataPanel.java的寫法
        	 */
        }
        return query;
    }

    /**
     * This method initializes prescriptionTextArea	
     * 	
     * @return javax.swing.JTextArea	
     */
    private JTextArea getPrescriptionTextArea() {
        if (prescriptionTextArea == null) {
            prescriptionTextArea = new JTextArea();
        }
        return prescriptionTextArea;
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("開藥");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (aPres == null) {
                        JOptionPane.showMessageDialog(null,"沒有藥單喔！");
                        return;
                    }
                    // 扣庫存
                    for (Medicine m : Medicine.values()) {
                        if (aPres.medicines().get(m) != null) {
                            MedicineStocks.Instance().put(  // 再put一次就是更新
                                    m,
                                    new Integer ( MedicineStocks.Instance().get(m).intValue()
                                            - aPres.medicines().get(m).intValue() ) );
                        }
                    }
                    // 改成已繳費
                    aPres.giveMedicinesToPatient();
                    // 清面板
                    prescriptionTextArea.setText("");
                    // 顯示成功開藥訊息
                    JOptionPane.showMessageDialog(null,"成功開藥囉！");
                    // 清指標
                    aPres = null;
                }
            });
        }
        return submit;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
