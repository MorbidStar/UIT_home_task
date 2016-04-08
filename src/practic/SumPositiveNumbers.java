package practic;

public class SumPositiveNumbers {

	public static void main(String[] args) {
		int[] arr1 = {1,-3,4,-50,0,-7,20};
		//25
		System.out.println(sum(arr1));

		int[] arr2 = {-2, -5, -0};
		//0
		System.out.println(sum(arr2));
	}
	
	static int sum(int [] numbers) {
		int result = 0;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]>0) {
				result+=numbers[i];
			}
		}
		return result;
	}
	
}
