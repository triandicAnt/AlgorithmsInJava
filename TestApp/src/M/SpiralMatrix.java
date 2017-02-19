public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return list;
        int topRow = 0;
        int topCol  = 0;
        int botRow = matrix.length-1;
        int botCol = matrix[0].length-1;
        
        int d = 0;//right
        while(topRow<=botRow && topCol<=botCol){
            //right
            if(d==0){
                for(int i = topCol; i<=botCol;i++){
                    list.add(matrix[topRow][i]);
                }
                    topRow++;
            }
            //down
            else if(d==1){
                for(int i = topRow; i<=botRow;i++){
                    list.add(matrix[i][botCol]);
                }
                    botCol--;

            }
               //left
           else if(d==2){
                for(int i = botCol; i>=topCol;i--){
                    list.add(matrix[botRow][i]);
                }
                    botRow--;

            }
               //up
            else if(d==3){
                for(int i = botRow; i>=topRow;i--){
                    list.add(matrix[i][topCol]);
                   
                }
                 topCol++;
            }
            d = (d+1)%4;
        }
        return list;
    }
}
