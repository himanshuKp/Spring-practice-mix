package com.himanshu.springbootaop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING SOME DB WORKS");
    }

    public void addSillyAccount(int id, double amount) {
        System.out.println(getClass() + ": DOING SOME DB ACCOUNT SECONDWORKS");
    }
}