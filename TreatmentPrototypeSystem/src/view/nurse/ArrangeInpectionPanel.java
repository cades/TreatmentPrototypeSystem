package view.nurse;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ArrangeInpectionPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField patientName = null;
    private JComboBox division = null;
    private JLabel jLabel1 = null;
    private JButton submit = null;

    /**
     * This is the default constructor
     */
    public ArrangeInpectionPanel() {
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
        gridBagConstraints11.gridx = 1;
        gridBagConstraints11.gridy = 2;
        GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
        gridBagConstraints10.gridx = 0;
        gridBagConstraints10.gridy = 1;
        jLabel1 = new JLabel();
        jLabel1.setText("檢查項目");
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
        gridBagConstraints8.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints8.gridy = 1;
        gridBagConstraints8.weightx = 1.0;
        gridBagConstraints8.gridx = 1;
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
        gridBagConstraints7.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints7.gridy = 0;
        gridBagConstraints7.weightx = 1.0;
        gridBagConstraints7.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jLabel = new JLabel();
        jLabel.setText("病人ID");
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getPatientName(), gridBagConstraints7);
        this.add(getDivision(), gridBagConstraints8);
        this.add(jLabel1, gridBagConstraints10);
        this.add(getSubmit(), gridBagConstraints11);
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
     * This method initializes division	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getDivision() {
        if (division == null) {
            division = new JComboBox();
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
            submit.setText("送出");
        }
        return submit;
    }

}
