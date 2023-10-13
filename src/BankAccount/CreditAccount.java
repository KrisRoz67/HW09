package src.BankAccount;

public class CreditAccount extends BankAccount {
    private double annualPercentage;
    private int loanPeriod;
    private double creditLimit;

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
        super(accountNumber, balance, isCredit);
        setAnnualPercentage(annualPercentage);
        setCreditLimit(creditLimit);
        setLoanPeriod(loanPeriod);
    }

    @Override
    public double countTheRate() {
        try {
            if ((getBalance() < 0) && (Math.abs(getBalance()) <= creditLimit)) {
                double interestAmount = (annualPercentage / 12) / 100 * loanPeriod * Math.abs(getBalance());
                System.out.printf("You have to return  %s eur.\n", Math.abs(getBalance()));
                return interestAmount;
            } else {
                System.out.printf("\nYou don't owe the bank anything, there's still money in your account : %s eur:", getBalance());
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.printf("""
                Your credit limit is %s . Try to withdraw from credit account : %s eur
                """, creditLimit, amount);
        double res = getBalance() - amount;
        if ((res < 0) && (Math.abs(res) <= creditLimit)) {
            setBalance(res);
            System.out.println("Withdrawal of " + amount + " eur was successful. Current balance:" + getBalance() + "eur");
        } else if (res > 0) {
            setBalance(res);
            System.out.println("Withdrawal of " + amount + " eur was successful. Current balance:" + getBalance() + " eur");
        } else {
            throw new RuntimeException("Withdrawal is impossible , you exceeded the limit ");
        }
    }

    @Override
    public String toString() {
        return String.format("\nA/c %s : Initial Balance : %s eur," +
                "Your credit limit :%s eur", getAccountNumber(), getBalance(), getCreditLimit());
    }
}

