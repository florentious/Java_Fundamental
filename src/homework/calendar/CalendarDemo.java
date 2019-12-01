package homework.calendar;

public class CalendarDemo {
	public void execute(Calendar c) throws Exception {
		c.start();
	}
	
	public static void main(String[] args) throws Exception {
		new CalendarDemo().execute(new Calendar());
	}
}
