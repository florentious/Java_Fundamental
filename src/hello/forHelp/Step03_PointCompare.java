package hello.forHelp;

public class Step03_PointCompare {

	public String pointCompare(int[] a, int[] b) {
		
		// 두 배열의 같은 인덱스의 차이를 비교해서 String 타입으로 반환해주세요 
		// 같은 인덱스를 기준으로 비교하되,점수가 높으면  1점 이긴것입니다.
		// 같은 점수면 아무도 점수를 얻지 못합니다.
		// String type "3:2" 형태로 반환해주세요
		// ex> a[] = {1,2,3,4,5}, b[] = {4,2,2,1,1} 
		// ex> return "3:2"
		
		String result = null;
		
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		int size = (int)(Math.random()*20+10);
		
		int[] a = new int[size];
		int[] b = new int[size];
		
		for (int i = 0; i < size; i++) {
			a[i] = (int)(Math.random()*(size*5));
			b[i] = (int)(Math.random()*(size*5));
		}
		
		System.out.printf("result( a : b ) :  %s",new Step03_PointCompare().pointCompare(a, b));
		
		
	}
}
