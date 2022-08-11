package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BookDAO {
	private static BookDAO instance = null;
	private BookDAO() {}
	public static BookDAO getInstance(){
		if(instance == null) instance = new BookDAO();
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	public List<Map<String, Object>> list(){
		return jdbc.selectList("SELECT * FROM BOOK ORDER BY 1");
	}
	public List<Map<String, Object>> listBest10(){
		return jdbc.selectList("SELECT * FROM BOOK ORDER BY 10");
	}
	public List<Map<String, Object>> listCategory(List<Object> param) {
		return jdbc.selectList("SELECT * FROM BOOK WHERE BOOK_GENRE = ?", param);
	}
	public List<Map<String, Object>> bookDetail(List<Object> param) {
		return jdbc.selectList("SELECT * FROM BOOK WHERE BOOK_NO = ?", param);
	}
	
	
	
}
