package hello.forHelp;

public class Step02_GetLotto {
	
	public int[] getNumber() {
		int[] lotto = new int[7];
		
		// complete this code
		
		
		
		return lotto;
	}
	
	
	public static void main(String[] args) {
		
		
		int[] lotto = new Step02_GetLotto().getNumber();
		
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		
		
	}
}
