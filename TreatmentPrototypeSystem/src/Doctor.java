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
		this.setTitle("��ͱM��");
		actionButton = new JButton("�ʧ@");
		logoutButton = new JButton("�n�X");
		
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
		System.out.println("[���] �M�w�f�H�n��|");
	}
	public void editMedicalRecord(){
		System.out.println("[���] �d�ݯf��");
	}
	public void showPetientInformation(){
		System.out.println("[���] �d�ݰ򥻸��");
	}
	public void showDrugStocks(){
		System.out.println("[���] �d���ī~�w�s");
	}
	public void makePrescriptions(){
		System.out.println("[���] �}�ĳ�");
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
