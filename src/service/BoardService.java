package service;

import java.util.List;
import java.util.Map;

import dao.BoardDAO;
import util.ScanUtil;
import util.View;

public class BoardService {
	private static BoardService instance = null;
	private BoardService() {}
	public static BoardService getInstance() { //단 하나만 생성하게끔 만든거
		if(instance == null) instance = new BoardService();
		return instance;	
	}
	
	BoardDAO dao = BoardDAO.getInstance();
	public int list() {//반환타입 int인건 View를 return할거라서
		System.out.println("----게시판 목록----");
		System.out.println("번호\t제목\t작성자\t작성일자");
		List<Map<String, Object>> list = dao.list();
							//int  list = 셀렉트쿼리의 결과값.
		for(Map<String, Object> item : list) {
			System.out.print(item.get("BOARD_NUMBER"));
			System.out.print("\t" + item.get("TITLE"));
			System.out.print("\t" + item.get("WRITER"));
			System.out.print("\t" + item.get("DATETIME"));
			System.out.println();
		}
		System.out.println("------------------------------------------");
		System.out.println("1.상세 2.등록 3.수정 4.삭제 0.종료");
		System.out.println("번호 선택 >> ");
		switch(ScanUtil.nextInt()) {
//		case 1: return View.BOARD_DETAIL;
//		case 2: return View.BOARD_INSERT;
//		case 3: return View.BOARD_UPDATE;
//		case 4: return View.BOARD_DELETE;
		default :
			System.out.println("잘못 입력하셨습니다.");
			return View.HOME;
		}
	}
}
