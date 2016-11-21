/**
 * 
 */
package leetcode;

import java.util.Random;

/**
 * @author Sudhansu
 *
 */
public class RandomPick {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution(new int []{1,2,3,3,3});
		System.out.println(s.pick(3));

	}

}
class Solution {
    int [] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
       /* for(int a:this.nums){
            if(a>max){
            	max =a;
                count =1;
            }else if(a==max){
                count ++;
            }
        }
        Random rand = new Random();
        int randomNum = rand.nextInt((count - 1) + 1) + 1;
        int index =-1;
        for(int i=0;i<this.nums.length;i++){
            if(this.nums[i]==max){
                randomNum--;
                index = i;
                
            }
            if(randomNum==0)
                break;
        }*/
        int index = -1;
        for(int i =0;i<this.nums.length;i++){
            if(this.nums[i]!=target)
                continue;
            if(rand.nextInt(++count)==0)
                index = i;
        }
        
        return index;
        
    }
}
