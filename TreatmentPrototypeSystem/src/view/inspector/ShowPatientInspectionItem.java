package view.inspector;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import storage.patient.PatientStorage;

public class ShowPatientInspectionItem extends JPanel  {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextArea resultTextArea = null;
    private JTextField patientName = null;
    private JButton query = null;

    /**
     * This is the default constructor
     */
    public ShowPatientInspectionItem() {
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
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridx = 1;
        gridBagConstraints3.gridy = 1;
        jLabel = new JLabel();
        resultTextArea = new JTextArea(100,20);
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setVisible(false);
        resultTextArea.setSize(300, 200);
        jLabel.setText("病人ID");
        this.setSize(390, 311);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getPatientName(), gridBagConstraints1);
        this.add(getQuery(), gridBagConstraints2);
        this.add(resultTextArea, gridBagConstraints3);
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
            query.setText("看此病人檢查項目");
            /* by 丁丁 
        	 * 學習view.doctor.SeePatientFoundamentalDataPanel.java的寫法
        	 */
            query.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(patientName.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                        resultTextArea.setText("");
                    } else {
                    	resultTextArea.setText(patientName.getText() + "：\n<檢查項目>");
                    	resultTextArea.setVisible(true);
                        
                        
                    }
                }
            });
            /* by 丁丁 
        	 * 學習view.doctor.SeePatientFoundamentalDataPanel.java的寫法
        	 */
        }
        return query;
    }
}
