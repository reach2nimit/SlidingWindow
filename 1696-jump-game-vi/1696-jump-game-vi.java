class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] score = new int[len];
        score[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque();
        dq.add(0);

        for(int i = 1; i<len; i++){
            while(!dq.isEmpty() && dq.peekFirst() + k < i)
                dq.pollFirst();
            
            score[i] = score[dq.peekFirst()] + nums[i];

            while(!dq.isEmpty() && score[i]>=score[dq.peekLast()])
                dq.pollLast();
            
            dq.add(i);
        }
        return score[len-1];
        //Current complexity: O ( N )
    }
}