package view.doctor;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SeePatientFoundamentalDataPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private JLabel jLabel = null;
    private JTextField id = null;
    private JButton submit = null;
    
    /**
     * This is the default constructor
     */
    public SeePatientFoundamentalDataPanel() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        jLabel = new JLabel();
        jLabel.setText("病人ID");
        this.setSize(300, 200);
        this.setLayout(new BorderLayout());
        this.add(jLabel, BorderLayout.WEST);
        this.add(getId(), BorderLayout.CENTER);
        this.add(getSubmit(), BorderLayout.EAST);
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
                    JButton jb = (JButton)e.getSource();
                    DoctorMainTabbedPane pane = (DoctorMainTabbedPane)jb.getParent().getParent();
                    if(pane.parent().loginFrame().patients().get(id.getText()) == null) {
                        JOptionPane.showMessageDialog(null, "查無此人喔！");
                    } else {
                        JOptionPane.showMessageDialog(null, "找到：" + pane.parent().loginFrame().patients().get(id.getText()).name());
                    }
                }
            });
        }
        return submit;
    }

}
