class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 0, right = 10_000_000;
        while(left < right){
            int mid = left + (right - left + 1)/2;
            long count = 0;
            for(int candy : candies)
                count+=(candy/mid);
            
            if(count>=k)
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }
}