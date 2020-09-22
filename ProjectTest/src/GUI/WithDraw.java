package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WithDraw extends JFrame{
	public WithDraw(String ID) {
		DB db = new DB();
		MemberDTO dto = db.DBGetPW(ID);
		int Account = dto.getMoney();
		
		JFrame Frame = new JFrame("���������");
		JLabel Acount = new JLabel("���� ���� �ݾ� : "+Account);
		JLabel Mon = new JLabel("����� �ݾ� : ");
		JTextField Minous = new JTextField();
		JButton OK = new JButton("��� ����");
		
		Frame.setLayout(null);
		Frame.setBounds(200, 100, 300, 250);
		Frame.setVisible(true);
		
		Acount.setBounds(10, 5, 230, 30);
		Mon.setBounds(10, 45, 80, 30);
		Minous.setBounds(90, 45, 180, 30);
		OK.setBounds(70, 105, 100, 50);
		
		Frame.add(Acount);
		Frame.add(Mon);
		Frame.add(Minous);
		Frame.add(OK);
		
		OK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ID = dto.getId();
				int money = dto.getMoney();
				int to = Integer.parseInt(Minous.getText());
				int result = money-to;
				if(result<=0) {
					JOptionPane.showMessageDialog(null,"���� ���¿� ���� �����մϴ�.","���� ����",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					boolean a;
					a = db.DBModify(result, ID);
					if(a==true) {
						Frame.dispose();
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "DB���� �Ұ�","DB���� �Ұ�.",JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
			
		});
		
	}
}
