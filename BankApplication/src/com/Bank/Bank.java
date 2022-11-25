package com.Bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Main.UserInterface;
import com.IOmanager;
import com.Account.Account;

public class Bank {
    // 멤버변수
    List<Account> accounts;
    IOmanager io;

    final String ACCOUNTPATH = "src/com/account.csv";

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

        List<List<String>> lists = new ArrayList<>();
        lists = io.readCSV(ACCOUNTPATH);

        for (int i = 1; i < lists.size(); i++) {

            String user = lists.get(i).get(0);
            String accountNumber = lists.get(i).get(1);
            int balance = Integer.valueOf(lists.get(i).get(2));
            String bankName = lists.get(i).get(3);
            Account account = new Account(user, accountNumber, balance, bankName);
            this.accounts.add(account);
        }


        // 정상적으로 작동하는지 확인하기 위한 콘솔 코드
        for (int i = 0; i < this.accounts.size(); i++) {
            String user = accounts.get(i).getUser();
            String accountNumber = accounts.get(i).getAccountNumber();
            int balance = accounts.get(i).getBalance();
            String bankName = accounts.get(i).getBankName();

            System.out.println("계좌주(" + user + ")" +
                    "  계좌번호(" + accountNumber + ")" +
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

        Account newAccount = new Account(user, account, balance, bankName);

        // 현재 계좌 리스트에 새로운 계좌 정보를 추가해준다
        accounts.add(newAccount);

        String temp[] = {user, account, String.valueOf(balance), bankName};
        List<String> accountInfo = Arrays.asList(temp);

        // 해당 계좌를 csv 파일에 입력해주기
        io.writeCSV(ACCOUNTPATH, accountInfo);
    }

    ;

    // 계좌 관리하기 (수정 or 삭제)
    public void manage() {

    }

    // 계좌 검색하기
    public Account search() {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        String checkNumber;
        boolean end = false;

        while (!end) {
            System.out.println("조회하실 계좌번호를 입력해주세요: ");
            checkNumber = sc.nextLine();
            if (checkNumber.length() != 16) {
                System.out.println("잘못된 입력입니다");
                break;
            }

            // 계좌 정규표현식으로 포멧이 맞는지 확인
            for (int i = 0; i < this.accounts.size(); i++) {
                Account account = accounts.get(i);

                if (account.getAccountNumber().equals(checkNumber)) {
                    System.out.println("계좌주(" + account.getUser() + ")" +
                            "  계좌번호(" + account.getAccountNumber() + ")" +
                            "  잔고(" + account.getBalance() + ")" +
                            "  은행명(" + account.getBankName() + ")");
                    end = true;
                    return account;
                }
            }
        }
        return null;
    }

}
