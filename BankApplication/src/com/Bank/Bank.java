package com.Bank;

import java.util.ArrayList;
import java.util.List;

import com.Account.Account;

public class Bank {
    // 멤버변수
    List<Account> accounts;

    // 생성자 -> 동적 배열 할당
    public Bank() { accounts = new ArrayList<>(); }

    // 매소드
    // 계좌 등록하기
    public void register() {};
    // 계좌 관리하기
    public void manage() {};
    // 계좌 검색하기
    public void search() {};
}
