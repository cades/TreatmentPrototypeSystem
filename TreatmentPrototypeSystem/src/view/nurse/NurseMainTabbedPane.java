package view.nurse;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class NurseMainTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    private PrintPrescriptionPanel printPrescriptionPanel = null;
    private ArrangeInpectionPanel arrangeInpectionPanel = null;

    /**
     * This is the default constructor
     */
    public NurseMainTabbedPane() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);

        this.addTab("列印藥單", null, getPrintPrescriptionPanel(), null);
        this.addTab("安排檢查", null, getArrangeInpectionPanel(), null);
    }

    /**
     * This method initializes printPrescriptionPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private PrintPrescriptionPanel getPrintPrescriptionPanel() {
        if (printPrescriptionPanel == null) {
            printPrescriptionPanel = new PrintPrescriptionPanel();
            //printPrescriptionPanel.setLayout(new GridBagLayout());
        }
        return printPrescriptionPanel;
    }

    /**
     * This method initializes arrangeInpectionPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private ArrangeInpectionPanel getArrangeInpectionPanel() {
        if (arrangeInpectionPanel == null) {
            arrangeInpectionPanel = new ArrangeInpectionPanel();
            //arrangeInpectionPanel.setLayout(new GridBagLayout());
        }
        return arrangeInpectionPanel;
    }

}
