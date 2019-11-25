package java_20191119;

public class GetLastNum {
	public int getLastNum(String subSsn){
		int lastNum = 0;
		
		String front = subSsn.substring(0, 6);
		String back = subSsn.substring(7);
		
		int frontNum = Integer.parseInt(front);
		int backNum = Integer.parseInt(back);
		
		int sum = (frontNum / 100_000) * 2 + ((frontNum / 10_000) % 10) * 3 + ((frontNum / 1_000) % 10) * 4
				+ ((frontNum / 100) % 10) * 5 + ((frontNum / 10) % 10) * 6 + (frontNum % 10) * 7
				+ (backNum / 100_000) * 8 + ((backNum / 10_000) % 10) * 9 + ((backNum / 1_000) % 10) * 2
				+ ((backNum / 100) % 10) * 3 + ((backNum / 10) % 10) * 4 + (backNum % 10) * 5;

		lastNum = (11 - (sum % 11)) % 10;		
		
		return lastNum;
	}
}
