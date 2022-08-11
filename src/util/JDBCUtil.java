package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	/*
	 * JDBC를 좀 더 쉬고 편하게 사용하기 위한 Utility 클래스
	 * 
	 * Map<String, Object> selectOne(String sql) //row 하나
	 * Map<String, Object> selectOne(String sql, List<Object> param)
	 * List<Map<String,Object>> selectList(String sql) //row를 여러개 갖는 리스트
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * int update(String sql)
	 * int update(String sql, List<Object> param)
	 */
	
	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	
	//인스턴스를 보관할 변수
	private static JDBCUtil instance = null;
	//private으로 제한해서 아무도 JDBCUtil 객체를 만들 수 없게함.(인스턴스화 할 수 없게)
	private JDBCUtil() {} 
	public static JDBCUtil getInstance() { //static = 객체를 생성하지 않고도 인스턴스를 사용할수있게함.
		if(instance == null) instance = new JDBCUtil();
		return instance;
	} //싱글톤은 항상 이 모양.
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String user = "PROJECT01_JH01";
	String password = "java";
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		//sql => "SELECT * FROM MEMBER WHERE MEM_ADD1 LIKE '%'||?||'%'"
		//sql => "SELECT * FROM JAVA_BOARD WHERE WRITER = ?"
		//sql => "SELECT * FROM JAVA_BOARD WHERE BOARD_NUM > ?"
		List<Map<String, Object>> result = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			//이때 실행. ps 만들어지고 쿼리 전.
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				if(result == null) result = new ArrayList<>();
				Map<String, Object> row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(key, value);
				}
				result.add(row);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try { rs.close(); } catch(Exception e) {}
			if(ps != null)try { ps.close(); } catch(Exception e) {}
			if(conn != null)try { conn.close(); } catch(Exception e) {}
		}
		return result;
	}
	public List<Map<String, Object>> selectList(String sql){
		//sql => "SELECT * FROM MEMBER"
		//sql => "SELECT * FROM JAVA_BOARD"
		//sql => "SELECT * FROM JAVA_BOARD WHERE BOARD_NUM > 10"
		List<Map<String, Object>> result = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				if(result == null) result = new ArrayList<>();
				Map<String, Object> row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(key, value);
				}
				result.add(row);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try { rs.close(); } catch(Exception e) {}
			if(ps != null)try { ps.close(); } catch(Exception e) {}
			if(conn != null)try { conn.close(); } catch(Exception e) {}
		}
		return result;
	}
	public int update(String sql, List<Object> param ) {
		///?가 없는 sql
				//sql = > "DELETE FROM JAVA_BOARD WHERE BOARD_NUMBER =?"
				//sql => "UPDATE JAVA_BOARD SET TITLE = '하하' WHERE BOARD_NUMBER = ?" 
				//sql => "INSERT MY_MEMBER(MEM_ID, MEM_PASS, MEM_NAME) VALUES(?,?,?)"
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch (Exception e) {}
			if(ps != null) try { rs.close(); } catch (Exception e) {}
			if(rs != null) try { rs.close(); } catch (Exception e) {}
		}
		return result;
	}
	public int update(String sql) {
		///?가 없는 sql
		//sql = > "DELETE FROM JAVA_BOARD"
		//sql => "UPDATE JAVA_BOARD SET TITLE = '하하' WHERE BOARD_NUMBER = 1" 
		//sql => "INSERT MY_MEMBER(MEM_ID, MEM_PASS, MEM_NAME) VALUES('admin','1234','홍길동')"
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try { rs.close(); } catch (Exception e) {}
				if(ps != null) try { rs.close(); } catch (Exception e) {}
				if(rs != null) try { rs.close(); } catch (Exception e) {}
		}
		return result;
	}
	
	//같은 이름 메소드 2개. 오버로딩
	public Map<String, Object> selectOne(String sql, List<Object> param){
		//sql => "SELECT *FROM JAVA_BOARD WHERE BOARD_NUMBER=?"
		//param => [1]
		
		//sql => "SELECT *FROM JAVA_BOARD WHERE WRITER =? AND TITLE=?"
		//param => ["홍길동", "안녕"]
		
		Map<String, Object> row = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					//getColumnName vs getColumnLabel
					//getColumnName : 원본 컬럼명을 가져옴
					//getColumnLabel : as로 선언된 별명을 가져옴, 없으면 
					Object value = rs.getObject(i);
					row.put(key, value);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch (Exception e) {}
			if(ps != null) try { rs.close(); } catch (Exception e) {}
			if(rs != null) try { rs.close(); } catch (Exception e) {}
		}
		
		return row;
	}
	public Map<String, Object> selectOne(String sql){
		//sql => "SELECT * FROM JAVA_BOARD
//				  WHERE BOARD_NUMBER=(SELECT MAX(BOARD_NUMBER) FROM JAVA_BOARD)"
		//sql => "SELECT * FROM MEMBER MEM_ID = 'a001' AND MEM_PASS='123'" //로그인
		Map<String, Object> row = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					//getColumnName vs getColumnLabel
					//getColumnName : 원본 컬럼명을 가져옴
					//getColumnLabel : as로 선언된 별명을 가져옴, 없으면 
					Object value = rs.getObject(i);
					row.put(key, value);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch (Exception e) {}
			if(ps != null) try { rs.close(); } catch (Exception e) {}
			if(rs != null) try { rs.close(); } catch (Exception e) {}
		}
		
		return row;
	}
}
