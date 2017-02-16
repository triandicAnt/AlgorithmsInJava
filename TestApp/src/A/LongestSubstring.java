public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
     /*
       HashSet<Character> set = new HashSet<Character>();
		int count=0, i=0 ,j=0;
		int n = s.length();
		while(i<n && j<n){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				count = Math.max(count, j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return count;
		*/
		return returnMax(s);
    }
    
    public int returnMax(String s){
        if(s==null || s.length()==0)
            return 0;
        int max = 0;
        Map<Character, Integer>map = new HashMap<>();
        for(int i=0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
