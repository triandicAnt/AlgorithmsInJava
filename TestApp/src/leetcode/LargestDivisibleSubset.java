public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length<=0)
            return list;
        int n = nums.length;
        int temp[] = new int [n];
        int locs[] = new int [n];
        int max = 0;
        Arrays.fill(temp, 1);
        Arrays.fill(locs,-1);
        int index = -1;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j = i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    if(temp[i]<temp[j]+1){
                        temp[i] = temp[j]+1;
                        locs[i] = j;
                    }
                }
            }
            if(temp[i]>max){
                max = temp[i];
                index = i;
            }
        }
        while(index!=-1){
            list.add(nums[index]);
            index = locs[index];
        }
        return list;
    }
}
