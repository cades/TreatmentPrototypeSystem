package view.inspector;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Iterator;

import javax.swing.*;

import storage.Hospital;
import storage.InspectionPlace;
import storage.inspectionreport.InspectionDivision;
import storage.patient.PatientStorage;
import javax.swing.JComboBox;

import list.InspectionRecord;
import javax.swing.JButton;

public class ShowPatientInspectionItem extends JPanel  {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextArea resultTextArea = null;
    private JTextField id = null;
    private JButton query = null;
    private JComboBox division = null;
    private JButton submit = null;

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
        GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
        gridBagConstraints11.gridx = 2;
        gridBagConstraints11.gridy = 3;
        GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
        gridBagConstraints31.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints31.gridy = 2;
        gridBagConstraints31.weightx = 1.0;
        gridBagConstraints31.gridx = 2;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 2;
        gridBagConstraints2.gridy = 1;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridx = 1;
        gridBagConstraints3.gridy = 2;
        jLabel = new JLabel();
        resultTextArea = new JTextArea(100,20);
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setVisible(false);
        resultTextArea.setSize(300, 200);
        jLabel.setText("病人ID");
        this.setSize(390, 311);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getId(), gridBagConstraints1);
        this.add(getQuery(), gridBagConstraints2);
        this.add(resultTextArea, gridBagConstraints3);
        this.add(getDivision(), gridBagConstraints31);
        this.add(getSubmit(), gridBagConstraints11);
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
            query.setText("看此病人檢查項目");
            /* by 丁丁 
        	 * 學習view.doctor.SeePatientFoundamentalDataPanel.java的寫法
        	 */
            query.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                        resultTextArea.setText("");
                        resultTextArea.setVisible(false);
                    } else {
                        // 版本一：找所有的檢查處
                        String result = "";
                        for (InspectionDivision d : InspectionDivision.values()) {
                            InspectionPlace place =  Hospital.Instance().inspectionPlaces().get(d);
                            Iterator<InspectionRecord> iter = place.inspectionList().iterator();
                            while (iter.hasNext()) {
                                InspectionRecord record = (InspectionRecord)iter.next();
                                // 如果這份檢查記錄的病人id跟輸入框的id一樣的話
                                if (record.patient().id().equals(patients.get(id.getText()).id())) {
                                    result = result + d.toString() + "\n";
                                    break;
                                }
                            }
                        }
                        resultTextArea.setText(id.getText() + "的檢查項目有：\n" + result);
                        resultTextArea.setVisible(true);
                        
//                        // 版本二：找到對的檢查處，看看是否有被排進去
//                        InspectionPlace place =  Hospital.Instance().inspectionPlaces().get(division.getSelectedItem());
//                        Iterator<InspectionRecord> iter = place.inspectionList().iterator();
//                        String result = "";
//                        while (iter.hasNext()) {
//                            InspectionRecord record = (InspectionRecord)iter.next();
//                            // 如果這份檢查記錄的病人id跟輸入框的id一樣的話
//                            if (record.patient().id().equals(patients.get(id.getText()).id())) {
//                                result = result + id.getText() + "有要檢查" + division.getSelectedItem() + "\n";
//                            }
//                        }
//                    	resultTextArea.setText(result);
//                    	resultTextArea.setVisible(true);
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
    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("檢查");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                        resultTextArea.setText("");
                        resultTextArea.setVisible(false);
                    } else {
                        // 版本一：找所有的檢查處
                        for (InspectionDivision d : InspectionDivision.values()) {
                            InspectionPlace place =  Hospital.Instance().inspectionPlaces().get(d);
                            Iterator<InspectionRecord> iter = place.inspectionList().iterator();
                            while (iter.hasNext()) {
                                InspectionRecord record = (InspectionRecord)iter.next();
                                // 如果這份檢查記錄的病人id跟輸入框的id一樣的話
                                if (record.patient().id().equals(patients.get(id.getText()).id())) {
                                    // 從檢查列表移出
                                    place.inspectionList().remove(record);
                                    // 顯示訊息
                                    JOptionPane.showMessageDialog(null, id.getText()+"已經做完"+d+"檢查了");
                                }
                            }
                        }
                    }
                }
            });
        }
        return submit;
    }
}
