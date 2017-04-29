
public class Q277 {
  int  MATRIX[][] =      {{0, 0, 1, 0},
                          {0, 0, 1, 0},
                          {0, 0, 0, 0},
                          {0, 0, 1, 0}
                          };  
  public static void main(String[] args) {
    Q277 s = new Q277();
    int id = s.findCelebrity(4);
    System.out.println(id);
  }
  
 
  boolean knows(int a, int b)
  {
      return MATRIX[a][b]==1?true:false;
  }
  public int findCelebrity(int n){
    int a = 0;
    int b = n-1;
    while(a<b){
      if(knows(a,b))
          a++;
      else
        b--;
    }
    for(int i = 0;i<n;i++){
     if((i != a) && (knows(a,i) || !knows(i,a)))
       return -1;
    }
    return a;
  }
}
