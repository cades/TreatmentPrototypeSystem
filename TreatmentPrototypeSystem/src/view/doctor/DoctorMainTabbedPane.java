package view.doctor;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class DoctorMainTabbedPane extends JTabbedPane {
    // MainTabbedPane加兩行，建構子加參數、賦值p。
    private DoctorMainView parent;
    public DoctorMainView parent() {return parent;}
    
    
    private static final long serialVersionUID = 1L;
    private SeePatientFoundamentalDataPanel seePatientFoundamentalDataPanel = null;


    private SeeCaseHistoryPanel seeCaseHistoryPanel = null;
    private SeeMedicinesPanel seeMedicinesPanel = null;
     
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
        this.addTab("看病歷", null, getSeeCaseHistoryPanel(), null);
        this.addTab("查藥品庫存", null, getSeeMedicinesPanel(), null);
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
    /**
     * This method initializes seeCaseHistoryPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getSeeCaseHistoryPanel() {
        if (seeCaseHistoryPanel == null) {
            seeCaseHistoryPanel = new SeeCaseHistoryPanel();
            seeCaseHistoryPanel.setLayout(new GridBagLayout());
        }
        return seeCaseHistoryPanel;
    }

    /**
     * This method initializes seeMedicinesPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getSeeMedicinesPanel() {
        if (seeMedicinesPanel == null) {
            seeMedicinesPanel = new SeeMedicinesPanel();
            seeMedicinesPanel.setLayout(new GridBagLayout());
        }
        return seeMedicinesPanel;
    }

}
