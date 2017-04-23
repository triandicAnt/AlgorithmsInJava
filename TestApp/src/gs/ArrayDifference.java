import java.util.Arrays;

public class ArrayDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {3,1,2,0};
		System.out.println(arrayDifference(a));

	}
	public static int arrayDifference(int[] nums){
		Arrays.sort(nums);
		int n = nums.length;
		int sum = 0;
		for(int i = n-1; i>=0 ; i--)
		{
			sum += nums[i]*i-nums[i]*(n-1-i);
		}
		return sum;
	}

}
