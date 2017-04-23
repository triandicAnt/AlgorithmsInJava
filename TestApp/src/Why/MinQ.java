import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniQ minQ = new MiniQ();
		int [] a = {12,5,10,7,11,19};
		for(int i:a){
			minQ.push(i);
		}
		System.out.println(minQ.q);
		System.out.println(minQ.dq);
		System.out.println("Popping");
		minQ.pop();
		System.out.println(minQ.q);
		System.out.println(minQ.dq);
		System.out.println("Minimum is "  + minQ.getMin());
		System.out.println("Popping");
		minQ.pop();
		System.out.println(minQ.q);
		System.out.println(minQ.dq);
		System.out.println("Minimum is "  + minQ.getMin());
	}

}
// [12,5,10,7,11,19]
class MiniQ{
	Queue<Integer> q;
	Deque<Integer> dq;
	public MiniQ(){
		q = new LinkedList<>();
		dq = new LinkedList<>();
	}
	public void push(int val){
		q.offer(val);
		while(!dq.isEmpty() && dq.peekLast()>val){
			dq.removeLast();
		}
		dq.addLast(val);
	}
	public int pop(){
		if(q.isEmpty())
			return -1;
		int x = 0;
		if(q.peek() == dq.peekFirst())
			dq.removeFirst();
		x = q.remove();
		return x;
	}
	public int getMin(){
		if(dq.isEmpty())
			return -1;
		return dq.peekFirst();
	}
}
