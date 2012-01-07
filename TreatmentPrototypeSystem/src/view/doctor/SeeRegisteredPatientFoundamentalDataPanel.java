package view.doctor;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import storage.patient.Patient;
import storage.patient.PatientStorage;
import storage.staff.Doctor;
import storage.staff.DoctorStorage;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import list.DiagnosisRecord;


public class SeeRegisteredPatientFoundamentalDataPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private JTextField patientName = null;
    private JTextField sex = null;
    private JTextField age = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel2 = null;
    private JButton next = null;
    private JLabel jLabel3 = null;
    private JTextField id = null;
    
    /**
     * This is the default constructor
     */
    public SeeRegisteredPatientFoundamentalDataPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
        gridBagConstraints16.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints16.gridy = 0;
        gridBagConstraints16.weightx = 1.0;
        gridBagConstraints16.gridx = 1;
        GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
        gridBagConstraints15.gridx = 0;
        gridBagConstraints15.gridy = 0;
        jLabel3 = new JLabel();
        jLabel3.setText("ID");
        GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
        gridBagConstraints14.gridx = 1;
        gridBagConstraints14.gridy = 4;
        GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
        gridBagConstraints13.gridx = 0;
        gridBagConstraints13.gridy = 3;
        jLabel2 = new JLabel();
        jLabel2.setText("年齡");
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 2;
        jLabel1 = new JLabel();
        jLabel1.setText("性別");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jLabel = new JLabel();
        jLabel.setText("姓名");
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints4.gridy = 3;
        gridBagConstraints4.weightx = 1.0;
        gridBagConstraints4.gridx = 1;
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints3.gridy = 2;
        gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.gridx = 1;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        this.setSize(300, 200);
        this.setLayout(new GridBagLayout());
        this.add(getPatientName(), gridBagConstraints1);
        this.add(getSex(), gridBagConstraints3);
        this.add(getAge(), gridBagConstraints4);
        this.add(jLabel, gridBagConstraints);
        this.add(jLabel1, gridBagConstraints2);
        this.add(jLabel2, gridBagConstraints13);
        this.add(getNext(), gridBagConstraints14);
        this.add(jLabel3, gridBagConstraints15);
        this.add(getId(), gridBagConstraints16);
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
     * This method initializes sex	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getSex() {
        if (sex == null) {
            sex = new JTextField();
            sex.setColumns(10);
        }
        return sex;
    }

    /**
     * This method initializes age	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getAge() {
        if (age == null) {
            age = new JTextField();
            age.setColumns(10);
        }
        return age;
    }

    /**
     * This method initializes next	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getNext() {
        if (next == null) {
            next = new JButton();
            next.setText("下一位");
            next.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    next_actionPerformed();
                }
            });
        }
        return next;
    }

    private void next_actionPerformed() {
        System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
        DoctorMainView v = (DoctorMainView)this.getRootPane().getParent();
        Doctor d = DoctorStorage.Instance().get(v.me.id());
        if (d.diagnosisList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "目前沒有病人在候診喔！忙裡偷閒一下吧:)");
        } else {
            DiagnosisRecord p = d.diagnosisList().remove(0);
            this.id.setText(p.patient().id());
            this.patientName.setText(p.patient().name());
            this.sex.setText(p.patient().sex());
            this.age.setText("" + p.patient().age());
        }
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
}
