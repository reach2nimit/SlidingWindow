class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int zeroes = 0, result = 0;
        int left = 0;

        for(int right = 0; right < len; right++){

            if(nums[right] == 0)
                zeroes++;
            
            while(zeroes > 1){
                if(nums[left]==0)
                    zeroes--;
                left++;
            }

            result = Math.max(result, right - left + 1 - zeroes);
            //check the condition in question carefully
        }

        return (result == len) ? result - 1 : result;
        //O(N)
    }
}