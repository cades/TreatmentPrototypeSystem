package view.doctor;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SeeInspectionReportPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JButton submit = null;
    private JTextField id = null;
    private JComboBox inspectionItem = null;
    /**
     * This is the default constructor
     */
    public SeeInspectionReportPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints3.gridy = 1;
        gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.gridx = 2;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.gridx = 1;
        GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
        gridBagConstraints11.gridx = 3;
        gridBagConstraints11.gridy = 1;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 0;
        jLabel1 = new JLabel();
        jLabel1.setText("檢查項目");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jLabel = new JLabel();
        jLabel.setText("病人ID");
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(jLabel1, gridBagConstraints1);
        this.add(getSubmit(), gridBagConstraints11);
        this.add(getId(), gridBagConstraints2);
        this.add(getInspectionItem(), gridBagConstraints3);
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("查詢");
        }
        return submit;
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
     * This method initializes inspectionItem	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getInspectionItem() {
        if (inspectionItem == null) {
            inspectionItem = new JComboBox();
            inspectionItem.addItem("血壓");
            inspectionItem.addItem("心跳");
            inspectionItem.addItem("腦波");
            inspectionItem.addItem("X光");
            inspectionItem.addItem("胃視鏡");
        }
        return inspectionItem;
    }

}
