package removier.mvc.view;



import removier.mvc.controller.MovieController;
import removier.mvc.controller.NoticeController;

import removier.mvc.controller.AdminController;


import removier.mvc.controller.UserController;



import removier.mvc.dto.Admin;
import removier.mvc.dto.Notice;
import removier.mvc.dto.User;
import removier.mvc.util.PhoneNumberConvertor;
import removier.mvc.util.ViewUtil;

import java.util.Scanner;


public class MenuView {
    static Scanner sc = new Scanner(System.in);


    /**
     * 시작 메뉴 : 회원가입, 로그인, 프로그램 종료
     * */
    public static void menu() {
        while (true) {

            MenuView.printMenu();

            int menu = Integer.parseInt(ViewUtil.input("번호를 입력하세요 > "));
            switch (menu) {
                case 1:

                    MenuView.register(); // 가입
                    break;
                case 2:
                    User requestLoginUser = MenuView.login();
                        UserController.login(requestLoginUser);// 로그인

                    break;
                case 7:
                    MenuView.adminLogin();// 관리자 로그인
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    /**
     * 화면이 시작되서 메뉴를 출력한다.
     * */
    public static void printMenu() {

        ViewUtil.printMessage(ViewConst.banner);

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        ViewUtil.printMessage("     1. 가입   |   2. 로그인   |  9. 종료");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }


    /**
     * 회원 가입 : 정보를 제공받아서 User 객체를 db에 등록한다.
     */
    private static void register() {
        String registerId = ViewUtil.input("아이디 > ");
        String registerPw = ViewUtil.input("비밀번호 > ");
        String registerName = ViewUtil.input("이름 > ");

        String registerPhone;
        do {
            registerPhone = ViewUtil.input("휴대폰 > ");
        } while (!PhoneNumberConvertor.supports(registerPhone));

        registerPhone = PhoneNumberConvertor.convert(registerPhone);

        String registerFG = ViewUtil.input("=== 멜로, 코미디, 애니메이션, 액션 ===\r\n"
                + "=== 스릴러, 미스터리, 공포, 공상과학, 판타지 ===\r\n"
                + "선호 장르 > ");
        String registerFA = ViewUtil.input("최애 배우 > ");

        User user = new User(0, registerName, registerId, registerPw, 1, registerPhone, registerFG, registerFA);

        UserController.signUp(user);
    }

    /**
     * 로그인 메뉴 : id & password 를 입력받는다.
     */
    public static User login() {

        String logingId = ViewUtil.input("아이디 > ");
        String password = ViewUtil.input("비밀번호 > ");

        User user = new User(logingId, password);


        return user;

    }

    /**
     * 관리자 로그인 : 관리자 id , password 를 입력받는다.
     * */
    public static void adminLogin(){
        System.out.println("==========[관리자 로그인]==========");
        String logingId = ViewUtil.input("관리자 아이디 ▷ ");
        String password = ViewUtil.input("관리자 비밀번호 ▷ ");

        Admin admin = new Admin(logingId, password);

        AdminController.login(admin);
    }

    /**
     * 관리장 계정 로그인
     * @param : admin 을 객체로 받는다.
     * */
    public static void printAdminMenu(Admin admin) {

        while (true) {
            ViewUtil.newLine();
            ViewUtil.printMessage(ViewConst.adminBanner);
            ViewUtil.printMessageNo(ViewConst.printAdminMenu1);
            ViewUtil.printMessageNo("┃　　　　　　                                 관리자 " + admin.getLogingId() + " 님 로그인 중                                            ┃ ");
            ViewUtil.printMessageNo(ViewConst.getPrintAdminMenu2);
            int menu = Integer.parseInt(ViewUtil.input("번호를 입력하세요 > "));
            switch (menu) {
                case 1:
                    AdminController.userSelectAll();
                    break;
                case 2:
                    inputInsertNotice();
                    break;
                case 3:
                    inputUpdateNotice();
                    break;
                case 4:
                    inputDeleteNotice();
                    break;
                case 5:
                    NoticeController.noticeSelectByAll();
                    break;
                case 9:
                    return;
            }
        }

    }


    /**
     * user 가 로그인 한 후 My page 를 조회한다.
     * */
    private static int showMyPage() {
    	User loginUser = UserController.updatedUserInfo(UserController.getLoginUser());
    	while(true) {
    		int menu = Integer.parseInt(
    			ViewUtil.input("\n===" + loginUser.getLogingId() + "님의 My Page ===\n" 
    				+ "[id] " + loginUser.getLogingId() + "\n"
    				+ "[이름] " + loginUser.getMember_name() + "\n"
    				+ "[나의 최애 배우] " + loginUser.getFavourite_actor() + "\n"
    				+ "[나의 선호 영화 장르] " + loginUser.getFavourite_genre() + "\n"
    				+ "[연락처] " + loginUser.getPhone() + "\n\n\n"
    				+ "======= 1. 회원정보 수정 2. 내가 작성한 리뷰(" + loginUser.getReviews().size() + ") 3.즐겨찾기 영화 4. 메인으로 ======\n"
    				+ "번호를 입력하세요 ▷ "
    			)		
    		); 
    	
    		switch(menu) {
				case 1 :
			        String updatePw = ViewUtil.input("변경하실 비밀번호 ▷ ");
			        String updateName = ViewUtil.input("변경하실 이름 ▷ ");
					String updateFA = ViewUtil.input("변경하실 최애 배우 ▷ ");
					String updateFG = ViewUtil.input("=== 멜로, 코미디, 애니메이션, 액션 ===\r\n"
                            + "=== 스릴러, 미스터리, 공포, 공상과학, 판타지 ===\r\n"
                            + "선호 장르 > ");
                    String registerPhone;
                    do {
                        registerPhone = ViewUtil.input("휴대폰 > ");
                    } while (!PhoneNumberConvertor.supports(registerPhone));

                    registerPhone = PhoneNumberConvertor.convert(registerPhone);
					
					loginUser = new User(loginUser.getMember_pk(), updateName, loginUser.getLogingId(), updatePw, 1, registerPhone, updateFG, updateFA);
					
					UserController.updateUserInfo(loginUser);
                    loginUser = UserController.updatedUserInfo(loginUser);
                    return 1;
//					break;
					
				case 2 :
                    ViewUtil.printMessage("\n┏━━━━━━ 내가 작성한 리뷰 ━━━━━━┓");
                    UserController.getMyReview(loginUser);

					break;
					
				case 3 :
					UserController.selectBookmarkByUser(loginUser);
					break;
					
				case 4 :
					return 0;
				}
    	}
	}





    /**
     * 로그아웃 : user 가 로그아웃을 진행한다.
     */
    public static void logout(User loginUser) {
        UserController.logout(loginUser);
    }

    /**
     * 유저 메뉴를 출력한다
     * @param : 로그인할때 얻어온 User 객체를 받는다.
     * */

    public static void printUserMenu(User user) {
        while (true) {

            ViewUtil.newLine();
            ViewUtil.printMessage(" ▣ " + user.getLogingId() + " 로그인 중 ");
            ViewUtil.printMessage(ViewConst.printUserMenu);
            MovieController.showBestMyGenreMovie(user);
            int menu = Integer.parseInt(ViewUtil.input("번호를 입력하세요 ▷ "));
            ViewUtil.newLine();
            switch (menu) {
                case 1:
                    MovieController.movieTopFive();
                    break;
                case 2:
                    SearchMovieView.searchMovie(user);
                    break;
                case 3:// 공지사항
                    NoticeController.noticeSelectByAll();
                    break;
                case 4:
                    if(showMyPage()==0){
                        break;
                    } else {
                        return;
                    }
                case 5:
                    logout(user);
                    return;

            }
        }

    }

    /**
     * 관리자 > 공지사항 - 등록, 수정, 삭제
     */

    /*공지사항 등록*/
    public static void inputInsertNotice() {
        ViewUtil.printMessage("공지사항 등록해주세요.\n");

        String notice_title = ViewUtil.input("제목 : ");

        String notice_content = ViewUtil.input("내용 : ");

        Notice notice = new Notice(0, notice_title, notice_content, null);
        NoticeController.noticeInsert(notice);
    }

    /**
     * 공지사항 수정
     * */
    public static void inputUpdateNotice() {
        ViewUtil.printMessage("공지사항 수정해주세요.\n");

        int no = Integer.parseInt(ViewUtil.input("수정 게시물 번호 ▷ "));

        String notice_content = ViewUtil.input("수정 내용 : ");

        Notice notice = new Notice(no, null, notice_content, null);
        NoticeController.noticeUpdate(notice);
    }

    /**
     * 공지사항 삭제
     * */
    public static void inputDeleteNotice() {
        int notice_pk = Integer.parseInt(ViewUtil.input("삭제 게시물 번호 ▷ "));
        NoticeController.noticeDelete(notice_pk);
    }


}
