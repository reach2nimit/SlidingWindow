class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int targetStart = times[targetFriend][0];

        Arrays.sort(times, (a,b) -> a[0] - b[0]);

        Queue<Integer> availableChairs = new PriorityQueue<>();
        Queue<int[]> leaveChair = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        int currChair = 0;

        for(int[] time : times){

            int start = time[0], leave = time[1];

            while(!leaveChair.isEmpty() && leaveChair.peek()[0]<= start)
                availableChairs.offer( leaveChair.poll()[1]);
            
            int chair;
            if(!availableChairs.isEmpty())
                chair = availableChairs.poll();
            else{
                chair = currChair;
                currChair++;
            }

            leaveChair.add(new int[]{leave, chair});

            if(targetStart == start)
                return chair;
        }
        return -1;
        //NlogN
    }
}