package view.inspector;

import javax.swing.JTabbedPane;

public class InspectorMainTabbedPane extends JTabbedPane {

    private static final long serialVersionUID = 1L;

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
        this.setSize(300, 200);

    }

}
