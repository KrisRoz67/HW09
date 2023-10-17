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

    public SavingsAccount(String accountNumber, double balance, double annualPercentage, int periodOfMonths) {
        super(accountNumber, balance);
        setAnnualPercentage(annualPercentage);
        setPeriodOfMonths(periodOfMonths);
    }

    @Override
    public double countTheRate() {
        try {
            return  (annualPercentage / 12) / 100 * periodOfMonths * getBalance();


        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }

    }
}