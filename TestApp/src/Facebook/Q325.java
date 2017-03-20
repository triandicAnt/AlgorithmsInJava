import java.util.Map;
import java.util.HashMap;
class Q325{
 public static int maxSubArrayLen(int a[],int k){
   if(a==null || a.length==0)
    return 0;
    int sum = 0;
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    for(int i =0;i<a.length;i++){
      sum+=a[i];
      if(sum==k)
        max = i+1;
      else if(map.containsKey(sum-k))
        max = Math.max(max, i-map.get(sum-k));
      if(!map.containsKey(sum))
        map.put(sum, i);
    }
    return max;
 } 
 public static void main(String[] args){
   int [] a = {1,-1,5,-2,3};
   int b [] = {-2,-1,2,1};
   System.out.println(maxSubArrayLen(a,3));
   System.out.println(maxSubArrayLen(b,1));
 }
}
