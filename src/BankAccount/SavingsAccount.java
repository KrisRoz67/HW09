package src.BankAccount;

public class SavingsAccount extends BankAccount {

    private double annualPercentage;
    private int periodOfMonths;

    public double getAnnualPercentage() {
        return annualPercentage;
    }

    public void setAnnualPercentage(double annualPercentage) {
        if (annualPercentage > 0 && annualPercentage < 100) {
            this.annualPercentage = annualPercentage;
        } else {
            throw new IllegalArgumentException("Rate is not correct");
        }
    }

    public int getPeriodOfMonths() {
        return periodOfMonths;
    }

    public void setPeriodOfMonths(int periodOfMonths) {
        if (periodOfMonths > 0) {
            this.periodOfMonths = periodOfMonths;
        } else {
            throw new IllegalArgumentException("Period is not correct");
        }
    }

    public SavingsAccount(String accountNumber, double balance, boolean isCredit, double annualPercentage, int periodOfMonths) {
        super(accountNumber, balance, isCredit);
        setAnnualPercentage(annualPercentage);
        setPeriodOfMonths(periodOfMonths);
    }

    @Override
    public double countTheRate() {
        try {
            double interestIncome = (annualPercentage / 12) / 100 * periodOfMonths * getBalance();
            System.out.printf("Saving period is %s months and you current balance is %s .", periodOfMonths, getBalance());
            return interestIncome;

        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }

    }
}