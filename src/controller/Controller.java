package controller;

import java.util.Map;

import dao.MemberDAO;
import service.BoardService;
import service.BookService;
import service.MemberService;
import util.ScanUtil;
import util.View;

public class Controller {

	MemberService memberService = MemberService.getInstance(); //MemberService.getInstance �� new MemberService(); ���� �����ΰ�����
//																MemberService�� ������ �����ص� �� �ѹ��� �����Ǿ� �ϳ��� ���Եȴ�. 
	BoardService boardService = BoardService.getInstance();
	BookService bookService = BookService.getInstance();
	static public boolean login = false; //������ �α��ε� ����Ŵϱ� int������
	static public Map<String, Object> loginInfo=null; //�α������� �����س���
	
	public static void main(String[] args) {
		new Controller().start();
	}
	
	private void start() {
		int view = View.HOME; //view.home =  1;

		//����
		while(true) {
			switch(view) {
			//����
			case View.HOME : view =  home(); break;
			//��� ��� ����
			case View.MEMBER_LOGIN : view = memberService.login(); break;
			case View.MEMBER_SIGNUP : view = memberService.signUp(); break;
			//���� ��� ����
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
		System.out.println("========������簳�߿�==========");
		System.out.println("\t1.�α��� 2.ȸ������ 3.������� ����");
		System.out.println("================================");
		System.out.println("��ȣ �Է� >> ");
		switch(ScanUtil.nextInt()) {
		case 1 : return View.MEMBER_LOGIN; //break�� ���� ������ ������ return�� �־ return ������ �޼��尡 �����
		case 2 : return View.MEMBER_SIGNUP;
		case 3 : return View.BOOK_LIST;
		default : return View.HOME;
		}
	}
}
