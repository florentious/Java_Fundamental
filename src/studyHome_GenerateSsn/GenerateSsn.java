package studyHome_GenerateSsn;

import java.util.Random;

import studyHome_GenerateSsn.CheckLeapYear;
import studyHome_GenerateSsn.GetLastNum;;

public class GenerateSsn {
	public String generateSsn() {

		Random random = new Random();
		CheckLeapYear leapYear = new CheckLeapYear();
		GetLastNum getLastNum = new GetLastNum();

		// get generate Front Num
		int year = random.nextInt(10000);
		int days = 0, day = 0;
		int month = 0;

		if (leapYear.checkLeapYear(year)) {
			days = random.nextInt(366);
			if (days <= 31) {
				month = 1;
				day = days;
			} else if (days <= 60 && days > 31) {
				month = 2;
				day = days - 31;
			} else if (days <= 91 && days > 60) {
				month = 3;
				day = days - 60;
			} else if (days <= 121 && days > 91) {
				month = 4;
				day = days - 91;
			} else if (days <= 152 && days > 121) {
				month = 5;
				day = days - 121;
			} else if (days <= 182 && days > 152) {
				month = 6;
				day = days - 152;
			} else if (days <= 213 && days > 182) {
				month = 7;
				day = days - 182;
			} else if (days <= 244 && days > 213) {
				month = 8;
				day = days - 213;
			} else if (days <= 274 && days > 244) {
				month = 9;
				day = days - 244;
			} else if (days <= 305 && days > 274) {
				month = 10;
				day = days - 274;
			} else if (days <= 335 && days > 305) {
				month = 11;
				day = days - 305;
			} else if (days <= 366 && days > 335) {
				month = 12;
				day = days - 335;
			}

		} else {
			days = random.nextInt(365);
			if (days <= 31) {
				month = 1;
				day = days;
			} else if (days <= 59 && days > 31) {
				month = 2;
				day = days - 31;
			} else if (days <= 90 && days > 59) {
				month = 3;
				day = days - 59;
			} else if (days <= 120 && days > 90) {
				month = 4;
				day = days - 90;
			} else if (days <= 151 && days > 120) {
				month = 5;
				day = days - 120;
			} else if (days <= 181 && days > 151) {
				month = 6;
				day = days - 151;
			} else if (days <= 212 && days > 181) {
				month = 7;
				day = days - 181;
			} else if (days <= 243 && days > 212) {
				month = 8;
				day = days - 212;
			} else if (days <= 273 && days > 243) {
				month = 9;
				day = days - 243;
			} else if (days <= 304 && days > 273) {
				month = 10;
				day = days - 273;
			} else if (days <= 334 && days > 304) {
				month = 11;
				day = days - 304;
			} else if (days <= 365 && days > 334) {
				month = 12;
				day = days - 334;
			}

		}

		//front SSN 
		String genFront = String.format("%02d", (year % 100)) + String.format("%02d", month)
				+ String.format("%02d", day);

		// get generate backNum

		int sexNum = 0;
		if (year < 2000) {
			sexNum = random.nextInt(5) + 1;
		} else {
			sexNum = random.nextInt(3) + 1;
			if (sexNum == 3) {
				sexNum = 5;
			}
		}

		int midNum = random.nextInt(100_000);
		String beforeSsn = genFront + "-" + sexNum + String.format("%05d", midNum);
		// System.out.println(beforeSsn);

		int lastNum = getLastNum.getLastNum(beforeSsn);

		//System.out.println(beforeSsn + lastNum);
		// System.out.println(checkSsn.CheckSsn(beforeSsn+lastNum));
		

		return beforeSsn + String.format("%d", lastNum);

	}
}
