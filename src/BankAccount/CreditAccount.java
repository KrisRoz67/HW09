package src.BankAccount;

public class CreditAccount extends BankAccount {
    private double annualPercentage;
    private int loanPeriod;
    private double creditLimit;
    boolean isCredit;

    public boolean getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(boolean credit) {
        isCredit = credit;
    }

    public double getAnnualPercentage() {

        return annualPercentage;
    }

    public void setAnnualPercentage(double annualPercentage) {
        if (annualPercentage > 0 && annualPercentage < 100) {
            this.annualPercentage = annualPercentage;
        } else {
            throw new IllegalArgumentException("Percent is incorrect");
        }
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        if (loanPeriod > 0) {
            this.loanPeriod = loanPeriod;
        } else {
            throw new RuntimeException("Wrong period");
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        if (creditLimit > 0) {
            this.creditLimit = creditLimit;
        } else {
            throw new IllegalArgumentException("Credit limit is not correct");
        }

    }


    public CreditAccount(String accountNumber,
                         double balance,
                         boolean isCredit,
                         double annualPercentage,
                         int loanPeriod,
                         double creditLimit) {
        super(accountNumber, balance);
        setIsCredit(isCredit);
        setAnnualPercentage(annualPercentage);
        setCreditLimit(creditLimit);
        setLoanPeriod(loanPeriod);
    }

    @Override
    public double countTheRate() {
        try {
            if ((getBalance() < 0) && (Math.abs(getBalance()) <= creditLimit)) {
                return (annualPercentage / 12) / 100 * loanPeriod * Math.abs(getBalance());
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.printf("\nYour credit limit is %s eur. Try to withdraw from credit account : %s eur \n ", creditLimit+getBalance(), amount);
        double res = getBalance() - amount;
        if (Math.abs(res) <= creditLimit) {
            setBalance(res);
            System.out.println("\nWithdrawal of " + amount + " eur was successful. Current balance:" + getBalance() + "eur\n");
        } else {
            throw new RuntimeException("Withdrawal is impossible , you exceeded the limit ");
        }
    }

    @Override
    public String toString() {
        return String.format("\nA/c %s : Initial Balance : %s eur," +
                "Your credit limit :%s eur", getAccountNumber(), getBalance(), getCreditLimit());
    }

    @Override
    protected void setBalance(double balance) {
        if (balance >= 0 && !isCredit) {
            this.balance = balance;
        } else if (isCredit) {
            this.balance = balance;
        } else throw new IllegalArgumentException("Balance can't be negative");
    }
}

