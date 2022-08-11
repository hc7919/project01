package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDAO {
	private static BoardDAO instance = null;
	private BoardDAO() {}
	public static BoardDAO getInstance() { //단 하나만 생성하게끔 만든거
		if(instance == null) instance = new BoardDAO();
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance() ;
	
	public List<Map<String, Object>> list(){
		return jdbc.selectList("SELECT * FROM JAVA_BOARD ORDER BY BOARD_NUMBER ASC");
	}
	
}
