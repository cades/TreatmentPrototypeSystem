


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.*;
import storage.staff.*;


public class CounterStaff extends JFrame {
	LoginFrame loginFrame;
	Staff me;
	JButton actionButton1, actionButton2, actionButton3, actionButton4, actionButton5, logoutButton;
	
	public CounterStaff(LoginFrame loginFrame, Staff aStaff){
	    me = aStaff;
	    setupGUI(loginFrame);
	}
	
	/**
	 * 櫃檯人員的各項操作
	 * 一個Controller=一個function?
	 * 醫生與櫃檯都想看病人資料，寫成各自function一定是複製貼上：code重複。
	 * 寫成controller吧！
	 */
    public void createFoundamentalData(){
        new AddFundamentalDataView(this);
        this.setVisible(false);
        new DEBUG(0, "[櫃台人員] 新增一筆基本資料");
    }
	public void arrangeCheckin(){
		new DEBUG(0, "[櫃台人員] 安排病人住病房");
	}
	public void quotePrice(){
		new DEBUG(0, "[櫃台人員] 批價");
	}

	public void pushToDiagnosisList(){
	    /**
	     * 櫃檯人員畫面->掛號畫面->選科別->選醫生->創建一個DiagnosisRecord物件、push到正確醫生的DiagnosisList
	     */
		new DEBUG(0, "[櫃台人員] 新增一筆資料到看診列表");
	}
	public void arrangeCheckout(){
		new DEBUG(0, "[櫃台人員] 辦理出院");
	}

	/**
	 * GUI相關
	 */
    public void setupGUI(LoginFrame loginFrame){
        this.loginFrame = loginFrame;
        this.setTitle("櫃台人員專用");
        this.setLayout(new FlowLayout());
        actionButton1 = new JButton("新增一筆基本資料");
        actionButton2 = new JButton("安排病人住進病房");
        actionButton3 = new JButton("批價");
        actionButton4 = new JButton("安排候診");
        actionButton5 = new JButton("辦理出院");
        logoutButton = new JButton("登出");
        
        actionButton1.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(ActionEvent e) { button_actionPerformed(e); }
            });
        actionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) { button_actionPerformed(e); }
          });
        actionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) { button_actionPerformed(e); }
          });
        actionButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) { button_actionPerformed(e); }
          });
        actionButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) { button_actionPerformed(e); }
          });
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(ActionEvent e) { button_actionPerformed(e); }
            });
        
        this.add(actionButton1);
        this.add(actionButton2);
        this.add(actionButton3);
        this.add(actionButton4);
        this.add(actionButton5);
        this.add(logoutButton);
        
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
	    if (e.getSource().equals(actionButton1)) {
	        createFoundamentalData();
	    } else if (e.getSource().equals(actionButton2)) {
	        arrangeCheckin();
	    } else if (e.getSource().equals(actionButton3)) {
	        quotePrice();
	    } else if (e.getSource().equals(actionButton4)) {
	        pushToDiagnosisList();
	    } else if (e.getSource().equals(actionButton5)) {
	        arrangeCheckout();
	    }else if (e.getSource().equals(logoutButton)) {
	        loginFrame.setVisible(true);
	        this.dispose();
	    }
	}
	
}
