public class Q165 {
    public int compareVersion(String version1, String version2) {
       /*
       try{
            float x = Float.parseFloat(version1);
            float y = Float.parseFloat(version2);
            if(x==y)
                return 0;
            return x>y?1:-1;
       }
         catch (NumberFormatException e) {
            if(version1.equals(version2))
            return 0;
            char c1 [] = version1.toCharArray();
            char c2 [] = version2.toCharArray();
            int n1 = c1.length;
            int n2 = c2.length;
            int i = 0;
            int j = 0;
            while(i<n1 && j<n2){
                System.out.println(c1[i] + " " + c2[j]);
               if(c1[i]>c2[j])
                    return 1;
                else if(c1[i]<c2[j])
                    return -1;
                // else{
                //     i++;
                //     j++;
                // }
                i++;j++;
            }
            return 0;
            */
            return compareVer(version1,version2);
       }
        
    public int compareVer(String ver1,String ver2){
        if(ver1.equals(ver2))
            return 0;
        String []arr1 = ver1.split("\\.");
        String []arr2 = ver2.split("\\.");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int l1 = arr1.length;
        int l2 = arr2.length;
        int l = Math.max(l1,l2);
        for(int i = 0 ;i<l;i++){
            Integer v1 = i<l1?Integer.parseInt(arr1[i]):0;
            Integer v2 = i<l2?Integer.parseInt(arr2[i]):0;
            int cmp = v1.compareTo(v2); 
            if(cmp!=0)
                return cmp;
        }
        return 0;
    }
}
