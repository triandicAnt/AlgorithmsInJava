/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class Q228 {
	public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums==null || nums.length<=0)
            return list;
        else if(nums.length == 1)
            return Collections.singletonList(""+nums[0]);
        int x = 0;
        int i = 1;
        int n = nums.length;
       // while(i<nums.length){
            for(i=1;i<nums.length;i++){
           // System.out.println("---"+i + " "+ x);

            while(i<n&&(nums[i-1]+1 == nums[i])){
                i++;
            }
            StringBuffer sb = new StringBuffer();
            if(i-x>1){
                sb.append(nums[x]);
                sb.append("->");
                sb.append(nums[i-1]);
            }else{
                sb.append(nums[x]);
            }
            list.add(sb.toString());
            x = i;
        }
        if(x==nums.length-1)
            list.add(""+nums[x]);
        return list;
    }
}
