public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4 || 4 < 2) 
            return result;
        Arrays.sort(nums);
        sum(nums, target, 4, 0, result, new ArrayList<>());
        return result;
    }
    void sum(int []a, int target, int k, int start, List<List<Integer>> list, List<Integer>temp){
        int max = a[a.length-1];
        if(a[start]*k>target || max*k<target)
            return;
        for(int i = start; i<a.length-k+1;i++){
            if(i>start && a[i]==a[i-1])
                continue;
             if(a[i] + max*(k-1)<target)
                continue;
             if(a[i]*k>target)
                break;
             if(a[i]*k == target){
                if(a[i+k-1] == a[i]){
                    list.add(new ArrayList<>(temp));
                    List<Integer> l = new ArrayList<>();
                    for(int x = 0; x<k;x++)
                        l.add(a[i]);
                    list.get(list.size()-1).addAll(l);
                }
                break;
            }
            temp.add(a[i]);
            sum(a,target-a[i],k-1,i+1,list,temp);
            temp.remove(temp.size()-1);
        }
    }
    
}
