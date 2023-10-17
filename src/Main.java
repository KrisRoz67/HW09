package src;

import src.BankAccount.CheckingAccount;
import src.BankAccount.CreditAccount;
import src.BankAccount.SavingsAccount;

public class Main {
    public static void main(String[] args) {
       SavingsAccount savingsAccount = new SavingsAccount(
               "EE123123123123666666",
               100,
               4.5,
               3);
        System.out.println(savingsAccount);
        savingsAccount.deposit(500);
        savingsAccount.withdraw(600);
        String str1  =String.format("""
                        Saving period is %s months ,deposit interest rate %s and your current balance is %s.
                        So,you will get extra %s eur in the end of saving period
                        .""",
     savingsAccount.getPeriodOfMonths(),
             savingsAccount.getAnnualPercentage(),
             savingsAccount.getBalance(),
             savingsAccount.countTheRate());
        String str2 = String.format("\nYou do not have money on your account. So, you will get %s interest on deposit\n",
             savingsAccount.countTheRate());
     System.out.printf( savingsAccount.countTheRate() > 0 ? str1: str2);

     System.out.println("-----------------------------------");
        CheckingAccount checkingAccount = new CheckingAccount(
                "EE123123123123666999",
                1000,
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
        creditAccount.withdraw(300);
        creditAccount.withdraw(300);
        System.out.println(creditAccount.countTheRate() > 0 ? "You have to return " +Math.abs(creditAccount.getBalance())
                +" eur.\nAlso you need return extra "
                + creditAccount.countTheRate()
                + " eur in the end of loan period ("+creditAccount.getLoanPeriod()
                + "s months)"
                : "\nYou don't owe the bank anything, there's still money in your account :" +creditAccount.getBalance()
                + " eur:\". You do not have to pay interest on loan");

        }
    }
