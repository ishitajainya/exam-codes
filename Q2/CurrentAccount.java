package labTest.Q2;

public class CurrentAccount extends Account{
	
	private final double minBalance = 100;
	
	CurrentAccount(Person owner, double balance, String ac_number) {
		super(owner, balance, ac_number);
	}

	double getCharges() {
		if(balance < minBalance) {
			return 100;
		}
		return 0;
	}

	@Override
	public void withDraw(int amount) {
		if(amount < 0) {
			System.out.println("amount cannot be -ve");
			return;
		}
		if(balance - amount < minBalance) {
			System.out.println("min balance of " + minBalance + " cannot be maintained");
			return;
		}
		balance -= amount;
		System.out.println("Amount withdrawn successfully : Rs " + amount);
	}
	
	@Override
	public String toString() {
		return "Current Account : " + super.toString() + "CurrentAccount [minBalance=" + minBalance + "]" + "\n";
	}
	
}
