public class Q155{

}
class MinStack {
    long min;
    Stack<Long> st;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        if(st.isEmpty()){
            st.push(0L);
            min = x;
        }else{
            st.push(x-min);
            if(x<min)
                min = x;
        }
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        long x = st.pop();
        if(x<0){
            min = min-x;
        }
    }
    
    public int top() {
        long top = st.peek();
        if(top<0)
            return (int)min;
        return (int)(min+top);
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
