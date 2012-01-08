package view.inspector;

import javax.swing.JTabbedPane;

import view.nurse.PrintPrescriptionPanel;

public class InspectorMainTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    ShowPatientInspectionItem showPatientInspectionItem = null;
    WritePatientInspectionReport writePatientInspectionReport = null;

    /**
     * This is the default constructor
     */
    public InspectorMainTabbedPane() {
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
        this.addTab("觀看檢查項目", null, getShowPatientInspectionItem(), null);
        this.addTab("寫檢查報告", null, getwritePatientInspectionReport(), null);

    }
    /**
     * This method initializes showPatientInspectionItem	
     * 	
     * @return javax.swing.JPanel	
     */
    private ShowPatientInspectionItem getShowPatientInspectionItem() {
        if (showPatientInspectionItem == null) {
        	showPatientInspectionItem = new ShowPatientInspectionItem();
        }
        return showPatientInspectionItem;
    }
    /**
     * This method initializes writePatientInspectionReport	
     * 	
     * @return javax.swing.JPanel	
     */
    private WritePatientInspectionReport getwritePatientInspectionReport() {
        if (writePatientInspectionReport == null) {
        	writePatientInspectionReport = new WritePatientInspectionReport();
        }
        return writePatientInspectionReport;
    }

}
