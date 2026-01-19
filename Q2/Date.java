package labTest.Q2;

public class Date {
	private int day;
	private int month;
	private int year;
	
	Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]" + "\n";
	}
	
}
