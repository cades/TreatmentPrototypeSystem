package view.doctor;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

import storage.medicine.MedicineStocks;
import storage.prescription.Prescription;

public class SeeMedicinesPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextArea content = null;
    private JButton refresh = null;
    /**
     * This is the default constructor
     */
    public SeeMedicinesPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
        gridBagConstraints13.fill = GridBagConstraints.BOTH;
        gridBagConstraints13.gridy = 0;
        gridBagConstraints13.weightx = 1.0;
        gridBagConstraints13.weighty = 1.0;
        gridBagConstraints13.gridx = 0;
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(getContent(), gridBagConstraints13);
        this.add(getRefresh(), gridBagConstraints);
    }

    /**
     * This method initializes content	
     * 	
     * @return javax.swing.JTextArea	
     */
    private JTextArea getContent() {
        if (content == null) {
            content = new JTextArea();
            content.setText(Prescription.medicinesToString(MedicineStocks.Instance()));
        }
        return content;
    }

    /**
     * This method initializes refresh	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getRefresh() {
        if (refresh == null) {
            refresh = new JButton();
            refresh.setText("重新整理");
            refresh.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    content.setText(Prescription.medicinesToString(MedicineStocks.Instance()));
                }
            });
        }
        return refresh;
    }

}
