package hello.forHelp;

public class Step03_GiveGrade {
	public String[] getGrade(int[] score) {
		/*
		점수배열을 받아서 그래이드 배열을 만들어서 반환해야합니다.
		90점 이상 A
		80점 이상 B
		70점 이상 C
		60점 이상 D
		그 외 F
		등급을 부여하는 배열을 리턴해주세요		
		*/
		String[] grade = new String[score.length];

		for (int i = 0; i < grade.length; i++) {
			if(score[i] >= 90) {
				grade[i] = "A";
			} else if(score[i] >= 80) {
				grade[i] = "B";
			} else if(score[i] >= 70) {
				grade[i] = "C";
			} else if(score[i] >= 60) {
				grade[i] = "D";
			} else {
				grade[i] = "F";
			}
		}

		return grade;


	}
	
	
	public static void main(String[] args) {
		int[] score = new int[(int)(Math.random() *30+20)];
		
		for(int i=0;i<score.length;i++) {
			score[i] = (int)(Math.random()*50 +50);
		}
		
		// System.out
		for (int i : score) {
			System.out.printf("%d  ", i);
		}
		System.out.println();
		String[] grade = new Step03_GiveGrade().getGrade(score);
		for(String str : grade) {
			System.out.printf("%s  ", str);
		}
		
	}
}


