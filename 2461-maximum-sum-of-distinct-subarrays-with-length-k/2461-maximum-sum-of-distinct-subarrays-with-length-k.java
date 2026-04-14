class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long currSum = 0, maxSum =0;
        int left = 0, right =0;
        Map<Integer,Integer> numIndex = new HashMap();
        //use map rather than set
        while(right<len){
            int num = nums[right];
            int lastSeen = numIndex.getOrDefault(num, -1);

            while(lastSeen >= left || (right - left + 1) > k){
                currSum -= nums[left];
                left++;
            }

            numIndex.put(num, right);
            currSum+=nums[right];

            if(right - left + 1 == k)
                maxSum = Math.max(maxSum, currSum);
            right++;          
        }
        return maxSum;
    }
}