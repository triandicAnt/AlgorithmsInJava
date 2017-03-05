public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return list;
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), new boolean[nums.length],nums,0);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, boolean[] visited, int[]a,int index){
        if(temp.size()==a.length){
            list.add(new ArrayList<>(temp));
            return;
        }
      //  visited[]
      for(int i = 0;i<a.length;i++){
          if(!visited[i]){
              if(i>0 && a[i-1]==a[i] && visited[i-1])
                continue;
            visited[i] = true;
            temp.add(a[i]);
            backtrack(list, temp, visited, a, index);
            visited[i] = false;
            temp.remove(temp.size()-1);
          }
      }
    }
}
