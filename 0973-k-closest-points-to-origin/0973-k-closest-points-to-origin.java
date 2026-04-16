class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> distance(b) - distance(a)
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

    public int distance(int[] arr){
        return arr[0]*arr[0] + arr[1]*arr[1];
    }
}