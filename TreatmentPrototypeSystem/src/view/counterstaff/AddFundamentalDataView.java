package view.counterstaff;





import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import control.*;
import storage.patient.*;

public class AddFundamentalDataView extends JFrame {
    CounterStaff parentFrame;
    GetPatientsData control;
    
    JLabel nameLabel, ageLabel, sexLabel, idLabel;
    JTextField name, age, sex, id;
    JButton submit;
    JPanel p1, p2, p3, p4, p5;
    
    public AddFundamentalDataView(CounterStaff frame) {
        parentFrame = frame;
        control = new GetPatientsData();
        control.setEntity(parentFrame.loginFrame.patients());
        
        this.setLayout(new FlowLayout());
        this.setTitle("新增一筆基本資料。來填資料吧！");
        nameLabel = new JLabel("姓名");
        ageLabel = new JLabel("年齡");
        sexLabel = new JLabel("性別");
        idLabel = new JLabel("ID");
        
        name = new JTextField(10);
        age = new JTextField(10);
        sex = new JTextField(10);
        id = new JTextField(10);
        submit = new JButton("確定新增");
        
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
              button_actionPerformed(e);
            }
          });
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        
        p1.add(nameLabel);
        p1.add(name);
        p2.add(ageLabel);
        p2.add(age);
        p3.add(sexLabel);
        p3.add(sex);
        
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.SOUTH);
        
        p5.add(idLabel);
        p5.add(id);
        
        this.add(p4, BorderLayout.NORTH);
        this.add(p5, BorderLayout.CENTER);
        this.add(submit, BorderLayout.SOUTH);
        
        
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
            /**
             *  這裡就是"業務邏輯"大顯身手的地方了
             *  因為屬「增刪修查」的增，所以就不另開controller囉
             */
            parentFrame.loginFrame.patients().put(id.getText(),
                    new Patient(
                            name.getText(),
                            Integer.parseInt( age.getText() ),
                            sex.getText(),
                            id.getText()));
            // TODO 再跳出個確認視窗/新增成功？
            
            // 重整GUI
            parentFrame.setVisible(true);
            this.dispose();
        }
    }
}
