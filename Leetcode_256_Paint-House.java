class Solution {
    public int minCost(int[][] costs) {
        if(costs[0].length == 0 || costs[1].length == 0){
            return 0;
        }
        else{
            for(int i = 1; i < cost.length; i++){
                costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][1], costs[i-1][2]);
                costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            }
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}