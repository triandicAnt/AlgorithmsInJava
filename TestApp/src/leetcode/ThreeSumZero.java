package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []  S = {-1, 0, 1, 2, -1, -4};
		int [] a = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		/**
		 *  Input: [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
			Output: [[-4,0,4],[-2,0,2],[-4,2,2],[-4,1,3],[-4,-2,6]]
			Expected: [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]] 
		 */
		threeSum(a);

	}
	public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int i=0, j=1,k=n-1;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<ThreePair> set = new  HashSet<ThreePair>();
        for(i=0;i<n-2;i++){
            j = i+1;
            k=n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
//                    System.out.println(">>>"+nums[i]+" "+nums[j]+" "+nums[k]);
                    set.add(new ThreePair(nums[i],nums[j],nums[k]));
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        System.out.println(set);
        for (ThreePair s : set) {
            list.add(Arrays.asList(s.x,s.y, s.z));
        }
        return list;
        
    }
}

class ThreePair{
	int x;
	int y;
	int z;
	public ThreePair(int i, int j, int k) {
		// TODO Auto-generated constructor stub
		this.x = i;
		this.y = j;
		this.z = k;
		
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return x*5 + y*31 + z*37;
	}
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj.getClass()!=ThreePair.class)
			return false;
		ThreePair tp = (ThreePair)obj;
		if(this.x!=tp.x || this.y!=tp.y || this.z!=tp.z)
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y + " "+ z;
	}
}