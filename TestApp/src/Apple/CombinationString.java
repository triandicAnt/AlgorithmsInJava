import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
class CombinationString{
  
  
  public static void main(String args[]){
    char[] a = {'a','a','n'};
    List<String> list = combination(a);
    Set<String> s = new HashSet<String>(list);
    System.out.println(list);
    System.out.println(list.size() + " " + s.size());
  }
  
  public static List<String> combination(char []arr){
    
    List<String> list = new ArrayList<>();
    if(arr==null || arr.length==0)
      return list;
    Arrays.sort(arr);
    boolean visited[] = new boolean[arr.length];
    backtrack(list, new ArrayList<Character>(), visited,arr);
    return list;
  }
  
  public static void backtrack(List<String> list, List<Character> temp, boolean[]visited, char []a){
    if(temp.size()==a.length)
    {
      StringBuffer sb = new StringBuffer();
      for(char c: temp){
        sb.append(c);
      }
      list.add(sb.toString());
      return;
    }
    for(int i = 0;i<a.length;i++){
      if(!visited[i]){
        if(i>0 && a[i]==a[i-1] && visited[i-1])
          continue;
        visited[i] = true;
        temp.add(a[i]);
        backtrack(list,temp, visited, a);
        visited[i] = false;
        temp.remove(temp.size()-1);
      }
    }
  }
}
