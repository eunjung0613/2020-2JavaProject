package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javax.swing.*;

public class remittance extends JFrame{
	public remittance(String ID) {
		DB db = new DB();
		MemberDTO dto = db.DBGetPW(ID);
		int Account = dto.getAccount();
		
		JFrame Frame = new JFrame("�۱�������");
		JLabel Acount = new JLabel("���� ����: "+Account);
		JLabel Mon = new JLabel("�۱��� �ݾ� : ");
		JTextField Monney = new JTextField();
		JLabel TO = new JLabel("�۱��� ID: ");
		JTextField Ant = new JTextField();
		JButton OK = new JButton("�۱� ����");
		
		Frame.setLayout(null);
		Frame.setBounds(200, 100, 300, 300);
		Frame.setVisible(true);
		
		Acount.setBounds(10, 5, 230, 30);
		Mon.setBounds(10, 45, 80, 30);
		Monney.setBounds(90, 45, 180, 30);
		TO.setBounds(10, 85, 80, 30);
		Ant.setBounds(90, 85, 180, 30);
		OK.setBounds(80, 155, 100, 50);
		
		Frame.add(Acount);
		Frame.add(Mon);
		Frame.add(Monney);
		Frame.add(TO);
		Frame.add(Ant);
		Frame.add(OK);
		
		OK.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ID = dto.getId();
				int money = dto.getMoney();
				int to = Integer.parseInt(Monney.getText());
				int result = money-to;
				boolean a,b;
				String AID = Ant.getText();
				MemberDTO dto2 = db.DBGetPW(AID);
				int money2 = dto2.getMoney();
				int result2 = money2+to;
				a = db.DBModify(result, ID);
				b = db.DBModify(result2, AID);
				if(result<0) {
					JOptionPane.showInternalMessageDialog(null, "�۱��ϱ⿡�� �ݾ��� �����մϴ�.","�ݾ� ����",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					if(a==true && b==true) {
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
