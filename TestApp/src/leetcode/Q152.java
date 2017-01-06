public class Q152 {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length<=0)
            return 0;
        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int maxSoFar = nums[0];
        int maxHere;
        int minHere;
        for(int i=1;i<nums.length;i++){
            // max = Math.max(nums[i], nums[i]*max);
            // maxSoFar = Math.max(max,maxSoFar);
            maxHere = Math.max(Math.max(maxHerePre*nums[i], minHerePre*nums[i]),nums[i]);
            minHere = Math.min(Math.min(maxHerePre*nums[i], minHerePre*nums[i]),nums[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }
        return maxSoFar;
    }
}
