public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int max = 0;
        // int n = gas.length;
        // for(int i=0;i<n;i++){
        //     if(gas[i]-cost[i]>max){
        //         return false;
        //     }
        //     max = Math.max(max+gas[i]-cost[i],max);
        // }
        // return true;
        //Every time a fail happens, accumulate the amount of gas that is needed to overcome the fail. After looping through the stations, if the gas left is more than gas needed, then we have a solution, otherwise not.
        int gasNeeded = 0;
        int gasLeft = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            gasLeft = gasLeft + gas[i] - cost[i];
            
            // if gasLeft is less than 0
            if(gasLeft<0){
                gasNeeded = gasNeeded - gasLeft;
                start = i+1;
                gasLeft = 0;
            }
        }
        return gasLeft>=gasNeeded?start:-1;
    }
}
