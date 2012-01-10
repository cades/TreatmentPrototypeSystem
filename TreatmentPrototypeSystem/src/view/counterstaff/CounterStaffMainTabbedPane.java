package view.counterstaff;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class CounterStaffMainTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    private RegisterPanel registerPanel = null;
    private AddFundamentalDataPanel addFundamentalDataPanel = null;
    private HospitalizePanel hospitalizePanel = null;
    private UnhospitalizePanel unhospitalizePanel = null;
    private ChargePanel chargePanel = null;

    /**
     * This is the default constructor
     */
    public CounterStaffMainTabbedPane() {
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
        
        this.addTab("新增基本資料", null, getAddFundamentalDataPanel(), null);
        this.addTab("掛號", null, getRegisterPanel(), null);
        this.addTab("辦住院", null, getHospitalizePanel(), null);
        this.addTab("辦離院", null, getUnhospitalizePanel(), null);
        this.addTab("批價", null, getChargePanel(), null);
    }

    /**
     * This method initializes registerPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private JPanel getRegisterPanel() {
        if (registerPanel == null) {
            registerPanel = new RegisterPanel();
            //registerPanel.setLayout(new GridBagLayout());
        }
        return registerPanel;
    }

    /**
     * This method initializes addFundamentalDataPanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private AddFundamentalDataPanel getAddFundamentalDataPanel() {
        if (addFundamentalDataPanel == null) {
            addFundamentalDataPanel = new AddFundamentalDataPanel();
            //addFundamentalDataPanel.setLayout(new GridBagLayout());
        }
        return addFundamentalDataPanel;
    }

    /**
     * This method initializes hospitalizePanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private HospitalizePanel getHospitalizePanel() {
        if (hospitalizePanel == null) {
            hospitalizePanel = new HospitalizePanel();
            //hospitalizePanel.setLayout(new GridBagLayout());
        }
        return hospitalizePanel;
    }

    /**
     * This method initializes unhospitalizePanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private UnhospitalizePanel getUnhospitalizePanel() {
        if (unhospitalizePanel == null) {
            unhospitalizePanel = new UnhospitalizePanel();
            //unhospitalizePanel.setLayout(new GridBagLayout());
        }
        return unhospitalizePanel;
    }

    /**
     * This method initializes chargePanel	
     * 	
     * @return javax.swing.JPanel	
     */
    private ChargePanel getChargePanel() {
        if (chargePanel == null) {
            chargePanel = new ChargePanel();
            //chargePanel.setLayout(new GridBagLayout());
        }
        return chargePanel;
    }

}
