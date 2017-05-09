import java.io.*;
import java.util.*;

public class RoundRobinTest {
  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>();
    for(int i =0;i<6;i++)
        l.add(i);
    RoundRobin<Integer> r = new RoundRobin<>(l);
    Iterator<Integer> it = r.iterator();
    int i = 0;
      while(it.hasNext()){
        System.out.println(it.next());
        i++;
        if(i==10)
          break;
      }
    
  }
  
  
}

class RoundRobin<T> implements Iterable<T>{
  public List<T> list;
  public RoundRobin(List<T> l){
    this.list = l;
  }
  public Iterator<T> iterator(){
    return new Iterator<T>(){
      int index = 0;
      @Override
      public boolean hasNext(){
        return true;
      }
      @Override 
      public T next(){
        T res = list.get(index);
        index = (index+1)%list.size();
        return res;
      }
      @Override 
      public void remove(){
        throw new RuntimeException("Not Supported");
      }
    };
  }
}
