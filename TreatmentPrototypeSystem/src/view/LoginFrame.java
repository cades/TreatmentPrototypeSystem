package view;




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import control.LoginoutControl;

import storage.staff.Doctor;
import storage.staff.DoctorStorage;
import storage.staff.Occupation;
import storage.staff.Staff;
import storage.staff.StaffStorage;
import storage.patient.*;
import view.counterstaff.CounterStaffMainView;
import view.doctor.DoctorMainView;
import view.inspector.InspectorMainView;
import view.nurse.NurseMainView;
import view.pharmacist.PharmacistMainView;



public class LoginFrame extends JFrame{
    /**
     * 1.  實體物件放在最外面，跟view同一層。我覺得即使view毀掉再重生，data也應該不變，這樣比較make sense。
     *     一想還真沒錯，登出再登入就是這麼回事！雖然目前只是把LoginFrame隱藏，不dispose。
     * 2.  我不知道把控制物件放這裡是不是個好決定，畢竟登入畫面本身是個View。
     *     不過想不到更好的作法了，因為main一new LoginFrame，所有權就被搶了。
     * *.  我發現，循序圖有個盲點：物件的生成時間。還有B、C、E之間的從屬關係，沒有明確規範
     */
    LoginoutControl control;
    Staff aStaff;
    
	JLabel idLabel,pwdLabel;
	JTextField id,pwd;
	JTextArea idCode;
	JPanel up ,center, down;
	JButton submit;
	
	
	public LoginFrame() {
	    control = new LoginoutControl();  // 生成控制物件
	    control.setStorage(StaffStorage.Instance());    // 連結控制物件與資料庫
	    
	    setupGUI();
	}
	
	private void setupGUI() {
        this.setTitle("登入");
        idLabel = new JLabel("帳號：");
        pwdLabel = new JLabel("密碼：");
        id = new JTextField(10);
        pwd = new JTextField(10);
        submit = new JButton("登入");
        idCode = new JTextArea("Doctor\t醫生\nNurse\t護士\nPharmacist\t藥劑師\nInspector\t檢查人員\nCounter staff\t櫃台人員\n");
        
        submit.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(ActionEvent e) {
                button_actionPerformed(e);
              }
            });
        
        up = new JPanel();
        center = new JPanel();
        down = new JPanel();
        
        up.add(idLabel);
        up.add(id);
        center.add(pwdLabel);
        center.add(pwd);
        down.add(submit);
        down.add(idCode);
        
        this.add(up,BorderLayout.NORTH);
        this.add(center,BorderLayout.CENTER);
        this.add(down,BorderLayout.SOUTH);
        
        this.setSize(500,300);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dialogSize = this.getSize();
        if(dialogSize.height > screenSize.height)
            dialogSize.height = screenSize.height;
        if(dialogSize.width > screenSize.width)
            dialogSize.width = screenSize.width;
        this.setLocation( (screenSize.width - dialogSize.width)/2 ,(screenSize.height - dialogSize.height)/2 );
        this.setVisible(true);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	private void button_actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(submit)) {
	        control.login(id.getText(), pwd.getText());
	        //this.setVisible(false); // 也可以不要設成false，可以大玩「單機多人登入」:)
	  }
	}
}
