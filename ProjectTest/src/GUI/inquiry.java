package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javax.swing.*;

public class inquiry extends JFrame{
	public inquiry(String ID) {
		DB db = new DB();
		MemberDTO dto = db.DBGetPW(ID);
		int Account = dto.getMoney();
		
		JFrame Frame = new JFrame("�Ա�������");
		JLabel Acount = new JLabel("���� ���� �ݾ� : "+Account);
		JLabel Mon = new JLabel("�Ա��� �ݾ� : ");
		JTextField PLUS = new JTextField();
		JButton OK = new JButton("�Ա� ����");
		
		Frame.setLayout(null);
		Frame.setBounds(200, 100, 300, 250);
		Frame.setVisible(true);
		
		Acount.setBounds(10, 5, 230, 30);
		Mon.setBounds(10, 45, 80, 30);
		PLUS.setBounds(90, 45, 180, 30);
		OK.setBounds(70, 105, 100, 50);
		
		Frame.add(Acount);
		Frame.add(Mon);
		Frame.add(PLUS);
		Frame.add(OK);
		
		OK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ID = dto.getId();
				int money = dto.getMoney();
				int to = Integer.parseInt(PLUS.getText());
				int result = money+to;
				boolean a;
				a = db.DBModify(result, ID);
				if(a==true) {
					Frame.dispose();
				}
				else {
					JOptionPane.showInternalMessageDialog(null, "DB���� �Ұ�","DB���� �Ұ�.",JOptionPane.PLAIN_MESSAGE);
				}
			}			
		});
			
	}
}
