class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        double[][] workers = new double[wage.length][3];

        for(int i =0; i< wage.length; i++){
            workers[i][0] = (double)wage[i]/quality[i];
            workers[i][1] = quality[i];
            workers[i][2] = wage[i];
        }

        Arrays.sort(workers, (a,b) -> Double.compare(a[0], b[0]));

        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(double[] w : workers){
            int workerQuality = (int)w[1];
            totalQuality+= workerQuality;
            maxHeap.offer(workerQuality);

            if(maxHeap.size() == k){
                double currCost = totalQuality * w[0];
                minCost = Math.min(minCost, currCost);
                totalQuality-=maxHeap.poll();
            }

        }
        return minCost;
    }
}