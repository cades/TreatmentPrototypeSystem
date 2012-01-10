package view.doctor;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import storage.patient.PatientStorage;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

import list.CheckinList;


public class DecideHospitalizePanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton submit = null;
    private JButton decide = null;
    
    /**
     * This is the default constructor
     */
    public DecideHospitalizePanel() {
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
        gridBagConstraints3.gridx = 1;
        gridBagConstraints3.gridy = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 2;
        gridBagConstraints2.ipady = 171;
        gridBagConstraints2.gridy = 0;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.ipadx = 171;
        gridBagConstraints1.ipady = 172;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.ipady = 184;
        gridBagConstraints.gridy = 0;
        jLabel = new JLabel();
        jLabel.setText("病人ID");
        this.setSize(302, 230);
        this.setLayout(new GridBagLayout());
        this.add(jLabel, gridBagConstraints);
        this.add(getId(), gridBagConstraints1);
        this.add(getSubmit(), gridBagConstraints2);
        this.add(getDecide(), gridBagConstraints3);
    }

    /**
     * This method initializes id   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getId() {
        if (id == null) {
            id = new JTextField();
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
            submit.setText("查詢");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        JOptionPane.showMessageDialog(null, "找到：" + patients.get(id.getText()).id());
                    }
                }
            });
        }
        return submit;
    }

    /**
     * This method initializes decide	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getDecide() {
        if (decide == null) {
            decide = new JButton();
            decide.setText("住院");
            decide.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        CheckinList.Instance().add(id.getText());
                        JOptionPane.showMessageDialog(null, "已加入住院列表囉！請去找櫃檯人員辦理住院手續吧:)");
                    }
                }
            });
        }
        return decide;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
