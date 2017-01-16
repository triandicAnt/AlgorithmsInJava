public class Q407 {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length<2 || heightMap[0].length<2)
            return 0;
        
        // create a priority queue of cell;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        // add all boundary cell to PQ
        int m=  heightMap.length;
        int n = heightMap[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i<m ; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }
        for(int i = 0; i<n ; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
        }
        
        int total = 0;
        int dir[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            Cell temp = pq.poll();
            for(int d[]:dir){
                int row = temp.row + d[0];
                int col = temp.col + d[1];
                if(row<0 || row>m-1 || col<0 || col>n-1 || visited[row][col]==true)
                    continue;
                visited[row][col] = true;
                total += Math.max(0, temp.height-heightMap[row][col]);
                pq.offer(new Cell(row,col,Math.max(heightMap[row][col],temp.height)));
            }
        }
        return total;
    }
}

class Cell implements Comparable<Cell> {
    int row;
    int col;
    int height;
    public Cell(int row, int col, int height){
        this.row = row;
        this.col = col;
        this.height = height;
    }
    public int compareTo(Cell cell){
        return this.height - cell .height;
    }
}
