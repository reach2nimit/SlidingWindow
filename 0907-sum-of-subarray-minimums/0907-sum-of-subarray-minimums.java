class Solution {
    
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        Deque<Integer> st = new ArrayDeque();
        long result = 0;

            //imp comparing condition
        for(int i = 0; i <= arr.length; i++){

            while(!st.isEmpty() && (i == arr.length || arr[st.peek()] >= arr[i])){

                int mid = st.pop();
                int left = (st.isEmpty()) ? -1 : st.peek();
                int right = i;

                long count = (mid - left) * (right - mid) % MOD;
                result+=(count * arr[mid])%MOD;
                result%=MOD;
            }
            st.push(i);
        }
        return (int)result;
        //O(N)
    }
}