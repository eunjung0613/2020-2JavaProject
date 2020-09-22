package GUI;
import java.sql.*;

public class DB {
	Connection conn = null;
	Statement stmt = null;

	public boolean DBInsert(String ID, String PW) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩
		}catch(ClassNotFoundException e) {
			System.err.print("ClassNotFindException: ");
			return false;
		}
		try {
			String url = "jdbc:mysql://localhost:3306/account_db?serverTimezone=UTC";
			String dbID="pm";
			String dbPassword="test123";
			conn = DriverManager.getConnection(url, dbID, dbPassword);
			stmt = conn.createStatement();
			System.out.println("제대로 연결됨."); // 성공시 화면에 출력
			String sql = "insert into account(id,pw) values ('"+ID+"',"+"'"+PW+"');";
			stmt.executeUpdate(sql);
			return true;
		}catch(SQLException e) {
			System.out.println("에러: "+e);
			return false;
		}
		finally {
			try {
				if(conn !=null && !conn.isClosed()) {
					conn.close();
				}
				if(stmt !=null&& !stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	public MemberDTO DBGetPW(String id) {
		MemberDTO dto = new MemberDTO();
		try {
			String dbid;
			String dbpw;
			int money;
			String url = "jdbc:mysql://localhost:3306/account_db?serverTimezone=UTC";
			String dbID="pm";
			String dbPassword="test123";
			PreparedStatement ps =null;
			ResultSet rs = null;
			
			conn = DriverManager.getConnection(url, dbID, dbPassword);
			stmt = conn.createStatement();
			System.out.println("제대로 연결됨."); // 성공시 화면에 출력
			String sql = "SELECT * FROM account_db.account where id='"+id+"';";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setMoney(rs.getInt("money"));
				dto.setAccount(rs.getInt("act"));
			}
			System.out.println(dto.getId()+" "+dto.getPw()+" "+dto.getAccount());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public boolean DBModify(int Money, String id) {
		try {
			String url = "jdbc:mysql://localhost:3306/account_db?serverTimezone=UTC";
			String dbID="pm";
			String dbPassword="test123";
			PreparedStatement ps =null;
			ResultSet rs = null;
			
			conn = DriverManager.getConnection(url, dbID, dbPassword);
			stmt = conn.createStatement();
			System.out.println("제대로 연결됨."); // 성공시 화면에 출력
			String sql = "update account set Money="+Money+" where id='"+id+"';";
			stmt.executeUpdate(sql);
			return true;
		}catch(SQLException e) {
			System.out.println("에러: "+e);
			return false;
		}
		finally {
			try {
				if(conn !=null && !conn.isClosed()) {
					conn.close();
				}
				if(stmt !=null&& !stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
	}
}
