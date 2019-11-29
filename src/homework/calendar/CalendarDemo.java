package homework.calendar;

public class CalendarDemo {
	public void execute(Calendar c) {
		c.start();
	}
	
	public static void main(String[] args) {
		new CalendarDemo().execute(new Calendar());
	}
}
