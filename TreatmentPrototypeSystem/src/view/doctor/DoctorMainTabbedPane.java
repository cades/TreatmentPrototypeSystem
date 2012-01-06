package view.doctor;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Dimension;

public class DoctorMainTabbedPane extends JTabbedPane {
    
    private static final long serialVersionUID = 1L;
    private SeePatientFoundamentalDataPanel seePatientFoundamentalDataPanel = null;


    private SeeCaseHistoryPanel seeCaseHistoryPanel = null;
    private SeeMedicinesPanel seeMedicinesPanel = null;
    private SeeInspectionReportPanel seeInspectionReportPanel = null;
     
    /**
     * This is the default constructor
     */
    public DoctorMainTabbedPane() {
        super();
        initialize();
    }
    
    public DoctorMainTabbedPane(DoctorMainView p) {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(394, 201);

        this.addTab("看病人基本資料", null, getSeePatientFoundamentalDataPanel(), null);
        this.addTab("看病歷", null, getSeeCaseHistoryPanel(), null);
        this.addTab("查藥品庫存", null, getSeeMedicinesPanel(), null);
        this.addTab("看檢查報告", null, getSeeInspectionReportPanel(), null);
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

    /**
     * This method initializes seeInspectionReportPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getSeeInspectionReportPanel() {
        if (seeInspectionReportPanel == null) {
            seeInspectionReportPanel = new SeeInspectionReportPanel();
            //seeInspectionReportPanel.setLayout(null);
        }
        return seeInspectionReportPanel;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
