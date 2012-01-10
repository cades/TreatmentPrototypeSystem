package HelloUserPackage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;


public class DingTimer extends TimerTask{
	String role;
	long period;
	String message;
	RemindFrame remindFrame;
	Timer timer;
	public DingTimer(String role, long  period, String message) {
		this.role = role;
		this.period = period;
		this.message = message;
		this.remindFrame = new RemindFrame(role,message);
		timer = new Timer();
		timer.schedule(this, period,period);
	}
	public static void main(String [] args){
		DingTimer d = new DingTimer("醫生", 1000 ,"巡診囉");
		try {
			Thread.sleep(3000);
			d.doCancel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		//System.out.println("to:" + role  + " " + message);
		this.remindFrame.setVisible(true);
	}
	public void doCancel(){
		timer.cancel();
	}
	
}
class RemindFrame extends JFrame{
	String role;
	String message;
	JLabel text; 
	JPanel panel1;
	JButton button;
	public RemindFrame(String role, String message){
		this.role = role;
		this.message = message;
		
		text = new JLabel("To:" + role + " " +message);
		button = new JButton("確定");
		button.addActionListener(new java.awt.event.ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        setVisible(false);
		      }
		    });
		panel1 = new JPanel();
		panel1.add(text);
		panel1.add(button);
		this.add(panel1);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,200);
		this.setBackground(new Color(245,185,20));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension dialogSize = this.getSize();
	    if(dialogSize.height > screenSize.height)
	    	dialogSize.height = screenSize.height;
	    if(dialogSize.width > screenSize.width)
	    	dialogSize.width = screenSize.width;
	    this.setLocation( (screenSize.width - dialogSize.width)/2 ,(screenSize.height - dialogSize.height)/2 );
		
		
		
	}
}