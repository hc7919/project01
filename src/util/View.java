package util;

public interface View {
	int HOME = 1; //static final int HOME
	
	//�� ���� �� �� �˾ƾ���
	
	//�α��ν� ȸ�� OR ��ȸ�� ����
	///�ʾ�
	
//------------------------------------------------------------
	//����
	
	//��� ��� ����
	//ȸ������ �������� �α��� ����
	int MEMBER = 2;
	int MEMBER_SIGNUP = 21; //ȸ������
	int MEMBER_LOGIN = 22;	//�α���
	
	//���ƿ�
	int LIKE = 8;
	int LIKE_INSERT =81;
	int LIKE_DELETE =82;
//	------------------------------------------------------------
	//��ȣ
	//���� ��� ���
	int BOOK = 4;
	int BOOK_LIST = 41; //���� ���� �۰� ���� //1�� �Ϸ�
	int BOOK_LIST_CATEGORY = 42;//1���Ϸ�
	int BOOK_LIST_BEST10 = 43;//1���Ϸ�
	
	//���� ����? ���� �����غ���
	//�켱 ����Ʈ�� �����ְ� �ű⼭ �Է¹޴� ���� ����Ʈ ������ ���� ����.
	
	int BOOK_DETAIL = 44; //�����Ͽ� ���ƿ� ��, ����, �ٰŸ� 
	
	//�����ڿ� -> �α��� ������ Ȯ���ؼ� ������ �α����� Ȯ�εǾ��� ��쿡�� �����ϵ���.
	int BOOK_INSERT = 45;
	int BOOK_DELETE = 46;
	int BOOK_UPDATE = 47;
	
//	------------------------------------------------------------
	//����
	//���� ��û �Խ��� ��� 
	int BOOKASK = 3;
	int BOOKASK_LIST = 31;
	int BOOKASK_DETAIL = 32;
	int BOOKASK_INSERT = 33;
	int BOOKASK_UPDATE = 34;
	int BOOKASK_DELETE = 35;
	
	//���� �Խ���
	int REVIEW = 5;
	int REVIEW_INSERT = 51;
	int REVIEW_DELETE = 52;
	int REVIEW_UPDATE = 53;
	
//	------------------------------------------------------------
	//����
	//�ֹ��� 
	int ORDER = 6;
	int ORDER_INSERT = 61;
	int ORDER_DELETE = 62;
	
	//��ٱ���
	int CART = 7;
	int CART_INSERT = 71;
	int CART_DELETE = 72;
	
	
	
	
}
