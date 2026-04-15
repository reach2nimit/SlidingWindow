class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long[] prefix = new long[len+1];
        long ans = Long.MIN_VALUE;

        for(int i = 0; i <len; i++)
            prefix[i+1] = prefix[i] + nums[i];
        
        Map<Long, Long> seen = new HashMap();

        for(int i = 0 ; i<len; i++){

            long val = nums[i];

            if(seen.containsKey(val+k))
                ans = Math.max(ans, prefix[i+1] - seen.get(val+k));
        
            if(seen.containsKey(val-k))
                ans = Math.max(ans, prefix[i+1] - seen.get(val-k));
            
            //be careful of this condition
            if(!seen.containsKey(val) || prefix[i] < seen.get(val))
                seen.put(val, prefix[i]);
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
        // O(N)
    }
}