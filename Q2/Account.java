package labTest.Q2;

public class Account {
	protected Person owner;
	protected double balance;
	protected String ac_number;
	
	Account(Person owner, double balance, String ac_number){
		this.setOwner(owner);
		this.setBalance(balance);
		this.setAc_number(ac_number);
	}
	
//	Account(Account obj){
//		owner = obj.owner;
//		balance = obj.balance;
//	}
	
	public Person getOwner() {
		return owner;
	}
	
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getAc_number() {
		return ac_number;
	}
	
	public void setAc_number(String ac_number) {
		this.ac_number = ac_number;
	}
	
	@Override
	public String toString() {
		return "Owner name : " + owner + " Balance : " + balance + "A/C No. : " + ac_number + "\n";
	}
	
	void deposit(int amount) {
		if(amount < 0) {
			System.out.println("amount cannot be -ve");
			return;
		}
		balance += amount;
	}
	
	void withDraw(int amount) {
		if(amount < 0) {
			System.out.println("amount cannot be -ve");
			return;
		}
		if(amount < balance) {
			System.out.println("not suuficient balance");
			return;
		}
		balance -= amount;
		System.out.println("Amount withdrawn successfully : Rs " + amount);
	}
}
