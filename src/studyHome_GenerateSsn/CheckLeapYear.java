package studyHome_GenerateSsn;

public class CheckLeapYear {
	public boolean checkLeapYear(int year) {
		boolean result = false;

		if ((year % 4) == 0) {
			if ((year % 100) == 0) {
				if ((year % 400) == 0) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = true;
			}
		} else {
			result = false;
		}

		return result;
	}

}
