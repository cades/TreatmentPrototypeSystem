import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.*;
public class Doctor extends Staff {
	LoginFrame loginFrame;
	JButton actionButton,logoutButton;
	public Doctor(LoginFrame loginFrame){
		this.loginFrame = loginFrame;
		this.setTitle("醫生專用");
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
	public void makePatientLiveInHospital(){
		System.out.println("[醫生] 決定病人要住院");
	}
	public void editMedicalRecord(){
		System.out.println("[醫生] 查看病歷");
	}
	public void showPetientInformation(){
		System.out.println("[醫生] 查看基本資料");
	}
	public void showDrugStocks(){
		System.out.println("[醫生] 查看藥品庫存");
	}
	public void makePrescriptions(){
		System.out.println("[醫生] 開藥單");
	}

	public void logout(){
		this.dispose();
		new LoginFrame();
	}
	private void button_actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(actionButton)) {
	    	makePatientLiveInHospital();
	    	editMedicalRecord();
	    	showPetientInformation();
	    	showDrugStocks();
	    	makePrescriptions();
	    }else if (e.getSource().equals(logoutButton)) {
	    	logout();
	    }
	}
	
}
