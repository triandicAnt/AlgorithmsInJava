package leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1,1};
		System.out.println(maxArea(a));

	}
	public static int maxArea(int[] arr) {
        if(arr == null || arr.length<2)
            return 0;
        int l = 0, r = arr.length-1, water = 0;
        while(l<r){
            water = Math.max(water, (r-l)*Math.min(arr[l],arr[r]));
            if(arr[l]<arr[r])
                l++;
            else
                r--;
        }
        return water;
    }
}
