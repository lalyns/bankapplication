package Main;

import com.Account.Account;
import com.Bank.Bank;

import java.util.Scanner;
import java.util.Arrays;

public class UserInterface {

    // 상수
    public static final int STANDARDVALUE = -1;

    // enum 타입
    enum MenuType {
        BANK,
        ACCOUNT
    }

    enum BankMenu {
        REGISTER(1),
        MANAGE(2),
        SEARCH(3),
        SEARCHALL(4);

        private final int label;

        BankMenu(int label) {
            this.label = label;
        }

        public int label() {
            return label;
        }

        public static BankMenu valueOfLabel(int label) {
            return Arrays.stream(values())
                        .filter(value -> value.label == label)
                        .findAny()
                        .orElse(null);
        }
    }

    static final int ACCOUNT_DEPOSIT    = 1;
    static final int ACCOUNT_WITHDRAW   = 2;
    static final int ACCOUNT_SEARCH     = 3;
    static final int ACCOUNT_VEIWTRADES = 4;

    // 멤버변수
    private Scanner sc;
    private MenuType curType;
    private Bank bank;
    private Account reTurnAccount;

    // 게터 및 세터
    public MenuType getCurType() { return curType; }
    public void setCurType(MenuType curType) { this.curType = curType; }

    // 생성자
    public UserInterface() {
        sc = new Scanner(System.in);
        curType = MenuType.BANK;
        bank = Bank.getInstance();
    }


    // 메소드
    public void run() {   
        boolean isQuit = false;

        int sellection = STANDARDVALUE;

        while(!isQuit) {
            
            // 현재 메뉴를 출력하는 창
            switch (curType) {
                case BANK :
                    bankMenuPrinter();
                    break;
                case ACCOUNT :
                    accountMenuPrinter();
                    break;
                default :
                    System.out.println("잘못된 접근입니다.");
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
                continue;
                
            }

            if (curType == MenuType.ACCOUNT) {
                accountMenu(sellection);
                continue;
            }
        }
    }

    // 은행 메뉴 선택시 해당 메뉴를 수행하는 메소드
    private void bankMenu(int sellection) {
        BankMenu menu = BankMenu.valueOfLabel(sellection);
        switch (menu) {
            case REGISTER :
                bank.register();
                break;
            case MANAGE :
                System.out.println("계좌를 수정/제거 합니다.");
                accountManagePrinter();
                try{
                    int tempSelection = Integer.valueOf(sc.nextLine());
                    if (tempSelection == 1 || tempSelection == 2) {
                        bank.manage(tempSelection);
                    }
                    else {
                        System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("잘못된 접근입니다 처음으로 돌아갑니다.");
                }
                break;
            case SEARCH :
                System.out.println("계좌를 찾습니다.");
                reTurnAccount = bank.search();
                if (reTurnAccount != null)
                    curType = MenuType.ACCOUNT;
                break;
            case SEARCHALL :
                System.out.println("전체 계좌를 조회합니다.");
                bank.searchAll();
                break;
            default :
                System.out.println("잘못된 메뉴입니다.");
        }
    }

    // 계좌 메뉴 선택시 해당 메뉴를 수행하는 메소드
    private void accountMenu(int sellection) {

        int fee = STANDARDVALUE;
        int balance = reTurnAccount.getBalance();

        switch (sellection) {
            case ACCOUNT_DEPOSIT:
                System.out.println("입금을 시작합니다. 금액을 입력해주세요");
                try{
                    fee = Integer.valueOf(sc.nextLine());
                    reTurnAccount.deposit(fee);
                    System.out.println("현재 잔액 : "+balance);
                }
                catch (NumberFormatException e) {
                    System.out.println("잘못된 금액입니다. 메뉴로 돌아갑니다.");
                }
                break;
            case ACCOUNT_WITHDRAW:
                System.out.println("출금 시작");
                try {
                    fee = 0;
                    fee = Integer.valueOf(sc.nextInt());
                    reTurnAccount.withdraw(fee);
                    System.out.println("현재 잔액 : "+balance);
                }catch (NumberFormatException e) {
                    System.out.println("잘못된 금액입니다. 메뉴로 돌아갑니다.");
                }
                break;
            case ACCOUNT_SEARCH:
                System.out.println("잔고를 확인합니다");
//                reTurnAccount.search();
                break;
            case ACCOUNT_VEIWTRADES:
                System.out.println("거래 내역을 조회합니다");
//                reTurnAccount.veiwTrades();
                break;
            default :
                System.out.println("잘못된 메뉴입니다.");
        }
    }
    
    private void accountManagePrinter() {
        System.out.println("----계좌 관리----");
        System.out.println("1. 수정");
        System.out.println("2. 삭제");
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
