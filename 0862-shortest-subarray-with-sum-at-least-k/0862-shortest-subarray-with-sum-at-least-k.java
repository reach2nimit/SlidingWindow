class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        int shortest = len + 1;

        long[] prefix = new long[len+1];
        for(int i =0; i<len; i++)
            prefix[i+1] = prefix[i] + nums[i];

        Deque<Integer> startIdx = new ArrayDeque();

        for(int i = 0; i <= len; i++){
            //study these conditions carefully
            while(!startIdx.isEmpty() && prefix[i] - prefix[startIdx.peekFirst()]>=k){
                shortest = Math.min(shortest, i - startIdx.pollFirst());
            }

            while(!startIdx.isEmpty() && prefix[i] <=prefix[startIdx.peekLast()])
                startIdx.pollLast();

            startIdx.addLast(i);
        }

        return (shortest == len + 1) ? -1 : shortest;
        //Current complexity: O ( N ) 
        
    }
}