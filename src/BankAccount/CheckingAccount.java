package src.BankAccount;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance, boolean isCredit, double withdrawLimit) {
        super(accountNumber, balance, isCredit);
        setWithdrawLimit(withdrawLimit);
    }

    private double withdrawLimit;

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        if (withdrawLimit > 0) {
            this.withdrawLimit = withdrawLimit;
        } else {
            throw new IllegalArgumentException("Limit is not correct");
        }
    }


    @Override
    public double countTheRate() {
        System.out.println("\nUnfortunately , rate is 0  for this type of account.\n");
        return 0;
    }

    @Override
    public void withdraw(double amount) {
        System.out.printf("\nTry to withdraw : %s eur\n", amount);
        if (amount > 0 && amount < getWithdrawLimit() && getBalance() - amount > 0) {
            setBalance(getBalance() - amount);
        } else {
            throw new RuntimeException("Withdrawal is impossible , you do not " +
                    "have enough money or your limit does not allow this operation");
        }
        System.out.printf("\nWithdrawal of %s eur  successful. Current balance: %s eur \n" , amount,getBalance());
    }
}
