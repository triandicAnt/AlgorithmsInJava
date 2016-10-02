package random;

public class ThreadC {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleDemo A = new SampleDemo("A");
		SampleDemo B = new SampleDemo("B");
		
		A.start();
		B.start();

	}
	static long strongRelation(int n, int m) {
	       int low = 1; 
	       int high = n + 1; 
	       int mid = (high + low)/2;
	       while (high > low + 1){
	            if (helper(mid, n) < m){
	                low = mid; 
	                mid = (high + low)/2;
	            }else{
	                high = mid; 
	                mid = (high + low)/2;
	       }
	      }
	      return high;

	    }
	static int helper(int r, int n){
	    int a = n%r;
	    int b = r - a;
	    int x = n/r + 1;
	    int y = n/r;
	    int ret = a*x*b*y +
	        a*(a-1)*x*x/2 +
	        b*(b-1)*y*y/2;
	    return ret;
	}
}

class SampleDemo implements Runnable{
	private Thread t;
	private String threadName;
	
	SampleDemo(String threadName){
		this.threadName = threadName;
	}
	public void run(){
		while(true){
			System.out.println(threadName);
		}
	}
	public void start(){
		if(t == null){
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
