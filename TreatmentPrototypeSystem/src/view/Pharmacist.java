package view;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.*;



public class Pharmacist extends JFrame {
	LoginFrame loginFrame;
	JButton actionButton,logoutButton;
	public Pharmacist(LoginFrame loginFrame){
		this.loginFrame = loginFrame;
		this.setTitle("藥劑師專用");
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
	public void dispense(){
		System.out.println("[藥劑師] 根據藥單調配藥劑");
	}
	public void checkIfPeePrice(){
		System.out.println("[藥劑師] 確認病人是否已批價");
	}

	private void button_actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(actionButton)) {
	    	dispense();
	    	checkIfPeePrice();
	    }else if (e.getSource().equals(logoutButton)) {
            loginFrame.setVisible(true);
            this.dispose();
        }
	}
	
}