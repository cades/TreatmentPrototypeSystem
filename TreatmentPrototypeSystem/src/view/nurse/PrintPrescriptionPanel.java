package view.nurse;

import java.awt.GridBagLayout;

import javax.swing.*;
import java.awt.GridBagConstraints;

import storage.patient.PatientStorage;

import java.awt.Dimension;

public class PrintPrescriptionPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField patientName = null;
    private JButton query = null;

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
        this.setSize(365, 311);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getPatientName(), gridBagConstraints1);
        this.add(getQuery(), gridBagConstraints2);
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
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(patientName.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        JOptionPane.showMessageDialog(null, "是否已繳費：\n收費者：\n是否領藥：\n開藥人：\n日期：\n內容：\n");
                        
                    }
                }
            });
            /* by 丁丁 
        	 * 學習view.doctor.SeePatientFoundamentalDataPanel.java的寫法
        	 */
        }
        return query;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
