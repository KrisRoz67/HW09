package src.BankAccount;

public abstract class BankAccount {

    String accountNumber;
    double balance;
    boolean isCredit;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(boolean credit) {
        isCredit = credit;
    }


    public BankAccount(String accountNumber, double balance, boolean isCredit) {
        setAccountNumber(accountNumber);
        setIsCredit(isCredit);
        setBalance(balance, isCredit);
    }

    public abstract double countTheRate();


    public String getAccountNumber() {

        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber.startsWith("EE") && accountNumber.length() == 20) {
            this.accountNumber = accountNumber;
        } else throw new RuntimeException("Account nr format is not correct. Account nr should be EE + 18 numbers");
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance, boolean isCredit) {
        if (balance >= 0 && !isCredit) {
            this.balance = balance;
        } else if (isCredit) {
            this.balance = balance;
        } else throw new IllegalArgumentException("Balance can't be negative");
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("\nDeposit of " + amount + " eur successful. Current balance:" + getBalance() + " eur");
    }

    public void withdraw(double amount) {
        System.out.printf("\nTry to withdraw : %s eur\n", amount);
        if (amount > 0 && getBalance() - amount > 0) {
            setBalance(getBalance() - amount);
        } else {
            throw new RuntimeException("Withdrawal is impossible , you do not have enough" +
                    " money or withdrawal sum is not correct");
        }
        System.out.println("\nWithdrawal of " + amount + " eur successful. Current balance:" + getBalance());
    }

    @Override
    public String toString() {
        return String.format("\nA/c %s : Initial Balance : %s eur", getAccountNumber(), getBalance());
    }

}