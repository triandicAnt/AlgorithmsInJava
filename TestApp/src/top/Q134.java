public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length==0 || cost ==null || cost.length==0)
            return 0;
        int gasLeft = 0;
        int gasNeeded = 0;
        int start = 0;
        for(int i = 0 ;i<gas.length;i++){
            gasLeft += gas[i]-cost[i];
            if(gasLeft<0){
                gasNeeded -= gasLeft;
                start = i+1;
                gasLeft = 0;
            }
        }
        return gasLeft>=gasNeeded?start:-1;
    }
}
