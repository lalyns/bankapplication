package com.Bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.IOmanager;
import com.Account.Account;

public class Bank {
    // 상수
    final String ACCOUNTPATH = "src/com/account.csv";

    // 멤버변수
    List<Account> accounts;
    IOmanager io;

    // -> 하나의 계좌만 찾게 될거같고
    HashMap<String, Account> number = new HashMap<>();
    // -> 사용자 하나가 여러개 계좌 만들수 있을수 있으니깐 여러개 반환될 가능성이 높아요
    HashMap<String, List<Account>> user = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    // 생성자
    // 어카운트의 리스트 동적 배열 할당
    // 생성될 때, csv에 저장된 내용들을 한번에 불러와서 어카운트에 저장해준다.
    public Bank() {
        accounts = new ArrayList<>();
        io = new IOmanager();

        // 계좌 정보를 저장하는 리스트 [계좌주, 계좌번호, 잔고, 은행명]
        List<List<String>> accountLists = new ArrayList<>();
        accountLists = io.readCSV(ACCOUNTPATH);

        for (int i = 1; i < accountLists.size(); i++) {
            String user = accountLists.get(i).get(0);
            String accountNumber = accountLists.get(i).get(1);
            int balance = Integer.valueOf(accountLists.get(i).get(2));
            String bankName = accountLists.get(i).get(3);
            String trade = accountLists.get(i).get(4);
            Account account = new Account(user, accountNumber, balance, bankName, trade);
            this.accounts.add(account);
        }


        // 정상적으로 작동하는지 확인하기 위한 콘솔
        for (int i = 0; i < this.accounts.size(); i++) {
            String user = accounts.get(i).getUser();
            String accountNumger = accounts.get(i).getAccountNumber();
            int balance = accounts.get(i).getBalance();
            String bankName = accounts.get(i).getBankName();

            System.out.println("계좌주(" + user + ")" +
                    "  계좌번호(" + accountNumger + ")" +
                    "  잔고(" + balance + ")" +
                    "  은행명(" + bankName + ")");
        }


    }

    // 매소드
    // 계좌 등록하기
    public void register() {
        // 예금주, 계좌번호, 잔고, 은행명을 기입한다.
        String user = "";
        String account = "";
        int balance = 0;
        String bankName = "";
        String trade = "";

        System.out.println("새로운 계좌를 등록합니다.");
        System.out.print("계좌주 : ");
        user = sc.nextLine();

        while (true) {
            System.out.print("계좌번호 : ");
            account = sc.nextLine();

            // 정규표현식 조사할 것 만약 아니면 올바른 입력값이 들어오기전까지 반복
            if (true) break;
        }

        while (true) {
            System.out.print("현재 잔고 : ");
            try {
                balance = Integer.valueOf(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("숫자만 입력해 주세요.");
            }
        }

        System.out.print("은행명 : ");
        bankName = sc.nextLine();

        // 거래내역 파일 생성후, 거래내역 파일의 주소를 저장해서 넣어준다.
        trade = io.createCSV(Account.TRADEPATH, accounts.size() + 1);

        Account newAccount = new Account(user, account, balance, bankName, trade);

        // 현재 계좌 리스트에 새로운 계좌 정보를 추가해준다
        accounts.add(newAccount);

        String temp[] = {user, account, String.valueOf(balance), bankName, trade};
        List<String> accountInfo = Arrays.asList(temp);

        // 해당 계좌를 csv 파일에 입력해주기
        io.writeCSV(ACCOUNTPATH, accountInfo);
    }

    ;

    // 계좌 관리하기 (수정 or 삭제)
    public void manage() {

    }

    ;

    // 계좌 검색하기
    public void search() {
    }
    public void searchAll() {
        System.out.println("---------");
        System.out.println("계좌목록");
        System.out.println("---------");
        for (int i = 0; i < this.accounts.size(); i++) {
            String user = accounts.get(i).getUser();
            String accountNumger = accounts.get(i).getAccountNumber();
            int balance = accounts.get(i).getBalance();
            String bankName = accounts.get(i).getBankName();

            System.out.println("계좌주(" + user + ")" +
                    "  계좌번호(" + accountNumger + ")" +
                    "  잔고(" + balance + ")" +
                    "  은행명(" + bankName + ")");
        }

    }
}
    