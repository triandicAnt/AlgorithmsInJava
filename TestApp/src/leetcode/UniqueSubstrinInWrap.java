public class UniqueSubstrinInWrap {
    public int findSubstringInWraproundString(String p) {
        if(p==null || p.length()==0)
            return 0;
        // Set<Character> set = new HashSet<Character>();
        // for(char c:p.toCharArray()){
        //     set.add(c);
        // }
        // //System.out.println(Arrays.toString(p.toCharArray()));
        // int n = set.size();
        // return factorial(n);
        int max =0;
        int [] temp = new int [26];
        for(int i=0;i<p.length();i++){
            if(i>0 &&(p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))){
                max++;
            }else{
                max=1;
            }
            int index = p.charAt(i)-'a';
            temp[index] = Math.max(temp[index],max);
        }
        int sum = 0;
        for(int a: temp){
            sum+=a;
        }
        return sum;
    }
    public int factorial(int n){
        if(n<=1)
            return 1;
        int [] fact = new int [n+1];
        fact[0]=1;
        fact[1]=1;
        for(int i=2;i<=n;i++){
            fact[i] = i*fact[i-1];
        }
        return fact[n];
    }
}
