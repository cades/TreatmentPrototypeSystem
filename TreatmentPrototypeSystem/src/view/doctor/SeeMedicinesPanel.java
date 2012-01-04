package view.doctor;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class SeeMedicinesPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JComboBox medicines = null;
    private JButton submit = null;

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
        jLabel.setText("選擇藥品");
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getMedicines(), gridBagConstraints1);
        this.add(getSubmit(), gridBagConstraints2);
    }

    /**
     * This method initializes medicines	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getMedicines() {
        if (medicines == null) {
            medicines = new JComboBox();
            medicines.addItem("A");
            medicines.addItem("B");
            medicines.addItem("C");
            medicines.addItem("藍波球");
            medicines.addItem("可樂");
        }
        return medicines;
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("查看");
        }
        return submit;
    }

}
