import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class LoginFrame extends JFrame{
	JLabel idLabel,pwdLabel;
	JTextField id,pwd;
	JTextArea idCode;
	JPanel up ,center, down;
	JButton submit;
	
	public LoginFrame(){
		this.setTitle("�n�J");
		idLabel = new JLabel("�b���G");
		pwdLabel = new JLabel("�K�X�G");
		id = new JTextField(10);
		pwd = new JTextField(10);
		submit = new JButton("�n�J");
		idCode = new JTextArea("Doctor\t���\nNurse\t�@�h\nPharmacist\t�ľ��v\nInspector\t�ˬd�H��\nCounter staff\t�d�x�H��\n");
		
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
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void button_actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(submit)) {
	    	if(id.getText().startsWith("d")){
	    		new Doctor(this);
	    		this.dispose();
	    		JOptionPane.showMessageDialog(null, "�P�_�b������͡C�n�J�I" );
	    	}else if(id.getText().startsWith("n")){
	    		new Nurse(this);
	    		JOptionPane.showMessageDialog(null, "�P�_�b�����@�h�C�n�J�I" );
	    		this.dispose();
	    	}else if(id.getText().startsWith("p")){
	    		new Pharmacist(this);
	    		JOptionPane.showMessageDialog(null, "�P�_�b�����ľ��v�C�n�J�I" );
	    		this.dispose();
	    	}else if(id.getText().startsWith("c")){
	    		new CounterStaff(this);
	    		JOptionPane.showMessageDialog(null, "�P�_�b�����d�x�H���C�n�J�I" );
	    		this.dispose();
	    	}else if(id.getText().startsWith("i")){
	    		new Inspector(this);
	    		JOptionPane.showMessageDialog(null, "�P�_�b�����ˬd�H���C�n�J�I" );
	    		this.dispose();
	    	}
	    	
	  }
	}
}
