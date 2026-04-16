class Solution {
    public int minMeetingRooms(int[][] intervals) {
       if(intervals.length<=1)
        return 1;

        Queue<Integer> heap = new PriorityQueue<>();

        Arrays.sort(intervals, (a,b) -> a[0] -  b[0]);

        for(int i=0; i<intervals.length; i++){
            
            if(!heap.isEmpty() && heap.peek() <= intervals[i][0])
                heap.poll();
            
            heap.offer(intervals[i][1]);
        }
       return heap.size();  
    }
}