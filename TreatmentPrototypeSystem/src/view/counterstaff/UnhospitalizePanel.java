package view.counterstaff;

import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JButton;

import list.CheckinList;
import storage.patient.PatientStorage;
import storage.ward.Sickbed;
import storage.ward.SickbedStorage;

public class UnhospitalizePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton query = null;
    private JButton submit = null;

    /**
     * This is the default constructor
     */
    public UnhospitalizePanel() {
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
        this.add(getSubmit(), gridBagConstraints3);
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
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        Collection<Sickbed> c = SickbedStorage.Instance().values();
                        Iterator<Sickbed> iter = c.iterator();
                        while (iter.hasNext()) {
                            Sickbed bed = (Sickbed)iter.next();
                            if (bed.patientId().equals(id.getText())) {
                                JOptionPane.showMessageDialog(null, "找到：" + patients.get(id.getText()).id() + "正在住院中");
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "這位病人並沒有在住院耶！");
                    }
                }
            });
        }
        return query;
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("辦離院");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        Collection<Sickbed> c = SickbedStorage.Instance().values();
                        Iterator<Sickbed> iter = c.iterator();
                        while (iter.hasNext()) {
                            Sickbed bed = (Sickbed)iter.next();
                            if (bed.patientId().equals(id.getText())) {
                                bed.checkout();
                                JOptionPane.showMessageDialog(null, "已經為" + patients.get(id.getText()).id() + "辦好離院手續囉！祝身體健康^^");
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "這位病人並沒有在住院耶！");
                    }
                }
            });
        }
        return submit;
    }

}
