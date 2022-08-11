package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDAO;
import util.ScanUtil;
import util.View;

public class MemberService { //�̱������� ���� //�����Ͻ� ����
	private static MemberService instance = null;
	private MemberService() {}
	public static MemberService getInstance() { //�� �ϳ��� �����ϰԲ� �����
		if(instance == null) instance = new MemberService();
		return instance;
	}
	
	MemberDAO dao = MemberDAO.getInstance();
	public int login() {
		System.out.println("----�α���-----");
		System.out.println("���̵� >> ");
		String id = ScanUtil.nextLine();
		System.out.println("��й�ȣ >> ");
		String pass = ScanUtil.nextLine();
		Map<String, Object> row = dao.login(id, pass);
		if(row == null) {
			System.out.println("���̵� �����ϴ�.");
			return View.HOME;
		}else {
			Controller.login = true;
			System.out.println(row.get("MEM_NAME") + "�� ȯ���մϴ�!");
			return View.BOOKASK_LIST;
		}
	}
	public int signUp() {
		System.out.println("-----ȸ������------");
		System.out.println("���̵� >> ");
		String id = ScanUtil.nextLine();
		System.out.println("��й�ȣ >> ");
		String pass = ScanUtil.nextLine();
		System.out.println("�̸� >> ");
		String name = ScanUtil.nextLine();
		
		

		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(pass);
		param.add(name);
		
		int result = dao.signUp(param);
		System.out.println("������ �Ϸ�Ǿ����ϴ�");
		return View.HOME;
	}
}
