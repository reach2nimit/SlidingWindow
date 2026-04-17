class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int len = nums.length;
        int remainingCount = len - k;

        for(int i = 0; i<len; i++){

            while(!queue.isEmpty() && queue.peekLast() > nums[i] && remainingCount>0){
                queue.pollLast();
                remainingCount--;
            }
            queue.offerLast(nums[i]);
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++)
            result[i] = queue.pollFirst();
        
        return result;
    }
}