package controller;

import java.util.Map;

import dao.MemberDAO;
import service.BoardService;
import service.BookService;
import service.MemberService;
import util.ScanUtil;
import util.View;

public class Controller {

	MemberService memberService = MemberService.getInstance(); //MemberService.getInstance 는 new MemberService(); 같은 형식인거지만
//																MemberService는 여러번 선언해도 단 한번만 생성되어 하나만 쓰게된다. 
	BoardService boardService = BoardService.getInstance();
	BookService bookService = BookService.getInstance();
	static public boolean login = false; //관리자 로그인도 만들거니까 int형으로
	static public Map<String, Object> loginInfo=null; //로그인정보 저장해놓기
	
	public static void main(String[] args) {
		new Controller().start();
	}
	
	private void start() {
		int view = View.HOME; //view.home =  1;

		//팀장
		while(true) {
			switch(view) {
			//팀장
			case View.HOME : view =  home(); break;
			//멤버 담당 팀원
			case View.MEMBER_LOGIN : view = memberService.login(); break;
			case View.MEMBER_SIGNUP : view = memberService.signUp(); break;
			//보드 담당 팀원
			case View.BOOKASK_LIST : view = boardService.list(); break;
//			case View.BOOKASK_DETAIL : view = boardService.detail();break;
//			case View.BOOKASK_INSERT : view = boardService.insert();break;
//			case View.BOOKASK_UPDATE : view = boardService.update();break;
//			case View.BOOKASK_DELETE : view = boardService.delete();break;
			
			case View.BOOK_LIST : view = bookService.list(); break;
			case View.BOOK_LIST_CATEGORY : view = bookService.listCategory(); break;
			case View.BOOK_LIST_BEST10 : view = bookService.listbest10(); break;
			case View.BOOK_DETAIL : view = bookService.bookDetail(); break;
			}
		}
	}


	private int home() {
		System.out.println("========대덕인재개발원==========");
		System.out.println("\t1.로그인 2.회원가입 3.도서목록 보기");
		System.out.println("================================");
		System.out.println("번호 입력 >> ");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.MEMBER_LOGIN; //break가 없는 이유는 어차피 return이 있어서 return 만나면 메서드가 종료됨
		case 2 : return View.MEMBER_SIGNUP;
		case 3 : return View.BOOK_LIST;
		default : return View.HOME;
		}
	}
}
