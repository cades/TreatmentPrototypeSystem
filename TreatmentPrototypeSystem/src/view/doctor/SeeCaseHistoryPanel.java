package view.doctor;

import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JButton;

import storage.casehistory.CaseHistory;
import storage.casehistory.CaseHistoryStorage;
import storage.patient.PatientStorage;

public class SeeCaseHistoryPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton submit = null;

    /**
     * This is the default constructor
     */
    public SeeCaseHistoryPanel() {
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
        gridBagConstraints2.gridy = 1;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jLabel = new JLabel();
        jLabel.setText("病人ID");
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getId(), gridBagConstraints1);
        this.add(getSubmit(), gridBagConstraints2);
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
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("看病歷");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        Iterator<CaseHistory> iter = CaseHistoryStorage.Instance().iterator();
                        while (iter.hasNext()) {
                            CaseHistory aCase = (CaseHistory)iter.next();
                            if (aCase.patientId().equals(id.getText())) {
                                JOptionPane.showMessageDialog(null,
                                        "病人ID  :" + aCase.patientId() + "\n" +
                                        "看診醫生 :" + aCase.doctorInChargeId() + "\n" +
                                        "就醫時間 :" + aCase.time() +  "\n" +
                                        "內容    :" + aCase.content()
                                        );
                            }
                        }
                    }
                }
            });
        }
        return submit;
    }

}
