package com.himanshu.springbootaop;

import com.himanshu.springbootaop.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
        return args -> {
            doingTheBeforeAdvice(accountDAO);
        };
    }

    private void doingTheBeforeAdvice(AccountDAO accountDAO) {
        accountDAO.addAccount();

        System.out.println("Random text");

        accountDAO.addSillyAccount();
    }

}
