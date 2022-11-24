package com.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Account.Account;

public class Bank {
    // 멤버변수
    List<Account> accounts;
    
    HashMap<String, Account> number = new HashMap<>(); // -> 하나의 계좌만 찾게 될거같고
    HashMap<String, List<Account>> user = new HashMap<>(); // -> 사용자 하나가 여러개 계좌 만들수 있을수 있으니깐 여러개 반환될 가능성이 높아요

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
    