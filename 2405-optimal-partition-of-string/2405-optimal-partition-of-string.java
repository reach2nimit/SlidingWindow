class Solution {
    public int partitionString(String s) {
        //a bac ab a
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int result = 1, subStringStart = 0;

        for(int i =0; i<s.length(); i++){

            if(lastSeen[s.charAt(i)] >= subStringStart){
                result++;
                subStringStart = i;
            }

            lastSeen[s.charAt(i)] = i;
        }
        return result;
    }
}