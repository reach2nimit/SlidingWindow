class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] result = new int[k][2];
        int index = 0;
        while(!maxHeap.isEmpty()){
            result[index] = maxHeap.poll();
            index++;
        }
        return result;
        //Time complexity:O(nlogk)
        //Space complexity:O(k)
    }
}