public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return list;
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(),nums);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int []a){
        if(temp.size()==a.length){
            list.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<a.length;i++){
                if(temp.contains(a[i]))
                    continue;
                temp.add(a[i]);
                backtrack(list, temp, a);
                temp.remove(temp.size()-1);
            }
        }
    }
}
