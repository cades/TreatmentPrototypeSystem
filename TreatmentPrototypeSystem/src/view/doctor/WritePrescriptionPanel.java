package view.doctor;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import storage.patient.PatientStorage;
import storage.prescription.Prescription;
import storage.prescription.PrescriptionStorage;

public class WritePrescriptionPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JTextArea content = null;
    private JButton submit = null;
    private JLabel jLabel1 = null;
    private JButton query = null;

    /**
     * This is the default constructor
     */
    public WritePrescriptionPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
        gridBagConstraints5.gridx = 2;
        gridBagConstraints5.gridy = 0;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.gridx = 0;
        gridBagConstraints4.gridy = 1;
        jLabel1 = new JLabel();
        jLabel1.setText("藥單內容");
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridx = 2;
        gridBagConstraints3.gridy = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.fill = GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.weighty = 1.0;
        gridBagConstraints2.gridx = 1;
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
        this.add(getContent(), gridBagConstraints2);
        this.add(getSubmit(), gridBagConstraints3);
        this.add(jLabel1, gridBagConstraints4);
        this.add(getQuery(), gridBagConstraints5);
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
     * This method initializes content	
     * 	
     * @return javax.swing.JTextArea	
     */
    private JTextArea getContent() {
        if (content == null) {
            content = new JTextArea();
        }
        return content;
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("確認送出");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PrescriptionStorage.Instance().add(
                            new Prescription(
                                    id.getText(),
                                    null,
                                    content.getText()
                                    ));
                    JOptionPane.showMessageDialog(null, "您寫好的藥單已經存進系統了！");
                }
            });
        }
        return submit;
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
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        JOptionPane.showMessageDialog(null, "找到：" + patients.get(id.getText()).id());
                    }
                }
            });
        }
        return query;
    }

}
