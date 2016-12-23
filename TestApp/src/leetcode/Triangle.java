public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0)
            return 0;
        int n = triangle.size();
        int []temp = new int [n+1];
        
        for(int i = n-1;i>=0;i--){
            for(int j = 0; j<triangle.get(i).size();j++){
                temp[j] = Math.min(temp[j],temp[j+1])+triangle.get(i).get(j);
            }
        }
        return temp[0];
        
    }
}
