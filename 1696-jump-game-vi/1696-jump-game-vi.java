class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> dq = new ArrayDeque();
        dq.add(0);

        for(int i = 1; i<len; i++){
            while(!dq.isEmpty() && dq.peekFirst() + k < i)
                dq.pollFirst();
            
            nums[i] = nums[dq.peekFirst()] + nums[i];

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
                dq.pollLast();
            
            dq.add(i);
        }
        return nums[len-1];
        //Current complexity: O ( N )
    }
}