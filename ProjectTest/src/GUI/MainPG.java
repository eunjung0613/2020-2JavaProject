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
		JLabel Acount = new JLabel("계좌번호: "+Account);
		JButton Withdraw = new JButton("출금");
		JButton remittance = new JButton("송금");
		JButton inquiry = new JButton("입금");
		JButton Logout = new JButton("로그아웃");
		
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
		
	
		remittance.addActionListener(new ActionListener() { //출금 버튼 클릭시 이벤트

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new remittance(ID);
			}
		});
		Logout.addActionListener(new ActionListener() { //로그아웃 버튼 클릭시 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("전체 종료");
				System.exit(0);
			}
		});
		Withdraw.addActionListener(new ActionListener() { //출금 버튼 클릭시 이벤트

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new WithDraw(ID);
			}
			
		});
		inquiry.addActionListener(new ActionListener() { //입금 버튼 클릭시 이벤트

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new inquiry(ID);
			}
		});
		
		
	}
}
