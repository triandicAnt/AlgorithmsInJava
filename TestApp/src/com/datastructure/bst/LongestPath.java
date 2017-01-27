// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
class Tree{
  int val;
  Tree l;
  Tree r;
}
public class LongestPath {
    public int solution(Tree T) {
        // write your code in Java SE 8
        if(T==null)
            return 0;
        // call on root T;
        PathLength rootLen = getPathLen(T);
        return rootLen.max;
    }
    public PathLength getPathLen(Tree T){
        // if root is null then all values would be 0
        if(T==null)
            return new PathLength(0,0,0);
        // call for the left node
        PathLength leftPath = getPathLen(T.l);
        PathLength rightPath = getPathLen(T.r);
        //
        int newLeft = T.l!=null?leftPath.left+1:0; // including the root itself
        int newRight = T.r!=null?rightPath.right +1:0; // including root itself
        int tempMax = Math.max(newLeft,newRight); // max of newLeft and newRight to calculate overall max
        int newMax = Math.max(tempMax, Math.max(leftPath.max,rightPath.max)); // new max
        return new PathLength(newLeft,newRight,newMax);
    }
}
// class to hold the path lengths of left and right
class PathLength{
    int left;
    int right;
    int max;
    //constructor
    public PathLength(int left, int right, int max){
        this.left = left;
        this.right = right;
        this.max = max;
    }
}
