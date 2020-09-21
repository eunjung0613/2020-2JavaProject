import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Login{
	private static JFrame MyJFrame = new JFrame("은행 로그인");
	private static JTextField MyId = new JTextField();
	private static JPasswordField MyPw = new JPasswordField();
	private static JButton OK = new JButton("로그인");
	private static JButton Create = new JButton("새계정");
	private static JLabel ID = new JLabel("ID입력 : ");
	private static JLabel PW = new JLabel("PW입력 : ");
	public static void main(String[] args) {
		MyJFrame.setLayout(null);
		MyJFrame.setBounds(200, 100, 360, 300);
		MyJFrame.setVisible(true);
		MyJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		Create.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateAccount();
			}
		});
	}
}
class CreateAccount extends JFrame{
	CreateAccount(){
		setTitle("계정생성");
		JFrame First = new JFrame();
		JLabel NID = new JLabel("새로운 ID: ");
		JLabel NPW = new JLabel("새로운 비밀번호: ");
		JLabel PWOK = new JLabel("비밀번호 확인: ");
		JTextField NID2 = new JTextField();
		JPasswordField NPW2 = new JPasswordField();
		JPasswordField PWOK2 = new JPasswordField();
		NPW2.setEchoChar('*');
		PWOK2.setEchoChar('*');
		JButton Create2 = new JButton("생성");
		
		First.setLayout(null);
		First.setBounds(200, 100, 430, 300);
		First.setVisible(true)
		;
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
					//DB에 저장하는 코드 추가
					JOptionPane.showMessageDialog(null, "계정이 생성되었습니다.","계정 생성 성공",JOptionPane.PLAIN_MESSAGE);
					First.dispose();
				}
				else if(!PW1.equals(PW2)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.","비밀번호 오류",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
			
	}
}