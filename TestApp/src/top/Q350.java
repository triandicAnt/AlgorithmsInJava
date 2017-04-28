public class Q350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
            return new int[0];
        List<Integer> l = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i : nums2){
            if(map.containsKey(i))
            {
                l.add(i);
                map.put(i,map.get(i)-1);
                if(map.get(i)==0)
                    map.remove(i);
            }
        }
        int []a = new int[l.size()];
        int i =0;
        for(int x:l)
            a[i++]=x;
        return a;
    }
}
