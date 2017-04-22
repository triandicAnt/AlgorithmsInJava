import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MoviePLayback {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, List<Integer>> map = new HashMap<>();
		map.put("A", new ArrayList<>(Arrays.asList(14,15,16,17)));
		map.put("B", new ArrayList<>(Arrays.asList(14,15,16)));
		map.put("C", new ArrayList<>(Arrays.asList(14,15)));
		map.put("D", new ArrayList<>(Arrays.asList(14,15,17)));
		
		List<Pair> list = findOrder(map);
		System.out.println(list);
	}
	/**
	 * Film A: 14, 15, 16, 17 
		Film B: 14, 15, 16 
		Film C: 14, 15 
		Film D: 14, 15, 17 
		
		returns a solution on the line, such as 
		A 14, B 16, C 15 , D 17 
		The If you want 
		A 14, B 15, 
		Behind C can not read. 
	 */
	public static List<Pair> findOrder(Map<String, List<Integer>> map){
		if(map == null)
			return null;
		List<Pair> list = new ArrayList<>();
		String movie []=map.keySet().toArray(new String[map.size()]); 
		Arrays.sort(movie);
		System.out.println(Arrays.toString(movie));
		if(backtrack(movie,map,0,list, new ArrayList<Pair>(), new HashSet<Integer> ()))
			return list;
		else
			throw new RuntimeException();
	}
	public static boolean backtrack(String[]movie, Map<String, List<Integer>> map, int index,List<Pair> list, List<Pair> temp, Set<Integer> set){
		
		if(index>movie.length)
			return false;
		if(index == movie.length){
			list.addAll(new ArrayList<>(temp));
			return true;
		}
		for(int i : map.get(movie[index])){
			System.out.println(i + "***" +index + "***" + temp + " *** " + set);

				if(!set.contains(i)){
					set.add(i);
					temp.add(new Pair(movie[index],i));
					if(backtrack(movie, map, index+1, list, temp, set)){
						return true;
					}
					temp.remove(temp.size()-1);
					set.remove(i);
				}else
					continue;
		}
		return false;
	}

}
class Pair{
	String name;
	int time;
	Pair(String name, int time){
		this.name = name;
		this.time = time;
	}
	@Override
	public String toString(){
		return "("+this.name+","+this.time+")";
	}
}
