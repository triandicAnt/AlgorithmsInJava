import java.util.Arrays;
 class FirstAndSecondLargest{
  public static void main(String []args){
    int []a = {6,1,3,2,4,7};
    int s[] = find(a);
    System.out.println(Arrays.toString(s));
  }
   static int[] find(int[]a){
        int first = 0;
        int second = 0;
        for(int i : a){
            if(i>first && i>second){
                second = first;
                first = i;
            }else if(i>second){
                second = i;
            }
        }
        int s[] = new int[2];
        s[0] = first;
        s[1] = second;
        return s;
    }
}
