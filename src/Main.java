package src;

import src.BankAccount.CheckingAccount;
import src.BankAccount.CreditAccount;
import src.BankAccount.SavingsAccount;

public class Main {
    public static void main(String[] args) {
       SavingsAccount savingsAccount = new SavingsAccount(
               "EE123123123123666666",
               100,
               false,
               4.5,
               3);
        System.out.println(savingsAccount);
        savingsAccount.deposit(500);
        savingsAccount.withdraw(400);
       System.out.printf("So,you will get extra %s eur in the end of saving period\n"
               ,savingsAccount.countTheRate());
        System.out.println("-----------------------------------");
        CheckingAccount checkingAccount = new CheckingAccount(
                "EE123123123123666999",
                1000,
                false,
                400);
        System.out.println(checkingAccount);
        checkingAccount.withdraw(300);
        checkingAccount.deposit(200);
        checkingAccount.countTheRate();
        System.out.println("-----------------------------------");
        CreditAccount creditAccount = new CreditAccount(
                "EE123123123123666999",
                10 ,
                true,
                5,
                12,
                3000);
        System.out.println(creditAccount);
        creditAccount.deposit(300);
        creditAccount.withdraw(200);
        System.out.println(creditAccount.countTheRate() > 0 ? "Also you need return extra "
                + creditAccount.countTheRate()
                + "eur in the end of loan period ("+creditAccount.getLoanPeriod()
                + "s months)": "\nYou do not have to pay interest on loan");
        }
    }
