class Solution {
    public int minSwaps(String s) {
        int stackSize = 0;
        for(int i = 0; i<s.length(); i++){
            
            if(s.charAt(i) == '[')
                stackSize++;
            else{
                if(stackSize > 0)
                    stackSize --;
            }

        }

        return (stackSize + 1)/2;
        // O(N)
    }
}