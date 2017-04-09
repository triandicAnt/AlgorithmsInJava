public class Q140 {
    Map<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
       List<String> res = new ArrayList<>();
       if(s==null || s.length()==0 || wordDict == null || wordDict.size()==0)
        return res;
        
       if(map.containsKey(s))
            return map.get(s);
        if(wordDict.contains(s))
            res.add(s);
            
        for(int i = 1; i<s.length();i++){
            String t = s.substring(i);
            if(wordDict.contains(t)){
                List<String> l = wordBreak(s.substring(0,i),wordDict);
                if(l.size()>0){
                    for(String str : l)
                        res.add(str + " " + t);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}
