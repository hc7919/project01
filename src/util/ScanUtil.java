package util;

import java.util.Scanner;

public class ScanUtil {
	//��ĳ�ʸ� �ս��� ����� �� �ִ� static �޼��带 ������ ����.
	static Scanner sc = new Scanner(System.in); //static �߰�
	
	public static String nextLine() {
		return sc.nextLine(); //static �޼��忡���� static�� �����ֱ⶧���� ��ĳ�ʿ� static �߰��ؾ���
	}
	public static int nextInt() {
		return Integer.parseInt(sc.nextLine());
	}
}
