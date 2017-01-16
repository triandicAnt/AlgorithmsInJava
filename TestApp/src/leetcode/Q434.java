public class Q434 {
    public int countSegments(String s) {
        if(s==null || s.length() ==0 )
            return 0;
        // System.out.println(Arrays.toString(s.split("\\s+")));
        // int c = 0;
        // for(String str :s.split("\\s+")){
        //     if(str.length()>0)
        //         c++;
        // }
        // return c;
        return ("x " +s).split("\\s+").length-1;
    }
}
