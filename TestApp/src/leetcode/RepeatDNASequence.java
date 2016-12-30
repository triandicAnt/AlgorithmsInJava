package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s==null || s.length()<10)
            return list;
        HashMap<String, Integer> map = new HashMap<>();
        // check every 10 length sunstring
        for(int i=0;i<=s.length()-10;i++)
        {
            String str = s.substring(i,i+10);
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
                if(!list.contains(str) && map.get(str)>1){
                    list.add(str);
                }
            }else{
                    map.put(str,1);
                }
        }
        return list;
    }
}
