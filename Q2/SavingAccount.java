package labTest.Q2;

public class SavingAccount extends Account{
	private int interestRate; 
	
	SavingAccount(Person owner, double balance, String ac_number, int interestRate) {
		super(owner, balance, ac_number);
		this.interestRate = interestRate;
	}
	
	public double getBalance() {
		return balance + (balance * interestRate / 100);
	}
	
	public double getInterest() {
		return (balance * interestRate / 100);
	}
	
	public int getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "Saving Account : " + super.toString() + "SavingAccount [interestRate=" + interestRate + "\n";
	}
	
}
