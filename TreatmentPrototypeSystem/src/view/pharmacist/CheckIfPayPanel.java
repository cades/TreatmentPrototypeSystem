package view.pharmacist;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import storage.patient.PatientStorage;
import storage.prescription.Prescription;
import storage.prescription.PrescriptionStorage;

public class CheckIfPayPanel extends JPanel  {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton query = null;
    private JLabel resultLabel = null;

    /**
     * This is the default constructor
     */
    public CheckIfPayPanel() {
        super();
        initialize();
    }
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
        gridBagConstraints6.gridx = 1;
        gridBagConstraints6.gridy = 1;
        resultLabel = new JLabel();
        resultLabel.setText("");
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
        this.setSize(390, 311);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getId(), gridBagConstraints1);
        this.add(getQuery(), gridBagConstraints2);
        this.add(resultLabel, gridBagConstraints6);
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
            query.setText("查詢此人是否批價");
            /* by 丁丁 
        	 * 學習view.doctor.SeePatientFoundamentalDataPanel.java的寫法
        	 */
            query.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        Iterator<Prescription> iter = PrescriptionStorage.Instance().iterator();
                        while (iter.hasNext()) {
                            Prescription pres = (Prescription)iter.next();
                            if (pres.patientId().equals(id.getText())) {
                                if (pres.isMoneyPaid())
                                    resultLabel.setText(id.getText() + "：已批價");
                                else
                                    resultLabel.setText(id.getText() + "：未批價");
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "醫生沒有給這位病人開藥單呢！");
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
