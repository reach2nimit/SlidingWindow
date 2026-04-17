class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        Queue<long[]> busyRooms = new PriorityQueue<>(
            (a,b) -> (a[0] != b[0]) ? Long.compare(a[0],b[0]) : Long.compare(a[1], b[1])
        );

        int[] count = new int[n];
        for(int i =0; i<n; i++)
            free.offer(i);
        
        for(int[] meet : meetings){

            long start = meet[0], end = meet[1];
            long duration = meet[1] - meet[0];

            while(!busyRooms.isEmpty() && busyRooms.peek()[0]<= start)
                free.offer((int)busyRooms.poll()[1]);
            
            if(!free.isEmpty()){
                int room = free.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            }
            else{
                long[] busy = busyRooms.poll();
                busyRooms.offer(new long[]{busy[0] + duration, busy[1]});
                count[(int)busy[1]]++;
            }

        }
        int result = 0;
        for(int i =0; i<n; i++ ){
            if(count[i] > count[result])
                result = i;
        }
        return result;
    }
}