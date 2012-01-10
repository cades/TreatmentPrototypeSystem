package view.counterstaff;

import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JButton;

import storage.patient.PatientStorage;
import storage.prescription.Prescription;
import storage.prescription.PrescriptionStorage;

public class ChargePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton query = null;
    private JLabel priceLabel = null;
    private JButton chargeButton = null;

    private Prescription aPres = null;
    /**
     * This is the default constructor
     */
    public ChargePanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
        gridBagConstraints20.gridx = 2;
        gridBagConstraints20.gridy = 2;
        GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
        gridBagConstraints19.gridx = 1;
        gridBagConstraints19.gridy = 1;
        priceLabel = new JLabel();
        priceLabel.setText("");
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
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getId(), gridBagConstraints1);
        this.add(getQuery(), gridBagConstraints2);
        this.add(priceLabel, gridBagConstraints19);
        this.add(getChargeButton(), gridBagConstraints20);
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
            query.setText("查詢");
            query.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    aPres = null;
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        Iterator<Prescription> iter = PrescriptionStorage.Instance().iterator();
                        while (iter.hasNext()) {
                            Prescription pres = (Prescription)iter.next();
                            if (pres.patientId().equals(id.getText())) {
                                if (pres.isMoneyPaid()) { // 已經附過了
                                    priceLabel.setText(id.getText() + "沒有藥單要批價喔！");
                                } else {    // 付錢吧！
                                    priceLabel.setText(id.getText() + "需繳" + pres.price() + "元");
                                    aPres = pres;
                                }
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "醫生沒有給這位病人開藥單呢！");
                    }
                }
            });
        }
        return query;
    }

    /**
     * This method initializes chargeButton	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getChargeButton() {
        if (chargeButton == null) {
            chargeButton = new JButton();
            chargeButton.setText("收費");
            chargeButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    aPres.pay();
                    aPres = null;
                    JOptionPane.showMessageDialog(null, "已經付清，可以去領藥囉！");
                }
            });
        }
        return chargeButton;
    }

}
