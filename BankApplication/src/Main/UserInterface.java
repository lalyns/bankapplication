package Main;

import java.util.Scanner;

import com.Bank.Bank;

public class UserInterface {

    // 전역 변수
    public static final int STANDARD = -1;

    static final int BANKMENU_REGISTER  = 1;
    static final int BANKMENU_MANAGE    = 2;
    static final int BANKMENU_SEARCH    = 3;
    static final int BANKMENU_SEARCHALL = 4;
    
    // 멤버변수
    private Scanner sc;
    private MenuType curType;
    private Bank bank;

    // 게터 및 세터
    public MenuType getCurType() { return curType; }
    public void setCurType(MenuType curType) { this.curType = curType; }

    // 생성자
    public UserInterface() {
        sc = new Scanner(System.in);
        curType = MenuType.BANK;
        bank = new Bank();
    }

    // enum 타입
    enum MenuType {
        BANK,
        ACCOUNT
    }

    // 메소드
    public void run() {   
        boolean isQuit = false;

        int sellection = STANDARD;

        while(!isQuit) {
            
            // 현재 메뉴를 출력하는 창
            switch (curType) {
                case BANK :
                    bankMenuPrinter();
                    break;
                case ACCOUNT :
                    accountMenuPrinter();
                    break;
            }

            try {
            sellection = Integer.valueOf(sc.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            }

            
            if (sellection < 1 && sellection > 4) {
                System.out.println("존재하지 않는 메뉴 입니다.");
                continue;
            }

            if (curType == MenuType.BANK) {
                bankMenu(sellection);
                
            }

            if (curType == MenuType.ACCOUNT) {
                accountMenu(sellection);
            }
        }
    }

    // 은행 메뉴 선택시 해당 메뉴를 수행하는 메소드
    private void bankMenu(int sellection) {

        switch (sellection) {
            case BANKMENU_REGISTER :
                bank.register();
                break;
            case BANKMENU_MANAGE :
                System.out.println("계좌를 수정/제거 합니다.");
                bank.manage();
                break;
            case BANKMENU_SEARCH :
                System.out.println("계좌를 찾습니다.");
                bank.search();
            break;
            case BANKMENU_SEARCHALL :
                System.out.println("전체 계좌를 조회합니다.");
                // 함수 생성후 넣어주기
                break;
        }
    }

    // 계좌 메뉴 선택시 해당 메뉴를 수행하는 메소드
    private void accountMenu(int sellection) {
    }
    

    private void accountMenuPrinter() {
        System.out.println("----계좌 메뉴----");
        System.out.println("1. 입금");
        System.out.println("2. 출금");
        System.out.println("3. 잔고 확인");
        System.out.println("4. 거래 내역 조회");
    }

    private void bankMenuPrinter() {
        System.out.println("----은행 어플리케이션----");
        System.out.println("1. 계좌 등록");
        System.out.println("2. 계좌 관리"); 
        System.out.println("3. 계좌 찾기"); // 계좌를 찾을땐 2가지 방법 -> 계좌 찾게되면 어떤 동작? 계좌메뉴로 넘겨준다
        System.out.println("4. 계좌 목록조회");

    }
}
