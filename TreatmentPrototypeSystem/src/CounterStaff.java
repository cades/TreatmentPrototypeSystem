import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.*;
public class CounterStaff extends Staff {
	LoginFrame loginFrame;
	JButton actionButton,logoutButton;
	public CounterStaff(LoginFrame loginFrame){
	    setupGUI(loginFrame);
	}
	public void arrangeCheckin(){
		new DEBUG(0, "[櫃台人員] 安排病人住病房");
	}
	public void quotePrice(){
		new DEBUG(0, "[櫃台人員] 批價");
	}
	public void createFoundamentalData(){
		new DEBUG(0, "[櫃台人員] 新增一筆基本資料");
	}
	public void pushToDiagnosisList(){
		new DEBUG(0, "[櫃台人員] 新增一筆資料到看診列表");
	}
	public void arrangeCheckout(){
		new DEBUG(0, "[櫃台人員] 辦理出院");
	}

    public void setupGUI(LoginFrame loginFrame){
        this.loginFrame = loginFrame;
        this.setTitle("櫃台人員專用");
        actionButton = new JButton("動作");
        logoutButton = new JButton("登出");
        
        actionButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(ActionEvent e) {
                button_actionPerformed(e);
              }
            });
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(ActionEvent e) {
                button_actionPerformed(e);
              }
            });
        this.add(actionButton,BorderLayout.NORTH);
        this.add(logoutButton,BorderLayout.CENTER);
        
        this.setSize(500,200);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dialogSize = this.getSize();
        if(dialogSize.height > screenSize.height)
            dialogSize.height = screenSize.height;
        if(dialogSize.width > screenSize.width)
            dialogSize.width = screenSize.width;
        this.setLocation( (screenSize.width - dialogSize.width)/2 ,(screenSize.height - dialogSize.height)/2 );
        this.setVisible(true);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
	private void button_actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(actionButton)) {
	        arrangeCheckin();
	        quotePrice();
	        createFoundamentalData();
	        pushToDiagnosisList();
	        arrangeCheckout();
	    }else if (e.getSource().equals(logoutButton)) {
	    	logout();
	    }
	}
	
}
