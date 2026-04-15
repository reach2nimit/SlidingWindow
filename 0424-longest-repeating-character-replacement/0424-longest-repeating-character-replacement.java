class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int result = 0;
        int maxFreq = 0;
        int left = 0, right = 0;
    
        while(right < s.length()){
            int ch = s.charAt(right) - 'A';
            arr[ch]++;

            maxFreq = Math.max(maxFreq, arr[ch]);

            if(right - left + 1 - maxFreq > k){

                int leftChar = s.charAt(left) - 'A';
                arr[leftChar]--;
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
        //O(N)
    }
}