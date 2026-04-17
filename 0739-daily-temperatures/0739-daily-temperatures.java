class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //  76 73
        // 1 1 4 2 1 1
        int len = temperatures.length;
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque();
        for( int i = 0 ; i < len; i++){

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}