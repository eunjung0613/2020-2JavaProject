package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainPG extends JFrame{
	public MainPG(String ID) {
		DB db = new DB();
		MemberDTO dto = db.DBGetPW(ID);
		int Account = dto.getAccount();
		
		JFrame Frame = new JFrame("ATM MAIN");
		JLabel Id = new JLabel("ID: "+ID);
		JLabel Acount = new JLabel("���¹�ȣ: "+Account);
		JButton Withdraw = new JButton("���");
		JButton remittance = new JButton("�۱�");
		JButton inquiry = new JButton("�Ա�");
		JButton Logout = new JButton("�α׾ƿ�");
		
		Frame.setLayout(null);
		Frame.setBounds(200,100,380,400);
		Frame.setVisible(true);
		
		Id.setBounds(20, 20, 400,30);
		Acount.setBounds(20,60,400,30);
		Withdraw.setBounds(20, 120, 150, 50);
		remittance.setBounds(190,120,150,50);
		inquiry.setBounds(20, 180, 150, 50);
		Logout.setBounds(190, 180, 150, 50);
		
		Frame.add(Id);
		Frame.add(Acount);
		Frame.add(Withdraw);
		Frame.add(remittance);
		Frame.add(inquiry);
		Frame.add(Logout);
		
	
		remittance.addActionListener(new ActionListener() { //��� ��ư Ŭ���� �̺�Ʈ

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new remittance(ID);
			}
		});
		Logout.addActionListener(new ActionListener() { //�α׾ƿ� ��ư Ŭ���� �̺�Ʈ
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ü ����");
				System.exit(0);
			}
		});
		Withdraw.addActionListener(new ActionListener() { //��� ��ư Ŭ���� �̺�Ʈ

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new WithDraw(ID);
			}
			
		});
		inquiry.addActionListener(new ActionListener() { //�Ա� ��ư Ŭ���� �̺�Ʈ

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new inquiry(ID);
			}
		});
		
		
	}
}
