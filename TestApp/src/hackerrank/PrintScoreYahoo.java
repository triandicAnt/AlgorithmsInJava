/**
 * 
 */
package hackerrank;

/**
 * @author Sudhansu
 *
 */
import java.io.*;
import java.util.*;
public class PrintScoreYahoo {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
      BufferedReader br = null;
        List<Score> list = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = br.readLine();
                if(input == null)
                    break;
                if(!input.equals("PRINT")){
                                       
                    Score s = new Score(input.split(","));
                    if(list.size()>0)
                         System.out.println(s.equals(list.get(0)));
                    list.add(s);
                }
                else{
                    System.out.println(list);

                    System.out.println("Leaders");
                    if (list.size() > 0) {
                      Collections.sort(list, new Comparator<Score>() {
                          @Override
                          public int compare(final Score object1, final Score object2) {
                              int a = object1.score;
                              int b = object2.score;
                              int x = Integer.parseInt(object1.playerId);
                              int y = Integer.parseInt(object2.playerId);
                              
                              return a > b ? -1 : a < b ? +1 :(x>y?-1:1);
                              //return object1.score>object2.score?object1.score:object2.score;
                          }
                      });
                    }
                   // System.out.println(list);
                    int n = 10;
                    if(list.size()<n)
                        n = list.size()-1;
                    int i = 1;
                    for(int j=0;i<=n;j++){
                        Score s = list.get(j);
                        System.out.println(i + "," +s.toString());
                        i++;
                    }
                    //list.clear();
                }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
class Score{
    String playerId;
    int score;
    public Score(String [] arr){
        int russingYard = Integer.parseInt(arr[1]);
        int passingYard = Integer.parseInt(arr[2]);
        int passingTd = Integer.parseInt(arr[3]);
        int inter = Integer.parseInt(arr[4]);
        this.playerId = arr[0];
        this.score = (russingYard*2) + passingYard + (passingTd*6) - inter;
    }
    @Override
    public String toString(){
        return this.playerId + "," + this.score;
    }
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        final Score other = (Score) obj;
        
        if (this.hashCode() != other.hashCode()) {
            //System.out.println("here");
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.playerId != null ? this.playerId.hashCode() : 0);

        return hash;
    }
}