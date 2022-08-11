package service;

import java.util.List;
import java.util.Map;

import dao.BoardDAO;
import util.ScanUtil;
import util.View;

public class BoardService {
	private static BoardService instance = null;
	private BoardService() {}
	public static BoardService getInstance() { //�� �ϳ��� �����ϰԲ� �����
		if(instance == null) instance = new BoardService();
		return instance;	
	}
	
	BoardDAO dao = BoardDAO.getInstance();
	public int list() {//��ȯŸ�� int�ΰ� View�� return�ҰŶ�
		System.out.println("----�Խ��� ���----");
		System.out.println("��ȣ\t����\t�ۼ���\t�ۼ�����");
		List<Map<String, Object>> list = dao.list();
							//int  list = ����Ʈ������ �����.
		for(Map<String, Object> item : list) {
			System.out.print(item.get("BOARD_NUMBER"));
			System.out.print("\t" + item.get("TITLE"));
			System.out.print("\t" + item.get("WRITER"));
			System.out.print("\t" + item.get("DATETIME"));
			System.out.println();
		}
		System.out.println("------------------------------------------");
		System.out.println("1.�� 2.��� 3.���� 4.���� 0.����");
		System.out.println("��ȣ ���� >> ");
		switch(ScanUtil.nextInt()) {
//		case 1: return View.BOARD_DETAIL;
//		case 2: return View.BOARD_INSERT;
//		case 3: return View.BOARD_UPDATE;
//		case 4: return View.BOARD_DELETE;
		default :
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			return View.HOME;
		}
	}
}
