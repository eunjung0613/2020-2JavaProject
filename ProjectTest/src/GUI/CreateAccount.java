package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.DB;

public class CreateAccount extends JFrame {
	public CreateAccount(){
		JFrame First = new JFrame("��������");
		JLabel NID = new JLabel("���ο� ID: ");
		JLabel NPW = new JLabel("���ο� ��й�ȣ: ");
		JLabel PWOK = new JLabel("��й�ȣ Ȯ��: ");
		JTextField NID2 = new JTextField();
		JPasswordField NPW2 = new JPasswordField();
		JPasswordField PWOK2 = new JPasswordField();
		NPW2.setEchoChar('*');
		PWOK2.setEchoChar('*');
		JButton Create2 = new JButton("����");
		
		First.setLayout(null);
		First.setBounds(200, 100, 430, 300);
		First.setVisible(true);
		NID.setBounds(20, 30, 100, 30);
		NID2.setBounds(150, 30, 210, 30);
		NPW.setBounds(20, 70, 100, 30);
		NPW2.setBounds(150, 70, 210, 30);
		PWOK.setBounds(20,110,100,30);
		PWOK2.setBounds(150,110,210,30);
		Create2.setBounds(120, 180, 130, 30);
		
		First.add(NID);
		First.add(NID2);
		First.add(NPW);
		First.add(NPW2);
		First.add(PWOK);
		First.add(PWOK2);
		First.add(Create2);
		
		Create2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DB db = new DB();
				String PW1 ="";
				String PW2 ="";
				char[] secret_pw = NPW2.getPassword();
				for(char cha : secret_pw) {
					Character.toString(cha);
					PW1 += (PW1.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				char[] secret_pw2 = PWOK2.getPassword();
				for(char cha : secret_pw2) {
					Character.toString(cha);
					PW2 += (PW2.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				if(PW1.equals(PW2)) {
					//DB�� �����ϴ� �ڵ� �߰�
					boolean b;
					b = db.DBInsert(NID2.getText(), PW1);
					if(b==true) {
						JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�.","���� ���� ����",JOptionPane.PLAIN_MESSAGE);
						First.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "DB���Կ���","DB�� �߰����� �ʾҽ��ϴ�.",JOptionPane.PLAIN_MESSAGE);
					}
				}
				else if(!PW1.equals(PW2)) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٸ��ϴ�.","��й�ȣ ����",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
			
	}
}
