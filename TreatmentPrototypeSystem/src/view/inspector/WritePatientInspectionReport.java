package view.inspector;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import storage.Hospital;
import storage.InspectionPlace;
import storage.inspectionreport.InspectionDivision;
import storage.inspectionreport.InspectionReport;
import storage.inspectionreport.InspectionReportStorage;
import storage.patient.PatientStorage;
import storage.staff.Doctor;
import storage.staff.DoctorStorage;

import javax.swing.JComboBox;

public class WritePatientInspectionReport extends JPanel   {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextArea resultTextArea = null;
    private JTextField patientName = null;
    private JButton query = null;
    private JButton submit = null;
    private JLabel jLabel1 = null;
    private JComboBox division = null;

    /**
     * This is the default constructor
     */
    public WritePatientInspectionReport() {
        super();
        initialize();
    }
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
        gridBagConstraints21.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints21.gridy = 1;
        gridBagConstraints21.weightx = 1.0;
        gridBagConstraints21.gridx = 2;
        GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
        gridBagConstraints11.gridx = 0;
        gridBagConstraints11.gridy = 1;
        jLabel1 = new JLabel();
        jLabel1.setText("在此寫報告");
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
        //gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.gridy = 1;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.gridx = 2;
        gridBagConstraints4.gridy = 2;
        gridBagConstraints3.gridx = 1;
        //gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.gridy = 2;
        jLabel = new JLabel();
        resultTextArea = new JTextArea();
        resultTextArea.setVisible(false);
        jLabel.setText("病人ID");
        this.setSize(390, 311);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getPatientName(), gridBagConstraints1);
        this.add(getQuery(), gridBagConstraints2);
        this.add(resultTextArea, gridBagConstraints3);
        this.add(getSubmit(), gridBagConstraints4);
        this.add(jLabel1, gridBagConstraints11);
        this.add(getDivision(), gridBagConstraints21);
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
            query.setText("查詢病人");

            query.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(patientName.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                        resultTextArea.setText("");
                        resultTextArea.setVisible(false);
                    } else {
                    	resultTextArea.setText(patientName.getText() + "：\n<檢查報告>");
                    	resultTextArea.setVisible(true);
                        
                        
                    }
                }
            });

        }
        return query;
    }
    
    private JButton getSubmit() {
        if (submit == null) {
        	submit = new JButton();
        	submit.setText("送出報告");
        	submit.addActionListener(new java.awt.event.ActionListener() {
        	    public void actionPerformed(java.awt.event.ActionEvent e) {
        	        // 新增一筆InpectionReport, 加入InpectionReportStorage
        	        InspectionReportStorage.Instance().add(
        	                new InspectionReport(
        	                        "",    // 這個檢員的id，先不做
        	                        patientName.getText(), // 病人id
        	                        (InspectionDivision) division.getSelectedItem(),    // 檢查科別
        	                        null,  // 時間，先不做
        	                        resultTextArea.getText()
        	                        ));
        	        JOptionPane.showMessageDialog(null, "報告已經送出囉！");
        	    }
        	});
        }
        
        return submit;
    }
    /**
     * This method initializes division	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getDivision() {
        if (division == null) {
            division = new JComboBox();
            for (InspectionDivision d : InspectionDivision.values()) {
                division.addItem(d);
            }
        }
        return division;
    }
}
