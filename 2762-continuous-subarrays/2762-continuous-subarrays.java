class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minQ = new ArrayDeque();
        Deque<Integer> maxQ = new ArrayDeque();
        int left = 0, right = 0;
        long count = 0;

        while(right < nums.length){

            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right])
                maxQ.pollLast();
            
            maxQ.offerLast(right);

            while(!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right])
                minQ.pollLast();
            
            minQ.offerLast(right);

            while (
                !minQ.isEmpty() &&
                !maxQ.isEmpty() &&
                nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > 2
            ){

                if(maxQ.peekFirst() < minQ.peekFirst()){
                    left = maxQ.peekFirst() + 1;
                    maxQ.pollFirst();
                }
                else {
                    left = minQ.peekFirst() + 1;
                    minQ.pollFirst();
                }
            }

            count+=(right - left + 1);
            right++;
        }

        return count;
    }
}