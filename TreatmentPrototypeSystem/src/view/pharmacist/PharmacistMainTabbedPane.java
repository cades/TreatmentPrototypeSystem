package view.pharmacist;

import javax.swing.JTabbedPane;

import view.nurse.ArrangeInpectionPanel;
import view.nurse.PrintPrescriptionPanel;

public class PharmacistMainTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    private PrintPrescriptionPanel printPrescriptionPanel = null;
    private CheckIfPayPanel checkIfPayPanel = null;

    /**
     * This is the default constructor
     */
    public PharmacistMainTabbedPane() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(390, 200);
        
        this.addTab("看藥單，配藥劑", null, getPrintPrescriptionPanel(), null);
        this.addTab("確認病人是否批價", null, getCheckIfPayPanel(), null);

    }
    /**
     * This method initializes printPrescriptionPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private PrintPrescriptionPanel getPrintPrescriptionPanel() {
        if (printPrescriptionPanel == null) {
            printPrescriptionPanel = new PrintPrescriptionPanel();
        }
        return printPrescriptionPanel;
    }

    /**
     * This method initializes checkIfPayPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private CheckIfPayPanel getCheckIfPayPanel() {
        if (checkIfPayPanel == null) {
        	checkIfPayPanel = new CheckIfPayPanel();
        }
        return checkIfPayPanel;
    }

}
