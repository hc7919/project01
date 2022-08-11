package util;

import java.util.Scanner;

public class ScanUtil {
	//스캐너를 손쉽게 사용할 수 있는 static 메서드를 가지고 있음.
	static Scanner sc = new Scanner(System.in); //static 추가
	
	public static String nextLine() {
		return sc.nextLine(); //static 메서드에서는 static만 쓸수있기때문에 스캐너에 static 추가해야함
	}
	public static int nextInt() {
		return Integer.parseInt(sc.nextLine());
	}
}
