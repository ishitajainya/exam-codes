package labTest.Q2;

public class Person {
	
	String firstName;
	String lastName;
	Date dob;
	
	Person(String firstName, String lastName, Date dob){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "[firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + "]" + "\n";
	}
	
}
