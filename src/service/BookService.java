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
		
		
		System.out.println("------도서 목록------");
		System.out.println("번호\t\t도서제목\t\t\t작가명\t가격\t평점");
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
		System.out.println("1.도서 상세보기 2.장르별로 보기 3.베스트10");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_DETAIL;
		case 2 : return View.BOOK_LIST_CATEGORY;
		case 3 : return View.BOOK_LIST_BEST10;
		case 4 : default : return View.HOME;
		
		
			
		}
		
		
	}
	public int listCategory() {
		List<Object> param = new ArrayList();
		System.out.println("-----------장르 선택------------");
		System.out.println("1.시 2.에세이 3.소설");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:  param.add("시"); break;
		case 2:  param.add("에세이"); break;
		case 3:  param.add("소설"); break;
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
		System.out.println("1.도서 상세보기 2.장르별로 보기 3. 이전화면");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_DETAIL;
		case 2 : return View.BOOK_LIST_CATEGORY;
		case 3 : default : return View.HOME;
		}
	}
	public int listbest10() {
		System.out.println("-----------BEST TOP10------------");
		System.out.println("번호\t\t도서제목\t\t\t작가명\t가격\t판매순위");
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
		System.out.println("1.이전 화면으로 돌아가기 2. 홈 화면으로 돌아가기");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_LIST;
		case 2 : return View.HOME;
		}
		return 0;
	}
	public int bookDetail() {
		List<Object> param = new ArrayList();
		System.out.println("도서 번호를 입력해주세요 >> ");
		param.add(ScanUtil.nextLine());
		System.out.println("---------도서 상세정보---------");
		System.out.println("번호\t\t도서제목\t\t작가명\t가격\t평점\t판매순위\t좋아요 수\t내용");
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
		System.out.println("1.이전 화면으로 돌아가기 2. 홈 화면으로 돌아가기");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.BOOK_LIST;
		case 2 : return View.HOME;
		}
		return 0;
	}
}
