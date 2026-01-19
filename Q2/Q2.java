package labTest.Q2;

public class Q2 {
	public static void main(String[] args) {
		Date dob_of_person1 = new Date(5, 12, 2002);
		Person person1 = new Person("Ishita", "Jain", dob_of_person1);
		
		SavingAccount sav_acc_person1 = new SavingAccount(person1, 10000, "A123", 5);
		System.out.println(sav_acc_person1);
		
		CurrentAccount cu_acc_person1 = new CurrentAccount(person1, 30000, "A124");
		System.out.println(cu_acc_person1);
		
	}
}
