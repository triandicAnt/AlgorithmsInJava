public class Q155
{}
class MinStack {

    /** initialize your data structure here. */
   Stack<Long> s;
   long min;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int x) {
        if(s.isEmpty()){
          s.push(0L);
          min = x;
          return;
        }
      s.push(x-min);
      if(min>x)
        min = (long)x;
    }
    
    public void pop() {
        if(s.isEmpty())
            return;
      long x = s.pop();
      if(x<0)
        min = min-x;
      
    }
    
    public int top() {
        if(s.isEmpty())
            return -1;
       long x = s.peek();
      if(x<0)
          return (int)min;
      return (int)(x+min);
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
