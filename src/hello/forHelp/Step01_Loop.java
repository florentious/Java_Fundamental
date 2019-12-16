package hello.forHelp;

public class Step01_Loop {
	public int[] forloop(int size) {
		int[] a = new int[size]; 
		
		// 크기를 입력받으면 크기의 역순(받은크기의 내림차순)으로 배열에 저장해서 배열을 반환해주세요
		// desc 출력
		
		
		
		return a;
	}
	
	
	
	
	public static void main(String[] args) {
	
		int[] array = new Step01_Loop().forloop((int)(Math.random()*40+10));
		
		for (int i : array) {
			System.out.printf("%d ",i);
		}
		
		
	}
}
