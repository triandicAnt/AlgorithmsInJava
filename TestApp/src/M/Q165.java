public class Q165 {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int l1 = arr1.length;
        int l2 = arr2.length;
        int l = Math.max(arr1.length,arr2.length);
        for(int i = 0;i<l;i++){
            Integer v1;
            Integer v2;
            v1 = i<l1?Integer.parseInt(arr1[i]):0;
            v2 = i<l2?Integer.parseInt(arr2[i]):0;
            int cmp=v1.compareTo(v2);
            if(cmp!=0)
                return cmp;
        }
        return 0;
    }
}
