
public class BankAccount {
	private String owner;
    private float balance;

    public BankAccount(String owner, float balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() { return owner; }
    public double getBalance() { return balance; }
    
    public void setOwner(String owner) { this.owner = owner; }
    public void setBalance(float balance) { this.balance = balance; }

    @Override
    public String toString() {
        return String.format("Owner: %s; Balance: %.2f", owner, balance);
    }
}
