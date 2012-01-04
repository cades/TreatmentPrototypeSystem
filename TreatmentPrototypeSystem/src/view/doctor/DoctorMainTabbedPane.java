package view.doctor;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class DoctorMainTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    private SeePatientFoundamentalDataPanel seePatientFoundamentalDataPanel = null;

    // MainTabbedPane加兩行，建構子加參數、賦值p。
    private DoctorMainView parent;
    public DoctorMainView parent() {return parent;} 
    /**
     * This is the default constructor
     */
    public DoctorMainTabbedPane(DoctorMainView p) {
        super();
        parent = p;
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);

        this.addTab("看病人基本資料", null, getSeePatientFoundamentalDataPanel(), null);
    }

    /**
     * This method initializes seePatientFoundamentalDataPanel  
     *  
     * @return javax.swing.JPanel   
     */
    private JPanel getSeePatientFoundamentalDataPanel() {
        if (seePatientFoundamentalDataPanel == null) {
            seePatientFoundamentalDataPanel = new SeePatientFoundamentalDataPanel();
        }
        return seePatientFoundamentalDataPanel;
    }

}
