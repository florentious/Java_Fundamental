package hello.forHelp;

public class Step01_Loop {
	public int[] forloop(int size) {
		int[] a = new int[size]; 
		/*
		for (int i = 0; i < a.length; i++) {
			a[i] = a.length-i;
		}
		*/
		return a;
	}
	
	
	
	
	
	public static void main(String[] args) {
	
		int[] array = new Step01_Loop().forloop((int)(Math.random()*40+10));
		
		for (int i : array) {
			System.out.printf("%d ",i);
		}
		
		
	}
}
