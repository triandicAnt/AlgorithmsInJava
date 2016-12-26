public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        if(candidates.length<=0)
            return list;
        long millis = System.currentTimeMillis() % 1000;
        dfs(candidates,0,target,0,list,new ArrayList<>());
        long millis1 = System.currentTimeMillis() % 1000;
        System.out.println(millis1-millis);

        return list;
    }
    
    public void dfs(int [] nums,int index,int target,int sum,List<List<Integer>> list, List<Integer>l){
        if(sum==target){
            if(!list.contains(l))
                list.add(new ArrayList<>(l));
            return;
        }
        for(int i=index; i<nums.length;i++){
            // l.add(nums[i]);
            // dfs(nums,i+1,target,sum+nums[i],list,l);
            // l.remove(l.size()-1);
             if(i > index && nums[i] == nums[i-1]) 
                continue;
            if(nums[i] + sum <= target){
                l.add(nums[i]);
                dfs(nums, i+1, target,sum+nums[i], list, l);
                l.remove(l.size()-1);
            }
        }
    }
}
