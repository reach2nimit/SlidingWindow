class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int len = heights.length;
        Queue<Integer> heap = new PriorityQueue();

       for( int index = 0; index + 1 < len; index++ ){

            int climb = heights[index+1] - heights[index];

            if(climb<=0)
                continue;

            heap.offer(climb);
            if(heap.size() <= ladders)
                continue;

            bricks-=heap.poll();
            if(bricks<0)
                return index;
        }

        return len-1;
        //nLogN
    }
}