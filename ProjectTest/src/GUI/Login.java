package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.FlowLayout;

public class Login extends JFrame {
	public Login(){
		JFrame MyJFrame = new JFrame("은행 로그인");
		JTextField MyId = new JTextField();
		JPasswordField MyPw = new JPasswordField();
		MyPw.setEchoChar('*');
		JButton OK = new JButton("로그인");
		JButton Create = new JButton("새계정");
		JLabel ID = new JLabel("ID입력 : ");
		JLabel PW = new JLabel("PW입력 : ");
		
		MyJFrame.setLayout(null);
		MyJFrame.setBounds(200, 100, 360, 300);
		MyJFrame.setVisible(true);
		
		ID.setBounds(20, 60, 80, 30);
		MyId.setBounds(80, 60, 210, 30);
		PW.setBounds(20, 110, 80, 30);
		MyPw.setBounds(80, 110, 210, 30);
		OK.setBounds(90, 180, 80, 30);
		Create.setBounds(190, 180, 80, 30);
		
		MyJFrame.add(ID);
		MyJFrame.add(MyId);
		MyJFrame.add(PW);
		MyJFrame.add(MyPw);
		MyJFrame.add(OK);
		MyJFrame.add(Create);
		
		OK.addActionListener(new ActionListener() { //OK 버튼이 눌렸을 때 행동
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DB db = new DB();
				String ID = MyId.getText();
				String PW2 ="";
				char[] secret_pw = MyPw.getPassword();
				for(char cha :secret_pw) {
					Character.toString(cha);
					PW2 += (PW2.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				MemberDTO dto = db.DBGetPW(ID);
				if(MyId.equals(null) && PW2.equals(null)){
					JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 입력하세요.","아이디 미입력",JOptionPane.PLAIN_MESSAGE);
				}
				else if(dto.getId().equals(ID) && !dto.getPw().equals(PW2)) {
					JOptionPane.showMessageDialog(null,"비밀번호가 틀립니다.","비밀번호 오류",JOptionPane.PLAIN_MESSAGE);
				}
				else if(dto.getId().equals(MyId.getText()) && dto.getPw().equals(PW2)){
					new MainPG(ID);
				}
			}
			
		});
		Create.addActionListener(new ActionListener(){ //계정생성 버튼이 눌렸을 때 새 창
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateAccount();
			}
		});
	}
}
