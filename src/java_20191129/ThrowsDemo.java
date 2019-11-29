package java_20191129;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ThrowsDemo {
	
	public static double getAverage(int... temp) throws ArrayIndexOutOfBoundsException {
		
		double sum = 0;
		/*
		for(int i=0;i<temp.length;i++) {
			sum += temp[i];
		}
		*/
		
		//err test
		int k= temp[0];
		int m= temp[1];
		int e= temp[2];
		int h= temp[3];
		sum = k+m+e+h;		
		
		return sum / temp.length;
		
	}
	
	
	
	public static void main(String[] args) {
		int[] exam = {10,20,30};
		try {
			double average = getAverage(exam);
			
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("국어, 영어, 수학, 국사 4과목의 점수를 입력해야 합니다.");
		}
		
		// runtime 오류가 아니면 무조건 예외처리를 해줘야합니다.
		try {
			new FileOutputStream("c:\\dev\\Hello.java");
		} catch (FileNotFoundException e) {			// 파일이 없으면 예외가 발생
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
