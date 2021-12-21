package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DBDAO {
	// DAO -> DataBase Access Object
	// ������ ���̽��� �����ϱ����� ��ü�� ���� �� �ִ� Ŭ����
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);

	// ����̹� �ε��� Ŀ�ؼ� ��ü�� �������� �޼ҵ�
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_f_2_1209";
			String db_pw = "smhrd2";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// DataBase�� ������ �����ִ� �޼ҵ�
	private void close() {
		// 4. Java�� DataBase���� ������ �����ش�
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// �α��� ���
	public String login(String id, String pw) {
		
		getConnection();
		String nick = null;
		try {

			// 3. SQL�� �ۼ� �� ����
			String sql = "select * from account where id = ? and pw = ? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			
			
			
			if (rs.next()) {
				nick = rs.getString("nick");
			} 
			// select���� ���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return nick;
	}

	// ȸ�� ���� ����� �Ű� �ּ���
	// �޼ҵ� �̸� -> join
	public int join(String id, String pw, String nick) {
		
		MemberDTO m = new MemberDTO(id, pw, nick);
		ArrayList<MemberDTO> list = selectAll(); //�ؿ��ִ� selectall �޼ҵ� ��������

		getConnection();
		int cnt = 0;

		try {

			// 3. SQL�� �ۼ� �� ����
			String sql = "insert into account values(account_seq.nextval, ?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);
			
			boolean isCheck = true; //������ �ְ� Ʈ�簪�� �ش�.
			
			for(int i = 0; i < list.size(); i++) { //�г��� �ϳ��� Ȯ���ϴ°�
				if(list.get(i).getNick().equals(nick)) {
					isCheck = false; //�ϳ��� �ߺ��� ������ false�� ��ȯ
				}					//�ߺ��� ������ isCheck�� true
			}
			if(isCheck) { //isCheck�� Ʈ���� 
				cnt = psmt.executeUpdate(); //cnt���� ����
			}
			
			
//			if(!m.getNick().equals(nick)) { //�ߺ��� �ƴϸ� cnt���� ����
//				cnt = psmt.executeUpdate();
//			}else {  //�ߺ��̸� cnt�� 0
//				cnt = 0;
//			}
			
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// ȸ�� ���� ���� update
	public int update(String inputNick, String id, String pw) {

		getConnection();
		int cnt = 0;

		try {

			// 3. sql �� �ۼ� �� ����
			String sql = "update account set nick = ? where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, inputNick);
			psmt.setString(2, id);
			psmt.setString(3, pw);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}
		return cnt;
	}

	public ArrayList<MemberDTO> selectAll() {

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		getConnection();

		try {
			String sql = "select * from account";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {

				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				MemberDTO m = new MemberDTO(id, pw, nick);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int delete(String id, String pw) {

		getConnection();
		int cnt = 0;
		try {
			String sql = "delete from account where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int adminUpdate(String change_id, String change_nick) {
		getConnection();
		int cnt = 0;

		try {

			// 3. sql �� �ۼ� �� ����
			String sql = "update account set nick = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, change_nick);
			psmt.setString(2, change_id);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}
		return cnt;
	
	}

	public int deleteId(String removeId) {
		getConnection();
		int cnt = 0;
		
		try {
			String sql = "delete from account where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, removeId);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			close();
		}
		
		return cnt;
	}
	
	
	public int ranking(String nick, String name, String month) {
		getConnection();
		
		try {
			String sql = "insert into ranking values(ranking_seq.nextval, ? , ? ,? )";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nick);
			psmt.setString(2, name);
			psmt.setString(3, month);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		
		
		
		return 0;
		
		
	}
	
	
//	boolean overCheck(String a) { // �ʿ��������
//		boolean flag = false;
//		getConnection();
//		
//		
//		try {
//			String sql = "select from ss where id = ?";
//			psmt.setString(1, a);
//			rs = psmt.executeQuery(sql);
//			int cnt = 0;
//			while(rs.next()) {
//				if(!"id".equals(rs.getString("id"))) {
//					flag = true;
//				} else {
//					flag = false;
//				} cnt++;
//			}
//			System.out.println("[Server] �ߺ� Ȯ�� ����");
//		} catch(Exception e) {
//			System.out.println("[Server] �ߺ� Ȯ�� ���� > " + e.toString());
//		} finally {
//			close();
//		}
//	return flag;
//	} 

}
// delete from ���̺�� where ����

//JDBC
// 0.JDBC�� ����ϴ� ������Ʈ�� Driver ���ϳֱ�
// 1.Driver �ε� (Oracle Driver) -> �����ε�
// ���� ����ϴ� DBMS�� ����̹� �ε�

// 2.Connection ����
// Connection�� �����ϱ� ���ؼ���
// DB�� ���Ӱ����� url, id, pw�� �ʿ��ϴ�

//update ���̺�� set �÷��� = �ٲٰ� ���� �� where ����
// executeQuery -> ���̺� �����Ͱ� ���� ������
// ResultSet �� ��ȯ
// executeUpdate -> ���̺��� ������ ����ɶ�
// int Ÿ������ ��ȯ! -> ����� sql ���� ��
// 4. finally
// conn ��ü, psmt, rs
// �ݾ��ִ� ���� -> re -> psmt -> conn

// id -> pbk �� ȸ���� �г�����
// 'ŷ����' ���� �ٲپ� �ּ���!