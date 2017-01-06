public class Q179 {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return "";
        String [] strArray = new String[nums.length];
        int i = 0;
        for(int a : nums){
            strArray[i++] = "" +a;
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        };
        Arrays.sort(strArray, comp);
        if(strArray[0].charAt(0) == '0')
            return "0";
        StringBuffer sb = new StringBuffer();
        for(String s : strArray){
            sb.append(s);
        }
        return sb.toString();
    }
}
