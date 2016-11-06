/**
 * 
 */
package interviews;

/**
 * @author Sudhansu
 * [5, 6, 0, 4, 2, 4, 1, 0, 0, 4]
 * 
 * 0, 5, 9, out
 */
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class ArrayHopper {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = null;
        List<Integer> list = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = br.readLine();
                if(input == null)
                    break;
                list.add(Integer.parseInt(input));
                //System.out.println(input);
            }
          // fetch the value of hops list
          ArrayList<String> outList = findHops(list);
          // if hops list is null then print failure
          if(outList == null)
            System.out.println("failure");
          // else print all the values of hops list and add out to the standard output
          else{
              for(String s: outList){
                  System.out.print(s + ", ");
              }
              System.out.print("out");
          }
      
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    public static ArrayList<String> findHops(List<Integer> array) {
		ArrayList<String> hops = new ArrayList<String>();
		int indexReached = 0, currentIndex = 0, selectedIndex = 0;
		int i;
		for (i = 0; i < array.size(); i++) {
			// check out of bound
			if (!(i <= currentIndex)) 
				break;
			if (i > indexReached) {
                // update current index and add to the hops list
				indexReached = currentIndex;
				hops.add(String.valueOf(selectedIndex));
			}
			int sum = i + array.get(i);
			if (sum > currentIndex) 
				selectedIndex = i;
			currentIndex = Math.max(currentIndex, sum);
		}
        int s = hops.size();
		if ((i > indexReached) && (s > 0) && (selectedIndex != Integer.parseInt(hops.get(s-1)))) {
			hops.add(String.valueOf(selectedIndex));
		}

		if (indexReached >= array.size() - 1)
			return hops;
		else
			return null;
	}
}