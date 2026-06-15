class Solution {
    public double minmaxGasDist(int[] stations, int k) {

        double left = 0, right = stations[stations.length - 1] - stations[0];

        // for(int i=1; i<stations.length; i++){
        //     right = Math.max(right, stations[i] - stations[i-1]);
        // }

        while(right - left > 1e-6){
            double mid = left + (right - left)/2.0;
            if(isFeasible(stations, k, mid))
                right = mid;
            else
                left = mid;
        }
        return left;
        
    }

    public boolean isFeasible(int[] stations, int k, double mid){
        int count = 0;
        for(int i = 1 ; i < stations.length; i++)
            count+= (int)((stations[i] - stations[i-1])/mid);
        
        return count<=k;
    }
}