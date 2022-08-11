package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDAO;
import util.ScanUtil;
import util.View;

public class MemberService { //싱글톤으로 관리 //비지니스 로직
	private static MemberService instance = null;
	private MemberService() {}
	public static MemberService getInstance() { //단 하나만 생성하게끔 만든거
		if(instance == null) instance = new MemberService();
		return instance;
	}
	
	MemberDAO dao = MemberDAO.getInstance();
	public int login() {
		System.out.println("----로그인-----");
		System.out.println("아이디 >> ");
		String id = ScanUtil.nextLine();
		System.out.println("비밀번호 >> ");
		String pass = ScanUtil.nextLine();
		Map<String, Object> row = dao.login(id, pass);
		if(row == null) {
			System.out.println("아이디가 없습니다.");
			return View.HOME;
		}else {
			Controller.login = true;
			System.out.println(row.get("MEM_NAME") + "님 환영합니다!");
			return View.BOOKASK_LIST;
		}
	}
	public int signUp() {
		System.out.println("-----회원가입------");
		System.out.println("아이디 >> ");
		String id = ScanUtil.nextLine();
		System.out.println("비밀번호 >> ");
		String pass = ScanUtil.nextLine();
		System.out.println("이름 >> ");
		String name = ScanUtil.nextLine();
		
		

		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(pass);
		param.add(name);
		
		int result = dao.signUp(param);
		System.out.println("가입이 완료되었습니다");
		return View.HOME;
	}
}
