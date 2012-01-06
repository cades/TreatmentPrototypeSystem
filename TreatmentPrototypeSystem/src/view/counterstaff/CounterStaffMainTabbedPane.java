package view.counterstaff;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class CounterStaffMainTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;
    private RegisterPanel registerPanel = null;
    private AddFundamentalDataPanel addFundamentalDataPanel = null;

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

}
