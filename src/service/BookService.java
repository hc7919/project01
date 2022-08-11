package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.BookDAO;
import util.ScanUtil;
import util.View;

public class BookService {
	private static BookService instance = null;
	private BookService() {}
	public static BookService getInstance() {
		if(instance == null) instance = new BookService();
		return instance;
	}
	
	BookDAO dao = BookDAO.getInstance();
	public int list() {
		
		
		System.out.println("------���� ���------");
		System.out.println("��ȣ\t\t��������\t\t\t�۰���\t����\t����");
		List<Map<String, Object>> list = dao.list();
		for(Map<String, Object> item : list) {
			System.out.print(item.get("BOOK_NO"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_NAME"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_WRITER"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_PRICE"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_SCOREAVG"));
			System.out.println();
		}
		System.out.println("----------------------------");
		System.out.println("1.���� �󼼺��� 2.�帣���� ���� 3.����Ʈ10");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_DETAIL;
		case 2 : return View.BOOK_LIST_CATEGORY;
		case 3 : return View.BOOK_LIST_BEST10;
		case 4 : default : return View.HOME;
		
		
			
		}
		
		
	}
	public int listCategory() {
		List<Object> param = new ArrayList();
		System.out.println("-----------�帣 ����------------");
		System.out.println("1.�� 2.������ 3.�Ҽ�");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:  param.add("��"); break;
		case 2:  param.add("������"); break;
		case 3:  param.add("�Ҽ�"); break;
		}
		
		
		List<Map<String, Object>> listCategory = dao.listCategory(param);
		for(Map<String, Object> item : listCategory) {
			System.out.print(item.get("BOOK_NO"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_NAME"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_WRITER"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_PRICE"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_SCOREAVG"));
			System.out.println();
		}
		System.out.println("----------------------------");
		System.out.println("1.���� �󼼺��� 2.�帣���� ���� 3. ����ȭ��");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_DETAIL;
		case 2 : return View.BOOK_LIST_CATEGORY;
		case 3 : default : return View.HOME;
		}
	}
	public int listbest10() {
		System.out.println("-----------BEST TOP10------------");
		System.out.println("��ȣ\t\t��������\t\t\t�۰���\t����\t�Ǹż���");
		List<Map<String, Object>> listBest10 = dao.listBest10();
		for(Map<String, Object> item : listBest10 ) {
			System.out.print(item.get("BOOK_NO"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_NAME"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_WRITER"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_PRICE"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_RANK"));
			System.out.println();
		}
		System.out.println("---------------------------------");
		System.out.println("1.���� ȭ������ ���ư��� 2. Ȩ ȭ������ ���ư���");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_LIST;
		case 2 : return View.HOME;
		}
		return 0;
	}
	public int bookDetail() {
		List<Object> param = new ArrayList();
		System.out.println("���� ��ȣ�� �Է����ּ��� >> ");
		param.add(ScanUtil.nextLine());
		System.out.println("---------���� ������---------");
		System.out.println("��ȣ\t\t��������\t\t�۰���\t����\t����\t�Ǹż���\t���ƿ� ��\t����");
		List<Map<String, Object>> bookDetail = dao.bookDetail(param);
		for(Map<String, Object> item : bookDetail) {
			System.out.print(item.get("BOOK_NO"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_NAME"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_WRITER"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_PRICE"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_SCOREAVG"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_RANK"));
			System.out.print("\t\t");
			System.out.print(item.get("BOOK_LIKE"));
			System.out.print("\t");
			System.out.print(item.get("BOOK_CONTENT"));
			System.out.println();
		}
		System.out.println("---------------------------------");
		System.out.println("1.���� ȭ������ ���ư��� 2. Ȩ ȭ������ ���ư���");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_LIST;
		case 2 : return View.HOME;
		}
		return 0;
	}
}
