package view.counterstaff;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import list.CheckinList;

import storage.patient.PatientStorage;
import storage.ward.Sickbed;
import storage.ward.SickbedStorage;

public class HospitalizePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton query = null;
    private JComboBox sickbedComboBox = null;
    private JLabel jLabel1 = null;
    private JButton submit = null;

    /**
     * This is the default constructor
     */
    public HospitalizePanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
        gridBagConstraints18.gridx = 1;
        gridBagConstraints18.gridy = 2;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.gridx = 0;
        gridBagConstraints4.gridy = 1;
        jLabel1 = new JLabel();
        jLabel1.setText("選病床");
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints3.gridy = 1;
        gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.gridx = 1;
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
        this.add(getSickbedComboBox(), gridBagConstraints3);
        this.add(jLabel1, gridBagConstraints4);
        this.add(getSubmit(), gridBagConstraints18);
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
                    } else if (!CheckinList.Instance().contains(id.getText())) {
                        JOptionPane.showMessageDialog(null, "這位病人並沒有要住院喔！");
                    } else {
                        JOptionPane.showMessageDialog(null, "找到：" + patients.get(id.getText()).id() + "正在等待辦住院");
                    }
                }
            });
        }
        return query;
    }

    /**
     * This method initializes sickbedComboBox	
     * 	
     * @return javax.swing.JComboBox	
     */
    private JComboBox getSickbedComboBox() {
        if (sickbedComboBox == null) {
            sickbedComboBox = new JComboBox();
            refreshComboBox();
        }
        return sickbedComboBox;
    }
    
    private void refreshComboBox() {
        sickbedComboBox.removeAllItems();
        Collection<Sickbed> c = SickbedStorage.Instance().values();
        Iterator<Sickbed> iter = c.iterator();
        while (iter.hasNext()) {
            Sickbed bed = (Sickbed)iter.next();
            if (bed.isEmpty()) {
                sickbedComboBox.addItem(bed.number());
            }
        }
    }

    /**
     * This method initializes submit	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getSubmit() {
        if (submit == null) {
            submit = new JButton();
            submit.setText("安排住院");
            submit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    PatientStorage patients = PatientStorage.Instance();
                    if(patients.get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        // 檢查是否真的有在住院列表中
                        if (!CheckinList.Instance().contains(id.getText())) {
                            JOptionPane.showMessageDialog(null, "這位病人並沒有要住院喔！");
                            return;
                        }
                        // 更新住院列表
                        CheckinList.Instance().remove(id.getText());
                        // 更新床位狀態
                        SickbedStorage.Instance().get(sickbedComboBox.getSelectedItem()).checkin();
                        // 秀出成功訊息
                        JOptionPane.showMessageDialog(null, "成功安排" + id.getText() + "住進" + sickbedComboBox.getSelectedItem() + "號床囉！");
                        // 這個必須放到最後，不然會出小錯
                        refreshComboBox();
                    }
                }
            });
        }
        return submit;
    }

}
