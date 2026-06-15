 //must read verr imp and beautiful solution
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high =0;

        for(int num : nums){
            if(low<num)
                low = num;
            high+=num;
        }
        //int result = high;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(isFeasible(mid, nums, k)){
                //result = mid;
                high = mid -1;
            }
            else
                low = mid+1;
        }
       return low;
        
    }

    boolean isFeasible(int maxSum, int[] nums, int k){
        int count = 1;
        int currSum = 0;

        for(int num : nums){
            currSum+=num;
            if(currSum > maxSum){
                currSum = num;
                count++;
            }
            if(count>k)
                return false;
        }
        return true;
    }
}