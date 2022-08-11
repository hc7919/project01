package util;

public interface View {
	int HOME = 1; //static final int HOME
	
	//뷰 정의 할 줄 알아야함
	
	//로그인시 회원 OR 비회원 선택
	///초안
	
//------------------------------------------------------------
	//진영
	
	//멤버 담당 팀원
	//회원가입 페이지와 로그인 전부
	int MEMBER = 2;
	int MEMBER_SIGNUP = 21; //회원가입
	int MEMBER_LOGIN = 22;	//로그인
	
	//좋아요
	int LIKE = 8;
	int LIKE_INSERT =81;
	int LIKE_DELETE =82;
//	------------------------------------------------------------
	//진호
	//도서 목록 담당
	int BOOK = 4;
	int BOOK_LIST = 41; //제목 가격 작가 평점 //1차 완료
	int BOOK_LIST_CATEGORY = 42;//1차완료
	int BOOK_LIST_BEST10 = 43;//1차완료
	
	//제일 나중? ㄴㄴ 지금해보자
	//우선 리스트를 보여주고 거기서 입력받는 수를 셀렉트 쿼리에 맞춰 넣자.
	
	int BOOK_DETAIL = 44; //디테일에 좋아요 수, 리뷰, 줄거리 
	
	//관리자용 -> 로그인 정보를 확인해서 관리자 로그인이 확인되었을 경우에만 가능하도록.
	int BOOK_INSERT = 45;
	int BOOK_DELETE = 46;
	int BOOK_UPDATE = 47;
	
//	------------------------------------------------------------
	//서영
	//도서 요청 게시판 담당 
	int BOOKASK = 3;
	int BOOKASK_LIST = 31;
	int BOOKASK_DETAIL = 32;
	int BOOKASK_INSERT = 33;
	int BOOKASK_UPDATE = 34;
	int BOOKASK_DELETE = 35;
	
	//리뷰 게시판
	int REVIEW = 5;
	int REVIEW_INSERT = 51;
	int REVIEW_DELETE = 52;
	int REVIEW_UPDATE = 53;
	
//	------------------------------------------------------------
	//재일
	//주문서 
	int ORDER = 6;
	int ORDER_INSERT = 61;
	int ORDER_DELETE = 62;
	
	//장바구니
	int CART = 7;
	int CART_INSERT = 71;
	int CART_DELETE = 72;
	
	
	
	
}
