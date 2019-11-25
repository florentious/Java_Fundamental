package java_20191121;

public class TwoArrayDemo {
	public static void main(String[] args) {
		int[][] a = new int[3][2];

		a[0][0] = 10;
		a[0][1] = 20;
		a[1][0] = 30;
		a[1][1] = 40;
		a[2][0] = 50;
		a[2][1] = 60;
		
		int[][] b= {{10,20},{30,40},{50,60}};
		
/*		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+"\t"	);
			}
			System.out.println();
		}*/
		
		for (int[] i : b) {
			for (int j : i) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
		
		//2차원 배열의 동적할당
		int[][] c = {{1},{2,3},{4,5,6}};
		int[][] d = new int[3][];
		d[0] = new int[1];
		d[1] = new int[2];
		d[2] = new int[3];
		
		d[0][0] = 1;
		d[0][1] = 2;
		d[1][0] = 3;
		d[1][1] = 4;
		d[2][0] = 5;
		d[3][1] = 6;
		
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}
}
