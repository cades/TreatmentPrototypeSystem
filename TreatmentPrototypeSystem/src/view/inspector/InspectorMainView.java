package view.inspector;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import storage.staff.Staff;

public class InspectorMainView extends JFrame {
    Staff me;

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private InspectorMainTabbedPane inspectorMainTabbedPane = null;

    /**
     * This is the default constructor
     */
    public InspectorMainView(Staff aStaff) {
        super();
        me = aStaff;
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("檢查人員主畫面");
        me.login(this);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("" + me.name() + me.occupation() + "登出");
                me.logout();
                }
        });
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getInspectorMainTabbedPane(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes inspectorMainTabbedPane	
     * 	
     * @return javax.swing.JTabbedPane	
     */
    private InspectorMainTabbedPane getInspectorMainTabbedPane() {
        if (inspectorMainTabbedPane == null) {
            inspectorMainTabbedPane = new InspectorMainTabbedPane();
        }
        return inspectorMainTabbedPane;
    }

}
