package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<>();
        if(s==null || s.length()==0)
            return list;
        for(int a=1;a<4;a++){
            for(int b= 1; b<4;b++){
                for(int c=1;c<4;c++){
                    for(int d = 1;d<4;d++){
                        if(a+b+c+d == s.length()){
                            int s1 = Integer.parseInt(s.substring(0,a));
                            int s2 = Integer.parseInt(s.substring(a,a+b));
                            int s3 = Integer.parseInt(s.substring(a+b,a+b+c));
                            int s4 = Integer.parseInt(s.substring(a+b+c));
                            if(s1<=255 && s2<=255 && s3<=255 &s4<=255){
                                StringBuffer sb = new StringBuffer();
                                sb.append(s1);
                                sb.append(".");
                                sb.append(s2);
                                sb.append(".");
                                sb.append(s3);
                                sb.append(".");
                                sb.append(s4);
                                if(sb.length()-3 == s.length())
                                    list.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
