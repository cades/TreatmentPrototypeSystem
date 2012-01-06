package view;




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
    StaffStorage staffs;
    LoginControl control;
    Staff aStaff;
    
	JLabel idLabel,pwdLabel;
	JTextField id,pwd;
	JTextArea idCode;
	JPanel up ,center, down;
	JButton submit;
	
	public StaffStorage staffs() { return staffs; }
	
	public LoginFrame(StaffStorage staffs) {
	    this.staffs = staffs;          // 取得資料庫
	    control = new LoginControl();  // 生成控制物件
	    control.setStorage(staffs);    // 連結控制物件與資料庫
	    
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
            if ( (aStaff = control.login(id.getText(), pwd.getText()) ) != null ) { // 判斷登入成功
	            // 確定抓得到，還是要view自己抓。這裡就不透過control了，太冗了。
	            switch( staffs.get(id.getText()).occupation() ) {
	            case doctor:
	                new DoctorMainView(aStaff).setVisible(true);
	                break;
	            case nurse:
	                new NurseMainView(aStaff).setVisible(true);
	                break;
	            case counterStaff:
	                new CounterStaffMainView(aStaff).setVisible(true);
	                break;
	            case inspector:
	                new InspectorMainView(aStaff).setVisible(true);
	                break;
	            case pharmacist:
	                new PharmacistMainView(aStaff).setVisible(true); 
	                break;
                default:
                    System.out.println("未知的職業 ？！結束程式...");
                    System.exit(ERROR);
	            }
	            //this.setVisible(false); // 也可以不要設成false，可以大玩「單機多人登入」:)
	            JOptionPane.showMessageDialog(null, "歡迎登入，" + aStaff.name() + aStaff.occupation() + "。");
	        } else {
	            JOptionPane.showMessageDialog(null, "登入失敗。");
	        }
            /**
             * 增刪修查不必新增control，直接做在view裡面更能減少複雜性。
             */
	  }
	}
}
